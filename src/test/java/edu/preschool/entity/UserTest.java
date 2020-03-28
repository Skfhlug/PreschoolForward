package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.persitence.ReminderDao;
import edu.preschool.entity.User;
import edu.preschool.util.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    User user;
    GenericDao dao;


    @BeforeEach
    void setUp() {

        dao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getId() {/*
        User getUser = (User) user.genericDao.getById(3);
        assertEquals("Anne", user.getFirst_name());
        logger.info("User first name is: " + getUser.getFirst_name());
    */
    }
    @Test
    void insertUser() {
        User newUser = new User("TestFirstName", "TLastName", "test", "password", "test@test.com", "1111111111");
        int id = dao.insert(newUser);
        User insertedUser = (User) dao.getById(id);
        //User inserted = dao.getById(id);
        assertTrue(id > 0);
        assertEquals("TestFirstName",
                insertedUser.getFirst_name());

    }
}