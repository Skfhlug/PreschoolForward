package edu.preschool.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * A class to represent a admin.
 *
 * @author Suparin Fhlug
 */
@Entity(name = "Admin")
@Table(name = "admin")
public class Admin {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String username;
    private String password;
    private String email;
    private String phone;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //cascade = CascadeType.ALL => mean if we delete admin, we will delete all of reminder that was made by that admin
    //@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Reminder> reminders = new HashSet<>();

    /**
     * Instantiates a new Admin.
     */
    public Admin() {

    }

    /**
     * Instantiates a new Admin.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the username
     * @param password  the password
     * @param email     the email
     * @param phone     the phone
     */
    public Admin(String firstName, String lastName, String username, String password, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets reminder.
     *
     * @return the reminder
     */
    public Set<Reminder> getReminders() {
        return reminders;
    }

    /**
     * Sets reminder.
     *
     * @param reminders the reminder
     */
    public void setRemainder(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    /**
     * Add reminder.
     *
     * @param reminder the reminder
     */
    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
        reminder.setAdmin(this);
    }

    /**
     * Remove reminder.
     *
     * @param reminder the reminder
     */
    public void removeReminder(Reminder reminder) {
        reminders.add(reminder);
        reminder.setAdmin(null);
    }
    @Override
    public String toString() {
        return "Admin{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
//Two methods below help update test pass
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&
                firstName.equals(admin.firstName) &&
                lastName.equals(admin.lastName) &&
                username.equals(admin.username) &&
                password.equals(admin.password) &&
                email.equals(admin.email) &&
                phone.equals(admin.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, password, email, phone, id);
    }
}
