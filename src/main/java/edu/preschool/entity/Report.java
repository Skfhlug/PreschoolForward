package edu.preschool.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "Report")
@Table(name = "report")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private int emotion;
    private int eating;
    private int sleeping;
    private String report_date;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id",nullable = false)
    private Student student;

    public Report() {
    }

    public Report(int emotion, int eating, int sleeping, String report_date, User user, Student student) {
        this.emotion = emotion;
        this.eating = eating;
        this.sleeping = sleeping;
        this.report_date = report_date;
        this.user = user;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }

    public int getEating() {
        return eating;
    }

    public void setEating(int eating) {
        this.eating = eating;
    }

    public int getSleeping() {
        return sleeping;
    }

    public void setSleeping(int sleeping) {
        this.sleeping = sleeping;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
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
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", emotion=" + emotion +
                ", eating=" + eating +
                ", sleeping=" + sleeping +
                ", report_date='" + report_date + '\'' +
                ", user=" + user +
                ", student=" + student +
                '}';
    }
}
