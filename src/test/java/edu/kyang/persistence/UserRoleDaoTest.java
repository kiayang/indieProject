package edu.kyang.persistence;

import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserRoleBean;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class UserRoleDaoTest {

    /**
     * The instance variable for Generic dao.
     */
    GenericDAO genericDao;

    /**
     * Create the dao
     * Delete all records and create/insert new ones for each run
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDAO(UserRoleBean.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all user role success.
     */
    @Test
    void getAllSuccess() {
        List<UserRoleBean> users = genericDao.getAll();
        assertEquals(5, users.size());
    }

    @Test
    void getByIdSuccess() {
        UserRoleBean retrievedUserRole = (UserRoleBean) genericDao.getById(1);
        assertNotNull(retrievedUserRole);
        assertEquals("admin", retrievedUserRole.getUserRole());
    }

/*
    @Test
    void insertUserRoleSuccess() {
    UserBean newUser = new UserBean(('kyang@hotmail.com','active','password1','kia','yang','s','1973-08-05','123 main st','wi','53533','608-888-8788');
    int id = genericDao.insert(newUser);
    UserRoleBean userRole = new UserRoleBean(1,2,"kyang@hotmail.com","new", newUser);
    assertNotEquals(0, id);
    UserBean insertedUser = genericDao.getById(id);
    assertEquals("new", insertedUser.getUserRole());
}
*/
}
