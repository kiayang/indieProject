package edu.kyang.persistence;

import edu.kyang.entity.UserBean;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type User dao.
 */
public class UserDAO {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<UserBean> getAllUsers() {
        /* These objects will be used in conjunction to build queries, you will get use to it
        /* These 4 lines will create/open up a session, build the query for an entity and
        /* in this case the User class as well as building the part of the query like the
        /* 'from' clause from user
        */
        Session session = sessionFactory.openSession();

        logger.debug("Get all Users");

        CriteriaBuilder builder = ((Session) session).getCriteriaBuilder();
        CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
        Root<UserBean> root = query.from(UserBean.class);

        //Ultimately, we are getting a list of users back out
        List<UserBean> users = session.createQuery(query).getResultList();

        //Close session before returning the users
        session.close();

        return users;
    }

    /**
     * Gets users by last name.
     *
     * @param lastName the last name
     * @return the users by last name
     */
    public List<UserBean> getUsersByLastName(String lastName) {

        Session session = sessionFactory.openSession();

        logger.debug("Search users by last name " + "last name =" + lastName);

        CriteriaBuilder builder = ((Session) session).getCriteriaBuilder();
        CriteriaQuery<edu.kyang.entity.UserBean> query = builder.createQuery(edu.kyang.entity.UserBean.class);
        Root<edu.kyang.entity.UserBean> root = query.from(edu.kyang.entity.UserBean.class);

        //This Expression builds the where clause similar to what's on the UserData Class
        //String sql = "SELECT * FROM user WHERE last_name like "%" + lastName + "%'";
        Expression<String> propertyPath = root.get("lastName");
       //query.where(builder.like(propertyPath, "%" + lastName + "%"));
        query.where(builder.like(propertyPath, lastName + "%"));

        List<edu.kyang.entity.UserBean> users = session.createQuery(query).getResultList();
        session.close();
        return users;

    }


    /**
     * Get user by id user.
     *
     * @param id the id
     * @return the user
     */
    public UserBean getUserById(int id){
        Session session = sessionFactory.openSession();

        UserBean user = session.get(UserBean.class, id);

        //Close session
        session.close();

        //Return the user
        return user;

    }

    /******************************************************************************************
     * update user
     * @param user  User to be inserted or updated
     ******************************************************************************************/
    public void saveOrUpdate(UserBean user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public int insert(UserBean user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public void delete(UserBean user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<UserBean> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserBean> query = builder.createQuery( UserBean.class );
        Root<UserBean> root = query.from( UserBean.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<UserBean> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }


    public List<UserBean> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + "%" + value + "%");

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserBean> query = builder.createQuery( UserBean.class );
        Root<UserBean> root = query.from( UserBean.class );

        //This Expression builds the where clause similar to what's on the UserData Class
        //String sql = "SELECT * FROM user WHERE last_name like '%" + lastName + "%'";
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + value + "%"));


        List<UserBean> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

}
