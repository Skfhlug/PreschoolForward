package edu.preschool.persitence;

import edu.preschool.entity.Admin;
import edu.preschool.entity.Reminder;
import edu.preschool.entity.Reminder;
import edu.preschool.util.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//Many to one
/**
 * The type Reminder dao test.
 */
class ReminderDaoTest {
    /**
     * The Dao.
     */
    ReminderDao dao;
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        //edu.preschool.util.util.Database database = edu.preschool.util.util.Database.getInstance();
        dao = new ReminderDao();
        genericDao = new GenericDao(Reminder.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<Reminder> reminders = dao.getAll();
        assertEquals(4, reminders.size());

    }
    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Reminder retrievedReminder = (Reminder)genericDao.getById(2);
        assertNotNull(retrievedReminder);
        assertEquals("SecondReminder", retrievedReminder.getReminder_title());

    }
    /**
     * Insert.
     */
    @Test
    void insert() {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.getById(1);
        Reminder newReminder = new Reminder("Test1", "Some detail for the note", 0, admin);
        admin.addReminder(newReminder);
        int id = dao.insert(newReminder);
        assertNotEquals(0,id);
        Reminder insertedReminder = dao.getById(id);
        assertEquals("Test1", insertedReminder.getReminder_title());
        assertNotNull(insertedReminder.getAdmin());
        assertEquals("Nina", insertedReminder.getAdmin().getFirstName());

    }


    /**
     * Delete.
     */
    @Test
    void delete() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }


    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        String newDescription = "Test2";
        Reminder reminderToUpdate = dao.getById(2);
        reminderToUpdate.setReminder_title(newDescription);
        dao.saveOrUpdate(reminderToUpdate);
        Reminder retrievedReminder = dao.getById(2);
        assertEquals(newDescription, retrievedReminder.getReminder_title());
    }



    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<Reminder> reminders = dao.getByPropertyLike("description", "Somethings in the third reminder");
        assertEquals(1, reminders.size());
        assertEquals(3, reminders.get(0).getId());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<Reminder> reminders = dao.getByPropertyLike("description", "Somethings in the Fourth reminder");
        assertEquals(1, reminders.size());
        assertEquals(4, reminders.get(0).getId());
    }
}