package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    GenericDao reportDao;
    GenericDao studentDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {

        reportDao = new GenericDao(Report.class);
        studentDao = new GenericDao(Student.class);
        userDao = new GenericDao(User.class);


        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    @Test
    void getAllReportSuccess(){
        List<Report> reports = reportDao.getAll();
        assertEquals(3, reports.size());
    }

    @Test
    void getId() {
        Report retrievedReport = (Report) reportDao.getById(1);
        assertNotNull(retrievedReport);
        assertEquals(4, retrievedReport.getEating());
    }
    @Test
    void insertReportSuccess() {

        Report newReport = new Report();
        newReport.setId(1);
        newReport.setEmotion(3);
        newReport.setEating(3);
        newReport.setSleeping(3);
        newReport.setReport_date("2020-05-01");
        //Get student and set into report
        Student students = (Student) studentDao.getById(2);
        newReport.setStudent(students);
        //Get User and set into report
        User users = (User) userDao.getById(1);
        newReport.setUser(users);

        int report_id = reportDao.insert(newReport);
        assertNotEquals(0, report_id);
        Report addedReport = (Report) reportDao.getById(report_id);
        assertEquals(report_id, addedReport.getId());
    }
    @Test
    public void  testUpdateRole(){
        int newReport = 5;
        Report updatedReport = (Report) reportDao.getById(1);
        updatedReport.setEating(newReport);
        reportDao.saveOrUpdate(updatedReport);
        Report retrievedReport = (Report) reportDao.getById(2);
        assertEquals(5, retrievedReport.getEating());
    }

    @Test
    public void deleteRoleSuccess() {

        reportDao.delete(reportDao.getById(3));
        assertNull(reportDao.getById(3));
    }

}