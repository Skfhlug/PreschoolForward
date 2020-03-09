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


    @Test
    void getId() {/*
        User getUser = (User) user.genericDao.getById(3);
        assertEquals("Anne", user.getFirst_name());
        logger.info("User first name is: " + getUser.getFirst_name());
    */
    }

}