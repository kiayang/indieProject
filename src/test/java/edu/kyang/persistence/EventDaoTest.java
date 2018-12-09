package edu.kyang.persistence;

import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
import edu.kyang.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Author dao test.
 */
public class EventDaoTest {

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

        genericDao = new GenericDAO(EventBean.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<EventBean> users = genericDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {

        EventBean retrievedEvent = (EventBean) genericDao.getById(1);
        LocalDate date = LocalDate.parse("2018-09-10");
        assertNotNull(retrievedEvent);
        assertEquals(date, retrievedEvent.getEvent_date());
    }


    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {

        EventBean newEvent = new EventBean("test event", LocalDate.parse("2018-02-15"), new BigDecimal(15.50));
        int id = genericDao.insert(newEvent);
        assertNotEquals(0,id);
        EventBean insertedEvent = (EventBean) genericDao.getById(id);
        assertEquals("test event", insertedEvent.getDescription());
    }

    /**
     * Save or update successful.
     */
    @Test
    void SaveOrUpdateSuccessful() {
        String newDesc = "Test Event 2";
        EventBean eventToUpdate = (EventBean)genericDao.getById(1);
        eventToUpdate.setDescription(newDesc);
        genericDao.saveOrUpdate(eventToUpdate);
        EventBean retrievedEvent = (EventBean) genericDao.getById(1);
        assertEquals(newDesc, retrievedEvent.getDescription());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<EventBean> events = genericDao.getByPropertyEqual("description", "perry tang");
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals(1, events.get(0).getEvent_id());
    }

    /**
     * Gets by property like successs.
     */
    @Test
    void getByPropertyLikeSuccesss() {
        List<EventBean> events = genericDao.getByPropertyLike("description", "perry");
        Assertions.assertEquals(1, events.size());

        List<EventBean> events2 = genericDao.getByPropertyLike("description", "aid");
        Assertions.assertEquals(1, events2.size());
        Assertions.assertEquals(2, events2.get(0).getEvent_id());
    }

    @Test
    void getByPropertyEqualUnique() {
        EventBean event = (EventBean) genericDao.getByPropertyEqualUnique("description", "kool aid");
        LocalDate date2 = LocalDate.parse("2018-01-10");
        BigDecimal fee = new BigDecimal(15);
        assertEquals(date2, event.getEvent_date());
        assertEquals(fee, event.getEvent_fee());
    }



}
