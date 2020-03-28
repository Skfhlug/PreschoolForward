package edu.preschool.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReminderTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Test
    void getReminder_title() {
        Reminder reminder = new Reminder();
        reminder.setReminder_title("Reminder1");
        assertEquals("Reminder1", reminder.getReminder_title());
        logger.info(reminder.getReminder_title());
    }

    @Test
    void getDescription() {
        Reminder reminder = new Reminder();
        reminder.setDescription("Reminder1 Description test");
        assertEquals("Reminder1 Description test", reminder.getDescription());
        logger.info(reminder.getDescription());
    }
}