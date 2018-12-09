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

        EventBean newEvent = new EventBean("tpot4@gmail.com","event 4",LocalDate.parse("2018-09-10"),new BigDecimal(15.99));

        int id = genericDao.insert(newEvent);
        assertNotEquals(0,id);
        EventBean insertedEvent = (EventBean) genericDao.getById(id);
        assertEquals("tpot4@gmail.com", insertedEvent.getEvent_userid());
    }

    /**
     * Save or update successful.
     */
    @Test
    void SaveOrUpdateSuccessful() {
        String newDesc = "Update Event to different event";
        LocalDate newDate = LocalDate.parse("2018-03-13");
        EventBean eventToUpdate = (EventBean)genericDao.getById(1);
        eventToUpdate.setDescription(newDesc);
        eventToUpdate.setEvent_date(newDate);
        genericDao.saveOrUpdate(eventToUpdate);
        EventBean retrievedEvent = (EventBean) genericDao.getById(1);
        assertEquals(newDesc, retrievedEvent.getDescription());
        assertEquals(newDate, retrievedEvent.getEvent_date());
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
        List<EventBean> events = genericDao.getByPropertyEqual("event_userid", "tpot2@gmail.com");
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals(2, events.get(0).getEvent_id());
    }

    /**
     * Gets by property like successs.
     */
    @Test
    void getByPropertyLikeSuccesss() {
        List<EventBean> events = genericDao.getByPropertyLike("description", "knigh");
        Assertions.assertEquals(1, events.size());

        List<EventBean> events2 = genericDao.getByPropertyLike("event_userid", "tpot3@gmail.com");
        Assertions.assertEquals(1, events2.size());
        Assertions.assertEquals(3, events2.get(0).getEvent_id());

        List<EventBean> events3 = genericDao.getByPropertyLike("event_userid", "tpot33@gmail.com");
        Assertions.assertEquals(0, events3.size());
    }

    @Test
    void getByPropertyEqualUnique() {
        EventBean event = (EventBean) genericDao.getByPropertyEqualUnique("event_userid", "tpot1@gmail.com");
        LocalDate date2 = LocalDate.parse("2018-09-10");
        BigDecimal fee = new BigDecimal(15);
        assertEquals(date2, event.getEvent_date());
        assertEquals(fee, event.getEvent_fee());
    }



}
