package edu.kyang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDAO<T>{

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDAO(Class<T> type) {
        this.type = type;
    }


    /**
     * Gets all entities
     *
     * @return the all entities
     */
    public List<T> getAll() {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        logger.debug("Get all rows from entity : " + list);
        session.close();
        return list;
    }


    /**
     * Get entity by id. - Any entity
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the some entity Specify generic type <T>
     */
    public <T>T getById(int id){

        Session session = getSession();

        //caste to a particular type and pass in a type so get type
        T entity  = (T)session.get(type, id);

        logger.debug("Get entity by Id : " + entity);

        //Close session
        session.close();

        //Return the entity
        return entity;
    }


    /**
     * Delete entity.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session =  getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);

        logger.debug("Deleted entity " + entity);

        transaction.commit();
        session.close();
    }


    /**
     * Save or update for an entity
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);

        logger.debug("Save/update entity " + entity);

        transaction.commit();
        session.close();
    }


    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);

        logger.debug("Insert entity " + entity);

        transaction.commit();
        session.close();
        return id;
    }


    /**
     * Get entity by property (exact match)
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {

        Session session = getSession();

        logger.debug("Searching for entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery( query ).getResultList();

        session.close();
        return list;
    }


    /**
     * Gets by property equal int.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal int
     */
    public List<T> getByPropertyEqualInt(String propertyName, int value) {

        Session session = getSession();

        logger.debug("Searching for entity equal int " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery( query ).getResultList();

        session.close();
        return list;
    }

    private Session getSession(){
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets by property like for some entity
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for Entity with " + propertyName + " = " + "%" + value + "%");

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> list = session.createQuery( query ).getResultList();

        logger.debug("Get list by property like " + list);
        session.close();
        return list;
    }


    /**
     * Gets by property like two.
     *
     * @param propertyName1 the property name 1
     * @param value1        the value 1
     * @param propertyName2 the property name 2
     * @param value2        the value 2
     * @return the by property like two
     */
    public List<T> getByPropertyLikeTwo(String propertyName1, String value1, String propertyName2, String value2) {
        Session session = getSession();

        logger.debug("Searching for entity with Like " + propertyName1 + " = " + value1);
        logger.debug("Searching for entity with Like " + propertyName2 + " = " + value2);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath1 = root.get(propertyName1);
        Expression<String> propertyPath2 = root.get(propertyName2);

        query.select(root).where(
                builder.and(
                        builder.like(propertyPath1, "%" + value1 + "%"),
                        builder.like(propertyPath2,"%" + value2 + "%")
                )
                );

        List<T> list = session.createQuery( query ).getResultList();

        logger.debug("Get list by property like " + list);

        session.close();
        return list;
    }

    /**
     * Gets by property equal two.
     *
     * @param propertyName1 the property name 1
     * @param value1        the value 1
     * @param propertyName2 the property name 2
     * @param value2        the value 2
     * @return the by property equal two
     */
    public List<T> getByPropertyEqualTwo(String propertyName1, String value1, String propertyName2, String value2) {
        Session session = getSession();

        logger.debug("Searching for entity with Equal " + propertyName1 + " = " + value1);
        logger.debug("Searching for entity with Equal " + propertyName2 + " = " + value2);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath1 = root.get(propertyName1);
        Expression<String> propertyPath2 = root.get(propertyName2);

        query.select(root).where(
                builder.and (
                        builder.equal(root.get(propertyName1), value1),
                        builder.equal(root.get(propertyName2), value2))
                        );

        List<T> list = session.createQuery( query ).getResultList();

        logger.debug("Get list by property like " + list);

        session.close();
        return list;
    }

    /**
     * This generic method That gets a single object by property name and a value
     *
     * @param propertyName entity property name
     * @param value        value to query by
     * @return entity by property equal unique
     */
    public T getByPropertyEqualUnique(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        T entity = session.createQuery( query ).getSingleResult();

        logger.debug("Get unique entity " + entity);

        session.close();
        return entity;
    }
}
