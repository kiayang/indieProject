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
 * The type User role dao test.
 */
public class UserRoleDaoTest {

    /**
     * The instance variable for Generic dao.
     */
    GenericDAO genericUserDao;
    /**
     * The Generic user role dao.
     */
    GenericDAO genericUserRoleDao;

    /**
     * Create the dao
     * Delete all records and create/insert new ones for each run
     */
    @BeforeEach
    void setUp() {

        genericUserRoleDao = new GenericDAO(UserRoleBean.class);
        genericUserDao = new GenericDAO(UserBean.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all user role success.
     */
    @Test
    void getAllSuccess() {
        List<UserRoleBean> users = genericUserRoleDao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        UserRoleBean retrievedUserRole = (UserRoleBean) genericUserRoleDao.getById(1);
        assertNotNull(retrievedUserRole);
        assertEquals("admin", retrievedUserRole.getUserRole());
    }

    /**
     * Insert user role success.
     */
    @Test
    void insertUserRoleSuccess() {
        UserBean newUser = new UserBean("kyang1@hotmail.com", "active", "password1", "kia", "yang", "s", LocalDate.parse("1973-08-05"), "123 main st", "wi", "53533", "608-888-8788");
        UserRoleBean newRole = new UserRoleBean(newUser, "kyang1@hotmail.com", "admin");
        int id = genericUserRoleDao.insert(newRole);
        assertNotEquals(0, id);
        UserRoleBean insertedRole = (UserRoleBean)genericUserRoleDao.getById(id);
        assertEquals("admin", insertedRole.getUserRole(), "role is equal");

    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericUserRoleDao.delete(genericUserRoleDao.getById(5));
        assertNull(genericUserRoleDao.getById(5));
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<UserRoleBean> userRoles = genericUserRoleDao.getByPropertyEqual("username", "kyang@hotmail.com");
        Assertions.assertEquals(1, userRoles.size());
        Assertions.assertEquals(1, userRoles.get(0).getId());
    }

    /**
     * Gets by property like successs.
     */
    @Test
    void getByPropertyLikeSuccesss() {
        List<UserRoleBean> userRoles = genericUserRoleDao.getByPropertyLike("userRole", "member");
        Assertions.assertEquals(3, userRoles.size());
    }

    /**
     * Gets by property equal unique.
     */
    @Test
    void getByPropertyEqualUnique() {
        UserRoleBean userRole = (UserRoleBean) genericUserRoleDao.getByPropertyEqualUnique("username", "kyang@hotmail.com");
        assertEquals("admin", userRole.getUserRole() );
    }


}
