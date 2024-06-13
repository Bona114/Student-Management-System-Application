package StudentManagement;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private int age;
    private int ID;
    public HashMap<Course, Integer> courseGrades = new HashMap<>();

    public Student(int ID, String name, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int newID) {
        this.ID = newID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Course> getEnrolledCourses() {
		ArrayList<Course> enrolledCourses = new ArrayList<Course>();
		for (Course course : this.courseGrades.keySet()) {
			enrolledCourses.add(course);
		}
        return enrolledCourses;
    }

    public void enrollCourse(Course newCourse) {
        if (!this.courseGrades.containsKey(newCourse)) {
            this.courseGrades.put(newCourse, 0);
            Course.enrolledStudentsCount++;
        }
    }

    public HashMap<Course, Integer> getCourses() {
		return this.courseGrades;
	}
    
    public void assignGrade(Course course, int grade) {
        this.courseGrades.put(course, grade);
    }
    
    public int getGradeForCourse(Course course) {
        return this.courseGrades.get(course);
    }
}
