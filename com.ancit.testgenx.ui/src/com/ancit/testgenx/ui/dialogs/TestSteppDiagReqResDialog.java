package com.ancit.testgenx.ui.dialogs;

import java.util.Arrays;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import com.ancit.testgenx.ui.provider.DiagnosticTableLabelProvider;

import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagnosticRequest;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.OneOf;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.Range;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.Var;

public class TestSteppDiagReqResDialog extends TitleAreaDialog {
	protected static final String IStructuredSelection = null;
	private String qualifier;
	private Text textPrimitive;
	Composite stackLayoutComposite;
	StackLayout stackLayout;
	private Table table;
	Composite primitiveComposite;
	DiagnosticRequest diagnosticRequest;
	DiagnosticResponse diagnosticResponse;
	TestSpecification testSpecification;
	private Text text;
	private TableViewer tableViewer;

	/**
	 * * Create the dialog. * @param parentShell
	 * 
	 * @param diagnosticService
	 * @param testSpecification
	 */
	public TestSteppDiagReqResDialog(Shell parentShell, TestSpecification testSpecification, Object diagnosticService) {
		super(parentShell);
		this.testSpecification = testSpecification;
		if (diagnosticService instanceof DiagnosticRequest) {
			this.diagnosticRequest = (DiagnosticRequest) diagnosticService;
		} else if (diagnosticService instanceof DiagnosticResponse) {
			this.diagnosticResponse = (DiagnosticResponse) diagnosticService;
		}
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Request and Response");
	}
	
