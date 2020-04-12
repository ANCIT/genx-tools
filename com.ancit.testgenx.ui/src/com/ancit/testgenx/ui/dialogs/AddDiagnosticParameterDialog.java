package com.ancit.testgenx.ui.dialogs;

import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.OneOf;
import DiagonosticModel.Range;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.Var;

public class AddDiagnosticParameterDialog extends TitleAreaDialog {

	private Text txtCopyToVar;
	private Text txtQualifier;
	private String title;
	private Label lblValueTo;
	private Label lblValueFrom;
	private Text txtValueTo;
	private Text txtValueFrom;
	private Composite contentComposite;
	private Composite varComposite;
	private Label lblValueType;
	private Combo combo;
	private Text nametxt;
	private List oneOflist;
	private Composite rangeComposite;
	private Composite listComposite;
	private String qualifier, copyToVariable, valueType, fromValue, toValue, name, inputValues;
	private String[] oneOfSelectedItem;
	private Button btnRemove;
	private Button btnAddList;
	private Text txtAddDataToList;
	private Label lblAddDataToList;
	private String[] listDatas;
	private DiagnosticParam diagnosticParam;
	private StackLayout stackLayout;

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Parameters");
	}
	
	public AddDiagnosticParameterDialog(Shell parentShell, TestSpecification spec, DiagnosticParam diagnosticParam) {
		super(parentShell);
		if (null != diagnosticParam) {
			this.diagnosticParam = diagnosticParam;
		}
	}

	@Override
	public void create() {
		super.create();
		setTitle("Diagnostic parameters");
		setMessage("Create new diagnostic parameters", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		Label lblQualifier = new Label(composite, SWT.NONE);
		lblQualifier.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblQualifier.setText("Qualifier");

		txtQualifier = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtQualifier = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_txtQualifier.widthHint = 313;
		txtQualifier.setLayoutData(gd_txtQualifier);
		new Label(composite, SWT.NONE);

		Label lblCopyToVar = new Label(composite, SWT.NONE);
		lblCopyToVar.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblCopyToVar.setText("Copy To Var");

		txtCopyToVar = new Text(composite, SWT.BORDER);
		txtCopyToVar.setEditable(true);
		GridData gd_txtCopyToVar = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_txtCopyToVar.widthHint = 187;
		txtCopyToVar.setLayoutData(gd_txtCopyToVar);
		txtCopyToVar.setText("");

		stackLayout = new StackLayout();
		new Label(composite, SWT.NONE);

		lblValueType = new Label(composite, SWT.NONE);
		lblValueType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValueType.setText("Value Types");

		combo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		String[] items = { "OneOf", "Range", "Var" };
		combo.setItems(items);
		combo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				if (null != combo.getItem(combo.getSelectionIndex())) {

					if (combo.getItem(combo.getSelectionIndex()).equalsIgnoreCase("Range")) {
						stackLayout.topControl = rangeComposite;
						contentComposite.layout();
						inputValues = "Range";

					} else if (combo.getItem(combo.getSelectionIndex()).equalsIgnoreCase("OneOf")) {
						stackLayout.topControl = listComposite;
						contentComposite.layout();
						inputValues = "OneOf";
					} else {

						stackLayout.topControl = varComposite;
						contentComposite.layout();
						inputValues = "Var";
					}

				}
			}
		});
		new Label(composite, SWT.NONE);

		contentComposite = new Composite(composite, SWT.NONE);
		contentComposite.setLayout(stackLayout);
		contentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		varComposite = new Composite(contentComposite, SWT.NONE);
		GridLayout gl_dbcValueComposite = new GridLayout(2, false);
		varComposite.setLayout(gl_dbcValueComposite);
		new Label(varComposite, SWT.NONE);
		new Label(varComposite, SWT.NONE);

		Label lblName = new Label(varComposite, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 62;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name");

		nametxt = new Text(varComposite, SWT.BORDER);
		GridData gd_nametxt = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_nametxt.heightHint = 20;
		gd_nametxt.widthHint = 527;
		nametxt.setLayoutData(gd_nametxt);

		rangeComposite = new Composite(contentComposite, SWT.NONE);
		rangeComposite.setLayout(new GridLayout(2, false));
		new Label(rangeComposite, SWT.NONE);
		new Label(rangeComposite, SWT.NONE);

		lblValueFrom = new Label(rangeComposite, SWT.NONE);
		GridData gd_lblValueFrom = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblValueFrom.widthHint = 62;
		lblValueFrom.setLayoutData(gd_lblValueFrom);
		lblValueFrom.setText("From");

		txtValueFrom = new Text(rangeComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtValueFrom = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtValueFrom.widthHint = 531;
		txtValueFrom.setLayoutData(gd_txtValueFrom);
		txtValueFrom.setText("");

		lblValueTo = new Label(rangeComposite, SWT.NONE);
		lblValueTo.setText("To");

		txtValueTo = new Text(rangeComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtValueTo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtValueTo.widthHint = 531;
		txtValueTo.setLayoutData(gd_txtValueTo);
		txtValueTo.setText("");

		listComposite = new Composite(contentComposite, SWT.NONE);
		listComposite.setLayout(new GridLayout(4, false));
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);

		lblAddDataToList = new Label(listComposite, SWT.NONE);
		GridData gd_lblAddDataToList = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblAddDataToList.widthHint = 68;
		lblAddDataToList.setLayoutData(gd_lblAddDataToList);
		lblAddDataToList.setText("One Of");
		new Label(listComposite, SWT.NONE);

		txtAddDataToList = new Text(listComposite, SWT.BORDER);
		txtAddDataToList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnAddList = new Button(listComposite, SWT.NONE);
		btnAddList.setImage(ResourceManager.getPluginImage("com.ancit.diagnostictool.ui", "icons/add_icon.png"));
		btnAddList.setEnabled(false);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		new Label(listComposite, SWT.NONE);
		txtAddDataToList.addModifyListener(e -> btnAddList.setEnabled(txtAddDataToList.getText().length() > 0));
		oneOflist = new List(listComposite, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_oneOflist = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_oneOflist.heightHint = 63;
		gd_oneOflist.widthHint = 409;
		oneOflist.setLayoutData(gd_oneOflist);
		btnAddList.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				oneOflist.add(txtAddDataToList.getText().toString());
				oneOflist.update();
				txtAddDataToList.setText("");
			}
		});

		btnRemove = new Button(listComposite, SWT.NONE);
		btnRemove.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				oneOflist.remove(oneOflist.getSelectionIndex());
				oneOflist.update();
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage("com.ancit.diagnostictool.ui", "icons/Remove.png"));
		/*
		 * listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		 * 
		 * @Override public void selectionChanged(SelectionChangedEvent event) { // TODO
		 * Auto-generated method stub IStructuredSelection selection =
		 * (IStructuredSelection)event.getSelection(); if(selection!=null) {
		 * setOneOfSelectedItem(selection.getFirstElement().toString()); }
		 * 
		 * } });
		 */

		setValueintoWighet();
		return container;
	}

	private void setValueintoWighet() {

		if (null != diagnosticParam) {
			combo.forceFocus();
			txtQualifier.setText(diagnosticParam.getQualifier());
			txtCopyToVar.setText(diagnosticParam.getCopyToVar());
			if (diagnosticParam.getValueTypes() instanceof Range) {
				combo.select(1);

				stackLayout.topControl = rangeComposite;
				contentComposite.layout();
				inputValues = "Range";

				Range rangeObj = (Range) diagnosticParam.getValueTypes();
				txtValueFrom.setText("" + rangeObj.getFrom());
				txtValueTo.setText("" + rangeObj.getTo());
//				setToValue(txtValueTo.getText().toString());
			} else if (diagnosticParam.getValueTypes() instanceof OneOf) {
				combo.select(0);
				stackLayout.topControl = listComposite;
				contentComposite.layout();
				inputValues = "OneOf";
				OneOf oneOfObj = (OneOf) diagnosticParam.getValueTypes();
				EList<String> values = oneOfObj.getValues();
				for (String itm : values) {
					oneOflist.add(itm);
				}
				oneOflist.update();
			} else if (diagnosticParam.getValueTypes() instanceof Var) {
				combo.select(2);
				stackLayout.topControl = varComposite;
				contentComposite.layout();
				inputValues = "Var";
				Var varObj = (Var) diagnosticParam.getValueTypes();
				nametxt.setText(varObj.getName());
			}
		} else {
			txtQualifier.setText("");
			txtCopyToVar.setText("");
		}

	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	public void saveInput() {
		setQuaprlifier(txtQualifier.getText().toString());
		setCopyToVariable(txtCopyToVar.getText().toString());
		setValueType(inputValues);

		if (inputValues.equalsIgnoreCase("Range")) {
//			Range createRange = DiagonosticModelFactory.eINSTANCE.createRange();
//			createRange.setFrom(Integer.parseInt(txtValueFrom.getText()));
//			createRange.setTo(Integer.parseInt(txtValueTo.getText().toString()));
//			diagnosticParam.setValueTypes(createRange);
			setFromValue(txtValueFrom.getText().toString());
			setToValue(txtValueTo.getText().toString());
			
		} else if (inputValues.equalsIgnoreCase("OneOf")) {
//			OneOf createOneOf = DiagonosticModelFactory.eINSTANCE.createOneOf();
			setOneOfSelectedItem(oneOflist.getItems());
//			createOneOf.getValues().addAll(Arrays.asList(getOneOfSelectedItem()));
//			diagnosticParam.setValueTypes((OneOf)diagnosticParam.getValueTypes());
			
		} else if (inputValues.equalsIgnoreCase("var")) {
//			diagnosticParam.setValueTypes((Var)diagnosticParam.getValueTypes());
			setName(nametxt.getText().toString());
		}
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getTitle() {
		return title;
	}

	public String getNameTxt() {
		return nametxt.toString();
	}

	public String getTxtCopyToVar() {
		return txtCopyToVar.toString();
	}

	public String getTxtQualifier() {
		return txtQualifier.toString();
	}

	public List getOneOflist() {
		return oneOflist;
	}

	public String getTxtValueFrom() {
		return txtValueFrom.toString();
	}

	/*
	 * public String getValueTo() { return valueTo; }
	 */
	public String getTxtValueTo() {
		return txtValueTo.toString();
	}

	@Override
	protected Point getInitialSize() {
		return new Point(632, 457);
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQuaprlifier(String quaprlifier) {
		this.qualifier = quaprlifier;
	}

	public String getCopyToVariable() {
		return copyToVariable;
	}

	public void setCopyToVariable(String copyToVariable) {
		this.copyToVariable = copyToVariable;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getFromValue() {
		return fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getToValue() {
		return toValue;
	}

	public void setToValue(String toValue) {
		this.toValue = toValue;
	}

	public void setOneOflist(List oneOflist) {
		this.oneOflist = oneOflist;
	}

	public String[] getListDatas() {
		return listDatas;
	}

	public void setListDatas(String[] listDatas) {
		this.listDatas = listDatas;
	}

	public String[] getOneOfSelectedItem() {
		return oneOfSelectedItem;
	}

	public void setOneOfSelectedItem(String[] strings) {
		this.oneOfSelectedItem = strings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
