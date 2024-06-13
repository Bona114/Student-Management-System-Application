package StudentManagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;

import java.text.NumberFormat;


public class AddNewStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;


	// Constructor
	public AddNewStudent(int x, int y) {
		// Frame setup
		setResizable(false);
		setTitle("Add New Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Labels
		JLabel lblEnterStudentDetails = new JLabel("Enter Student Details");
		lblEnterStudentDetails.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Text fields
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldName.setColumns(10);
		
		NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setParseIntegerOnly(true);
        final JFormattedTextField textFieldAge = new JFormattedTextField(integerFormat);
		textFieldAge.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldAge.setColumns(10);
		
		// Done Button
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Select course label and combo box
		JLabel lblSelectCourse = new JLabel("Select a course");
		lblSelectCourse.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		final JComboBox<Course> courseComboBox = new JComboBox<>(StudentManagement.getCourseList());
		courseComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		courseComboBox.setRenderer(new CourseListRenderer());
		
		// Button action listener
		btnDone.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String name = textFieldName.getText();
		    	String ageText = textFieldAge.getText();
		    	if (name.trim().isEmpty()) {
		    		showErrorPopup("Cannot have an empty name field");
		    	} else if (ageText.isEmpty()){
		    		showErrorPopup("Cannot have an empty age field");
		    	} else {
			    	int age = Integer.parseInt(ageText);
			    	Course course = courseComboBox.getItemAt(courseComboBox.getSelectedIndex());
			    	Student student = StudentManagement.enrollStudent(name, age);
			    	StudentManagement.enrollStudentToCourse(student, course);
			    	AdministratorInterface.getInstance().refresh();
			    	showSuccessPopup("Added '" + student.getName() + "' ID: " + student.getID());
			    	dispose();
			    	}
		    	}
		});
		
		// Setup GroupLayout for contentPane **IGNORE**
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblSelectCourse, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(courseComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addComponent(btnDone))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(132)
							.addComponent(lblEnterStudentDetails, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEnterStudentDetails, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectCourse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDone)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	// Method to show error message popup
	public void showErrorPopup(String message) {
		JLabel label = new JLabel(message);
	    label.setFont(new Font("Segoe UI", Font.PLAIN, 11));

	    JOptionPane.showMessageDialog(contentPane, label, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	// Method to show success message popup
	public void showSuccessPopup(String message) {
	    JLabel label = new JLabel(message);
	    label.setFont(new Font("Segoe UI", Font.PLAIN, 11));

	    JOptionPane.showMessageDialog(contentPane, label, "Success", JOptionPane.INFORMATION_MESSAGE);
	}
}