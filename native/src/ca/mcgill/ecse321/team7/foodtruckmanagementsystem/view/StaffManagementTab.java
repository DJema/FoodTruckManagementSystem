package ca.mcgill.ecse321.team7.foodtruckmanagementsystem.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.controller.StaffController;
import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.controller.StaffControllerAdapter;
import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.model.FoodTruckManagementSystem;
import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.model.Staff;
import ca.mcgill.ecse321.team7.foodtruckmanagementsystem.model.WorkShift;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * This panel, meant to be used as a tab in a JTabbedPane, allows the user to interact with
 * data associated with staff.
 * @author Kevin Laframboise
 *
 */
public class StaffManagementTab extends JPanel {
	
	private JTextField newStaffNameField;
	private JTextField newStaffJobField;
	private JTextField updateStaffNameField;
	private JTextField updateStaffJobField;
	private JTable workShiftTable;
	private JComboBox<String> staffComboBox;
	private JLabel nameLabel;
	private JLabel jobLabel;
	private JLabel errorLabel;

	// Data field
	/**
	 * Index of the selected staff in the combo box.
	 */
	private int selectedStaff;
	/**
	 * String containing any errors.
	 */
	private String error;
	/**
	 * Model to adapt a list of work shift to a 4 column JTable.
	 */
	private WorkShiftTableModel tableModel;

	/**
	 * Create the panel. Code generated by Window Builder.
	 */
	public StaffManagementTab() {

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Create A New Staff Member", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Select A Staff Member to View or Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "View Staff Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edit Staff Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);

