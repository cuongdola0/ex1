package Ex2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Processor {

    
    public static void main(String[] args) throws ParseException {
        Scanner scanner= new Scanner(System.in);
        StudentList studentList =  new StudentList();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        boolean exit=false;
        while (!exit)
        {
            System.out.println("1. them moi student");
            System.out.println("2. cap nhat thong tin");
            System.out.println("3. xoa id");
            System.out.println("4. hien thi tat ca sinh vien");
            System.out.println("5. tim sinh vien co gpa cao nhat");
            System.out.println("6. hien thi sinh vien co hoc bong");
            System.out.println("7. tong hoc phi cua tat ca sinh vien");
            System.out.println("8. thoat");
            int choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    scanner.nextLine();
                    System.out.print("ID: ");
                    String id=scanner.nextLine();
                    System.out.print("fullName: ");
                    String fullName=scanner.nextLine();
                    System.out.print("Date of Birth(dd/MM/yyyy): ");
                    String dob=scanner.nextLine();
                    Date dateOfBirth=formatter.parse(dob);
                    System.out.print("GPA: ");
                    float GPA = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("major: ");
                    String major=scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, dateOfBirth,GPA, major));
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Nhap id can thay doi");
                    String updateId= scanner.nextLine();
                    Student studentToUpdate = studentList.findStudentById(updateId);
                    if (studentToUpdate != null) {
                        System.out.print("ten: ");
                        String updatedFullName = scanner.nextLine();
                        System.out.print(" birth (dd/MM/yyyy): ");
                        Date updatedDob = formatter.parse(scanner.nextLine());

                        System.out.print("GPA: ");
                        float updatedGpa = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print(" major: ");
                        String updatedMajor = scanner.nextLine();
                        Student updatedStudent = new Student(updateId, updatedFullName, updatedDob, updatedGpa, updatedMajor);
                        studentList.updateStudentById(updateId, updatedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Nhap ID can xoa: ");
                    String deleteid=scanner.nextLine();
                    studentList.deleteStudentByid(deleteid);
                    break;
                case 4:
                    System.out.print("thong tin sinh vien");
                    studentList.displayAllStudent();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                       if (topStudent != null) {
                       System.out.println("sinh vien co gpa cao nhat:");
                             topStudent.displayInfo();
                          }
                    break;
                case 6:
                        System.out.println("thong tin sinh vien co hoc bong cao nhat:");
                         studentList.displayStudentsWithScholarship();
                     
                    break;
                case 7:
                    double totalTuition = studentList.calculateTuiitionOfAllStudent();
                        System.out.println("Tổng học phí: " + totalTuition);
                        break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("moi nhap lai");
            }
                    
        }
        scanner.close();
    }
    
}