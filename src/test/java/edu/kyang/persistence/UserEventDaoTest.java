package edu.kyang.persistence;

import edu.kyang.entity.EventBean;
import edu.kyang.entity.UserBean;
import edu.kyang.entity.UserEventBean;
import edu.kyang.entity.UserRoleBean;
import edu.kyang.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.sql.Types.NULL;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User role dao test.
 */
public class UserEventDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The instance variable for Generic User dao.
     */
    GenericDAO userDao;
    /**
     * The instance variable for Generic Event dao.
     */
    GenericDAO eventDao;

    /**
     * The instance variable for Generic User Event dao.
     */
    GenericDAO userEventDao;

    /**
     * Create the dao
     * Delete all records and create/insert new ones for each run
     */
    @BeforeEach
    void setUp() {

        logger.info("starting the Setup for UserEventDaoTest");

        userEventDao = new GenericDAO(UserEventBean.class);
        userDao = new GenericDAO(UserBean.class);
        eventDao = new GenericDAO(EventBean.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all User Event success.
     */
    @Test
    void getAllSuccess() {
        List<UserEventBean> userEvents = userEventDao.getAll();
        logger.info("User Event - Get All Testing : " + userEvents);
        assertEquals(1, userEvents.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        UserBean userBean = (UserBean) userDao.getById(2);
        EventBean eventBean = (EventBean) eventDao.getById(2);
        logger.info("User Bean - Get ByID Testing : " + userBean);
        logger.info("Event Bean - Get ByID Testing : " + eventBean);

        UserEventBean userEvent = (UserEventBean) userEventDao.getById(1);
        assertNotNull(userEvent);
        assertEquals(1, userEvent.getUeId());

        logger.info("User Event Bean - Get ByID Testing : " + userEvent);
        UserEventBean expectedObj = new UserEventBean(1,userBean, eventBean,"paid",LocalDate.parse("2018-10-05"));
        assertEquals(expectedObj, userEvent);

    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        logger.info("Testing UserEventDao - Insert Method");
        /*
        UserEventBean newUserEvent = (UserEventBean) userEventDao.getById(1);
        String name = newUserEvent.getUserBean().getUsername();
        logger.info("User Event - Get User Name : " + name);
        */

        //Retrieve user info from UserBean to be inserted
        UserBean userBean = (UserBean) userDao.getById(4);

        //Retrieve the event info from EventBean to be inserted
        EventBean eventBean = (EventBean) eventDao.getById(2);
        logger.info("Event Bean - Get ByID Testing : " + eventBean);

        //Instantiate and set the values that will need to be updated
        UserEventBean newUserEventBean = new UserEventBean(userBean,eventBean,null,null);
        //UserEventBean newUserEventBean = new UserEventBean(userBean,eventBean,"paid",LocalDate.parse("2018-10-05"));

        //INSERT new row to UserEvent table for the Event and User retrieved above
        int ueId = userEventDao.insert(newUserEventBean);
        UserEventBean insertedUserEvent = (UserEventBean) userEventDao.getById(ueId);
        logger.info("User Event - After Insert : " + insertedUserEvent);

        String  username = insertedUserEvent.getUserBean().getUsername();
        assertEquals("kterry@hotmail.com", username);

        String status = insertedUserEvent.getUePaidStatus();
        assertEquals(null, status);

    }

    /**
     * Save or update successful.
     */
    @Test
    void SaveOrUpdateSuccessful() {
        logger.info("Testing UserEventDao - Save/Update Method");

        String newStatus = "unpaid";
        LocalDate newDate = LocalDate.parse("2018-12-13");
        UserEventBean userEventToUpdate = (UserEventBean)userEventDao.getById(1);

        //Sets databases values
        userEventToUpdate.setUePaidStatus(newStatus);
        userEventToUpdate.setUePaidDate(newDate);

        //updates table
        userEventDao.saveOrUpdate(userEventToUpdate);

        //retrives user event info for the updated user event
        UserEventBean retrievedUserEvent = (UserEventBean) userEventDao.getById(1);

        //retrieve the userid (foreign key) from user event bean
        int fk_userid = retrievedUserEvent.getUserBean().getId();

        //retrieve user info related to user event update
        UserBean userBean = (UserBean) userDao.getById(fk_userid);

        //retrieve the eventid (foreign key) from user event bean
        int fk_eventid = retrievedUserEvent.getEventBean().getEventId();
        EventBean eventBean = (EventBean) eventDao.getById(fk_eventid);

        logger.info("User Event Bean - Get ByID Testing : " + retrievedUserEvent);
        UserEventBean expectedObj = new UserEventBean(1,userBean, eventBean,newStatus,newDate);
        assertEquals(expectedObj, retrievedUserEvent);

        logger.info("User Event Bean - After Update : " + retrievedUserEvent);
        assertEquals(newStatus, retrievedUserEvent.getUePaidStatus());
        assertEquals(newDate, retrievedUserEvent.getUePaidDate());
    }

    /* NOt allowed to delete from this table
    @Test
    void deleteSuccess() {
        userEventDao.delete(userEventDao.getById(1));
        assertNull(userEventDao.getById(1));
    }
    */

    /**
     * Gets by property equal int success.
     */
    @Test
    void getByPropertyEqualIntSuccess() {

        //retrieve user info related to user bean
        List<UserBean> users = userDao.getByPropertyEqual("username", "kyang@hotmail.com");
        Assertions.assertEquals(1, users.size());
        int userid = users.get(0).getId();

        List<UserEventBean> userEvents2 = userEventDao.getByPropertyEqualInt("ueId",userid);

        logger.info("User Event Bean List 2: " + userEvents2);

        int userEventId = userEvents2.get(0).getUeId();
        String firstname = userEvents2.get(0).getUserBean().getFirstname();
        String lastname = userEvents2.get(0).getUserBean().getLastname();
        String username = userEvents2.get(0).getUserBean().getUsername();
        int eventid = userEvents2.get(0).getEventBean().getEventId();
        BigDecimal fee = userEvents2.get(0).getEventBean().getEvent_fee();
        LocalDate eventDate = userEvents2.get(0).getEventBean().getEvent_date();
        String status = userEvents2.get(0).getUePaidStatus();
        LocalDate paidDate = userEvents2.get(0).getUePaidDate();

        List<UserEventBean> userEvents3 = userEventDao.getByPropertyEqualInt("userBean",userid);
        System.out.println("User Events List 3: " + userEvents3);

        BigDecimal fee1 = BigDecimal.valueOf(15);

        logger.info("Firstname : " + firstname);
        logger.info("Lastname : " + lastname);
        logger.info("Username : " + username);
        logger.info("eventid : " + eventid);
        logger.info("fee : " + fee);
        logger.info("event date : " + eventDate);
        logger.info("paid status: " + status);
        logger.info("paid date : " + paidDate);

        assertEquals("kia", firstname);
        assertEquals("yang", lastname);
        assertEquals("kyang@hotmail.com", username);
        assertEquals(1, eventid);
        assertEquals(fee1, fee);
        assertEquals(LocalDate.parse("2018-09-10"), eventDate);
        assertEquals("paid", status);
        assertEquals(LocalDate.parse("2018-10-05"),paidDate);
    }

}