		JButton DeleteSelectedStaffButton = new JButton("Delete Selected Staff");
		DeleteSelectedStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStaffButtonActionPerformed();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DeleteSelectedStaffButton))
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 173, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(DeleteSelectedStaffButton))
					.addContainerGap())
		);

		JLabel lblStaffName = new JLabel("Staff name:");

		updateStaffNameField = new JTextField();
		updateStaffNameField.setColumns(10);

		JLabel lblStaffJob = new JLabel("Staff job: ");

		updateStaffJobField = new JTextField();
		updateStaffJobField.setColumns(10);

		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonActionPerformed();
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblStaffName)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(updateStaffNameField, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblStaffJob)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(updateStaffJobField, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(updateButton).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblStaffName)
								.addComponent(updateStaffNameField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStaffJob)
								.addComponent(updateStaffJobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(updateButton))
						.addContainerGap(29, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JScrollPane scrollPane = new JScrollPane();

		nameLabel = new JLabel("");

		jobLabel = new JLabel("");

		JButton NewWSButton = new JButton("Add New Work Shift...");
		NewWSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewWSButtonActionPerformed();
			}
		});

		JButton editWSButton = new JButton("Edit Selected Work Shift...");
		editWSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editWSButtonActionPerformed();
			}
		});

		JButton deleteWSButton = new JButton("Delete Selected Work Shift");
		deleteWSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteWSButtonActionPerformed();
			}
		});

		JLabel lblNewLabel = new JLabel("Name:");

		JLabel lblNewLabel_1 = new JLabel("Job:");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE).addGap(6)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(deleteWSButton, GroupLayout.PREFERRED_SIZE, 215,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(editWSButton, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewWSButton, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel,
														GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jobLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
				.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(13)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup().addGap(1)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(nameLabel)
										.addComponent(lblNewLabel))
								.addGap(10)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(jobLabel)
										.addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(NewWSButton).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(editWSButton).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(deleteWSButton).addGap(1)))
				.addContainerGap()));

		workShiftTable = new JTable();
		scrollPane.setViewportView(workShiftTable);
		panel_2.setLayout(gl_panel_2);

		staffComboBox = new JComboBox<String>();
		staffComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				selectedStaff = cb.getSelectedIndex();
			}
		});

		JButton ViewEditButton = new JButton("View/Edit");
		ViewEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshData();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(staffComboBox, 0, 578, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(ViewEditButton))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(ViewEditButton)
						.addComponent(staffComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewStaffName = new JLabel("New staff name:");
		lblNewStaffName.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblNewStaffJob = new JLabel("New staff job:");
		lblNewStaffJob.setHorizontalAlignment(SwingConstants.TRAILING);

		newStaffNameField = new JTextField();
		newStaffNameField.setColumns(10);

		newStaffJobField = new JTextField();
		newStaffJobField.setColumns(10);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStaffButtonActionPerformed();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewStaffJob, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewStaffName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(newStaffNameField, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
										.addComponent(newStaffJobField, GroupLayout.DEFAULT_SIZE, 322,
												Short.MAX_VALUE)))
						.addComponent(btnCreate, Alignment.TRAILING))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewStaffName).addComponent(
						newStaffNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewStaffJob).addComponent(
						newStaffJobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE).addComponent(btnCreate)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		// End generated code

		// Init work shift table
		tableModel = new WorkShiftTableModel();
		workShiftTable.setModel(tableModel);
		workShiftTable.setFillsViewportHeight(true);

		setVisible(true);

	}

	protected void deleteWSButtonActionPerformed() {
		
		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();
		//Initialize Controller
		StaffController sc = new StaffControllerAdapter();
		
		// Get selected staff and shift
		Staff staff = null;
		WorkShift workShift = null;
		try {
			staff = ftms.getStaff(selectedStaff);
			workShift = staff.getWorkShift(workShiftTable.getSelectedRow());
		} catch (IndexOutOfBoundsException e) {
		}
		
		// Delete selected workShift
		try {
			sc.deleteWorkShift(staff, workShift);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		refreshData();
	}

	protected void editWSButtonActionPerformed() {
		
		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();

		// Get selected staff and work shift
		Staff staff = null;
		WorkShift workShift = null; 
		try {
			staff = ftms.getStaff(selectedStaff);
			workShift = staff.getWorkShift(workShiftTable.getSelectedRow());
		} catch (IndexOutOfBoundsException e) {
		}
		// Show dialog
		try {
			EditWorkShiftDialog dialog = new EditWorkShiftDialog(staff, workShift);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		refreshData();

	}

	protected void addNewWSButtonActionPerformed() {

		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();

		// Get selected staff
		Staff staff = null;
		try {
			staff = ftms.getStaff(selectedStaff);
		} catch (IndexOutOfBoundsException e) {
		}
		// Show dialog
		try {
			EditWorkShiftDialog dialog = new EditWorkShiftDialog(staff);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		refreshData();

	}

	protected void deleteStaffButtonActionPerformed() {

		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();
		// Initialize controller
		StaffController sc = new StaffControllerAdapter();

		Staff staff = null;

		// Verify a valid staff is selected
		if (ftms.getStaffs().size() > 0 && selectedStaff >= 0) {
			staff = ftms.getStaff(selectedStaff);
			// Confirm user wishes to continue with deletion
			String confMsg = "Are you sure you wish to delete staff member " + staff.getName()
					+ "?\nThis action is irreversible. ";
			int choice = JOptionPane.showConfirmDialog(null, confMsg, "Delete staff", JOptionPane.YES_NO_OPTION);
			// Return if user answered no
			if (choice == JOptionPane.NO_OPTION)
				return;
		}

		// Delete staff
		try {
			sc.deleteStaffMember(staff);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		refreshData();

	}

	protected void updateButtonActionPerformed() {

		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();
		// Initialize controller
		StaffController sc = new StaffControllerAdapter();

		// Get staff, staff new name and job
		String name = updateStaffNameField.getText();
		String job = updateStaffJobField.getText();
		Staff staff = null;
		try {
			staff = ftms.getStaff(selectedStaff);
		} catch (IndexOutOfBoundsException e) {
		}

		// Change name and job
		try {
			sc.changeStaffMemberName(staff, name);
			refreshData();
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		try {
			sc.changeStaffMemberJob(staff, job);
			refreshData();
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		refreshData();

	}

	protected void createStaffButtonActionPerformed() {

		// Initialize controller
		StaffController sc = new StaffControllerAdapter();

		// Get staff name and job
		String name = newStaffNameField.getText();
		String job = newStaffJobField.getText();

		// Create staff
		try {
			sc.createStaffMember(name, job);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		refreshData();

	}

	/**
	 * Refreshes all components that display data to the most up-to-date instance of the FoodTruckManagementSystem.
	 */
	public void refreshData() {

		// If an error was detected, show error to user and do nothing
		if (error == null) {
			error = "";
		}
		errorLabel.setText(error);
		if (error.trim().length() > 0) {
			error = "";
			return;
		}

		// Get instance of management system
		FoodTruckManagementSystem ftms = FoodTruckManagementSystem.getInstance();

		// Populate combo box
		String prev = (String) staffComboBox.getSelectedItem();
		Staff current;
		staffComboBox.removeAllItems();
		Iterator<Staff> its = ftms.getStaffs().iterator();
		while (its.hasNext()) {
			current = its.next();
			staffComboBox.addItem(current.getName());
		}
		// Reset selection to what it was before update
		if (prev != null)
			staffComboBox.setSelectedItem(prev);

		// Populate edition text fields with current info about selected staff
		if (selectedStaff >= 0 && ftms.getStaffs().size() > 0) {
			Staff currentStaff = ftms.getStaff(selectedStaff);
			nameLabel.setText(currentStaff.getName());
			jobLabel.setText(currentStaff.getJob());
			updateStaffNameField.setText(currentStaff.getName());
			updateStaffJobField.setText(currentStaff.getJob());
			// Set data for table
			tableModel.setData(currentStaff.getWorkShifts());
			tableModel.fireTableChanged(null);
		} else {
			nameLabel.setText("");
			jobLabel.setText("");
			updateStaffNameField.setText("");
			updateStaffJobField.setText("");
			// Clear data from table
			tableModel.setData(null);
			tableModel.fireTableChanged(null);
		}

		// Clear all text field (except update fields)
		newStaffNameField.setText("");
		newStaffJobField.setText("");

	}
}