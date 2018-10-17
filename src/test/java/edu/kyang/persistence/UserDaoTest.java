package edu.kyang.persistence;

import edu.kyang.entity.UserBean;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Author dao test.
 */
public class UserDaoTest {

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

        genericDao = new GenericDAO(UserBean.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<UserBean> users = genericDao.getAll();
        Assertions.assertEquals(5, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {

        UserBean retrievedUser = (UserBean) genericDao.getById(1);
        assertNotNull(retrievedUser);
        Assertions.assertEquals("kia", retrievedUser.getFirstname());
    }

}
