package edu.preschool.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String address;
    private String date_of_birth;
    private String class_room;
    private String grade;
    private String emergency_phone1;
    private String emergency_phone2;
    private String picture_address;
    private String parent_status;
    private String gender;

    public Student() {
    }

    public Student(String first_name, String middle_name, String last_name, String address, String date_of_birth, String class_room, String grade, String emergency_phone1, String emergency_phone2, String picture_address, String parent_status, String gender) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.class_room = class_room;
        this.grade = grade;
        this.emergency_phone1 = emergency_phone1;
        this.emergency_phone2 = emergency_phone2;
        this.picture_address = picture_address;
        this.parent_status = parent_status;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmergency_phone1() {
        return emergency_phone1;
    }

    public void setEmergency_phone1(String emergency_phone1) {
        this.emergency_phone1 = emergency_phone1;
    }

    public String getEmergency_phone2() {
        return emergency_phone2;
    }

    public void setEmergency_phone2(String emergency_phone2) {
        this.emergency_phone2 = emergency_phone2;
    }

    public String getPicture_address() {
        return picture_address;
    }

    public void setPicture_address(String picture_address) {
        this.picture_address = picture_address;
    }

    public String getParent_status() {
        return parent_status;
    }

    public void setParent_status(String parent_status) {
        this.parent_status = parent_status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
/*
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", class_room='" + class_room + '\'' +
                ", grade='" + grade + '\'' +
                ", emergency_phone1='" + emergency_phone1 + '\'' +
                ", emergency_phone2='" + emergency_phone2 + '\'' +
                ", picture_address='" + picture_address + '\'' +
                ", parent_status='" + parent_status + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }*/
}