	/** * Create contents of the dialog. * @param parent */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Diagnostic Request and Response");
		setMessage("Diagnostic service with diagnostic request and response details");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(3, false));

		stackLayout = new StackLayout();

		stackLayoutComposite = new Composite(composite, SWT.NONE);
		stackLayoutComposite.setLayout(stackLayout);

		GridData gd_stackLayoutComposite = new GridData(SWT.LEFT, SWT.FILL, false, false, 3, 1);
		gd_stackLayoutComposite.heightHint = 37;
		gd_stackLayoutComposite.widthHint = 677;
		stackLayoutComposite.setLayoutData(gd_stackLayoutComposite);

		primitiveComposite = new Composite(stackLayoutComposite, SWT.NONE);
		primitiveComposite.setLayout(new GridLayout(2, false));

		Label lblPrimitive = new Label(primitiveComposite, SWT.NONE);
		lblPrimitive.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrimitive.setText("Primitive");

		text = new Text(primitiveComposite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		if (null != diagnosticResponse) {
			showPrimitive();
		}
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_table.heightHint = 188;
		gd_table.widthHint = 609;
		table.setLayoutData(gd_table);
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQualifier = tableViewerColumn.getColumn();
		tblclmnQualifier.setAlignment(SWT.CENTER);
		tblclmnQualifier.setWidth(200);
		tblclmnQualifier.setText("Qualifier");
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCopytovar = tableViewerColumn_1.getColumn();
		tblclmnCopytovar.setAlignment(SWT.CENTER);
		tblclmnCopytovar.setWidth(200);
		tblclmnCopytovar.setText("CopyToVar");
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_1.setAlignment(SWT.CENTER);
		tblclmnNewColumn_1.setWidth(200);
		tblclmnNewColumn_1.setText("ValueTypes");

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Button btnAdd = new Button(composite_1, SWT.NONE);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnAdd.setImage(ResourceManager.getPluginImage("com.ancit.diagnostictool.ui", "icons/add_icon.png"));

		Button btnDel = new Button(composite_1, SWT.NONE);
		btnDel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnDel.setImage(ResourceManager.getPluginImage("com.ancit.diagnostictool.ui", "icons/Remove.png"));
		/*
		 * stackLayout.topControl=composite_2; primitiveComposite.layout();
		 */

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new DiagnosticTableLabelProvider());
		if (null != diagnosticRequest) {
			tableViewer.setInput(diagnosticRequest.getDiagparam());
		} else if (null != diagnosticResponse) {
			tableViewer.setInput(diagnosticResponse.getDiagparam());
		}

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selecedObj = (IStructuredSelection) event.getSelection();
				Object oldValue = selecedObj.getFirstElement();
				
				if (oldValue instanceof DiagnosticParam) {
					DiagnosticParam digReq = (DiagnosticParam) oldValue;
					AddDiagnosticParameterDialog addParameter = new AddDiagnosticParameterDialog(
							Display.getDefault().getActiveShell(), testSpecification,digReq);
					int result = addParameter.open();
					if (IDialogConstants.OK_ID == result) {
						
						digReq.setQualifier(addParameter.getQualifier());
						digReq.setCopyToVar(addParameter.getCopyToVariable());
						if (addParameter.getValueType().equalsIgnoreCase("Range")) {
							Range createRange = DiagonosticModelFactory.eINSTANCE.createRange();
							createRange.setFrom(Integer.parseInt(addParameter.getFromValue()));
							createRange.setTo(Integer.parseInt(addParameter.getToValue()));
							digReq.setValueTypes(createRange);

						} else if (addParameter.getValueType().equalsIgnoreCase("OneOf")) {
							OneOf createOneOf = DiagonosticModelFactory.eINSTANCE.createOneOf();
							createOneOf.getValues().addAll(Arrays.asList(addParameter.getOneOfSelectedItem()));
							digReq.setValueTypes(createOneOf);

						} else if (addParameter.getValueType().equalsIgnoreCase("var")) {
							Var createVar = DiagonosticModelFactory.eINSTANCE.createVar();
							createVar.setName(addParameter.getName());
							digReq.setValueTypes(createVar);

						}
						if (null != diagnosticRequest) {
							diagnosticRequest.getDiagparam().add(digReq);
						} else if (null != diagnosticResponse) {
							diagnosticResponse.getDiagparam().add(digReq);
						}
						
						tableViewer.refresh();
					}

				}
			}
		});

		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				if (null != diagnosticRequest) {
					AddDiagnosticParameterDialog addParameter = new AddDiagnosticParameterDialog(
							Display.getDefault().getActiveShell(), testSpecification,null);
					int result = addParameter.open();
					if (IDialogConstants.OK_ID == result) {

						DiagnosticParam disparam = DiagonosticModelFactory.eINSTANCE.createDiagnosticParam();
						disparam.setQualifier(addParameter.getQualifier());
						disparam.setCopyToVar(addParameter.getCopyToVariable());
						if (addParameter.getValueType().equalsIgnoreCase("Range")) {
							Range createRange = DiagonosticModelFactory.eINSTANCE.createRange();
							createRange.setFrom(Integer.parseInt(addParameter.getFromValue()));
							createRange.setTo(Integer.parseInt(addParameter.getToValue()));
							disparam.setValueTypes(createRange);

						} else if (addParameter.getValueType().equalsIgnoreCase("OneOf")) {
							OneOf createOneOf = DiagonosticModelFactory.eINSTANCE.createOneOf();
							createOneOf.getValues().addAll(Arrays.asList(addParameter.getOneOfSelectedItem()));
							disparam.setValueTypes(createOneOf);

						} else if (addParameter.getValueType().equalsIgnoreCase("var")) {
							Var createVar = DiagonosticModelFactory.eINSTANCE.createVar();
							createVar.setName(addParameter.getName());
							disparam.setValueTypes(createVar);

						}
						diagnosticRequest.getDiagparam().add(disparam);
						tableViewer.refresh();
					}

				} else if (null != diagnosticResponse) {
					AddDiagnosticParameterDialog addParameter = new AddDiagnosticParameterDialog(
							Display.getDefault().getActiveShell(), testSpecification,null);
					int result = addParameter.open();
					if (IDialogConstants.OK_ID == result) {

						DiagnosticParam disparam = DiagonosticModelFactory.eINSTANCE.createDiagnosticParam();
						disparam.setQualifier(addParameter.getQualifier());
						disparam.setCopyToVar(addParameter.getCopyToVariable());
						if (addParameter.getValueType().equalsIgnoreCase("Range")) {
							Range createRange = DiagonosticModelFactory.eINSTANCE.createRange();
							createRange.setFrom(Integer.parseInt(addParameter.getFromValue()));
							createRange.setTo(Integer.parseInt(addParameter.getToValue()));
							disparam.setValueTypes(createRange);

						} else if (addParameter.getValueType().equalsIgnoreCase("OneOf")) {
							OneOf createOneOf = DiagonosticModelFactory.eINSTANCE.createOneOf();
							createOneOf.getValues().addAll(Arrays.asList(addParameter.getOneOfSelectedItem()))	;
							disparam.setValueTypes(createOneOf);

						} else if (addParameter.getValueType().equalsIgnoreCase("var")) {
							Var createVar = DiagonosticModelFactory.eINSTANCE.createVar();
							createVar.setName(addParameter.getName());
							disparam.setValueTypes(createVar);

						}
						diagnosticResponse.getDiagparam().add(disparam);
						tableViewer.refresh();
					}
				}
			}
		});

		btnDel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				IStructuredSelection selObj = (IStructuredSelection)tableViewer.getSelection();
				Object firstElement = selObj.getFirstElement();
				if(null != firstElement) {
					tableViewer.remove(firstElement);
					diagnosticRequest.getDiagparam().remove(firstElement);
					tableViewer.refresh();
				}
			}
		});
		return area;
	}

	public void showPrimitive() {
		stackLayout.topControl = primitiveComposite;
		stackLayoutComposite.layout();
	}

	/** * Create contents of the button bar. * @param parent */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/** * Return the initial size of the dialog. */
	@Override
	protected Point getInitialSize() {
		return new Point(704, 491);
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
}
