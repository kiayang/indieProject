package edu.kyang.persistence;

import edu.kyang.entity.MemberBean;
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
public class MemberDAO {
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
    public List<MemberBean> getAllMembers() {
        /* These objects will be used in conjunction to build queries, you will get use to it
        /* These 4 lines will create/open up a session, build the query for an entity and
        /* in this case the User class as well as building the part of the query like the
        /* 'from' clause from user
        */
        Session session = sessionFactory.openSession();

        logger.debug("Get all Members");

        CriteriaBuilder builder = ((Session) session).getCriteriaBuilder();
        CriteriaQuery<MemberBean> query = builder.createQuery(MemberBean.class);
        Root<MemberBean> root = query.from(MemberBean.class);

        //Ultimately, we are getting a list of users back out
        List<MemberBean> members = session.createQuery(query).getResultList();

        //Close session before returning the users
        session.close();

        return members;
    }

    /**
     * Gets users by last name.
     *
     * @param lastName the last name
     * @return the users by last name
     */
    public List<MemberBean> getUsersByLastName(String lastName) {

        Session session = sessionFactory.openSession();

        logger.debug("Search users by last name " + "last name =" + lastName);

        CriteriaBuilder builder = ((Session) session).getCriteriaBuilder();
        CriteriaQuery<edu.kyang.entity.MemberBean> query = builder.createQuery(edu.kyang.entity.MemberBean.class);
        Root<edu.kyang.entity.MemberBean> root = query.from(edu.kyang.entity.MemberBean.class);

        //This Expression builds the where clause similar to what's on the UserData Class
        //String sql = "SELECT * FROM user WHERE last_name like "%" + lastName + "%'";
        Expression<String> propertyPath = root.get("lastName");
       //query.where(builder.like(propertyPath, "%" + lastName + "%"));
        query.where(builder.like(propertyPath, lastName + "%"));

        List<edu.kyang.entity.MemberBean> members = session.createQuery(query).getResultList();
        session.close();
        return members;
    }


    /**
     * Get user by id user.
     *
     * @param id the id
     * @return the user
     */
    public User getUserById(int id){
        Session session = sessionFactory.openSession();

        MemberBean member = session.get(MemberBean.class, id);

        //Close session
        session.close();

        //Return the user
        return member;

    }

    /******************************************************************************************
     * update member
     * @param user  Member to be inserted or updated
     ******************************************************************************************/
    public void saveOrUpdate(MemberBean user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * update user
     * @param member  Member to be inserted or updated
     */
    public int insert(MemberBean member) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(member);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a member
     * @param member Member to be deleted
     */
    public void delete(MemberBean member) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(member);
        transaction.commit();
        session.close();
    }

    /**
     * Get member by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<MemberBean> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for member with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MemberBean> query = builder.createQuery( MemberBean.class );
        Root<MemberBean> root = query.from( MemberBean.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<MemberBean> members = session.createQuery( query ).getResultList();

        session.close();
        return members;
    }


    public List<MemberBean> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for member with " + propertyName + " = " + "%" + value + "%");

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MemberBean> query = builder.createQuery( MemberBean.class );
        Root<MemberBean> root = query.from( MemberBean.class );

        //This Expression builds the where clause similar to what's on the UserData Class
        //String sql = "SELECT * FROM member WHERE last_name like '%" + lastName + "%'";
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + value + "%"));


        List<MemberBean> members = session.createQuery( query ).getResultList();

        session.close();
        return members;
    }

}
