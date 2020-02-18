package edu.preschool.util.persistence;

import edu.preschool.util.Database;
import edu.preschool.util.entity.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class AdminDaoTest {

    AdminDao dao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new AdminDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        Admin userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        Admin retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }
    /**
     * Verify the gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<Admin> users = dao.getAll();
        assertEquals(6, users.size());

    }

    /**
     * Verify the gets users by last name success.
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<Admin> users = dao.getByLastName("c");
        assertEquals(3, users.size());
    }
    /**
     * Verify a user is returned correctly based on id search
     */
    @Test
    void getUserByIdSuccess() {
        Admin retrievedUser = dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Barney", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        Admin newUser = new Admin("Anna", "Adam", "fflintstone", "11111111", "anne@somemail.com","2525252525");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        Admin insertedUser = dao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }



    /**
     * Verify successful get by property (equal match)
     */

    @Test
    void getByPropertyEqualSuccess() {
        List<Admin> users = dao.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */

    @Test
    void getByPropertyLikeSuccess() {
        List<Admin> users = dao.getByPropertyLike("lastName", "j");
        assertEquals(3, users.size());
    }
}