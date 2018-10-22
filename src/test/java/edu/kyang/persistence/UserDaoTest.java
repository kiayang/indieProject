package edu.kyang.persistence;

import edu.kyang.entity.UserBean;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertEquals(5, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {

        UserBean retrievedUser = (UserBean) genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("kia", retrievedUser.getFirstname());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {

        UserBean newUser = new UserBean(6,"tmocha@gmail.com","active","password6","Tina","Mocha","L", LocalDate.parse("1968-01-01"),"34233 Sate St","WI","24323","6898889898");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        UserBean insertedUsr = (UserBean) genericDao.getById(id);
        assertEquals("tmocha@gmail.com", insertedUsr.getUsername());
    }

    /**
     * Save or update successful.
     */
    @Test
    void SaveOrUpdateSuccessful() {
        String newLastname = "Davis";
        UserBean userToUpdate = (UserBean)genericDao.getById(5);
        userToUpdate.setLastname(newLastname);
        genericDao.saveOrUpdate(userToUpdate);
        UserBean retrievedUser = (UserBean) genericDao.getById(5);
        assertEquals("Davis", retrievedUser.getLastname());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(5));
        assertNull(genericDao.getById(5));
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<UserBean> users = genericDao.getByPropertyEqual("firstname", "kia");
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(1, users.get(0).getId());
    }

    /**
     * Gets by property like successs.
     */
    @Test
    void getByPropertyLikeSuccesss() {
        List<UserBean> users = genericDao.getByPropertyLike("lastname", "yang");
        Assertions.assertEquals(1, users.size());
    }

}
