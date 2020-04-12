package com.ancit.testgenx.ui.forms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.wb.swt.ResourceManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ancit.genxtools.dbc.model.BasicLabelType;
import com.ancit.genxtools.dbc.model.Bus;
import com.ancit.genxtools.dbc.model.EnvironmentVariable;
import com.ancit.genxtools.dbc.model.EnvironmentVariables;
import com.ancit.genxtools.dbc.model.LabelSet;
import com.ancit.genxtools.dbc.model.Message;
import com.ancit.genxtools.dbc.model.Signal;
import com.ancit.genxtools.dbc.parser.DbcReader;
import com.ancit.testgenx.ui.dialogs.ImportDBCFileDialog;
import com.ancit.testgenx.ui.dialogs.TSEExportDialog;
import com.ancit.testgenx.ui.utils.Activator;
import com.ancit.testgenx.ui.utils.CommonUtils;
import com.ancit.testgenx.ui.views.DiagnosticBlock;

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.ImportArtifact;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;

public class DiagnosticFormPage extends FormPage {

	private TestSpecification testSpecification;
	private Action importAction;
	private Action exportAction;
	private SignalType signalType;
	private Action importTestReportAction;
	private DiagnosticBlock block;

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public DiagnosticFormPage(String id, String title, TableViewer tableViewerAction) {
		super(id, title);
		// this.tableViewer =tableViewerAction;
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @param testSpecification
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public DiagnosticFormPage(FormEditor editor, String id, String title, TestSpecification testSpecification) {
		super(editor, id, title);
		this.testSpecification = testSpecification;
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Validation Tool");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		createActions(managedForm.getForm());

		block = new DiagnosticBlock(testSpecification);
		block.createContent(managedForm);

	}

	private void createActions(final ScrolledForm scrolledForm) {
		this.importAction = new Action("Import", IAction.AS_PUSH_BUTTON) {

			@Override
			public void run() {
				
				
				if(testSpecification.getImportArtifacts().size() == 2) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Import Artifact - Warning", "Currently Only 1 DBC Import is Supported.");
					return;
				}

				ImportDBCFileDialog dialog = new ImportDBCFileDialog(Display.getDefault().getActiveShell());
				int open = dialog.open();
				
				if (IDialogConstants.OK_ID == open) {

					String filePath = dialog.getDbcFilePath();
					String extension = filePath.substring(filePath.lastIndexOf("."), filePath.length());

					if (extension.equalsIgnoreCase(".dbc")) {
						ImportArtifact importArtifact = dbcRead(dialog.getDbcFilePath(), dialog.getMainImportFile());
						testSpecification.getImportArtifacts().add(importArtifact);
					} else {

						ImportArtifact importArtifact = xmlFileRead(dialog.getDbcFilePath());
						testSpecification.getImportArtifacts().add(importArtifact);
					}
				}
			}
		};

		// importAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		this.importAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/import_wiz.png"));

		this.exportAction = new Action("Export", IAction.AS_PUSH_BUTTON) {

			@Override
			public void run() {

				Diagnostic validate = Diagnostician.INSTANCE.validate(testSpecification);
				if ((testSpecification.getTestGroups().size() == 0)
						|| (testSpecification.getImportArtifacts().size() == 0
								|| (testSpecification.getImportArtifacts().size() == 1 && testSpecification
										.getImportArtifacts().get(0).getPath().equalsIgnoreCase("USERDEFINED")))
						|| (validate.getChildren().size() > 0)) {
					
					
						MessageDialog.openError(Display.getDefault().getActiveShell(), "Error - Generation",
								"Errors in Test Specification ! Fix the Errors to Generate Test Script.");
						return;
					
				}
				
				boolean isErrorOnpage = block.getTestCaseDetailPage().isErrorOnPage() || block.getTestGroupDetailsPage().isErrorOnPage() || block.getTestSpecificationDetailsPage().isErrorOnPage();
				if (isErrorOnpage) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Error - Generation",
							"Errors in Test Specification ! Fix the Errors to Generate Test Script.");
					return;
				}
				
				TSEExportDialog dialog = new TSEExportDialog(Display.getDefault().getActiveShell(),testSpecification);
				int open = dialog.open();

				if (IDialogConstants.OK_ID == open) {
					dialog.getExporter().export(testSpecification);
				}

			}
		};
		this.exportAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/export_wiz.png"));

		

		scrolledForm.getToolBarManager().add(this.importAction);
		scrolledForm.getToolBarManager().add(this.exportAction);
