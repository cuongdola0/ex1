
package Ex2;

import java.util.ArrayList;

public class StudentList {
    ArrayList<Student> studentList =  new ArrayList<>();
    public void addStudent(Student student)
    {
        studentList.add(student);
    }
   public void deleteStudentByid(String id)
    {
        studentList.removeIf(student->student.getId().equals(id));
    }
   public Student findStudentById(String id)
   {
       for (Student student: studentList)
       {
           if (student.getId().equals(id))
           {
          return student;
       
           }
       }
       return null;
   }
    public void displayAllStudent(){
       for (Student student:studentList)
       {
           student.displayInfo();
       }
   }
   public Student findTopStudent()
   {
        if (studentList.isEmpty())
        {
            return null;
        }
        Student topStudent= studentList.get(0);
        for (Student student: studentList)
        {
            if (student.getGPA()>topStudent.getGPA())
            {
                topStudent=student;
            }
        }
        return topStudent;
   }
   public ArrayList<Student> findScholarshipStudent(){
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.scholarship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
   }
    public double calculateTuiitionOfAllStudent(){
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.calculateTuition();
        }
        return totalTuition;
    }
    public void updateStudentById(String id, Student newStudentData) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.set(i, newStudentData);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    public void displayStudentsWithScholarship() {
        boolean hasScholarship = false;
        for (Student student : studentList) {
            if (student.scholarship()) {
                student.displayInfo();
                hasScholarship = true;
            }
        }
        if (!hasScholarship) {
            System.out.println("khong ai co hoc bong.");
        }
    }
}