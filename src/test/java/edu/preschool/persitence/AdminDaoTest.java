package edu.preschool.persitence;

import edu.preschool.entity.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminDaoTest {
    AdminDao dao;
    @BeforeEach
    void setUp() {

        edu.preschool.util.util.Database database = edu.preschool.util.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new AdminDao();
    }

    @Test
    void getById() {
        Admin retrievedUser = dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Tayloy", retrievedUser.getFirstName());

    }

    @Test
    void getByLastName() {
        List<Admin> users = dao.getByLastName("j");
        assertEquals(1, users.size());
    }

    @Test
    void saveOrUpdate() {
        String newLastName = "Davis";
        Admin userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        Admin retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    @Test
    void insert() {
        Admin newUser = new Admin("Anna", "Adam", "fflintstone", "11111111", "anne@somemail.com","2525252525");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        Admin insertedUser = dao.getById(id);
        assertEquals("Anna", insertedUser.getFirstName());

    }

    @Test
    void delete() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    @Test
    void getAll() {
        List<Admin> users = dao.getAll();
        assertEquals(3, users.size());

    }

    @Test
    void getByPropertyEqual() {
        List<Admin> users = dao.getByPropertyLike("lastName", "Red");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<Admin> users = dao.getByPropertyLike("lastName", "j");
        assertEquals(1, users.size());
    }
}