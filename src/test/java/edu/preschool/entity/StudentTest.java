package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    GenericDao genericDao = new GenericDao(Student.class);

    @BeforeEach
    void setUp() {

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
        Student retrievedStudent = (Student) genericDao.getById(4);
        assertNotNull(retrievedStudent);
        assertEquals("Alexander", retrievedStudent.getFirst_name());
    }

    @Test
    void getAll() {
        List<Student> students = genericDao.getAll();
        assertEquals(6, students.size());
    }

    @Test
    void insertStudentSuccess() {
        Student newStudent = new Student();
        newStudent.setId(4);
        newStudent.setFirst_name("TestInsert");
        newStudent.setLast_name("Test");
        newStudent.setAddress("123 Road");
        newStudent.setDate_of_birth("2020-01-01");
        newStudent.setGrade("Senior");
        newStudent.setClass_room("A");
        newStudent.setEmergency_phone1("0000000000");
        newStudent.setEmergency_phone2("0000000000");
        newStudent.setPicture_address("test.png");
        newStudent.setParent_status("married");
        newStudent.setGender("female");

        int student_id = genericDao.insert(newStudent);

        assertNotEquals(0,student_id);
        Student addedStudent = (Student) genericDao.getById(student_id);

        assertEquals("TestInsert", addedStudent.getFirst_name());

    }

    @Test
    public void  testUpdate(){
        String newFirstName = "editFirstName";
        Student updateStudent = (Student) genericDao.getById(3);
        updateStudent.setFirst_name(newFirstName);
        genericDao.saveOrUpdate(updateStudent);
        Student retrievedStudent = (Student) genericDao.getById(3);
        assertEquals(newFirstName, retrievedStudent.getFirst_name());
    }

    @Test
    public void deleteUserSuccess() {

        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }
}