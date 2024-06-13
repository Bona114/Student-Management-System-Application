package StudentManagement;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentManagement {
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final HashMap<Student, HashMap<Course, Integer>> studentList = new HashMap<>();
    private static final HashMap<Student, Integer> studentGrades = new HashMap<>();
    private static final HashMap<Student, Integer> studentIDs = new HashMap<>();
    
    public static void updateStudentName(Student student, String newName) {
    	student.setName(newName);
    }
    
    public static void updateStudentAge(Student student, int newAge) {
    	student.setAge(newAge);
    }

    public static Course addCourse(String name, int code, int maximumCapacity) {
        Course course = new Course(name, code, maximumCapacity);
        courses.add(course);
        return course;
    }
    
    public static Student enrollStudent(String name, int age) { 
    	int ID = 1;
    	int maxID = 0;
    	if (!studentIDs.isEmpty()) {
            for (int i : studentIDs.values()) {
                if (i > maxID) {
                    maxID = i;
                	}
                }
            ID = maxID+1;
            }
    	
        Student student = new Student(ID, name, age);
        studentIDs.put(student, ID);
        studentList.put(student, student.getCourses());
        return student;
    }

    public static HashMap<Student, HashMap<Course, Integer>> getStudentList() {
    	return studentList;
    }
    
    public static void enrollStudentToCourse(Student student, Course course) {
        student.enrollCourse(course);
    }

    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
        calculateOverallGrade(student);
    }

    public static void calculateOverallGrade(Student student) {
        if (student.courseGrades.isEmpty()) {
            studentGrades.put(student, 0);
        } else {
            int sum = 0;
            for (int grade : student.courseGrades.values()) {
                sum += grade;
            }
            studentGrades.put(student, sum / student.courseGrades.size());
        }
    }

    public static Course[] getCourseList() {
        return courses.toArray(new Course[0]);
    }

    public static int getStudentOverallGrade(Student student) {
        if (studentGrades.get(student) == null) {
        	return 0;
        }
        return studentGrades.get(student);
    }
}
