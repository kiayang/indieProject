package edu.kyang.persistence;

import edu.kyang.entity.Author;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Author dao test.
 */
public class AuthorDaoTest {

    /**
     * create instance variable for the dao
     */
    /**
     * The Generic dao.
     */
    GenericDAO genericDao;

    /**
     * Create the dao
     * Delete all records and create/insert new ones for each run
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDAO(Author.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }


    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<Author> authors = genericDao.getAll();
        Assertions.assertEquals(3, authors.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {

        Author retrievedAuthor = (Author) genericDao.getById(1);
        assertNotNull(retrievedAuthor);
        Assertions.assertEquals("Kathy", retrievedAuthor.getFirstName());
    }


}
