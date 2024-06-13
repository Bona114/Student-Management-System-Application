package StudentManagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.*;
import javax.swing.event.*;

import java.text.NumberFormat;
import java.text.Format;


public class StudentDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTable table;
	private Student student;
	private String studentName;
	private int studentAge;
	
	
	// Constructor
	public StudentDetails(Student student, int x, int y) {
		// Frame setup
		setResizable(false);
		setTitle("Student Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.student = student;
		this.studentName = student.getName();
		this.studentAge = student.getAge();
		
		// Labels
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblStudentID = new JLabel(String.valueOf(student.getID()));
		lblStudentID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblManageCourses = new JLabel("Enrolled Courses");
		lblManageCourses.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Text fields
		textFieldName = new JTextField(student.getName());
		textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldName.setColumns(10);
		
		NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setParseIntegerOnly(true);
		
		final JFormattedTextField textFieldAge = new JFormattedTextField((Format) null);
		textFieldAge.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldAge.setColumns(10);
		textFieldAge.setValue(student.getAge());
		
		// Buttons
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton btnEnrollToCourse = new JButton("Enroll To Course");
		btnEnrollToCourse.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Combo box
		final JComboBox<Course> courseComboBox = new JComboBox<>(StudentManagement.getCourseList());
		courseComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		courseComboBox.setRenderer(new CourseListRenderer());
		
		// Scroll pane
		JScrollPane coursesScrollPane = new JScrollPane();
		
		// Button action listeners
		btnDone.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String newName = textFieldName.getText();
		    	String ageText = textFieldAge.getText();
		    	
		    	if (newName.trim().isEmpty()) {
		    		showErrorPopup("Cannot have an empty name field");
		    	} else if (ageText.isEmpty()){
		    		showErrorPopup("Cannot have an empty age field");
		    	} else {
		    		int newAge = Integer.parseInt(ageText);
			    	
			    	if (!studentName.equals(newName)) {
			    		getStudent().setName(newName);
			    		showSuccessPopup("Changed Student Name to " + newName);
			    	}
			    	if (studentAge != newAge) {
			    		getStudent().setAge(newAge);
			    		showSuccessPopup("Changed Student Age to " + newAge);
			    	}
			    	
			    	AdministratorInterface.getInstance().refresh();
			    	dispose();
			    	}
		    	}
		});
		
		btnEnrollToCourse.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Student student = getStudent();
		    	Course course = courseComboBox.getItemAt(courseComboBox.getSelectedIndex());
		    	StudentManagement.enrollStudentToCourse(student, course);
		    	showSuccessPopup("Enrolled " + student.getName() + " to " + course.getName());
		    	refresh();
		    	}
		});
		
		// Setup GroupLayout for contentPane **IGNORE**
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStudentID, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldAge, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblManageCourses, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(coursesScrollPane, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnEnrollToCourse, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))))
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(194)
							.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
							.addGap(112))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStudentID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(coursesScrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManageCourses, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnrollToCourse)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDone)
					.addGap(13))
		);
		contentPane.setLayout(gl_contentPane);
		
		// Table setup
		final DefaultTableModel model = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column != 0;
		    }
		};
        model.addColumn("Course");
        model.addColumn("Grade");
        model.setColumnIdentifiers(new Object[]{"Course", "Grade"});

        Course[] courses = student.getEnrolledCourses().toArray(new Course[0]);
        for (int i = 0; i < courses.length; i++) {
            Course course = courses[i];
            int grade = student.getGradeForCourse(course);
            model.addRow(new Object[]{course.getName(), grade});
        }
		
		table = new JTable(model);
		coursesScrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setSelectionBackground(table.getBackground());
		table.getColumn("Grade").setCellEditor(new DefaultCellEditor(new JTextField()));
		
		table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    // If the grade column was updated
                    if (column == 1) {
                    	String courseName = (String) table.getModel().getValueAt(row, 0);
                    	
                    	Course selectedCourse = null;
                    	for (Course course:StudentManagement.getCourseList()) {
                    		if (course.getName().equals(courseName)) {
                    			selectedCourse = course;
                    		}
                    	}
                    	
                        int updatedGrade = Integer.parseInt( (String) table.getModel().getValueAt(row, column));
                        StudentManagement.assignGrade(getStudent(), selectedCourse, updatedGrade);
                    }
                }
            }
        });
	}
	
	
	// Getter for student
    public Student getStudent() {
        return student;
    }
	
    // Method to display error popup
	public void showErrorPopup(String message) {
		JLabel label = new JLabel(message);
	    label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	    
	    JOptionPane.showMessageDialog(contentPane, label, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	// Method to display success popup
	public void showSuccessPopup(String message) {
	    JLabel label = new JLabel(message);
	    label.setFont(new Font("Segoe UI", Font.PLAIN, 11));

	    JOptionPane.showMessageDialog(contentPane, label, "Success", JOptionPane.INFORMATION_MESSAGE);
	}


	// Method to refresh the frame
	public void refresh() {
		int x = this.getX();
	    int y = this.getY();
	    
	    StudentDetails studentDetailsFrame = new StudentDetails(student, x, y);
		studentDetailsFrame.setVisible(true);
		this.dispose();
	}
}