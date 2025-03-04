package com.restapi.REST.API.Entity;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String rollNumber;
    private int age;
    private String phone;

    private String image;

    public Student() {
        super();
    }

    public Student(Long id, String firstName, String lastName, String email, String password,
                   String rollNumber, int age, String phone, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rollNumber = rollNumber;
        this.age = age;
        this.phone = phone;
        this.image=image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
