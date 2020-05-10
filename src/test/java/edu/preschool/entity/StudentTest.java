package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    GenericDao genericDao = new GenericDao(Student.class);

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getId() {
        Student retrievedStudent = (Student) genericDao.getById(1);
        assertNotNull(retrievedStudent);
        assertEquals("Thomas", retrievedStudent.getFirst_name());
    }

    @Test
    void getFirst_name() {
        Student retrievedStudent = (Student) genericDao.getByPropertyLike("first_name", "Alexander");
        assertNotNull(retrievedStudent);
        assertEquals(4, retrievedStudent.getId());
    }

    @Test
    void getAll() {
        List<Student> students = genericDao.getAll();
        assertEquals(5, students.size());
    }
}