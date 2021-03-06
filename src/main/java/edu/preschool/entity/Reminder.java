package edu.preschool.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Reminder.
 */
@Entity(name="reminder")
@Table(name="reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;
    private String reminder_title;
    private String description;
    private String status;

    @ManyToOne
    private User user;

    public Reminder() {
    }

    /**
     * Instantiates a new Reminder.
     *
     * @param reminder_title       the reminder title
     * @param reminder_description the reminder description
     */
    public Reminder(String reminder_title, String reminder_description, User newUser) {
    }

    /**
     * Instantiates a new Reminder.
     *
     * @param reminder_title the reminder title
     * @param description    the description
     * @param status         the status
     * @param user          the user
     */
    public Reminder(String reminder_title, String description, String status, User user) {
        this.reminder_title = reminder_title;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Reminder(String title, String description, int userId, String status) {
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
     * Gets reminder title.
     *
     * @return the reminder title
     */
    public String getReminder_title() {
        return reminder_title;
    }

    /**
     * Sets reminder title.
     *
     * @param reminder_title the reminder title
     */
    public void setReminder_title(String reminder_title) {
        this.reminder_title = reminder_title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", reminder_title='" + reminder_title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
