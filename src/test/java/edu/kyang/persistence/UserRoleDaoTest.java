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
        assertEquals("admin", retrievedUserRole.getRole());
    }

    /*
    @Test
    void insertUserRoleSuccess() {
    UserBean user = new UserBean("new", "author");
    int id = dao.insert(newAuthor);
    Book book = new Book("new book5", 12, "3243299", 2013, newAuthor);
    newAuthor.addBook(book);
    assertNotEquals(0, id);
    Author insertedAuthor = dao.getById(id);
    assertEquals("new", insertedAuthor.getFirstName());
}

     */
}
