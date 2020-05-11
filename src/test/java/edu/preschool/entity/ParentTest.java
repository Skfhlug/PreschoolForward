package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class ParentTest {

    GenericDao studentDao;
    GenericDao userDao;
    GenericDao parentDao;

    @BeforeEach
    void setUp() {

        studentDao = new GenericDao(Student.class);
        userDao = new GenericDao(User.class);
        parentDao = new GenericDao(Parent.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    @Test
    void getId() {
        Parent retrievedParent = (Parent) parentDao.getById(2);
    }
    @Test
    void getAllParentSuccess(){
        List<Parent> parents = parentDao.getAll();
        assertEquals(3, parents.size());
    }

    @Test
    void insertParentSuccess() {

        Parent newParent = new Parent();
        newParent.setId(1);
        //Get  Student and set it into Parent table
        Student students = (Student) studentDao.getById(3);
        newParent.setStudent(students);
        //Get  User and set it into Parent table
        User users = (User) userDao.getById(5);
        newParent.setUser(users);

        int parent_id = parentDao.insert(newParent);
        assertNotEquals(0, parent_id);
        Parent addedParent = (Parent) parentDao.getById(parent_id);
        assertEquals(5, addedParent.getUser().getId());

    }
    @Test
    public void  testUpdateParent(){

        Parent updatedParent = (Parent) parentDao.getById(2);
        Student newStudent = (Student) studentDao.getById(5);
        updatedParent.setStudent(newStudent);
        parentDao.saveOrUpdate(updatedParent);
        Parent retrievedParent = (Parent) parentDao.getById(2);
        assertEquals(5, retrievedParent.getStudent().getId());
    }

    @Test
    public void deleteParentSuccess() {

        parentDao.delete(parentDao.getById(1));
        assertNull(parentDao.getById(1));
    }
}