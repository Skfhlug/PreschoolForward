package edu.preschool.entity;

import edu.preschool.persitence.GenericDao;
import edu.preschool.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    GenericDao roleDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {

        roleDao = new GenericDao(Role.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    @Test
    void getAllRoleSuccess(){
        List<Role> roles = roleDao.getAll();
        assertEquals(5, roles.size());
    }

    @Test
    void getId() {
        Role retrievedRole = (Role) roleDao.getById(1);
        assertNotNull(retrievedRole);
        assertEquals("admin", retrievedRole.getRole_name());
    }
    @Test
    void insertRoleSuccess() {

        Role newRole = new Role();
        newRole.setId(1);
        newRole.setRole_name("parent");
        User users = (User) userDao.getById(3);
        newRole.setUsername(users);

        int role_id = roleDao.insert(newRole);
        assertNotEquals(0, role_id);
        Role addedRole = (Role) roleDao.getById(role_id);
        assertEquals("parent", addedRole.getRole_name());

    }
    @Test
    public void  testUpdateRole(){
        String newRole = "admin";
        Role updatedRole = (Role) roleDao.getById(2);
        updatedRole.setRole_name(newRole);
        roleDao.saveOrUpdate(updatedRole);
        Role retrievedRole = (Role) roleDao.getById(2);
        assertEquals(newRole, retrievedRole.getRole_name());
    }

    @Test
    public void deleteRoleSuccess() {

        roleDao.delete(roleDao.getById(2));
        assertNull(roleDao.getById(2));
    }

}