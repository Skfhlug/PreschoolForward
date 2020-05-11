package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class ReminderTest {

    GenericDao reminderDao;
    GenericDao userDao;
    @BeforeEach
    void setUp() {

        reminderDao = new GenericDao(Reminder.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    @Test
    void getId() {
        Reminder retrievedReminder = (Reminder) reminderDao.getById(1);
        assertNotNull(retrievedReminder);
        assertEquals("FirstReminder", retrievedReminder.getReminder_title());
    }
    @Test
    void getAllReminderSuccess(){
        List<Reminder> reminders = reminderDao.getAll();
        assertEquals(4, reminders.size());
    }

    @Test
    void insertReminderSuccess() {
        Reminder newReminder = new Reminder();
        newReminder.setId(1);
        newReminder.setReminder_title("newReminder");
        newReminder.setDescription("new reminder description");
        newReminder.setStatus("none");
        User users = (User) userDao.getById(3);
        newReminder.setUser(users);

        int reminder_id = reminderDao.insert(newReminder);
        assertNotEquals(0, reminder_id);
        Reminder addedReminder = (Reminder) reminderDao.getById(reminder_id);
        assertEquals("newReminder", addedReminder.getReminder_title());
    }

    @Test
    public void  testUpdateRole(){
        String newReminder = "editTitle";
        Reminder updatedReminder = (Reminder) reminderDao.getById(2);
        updatedReminder.setReminder_title(newReminder);
        reminderDao.saveOrUpdate(updatedReminder);
        Reminder retrievedRemember = (Reminder) reminderDao.getById(2);
        assertEquals(newReminder, retrievedRemember.getReminder_title());
    }

    @Test
    public void deleteReminderSuccess() {
        reminderDao.delete(reminderDao.getById(1));
        assertNull(reminderDao.getById(1));
    }
}