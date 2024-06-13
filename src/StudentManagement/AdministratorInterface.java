package StudentManagement;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;


public class AdministratorInterface {

	// Singleton instance
	private static AdministratorInterface instance;
	
	
	// GUI components
	private JFrame frmAdministratorInterface;
	private static HashMap<JRadioButton, Student> studentMap = new HashMap<>();
	private final ButtonGroup studentButtonGroup = new ButtonGroup();

	
	// Entry point of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Initialize and display the GUI
					AdministratorInterface window = new AdministratorInterface(100, 100);
					window.frmAdministratorInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Constructor
	public AdministratorInterface(int x, int y) {
		initialize(x, y);
	}
	
	
	// Singleton instance retrieval method
	public static AdministratorInterface getInstance() {
        return instance;
    }
	
	
	// Method to refresh the interface
	public void refresh() {
		int x = frmAdministratorInterface.getX();
	    int y = frmAdministratorInterface.getY();
	
	    try {
	    	// Create a new instance of the interface with the same position
			AdministratorInterface window = new AdministratorInterface(x, y);
			window.frmAdministratorInterface.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    // Dispose the current interface
		this.frmAdministratorInterface.dispose();
	}
	
	
	// Initialize the GUI components
	private void initialize(int x, int y) {
		instance = this;
		
		// Set up JFrame properties
		frmAdministratorInterface = new JFrame();
		frmAdministratorInterface.setResizable(false);
		frmAdministratorInterface.getContentPane().setBackground(new Color(255, 255, 255));
		frmAdministratorInterface.setTitle("Administrator Interface");
		frmAdministratorInterface.setBounds(x, y, 600, 400);
		frmAdministratorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create tabbed pane for managing students and courses
		JTabbedPane Tab = new JTabbedPane(JTabbedPane.TOP);
		Tab.setBorder(new LineBorder(new Color(192, 192, 192)));
		Tab.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Set up GroupLayout for main content pane 
		GroupLayout groupLayout = new GroupLayout(frmAdministratorInterface.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(Tab, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(Tab, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		// Add tabs and panels for managing students and courses
		setupStudentsPanel(Tab);
        setupCoursesPanel(Tab);
        
		
		frmAdministratorInterface.getContentPane().setLayout(groupLayout);
	}
	
	
	// Set up the panel for managing students
    private void setupStudentsPanel(JTabbedPane Tab) {
    	
    	// Set up students panel
    	JPanel studentsPanel = new JPanel();
		studentsPanel.setBackground(Color.WHITE);
		
		
		// Set up main students panel and labels
		JPanel stMainPanel = new JPanel();
		stMainPanel.setBackground(Color.WHITE);
		
		JScrollPane stScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		stScrollPane.setViewportView(stMainPanel);
		
		JPanel headerID = new JPanel();
		headerID.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerID.setBackground(Color.WHITE);
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerID.add(lblID);
		
		JPanel headerStudentName = new JPanel();
		headerStudentName.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerStudentName.setBackground(Color.WHITE);
		JLabel lblStudentname = new JLabel("Student Name");
		lblStudentname.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerStudentName.add(lblStudentname);
		
		JPanel headerOverallGrade = new JPanel();
		headerOverallGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerOverallGrade.setBackground(Color.WHITE);
		JLabel lblOverallGrade = new JLabel("Overall Grade");
		lblOverallGrade.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerOverallGrade.add(lblOverallGrade);
		
		JPanel stHeaderExtra = new JPanel();
		stHeaderExtra.setBorder(new LineBorder(new Color(0, 0, 0)));
		stHeaderExtra.setBackground(Color.WHITE);
		
		JPanel stViewportPanel = new JPanel();
		stViewportPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		stViewportPanel.setBackground(Color.WHITE);
		
		// Set up GroupLayout for main panel **IGNORE**
		GroupLayout gl_stMainPanel = new GroupLayout(stMainPanel);
		gl_stMainPanel.setHorizontalGroup(
			gl_stMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stMainPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_stMainPanel.createSequentialGroup()
						.addComponent(headerID, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerStudentName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerOverallGrade, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(stHeaderExtra, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addComponent(stViewportPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
		);
		gl_stMainPanel.setVerticalGroup(
			gl_stMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stMainPanel.createSequentialGroup()
					.addGroup(gl_stMainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(headerID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerStudentName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerOverallGrade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(stHeaderExtra, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addComponent(stViewportPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		stMainPanel.setLayout(gl_stMainPanel);
		
		
		// Add footer panel and buttons for managing students
		JPanel stFooterPanel = new JPanel();
		
		JButton btnAddNewStudent = new JButton("Add New Student");
		btnAddNewStudent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton btnViewStudentDetails = new JButton("View Details");
		btnViewStudentDetails.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// Set up GroupLayout for footer panel **IGNORE**
		GroupLayout gl_stFooterPanel = new GroupLayout(stFooterPanel);
		gl_stFooterPanel.setHorizontalGroup(
		gl_stFooterPanel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_stFooterPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAddNewStudent, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
					.addComponent(btnViewStudentDetails, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveStudent, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_stFooterPanel.setVerticalGroup(
			gl_stFooterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stFooterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_stFooterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_stFooterPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRemoveStudent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnViewStudentDetails, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE))
						.addComponent(btnAddNewStudent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		stFooterPanel.setLayout(gl_stFooterPanel);
		
		// Set up GroupLayout for students panel **IGNORE**
		GroupLayout gl_studentsPanel = new GroupLayout(studentsPanel);
		gl_studentsPanel.setHorizontalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 427, Short.MAX_VALUE)
				.addComponent(stScrollPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
				.addComponent(stFooterPanel, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
		);
		gl_studentsPanel.setVerticalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 230, Short.MAX_VALUE)
				.addGroup(gl_studentsPanel.createSequentialGroup()
					.addComponent(stScrollPane, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
					.addComponent(stFooterPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		studentsPanel.setLayout(gl_studentsPanel);
		
		// Set up 'AddNewStudent' button
		btnAddNewStudent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int x = frmAdministratorInterface.getX() + 100;
			    int y = frmAdministratorInterface.getY() + 100;
		    	AddNewStudent newStudentFrame = new AddNewStudent(x, y);
		        newStudentFrame.setVisible(true);
		    }
		});
		
		// Set up 'ViewStudentDetails' button
		btnViewStudentDetails.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JRadioButton selectedButton = getSelectedButtonText(studentButtonGroup);
		    	Student student = studentMap.get(selectedButton); 
		    	if (student == null) {
		    		showErrorPopup("No Student Selected");
		    	} else {
		    		int x = frmAdministratorInterface.getX() + 100;
		    		int y = frmAdministratorInterface.getY() + 100;
		    		StudentDetails studentDetailsFrame = new StudentDetails(student, x, y);
		    		studentDetailsFrame.setVisible(true);
		        }
		    }
		});
		
		// Set up 'RemoveStudent' button
		btnRemoveStudent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JRadioButton selectedButton = getSelectedButtonText(studentButtonGroup);
		    	Student student = studentMap.get(selectedButton);
		    	if (student == null) {
		    		showErrorPopup("No Student Selected");
		    	} else {
		    		int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove "
		    				+ student.getName()
		    				+ "?\nThis process cannot be reversed.", "Confirm Removal", JOptionPane.YES_NO_OPTION);
		    		if (response == JOptionPane.YES_OPTION) {
		    			StudentManagement.getStudentList().remove(student);
		    			student = null;
			    		refresh();
		    		}
		    	}
		    }
		});
		
		// Retrieve student objects from StudentManagement class
		displayStudents(stViewportPanel, studentButtonGroup);
		
		// Add studentsPanel to the tabbed pane
		Tab.addTab("Students", null, studentsPanel, null);
    }
    
    
    // Set up the panel for managing courses
    private void setupCoursesPanel(JTabbedPane Tab) {
    	
    	// Set up courses panel
    	JPanel coursesPanel = new JPanel();
		coursesPanel.setBackground(new Color(255, 255, 255));
		Tab.addTab("Courses", null, coursesPanel, null);
		
		// Set up main courses panel and labels
		JPanel csMainPanel = new JPanel();
		csMainPanel.setBackground(Color.WHITE);
		
		JScrollPane csScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		csScrollPane.setViewportView(csMainPanel);
		
		JPanel headerCode = new JPanel();
		headerCode.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerCode.setBackground(Color.WHITE);
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerCode.add(lblCode);
		
		JPanel headerCourseName = new JPanel();
		headerCourseName.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerCourseName.setBackground(Color.WHITE);
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerCourseName.add(lblCourseName);
		
		JPanel headerStudentsCount = new JPanel();
		headerStudentsCount.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerStudentsCount.setBackground(Color.WHITE);
		JLabel lblNumberOfStudents = new JLabel("Students Count");
		lblNumberOfStudents.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerStudentsCount.add(lblNumberOfStudents);
		
		JPanel headerMaxCapacity = new JPanel();
		headerMaxCapacity.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerMaxCapacity.setBackground(Color.WHITE);
		JLabel lblMax = new JLabel("Max Capacity");
		lblMax.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		headerMaxCapacity.add(lblMax);
		
		JPanel csHeaderExtra = new JPanel();
		csHeaderExtra.setBorder(new LineBorder(new Color(0, 0, 0)));
		csHeaderExtra.setBackground(Color.WHITE);
		
		JPanel csViewportPanel = new JPanel();
		csViewportPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		csViewportPanel.setBackground(Color.WHITE);
		
		// Set up GroupLayout for main panel **IGNORE**
		GroupLayout gl_csMainPanel = new GroupLayout(csMainPanel);
		gl_csMainPanel.setHorizontalGroup(
			gl_csMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_csMainPanel.createSequentialGroup()
					.addGroup(gl_csMainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_csMainPanel.createSequentialGroup()
							.addComponent(headerCode, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addComponent(headerCourseName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addComponent(headerStudentsCount, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addComponent(headerMaxCapacity, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addComponent(csHeaderExtra, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addComponent(csViewportPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)))
		);
		gl_csMainPanel.setVerticalGroup(
			gl_csMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_csMainPanel.createSequentialGroup()
					.addGroup(gl_csMainPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(headerCode, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerCourseName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerStudentsCount, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerMaxCapacity, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(csHeaderExtra, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addComponent(csViewportPanel, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
		);
		csMainPanel.setLayout(gl_csMainPanel);
		
		
		// Add footer panel and buttons for managing courses
		JPanel csFooterPanel = new JPanel();
		
		JButton btnAddNewCourse = new JButton("Add New Course");
		btnAddNewCourse.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton btnViewCourseDetails = new JButton("View Details");
		btnViewCourseDetails.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		
		// Set up GroupLayout for footer panel **IGNORE**
		GroupLayout gl_csFooterPanel = new GroupLayout(csFooterPanel);
		gl_csFooterPanel.setHorizontalGroup(
			gl_csFooterPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_csFooterPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAddNewCourse, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
					.addComponent(btnViewCourseDetails, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeleteCourse, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_csFooterPanel.setVerticalGroup(
			gl_csFooterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_csFooterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_csFooterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewCourseDetails, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(btnAddNewCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		csFooterPanel.setLayout(gl_csFooterPanel);
		
		// Set up GroupLayout for courses panel **IGNORE**
		GroupLayout gl_coursesPanel = new GroupLayout(coursesPanel);
		gl_coursesPanel.setHorizontalGroup(
			gl_coursesPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(csScrollPane, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
				.addGroup(gl_coursesPanel.createSequentialGroup()
					.addComponent(csFooterPanel, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
		);
		gl_coursesPanel.setVerticalGroup(
			gl_coursesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_coursesPanel.createSequentialGroup()
					.addComponent(csScrollPane, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
					.addComponent(csFooterPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		coursesPanel.setLayout(gl_coursesPanel);
    }
	
    
    // Method for retrieving student objects from StudentManagement class
	public static void displayStudents(JPanel stViewportPanel, ButtonGroup buttonGroup) {
		// Create GroupLayout for managing the layout of the stViewportPanel
		GroupLayout gl_stViewportPanel = new GroupLayout(stViewportPanel);
		GroupLayout.ParallelGroup pg_stViewportPanel = gl_stViewportPanel.createParallelGroup(Alignment.LEADING);
		GroupLayout.SequentialGroup sg_stViewportPanel = gl_stViewportPanel.createSequentialGroup();
		
		// Loop through the list of students obtained from StudentManagement class
		for (Student student : StudentManagement.getStudentList().keySet()) {
			
			// Create a panel to contain student information
			JPanel studentPanel = new JPanel();
			
			// Horizontal layout constraints for studentPanel
			gl_stViewportPanel.setHorizontalGroup(
				pg_stViewportPanel.addComponent(studentPanel, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
			);
			// Vertical layout constraints for studentPanel
			gl_stViewportPanel.setVerticalGroup(
				sg_stViewportPanel
						.addComponent(studentPanel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
			);
			
			// Add labels for displaying student information
			JLabel lblStudentID = new JLabel(String.valueOf(student.getID()));
			lblStudentID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			
			JLabel lblStudentName = new JLabel(student.getName());
			lblStudentName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			
			JLabel lblStudentOverallGrade = new JLabel(String.valueOf(StudentManagement.getStudentOverallGrade(student)));
			lblStudentOverallGrade.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			
			// Radio button for selecting the student
			JRadioButton rdbtnSelect = new JRadioButton("Select");
			buttonGroup.add(rdbtnSelect);
			rdbtnSelect.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			
			// Map the radio button to the corresponding student
			studentMap.put(rdbtnSelect, student);
			
			// Set up GroupLayout for studentPanel **IGNORE**
			GroupLayout gl_studentPanel = new GroupLayout(studentPanel);
			gl_studentPanel.setHorizontalGroup(
				gl_studentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_studentPanel.createSequentialGroup()
						.addComponent(lblStudentID, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentOverallGrade, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnSelect, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
			);
			gl_studentPanel.setVerticalGroup(
				gl_studentPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_studentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(lblStudentOverallGrade, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(rdbtnSelect))
					.addComponent(lblStudentID, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
			);
			studentPanel.setLayout(gl_studentPanel);
		}
	stViewportPanel.setLayout(gl_stViewportPanel);
	}
	
	
	// Method to get selected radio button
	public JRadioButton getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
        	JRadioButton button = (JRadioButton) buttons.nextElement();

            if (button.isSelected()) {
                return button;
            }
        }
        return null;
	}
	
	
	// Method to display error popup
	public void showErrorPopup(String message) {
		JLabel label = new JLabel(message);
	    label.setFont(new Font("Segoe UI", Font.PLAIN, 11));

	    JOptionPane.showMessageDialog(frmAdministratorInterface, label, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