//		scrolledForm.getToolBarManager().add(this.importTestReportAction);
		scrolledForm.updateToolBar();
	}

	
	private ImportArtifact dbcRead(String dbcfile, String mainFileImport) {

		File netwrkfile = new File(dbcfile);

		DbcReader reader = new DbcReader();
		if (netwrkfile.exists()) {
			HashMap<String, ArrayList<Signal>> signalWithMessageMap = new HashMap<String, ArrayList<Signal>>();
			HashMap<String, String> messageWithNodeMap = new HashMap<String, String>();
			if (netwrkfile.canRead()) {
				try {
					File outfile = new File(CommonUtils.generateTempFolder() + File.separator + "dbcviewer.log");
					reader.parseFile(netwrkfile, new FileOutputStream(outfile));
				} catch (IOException e) {
					e.printStackTrace();
				}

				ImportArtifact importArtifact = DiagonosticModelFactory.eINSTANCE.createImportArtifact();
				if (null != mainFileImport && !mainFileImport.trim().equals("")) {
					importArtifact.setPath(mainFileImport);
				} else {
					importArtifact.setPath(dbcfile);
				}

				ArrayList<Signal> signals = new ArrayList<Signal>();
				List<Bus> buses = reader.getNetwork().getBus();
				for (Bus bus : buses) {
					List<Message> messages = bus.getMessage();
					for (Message message : messages) {
						signals = new ArrayList<Signal>();
						signals.addAll(message.getSignal());
						signalWithMessageMap.put(message.getName(), signals);
						if (null != message.getProducer() && null != message.getProducer().getNodeRef()
								&& message.getProducer().getNodeRef().size() > 0
								&& null != message.getProducer().getNodeRef().get(0).getId()) {
							messageWithNodeMap.put(message.getName(),
									message.getProducer().getNodeRef().get(0).getId());
						}
					}
				}

				// Environment Variable
				List<EnvironmentVariables> envVariables = reader.getNetwork().getEnvVariables();
				for (EnvironmentVariables env : envVariables) {
					List<EnvironmentVariable> envirementVariables = env.getEnvirementVariable();
					for (EnvironmentVariable enviVar : envirementVariables) {
						signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
						signalType.setName(enviVar.getName());
						signalType.setType(SignalTypeEnum.ENVIRONMENT);
						importArtifact.getSignalType().add(signalType);
					}
				}

				for (Map.Entry<String, ArrayList<Signal>> signaldetails : signalWithMessageMap.entrySet()) {
					ArrayList<SignalType> signalTypeList = testSpecification.getSignals();

					for (Signal signal : signaldetails.getValue()) {
						SignalType oldSignal = null;

						if (signalTypeList != null) {
							for (SignalType signalType : signalTypeList) {
								if (signalType.getName().equals(signal.getName())) {
									oldSignal = signalType;
								}
							}
						}

						if (oldSignal == null) {
							signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
							signalType.setName(signal.getName());
							signalType.setType(SignalTypeEnum.SIGNAL);
							signalType.setMessageName(signaldetails.getKey());
							signalType.setNode(messageWithNodeMap.get(signaldetails.getKey()));
						}

						LabelSet labelSet = signal.getLabelSet();
						if (labelSet != null) {
							List<BasicLabelType> labelOrLabelGroup = labelSet.getLabelOrLabelGroup();
							for (BasicLabelType basicLabelType : labelOrLabelGroup) {
								if (signalType != null) {
									signalType.getLookupValues().add(basicLabelType.getName());
								}
								if (oldSignal != null) {
									oldSignal.getLookupValues().add(basicLabelType.getName());
								}
							}
						}
						if (signalType != null) {
							importArtifact.getSignalType().add(signalType);
						}
					}
				}
				return importArtifact;
			}
		}

		return null;
	}

	private ImportArtifact xmlFileRead(String file) {

		File fXmlFile = new File(file);

		ImportArtifact importArtifact = DiagonosticModelFactory.eINSTANCE.createImportArtifact();
		importArtifact.setPath(file);

		System.out.println("XML FILE PAth " + file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr1 = xpath.compile("//systemvariables/namespace/namespace");
			NodeList namespaceNL = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < namespaceNL.getLength(); i++) {
				Node namespaceNode = namespaceNL.item(i);
				String namespaceValue = namespaceNode.getAttributes().getNamedItem("name").getNodeValue();
				NodeList childNodes = namespaceNode.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node item = childNodes.item(j);
					if (!item.getNodeName().equals("#text")) {
						String varName = item.getAttributes().getNamedItem("name").getNodeValue();
						SignalType signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
						signalType.setType(SignalTypeEnum.SYSTEM);
						signalType.setName(varName);
						signalType.setNamespace(namespaceValue);
						importArtifact.getSignalType().add(signalType);
						System.out.println(varName);
					}
				}

			}
		} catch (SAXException | ParserConfigurationException | IOException | XPathExpressionException e1) {
			e1.printStackTrace();
		}

		return importArtifact;
	}

	/*
	 * private void createActions(final ScrolledForm scrolledForm) {
	 * this.importAction = new Action("Import", IAction.AS_PUSH_BUTTON) {
	 * 
	 * @Override public void run() {
	 * 
	 * ImportDBCFileDialog dialog = new
	 * ImportDBCFileDialog(Display.getDefault().getActiveShell()); int open =
	 * dialog.open();
	 * 
	 * if (IDialogConstants.OK_ID == open) {
	 * 
	 * File netwrkfile = new File(dialog.getDbcFilePath());
	 * 
	 * DbcReader reader = new DbcReader(); HashMap<String, ArrayList<Signal>>
	 * signalWithMessageMap = new HashMap<String, ArrayList<Signal>>(); if
	 * (netwrkfile.exists()) { if (netwrkfile.canRead()) { SignalType signalType;
	 * try { File outfile = new File(System.getProperty("user.home") +
	 * File.separator + "dbcviewer.log"); reader.parseFile(netwrkfile, new
	 * FileOutputStream(outfile)); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * ArrayList<Signal> signals = new ArrayList<Signal>(); List<Bus> buses =
	 * reader.getNetwork().getBus(); for (Bus bus : buses) { List<Message> messages
	 * = bus.getMessage(); for (Message message : messages) {
	 * signals.addAll(message.getSignal());
	 * signalWithMessageMap.put(message.getName(), signals); } }
	 * 
	 * for (Map.Entry<String, ArrayList<Signal>> signaldetails :
	 * signalWithMessageMap.entrySet()) { for (Signal signal :
	 * signaldetails.getValue()) { signalType =
	 * DiagonosticModelFactory.eINSTANCE.createSignalType();
	 * signalType.setName(signal.getName());
	 * signalType.setType(SignalTypeEnum.SIGNAL);
	 * signalType.setMessageName(signaldetails.getKey());
	 * 
	 * EList<SignalType> oldSignals = testSpecification.getSignalType(); boolean
	 * flag = false; for (SignalType item : oldSignals) { if
	 * (!item.getName().equalsIgnoreCase(signalType.getName())) { flag = true;
	 * break; } } if (flag) { testSpecification.getSignalType().add(signalType); } }
	 * }
	 * 
	 * testSpecification.setDbcPath(netwrkfile.getAbsolutePath()); } } } } };
	 * 
	 * //
	 * importAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
	 * getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
	 * this.importAction.setImageDescriptor(
	 * ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID,
	 * "icons/import_wiz.png"));
	 * 
	 * this.exportAction = new Action("Export", IAction.AS_PUSH_BUTTON) {
	 * 
	 * @Override public void run() {
	 * 
	 * TSEExportDialog dialog = new
	 * TSEExportDialog(Display.getDefault().getActiveShell()); int open =
	 * dialog.open();
	 * 
	 * if (IDialogConstants.OK_ID == open) {
	 * dialog.getExporter().export(testSpecification); }
	 * 
	 * } }; this.exportAction.setImageDescriptor(
	 * ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID,
	 * "icons/export_wiz.png"));
	 * 
	 * scrolledForm.getToolBarManager().add(this.importAction);
	 * scrolledForm.getToolBarManager().add(this.exportAction);
	 * scrolledForm.updateToolBar(); }
	 */

}
