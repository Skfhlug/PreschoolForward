package edu.preschool.entity;

import edu.preschool.entity.Reminder;
import edu.preschool.entity.User;
import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDaoTest {
    GenericDao userDao;
    User user;
/*
    @BeforeEach
    void setUp() {

        User user = new User();
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    @Test
    void getById() {
        User retrievedUser = (User) userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Nina", retrievedUser.getFirst_name());
    }
    @Test
    void getAllUserSuccess(){
        List<User> bkCategories = userDao.getAll();
        assertEquals(17,bkCategories.size());
    }
*/
}
