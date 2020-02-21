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
    private int status;

    @ManyToOne
    private Admin admin;

    public Reminder() {
    }

    /**
     * Instantiates a new Reminder.
     *
     * @param reminder_title       the reminder title
     * @param reminder_description the reminder description
     * @param newAdmin             the new admin
     */
    public Reminder(String reminder_title, String reminder_description, Admin newAdmin) {
    }

    /**
     * Instantiates a new Reminder.
     *
     * @param reminder_title the reminder title
     * @param description    the description
     * @param status         the status
     * @param admin          the admin
     */
    public Reminder(String reminder_title, String description, int status, Admin admin) {
        this.reminder_title = reminder_title;
        this.description = description;
        this.status = status;
        this.admin = admin;
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
    public int getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets admin.
     *
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Sets admin.
     *
     * @param admin the admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", reminder_title='" + reminder_title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", admin=" + admin +
                '}';
    }
}
