package StudentManagement;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Component;

public class CourseListRenderer extends JLabel implements ListCellRenderer<Course> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<? extends Course> list, Course value, int index, boolean isSelected, boolean cellHasFocus) {
    	if (value instanceof Course) {
        	setText(value.getName() + " " + value.getCourseCode());
        } else {
            setText("");
        }
        return this;
    }
}