package Ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private float GPA;
    private String major;
    private final double tuition = 10000000;
    private boolean scholarship;

    // Constructor mặc định
    public Student() {
    }

    // Constructor đầy đủ tham số
    public Student(String id, String fullName, Date dateOfBirth, float GPA, String major) {
        super(id, fullName, dateOfBirth);  // Gọi constructor của lớp cha
        this.GPA = GPA;
        this.major = major;
        this.scholarship = GPA >= 9.0;  // Cấp học bổng nếu GPA >= 9
    }

    // Getter và Setter cho các thuộc tính
    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
        this.scholarship = GPA >= 9.0;  // Cập nhật trạng thái học bổng khi thay đổi GPA
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean scholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    // Phương thức hiển thị thông tin sinh viên
    @Override
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(getDateOfBirth());

        System.out.println("ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + formattedDate);
        System.out.println("GPA: " + GPA);
        System.out.println("Major: " + major);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }

    // Phương thức tính học phí
    public double calculateTuition() {
        if (scholarship) {
            return tuition * 0.5;  // Giảm 50% học phí nếu có học bổng
        }
        return tuition;
    }
}