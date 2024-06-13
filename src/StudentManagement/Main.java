package StudentManagement;

public class Main {

    public static void main(String[] args) {
    	
    	Course course1 = StudentManagement.addCourse("College Algebra", 1201, 50);
    	Course course2 = StudentManagement.addCourse("Programming1", 1102, 50);
    	Course course3 = StudentManagement.addCourse("English", 1301, 50);
    	Course course4 = StudentManagement.addCourse("Programming Fundamentals", 1101, 50);
    	Course course5 = StudentManagement.addCourse("Calculus", 1201, 50);
    	Course course6 = StudentManagement.addCourse("Programming2", 1103, 50);
    	
    	Student student = StudentManagement.enrollStudent("Bonaventure Okoye", 18);
		StudentManagement.enrollStudentToCourse(student, course1);
		StudentManagement.assignGrade(student, course1, 99);
		StudentManagement.enrollStudentToCourse(student, course2);
		StudentManagement.assignGrade(student, course2, 90);
		StudentManagement.enrollStudentToCourse(student, course3);
		StudentManagement.assignGrade(student, course3, 97);
		StudentManagement.enrollStudentToCourse(student, course5);
		StudentManagement.assignGrade(student, course5, 91);
		
		student = StudentManagement.enrollStudent("Micheal Jackson", 17);
		StudentManagement.enrollStudentToCourse(student, course1);
		StudentManagement.assignGrade(student, course1, 92);
		StudentManagement.enrollStudentToCourse(student, course3);
		StudentManagement.assignGrade(student, course3, 84);
		
		student = StudentManagement.enrollStudent("Fedrick Bush", 18);
		StudentManagement.enrollStudentToCourse(student, course6);
		StudentManagement.assignGrade(student, course6, 89);
		
		student = StudentManagement.enrollStudent("Ronnie Mason", 19);
		StudentManagement.enrollStudentToCourse(student, course3);
		StudentManagement.assignGrade(student, course3, 83);
		StudentManagement.enrollStudentToCourse(student, course4);
		StudentManagement.assignGrade(student, course4, 95);
		StudentManagement.enrollStudentToCourse(student, course5);
		StudentManagement.assignGrade(student, course5, 90);
		
		student = StudentManagement.enrollStudent("Rachel Masaba", 18);
		StudentManagement.enrollStudentToCourse(student, course3);
		StudentManagement.assignGrade(student, course3, 92);
		StudentManagement.enrollStudentToCourse(student, course4);
		StudentManagement.assignGrade(student, course4, 84);
		
		String[] run = new String[0];
		AdministratorInterface.main(run);
    }
}