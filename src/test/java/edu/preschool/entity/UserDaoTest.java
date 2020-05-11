package edu.preschool.entity;


import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDaoTest {
    GenericDao userDao;
    User user;

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
        List<User> users = userDao.getAll();
        assertEquals(5, users.size());
    }

    @Test
    void insertUserSuccess() {
        User newUser = new User();
        newUser.setId(4);
        newUser.setFirst_name("TestInsert");
        newUser.setLast_name("Test");
        newUser.setUsername("usernameTest");
        newUser.setPassword("123456789");
        newUser.setPhone("1234567899");
        newUser.setEmail("test@amail.com");

        int user_id = userDao.insert(newUser);

        assertNotEquals(0,user_id);
        User addedUser = (User) userDao.getById(user_id);
        assertEquals("TestInsert", addedUser.getFirst_name());

    }
    @Test
    public void  testUpdate(){
        String newFirstName = "editFirstName";
        User updateUser = (User) userDao.getById(3);
        updateUser.setFirst_name(newFirstName);
        userDao.saveOrUpdate(updateUser);
        User retrievedUser = (User) userDao.getById(3);
        assertEquals(newFirstName, retrievedUser.getFirst_name());
    }

    @Test
    public void deleteUserSuccess() {

        userDao.delete(userDao.getById(2));
        assertNull(userDao.getById(2));
    }

}
