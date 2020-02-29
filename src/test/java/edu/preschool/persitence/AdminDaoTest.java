package edu.preschool.persitence;

import edu.preschool.entity.Admin;
import edu.preschool.entity.Reminder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//one to many

/**
 * The type Admin dao test.
 */
class AdminDaoTest {
    /**
     * The Dao.
     */
    AdminDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        edu.preschool.util.util.Database database = edu.preschool.util.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new AdminDao();
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Admin retrievedAdmin = dao.getById(3);
        assertNotNull(retrievedAdmin);
        assertEquals("Tayloy", retrievedAdmin.getFirstName());

    }


    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        String newLastName = "Davis";
        Admin adminToUpdate = dao.getById(3);
        adminToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(adminToUpdate);
        Admin retrievedAdmin = dao.getById(3);
        assertEquals(adminToUpdate, retrievedAdmin);
    }

    /**
     * Insert.
     */
    @Test
    void insert() {
        Admin newAdmin = new Admin("Anna", "Adam", "fflintstone", "11111111", "anne@somemail.com","2525252525");
        int id = dao.insert(newAdmin);
        assertNotEquals(0,id);
        Admin insertedAdmin = dao.getById(id);
        assertEquals("Anna", insertedAdmin.getFirstName());

    }


    /**
     * Insert.
     */
    @Test
    void insertWithDaoSuccess() {
        Admin newAdmin = new Admin("Tony", "Adam", "fflintstone", "11111111", "anne@somemail.com","2525252525");
        String reminderTitle = "Title";
        String reminderDescription = "Test Description";
        int status = 0;
        Reminder reminder = new Reminder(reminderTitle ,reminderDescription,status, newAdmin);
        newAdmin.addReminder(reminder);

        int id = dao.insert(newAdmin);

        assertNotEquals(0,id);
        Admin insertedAdmin = dao.getById(id);
        assertEquals("Tony", insertedAdmin.getFirstName());
        assertEquals(1, insertedAdmin.getReminders().size());
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
     * Gets all.
     */
    @Test
    void getAll() {
        List<Admin> admins = dao.getAll();
        assertEquals(3, admins.size());

    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<Admin> admins = dao.getByPropertyLike("lastName", "Red");
        assertEquals(1, admins.size());
        assertEquals(3, admins.get(0).getId());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<Admin> admins = dao.getByPropertyLike("lastName", "a");
        assertEquals(1, admins.size());
    }
}