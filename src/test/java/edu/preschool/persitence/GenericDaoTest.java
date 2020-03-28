package edu.preschool.persitence;

import edu.preschool.entity.Reminder;
import edu.preschool.entity.User;
import edu.preschool.util.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {

    GenericDao dao;


    @BeforeEach
    void setUp() {

        dao = new GenericDao(Reminder.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    @Test
    void getById() {
        Reminder retrievedReminder = (Reminder)dao.getById(2);
        assertNotNull(retrievedReminder);
        assertEquals("SecondReminder", retrievedReminder.getReminder_title());

    }

    @Test
    void saveOrUpdate() {
    }
/*
    @Test
    void insertReminder() {
        User user = (User) dao.getById(1);

        Reminder newReminder = new Reminder("TestTitle", "Reminder Description", user, "none");

        int id = dao.insert(newReminder);
        Reminder insertedReminder = (Reminder) dao.getById(id);
        assertTrue(id > 0);
        System.out.println(id);
        System.out.println(insertedReminder.getReminder_title());
        assertEquals("TestTitle", insertedReminder.getReminder_title());
        System.out.println(insertedReminder.getReminder_title());

    }
*/
    @Test
    void delete() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }

    @Test
    void getAll() {
        List<Reminder> reminders = dao.getAll();
        assertEquals(4, reminders.size());
    }

    @Test
    void findByPropertyEqual() {
    }

    @Test
    void testFindByPropertyEqual() {
        List<Reminder> reminders = dao.getByPropertyLike("description", "Somethings in the third reminder");
        assertEquals(1, reminders.size());
        assertEquals(3, reminders.get(0).getId());

    }

    @Test
    void getByPropertyLike() {
        List<Reminder> reminders = dao.getByPropertyLike("description", "Somethings in the Second reminder");
        assertEquals(1, reminders.size());
        assertEquals(2, reminders.get(0).getId());

    }
}