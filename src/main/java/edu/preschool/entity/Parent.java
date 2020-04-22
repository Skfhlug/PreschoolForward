package edu.preschool.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Parent")
@Table(name = "parent")
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id",nullable = false)
    private Student student;

    public Parent() {
    }

    public Parent(String gender, User user, Student student) {
        this.gender = gender;
        this.user = user;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return id == parent.id &&
                Objects.equals(gender, parent.gender) &&
                Objects.equals(user, parent.user) &&
                Objects.equals(student, parent.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, user, student);
    }
/*
    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", user=" + user +
                ", student=" + student +
                '}';
    }*/
}
