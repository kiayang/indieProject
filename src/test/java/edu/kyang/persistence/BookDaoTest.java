package edu.kyang.persistence;


import edu.kyang.entity.Book;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


/** Unit test for BookDao
 *
 * @author Kia Yang
 */
class BookDaoTest {
    

    GenericDAO genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDAO(Book.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }


    @Test
    void getAllSuccess() {
        List<Book> books = genericDao.getAll();
        Assertions.assertEquals(4, books.size());
    }



}