package edu.preschool.persitence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.*;


import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 */
public class GenericDao<T> {
    private Class<T>  type;
    public GenericDao genericDao;

    //private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao
     *
     * @param type the entity type, for examply, user
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    public GenericDao() {

    }

    /**
     * Get user by id
     * @return a entity
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }


    /**
     * update user
     * @param entity  User to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();

    }
    /**
     * update user
     * @param entity User to be inserted or updated
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a reminder
     * @param entity reminder to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();

    }

    /** Return a list of all reminders
     *
     * @return All reminders
     */
    public List<T> getAll() {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type );
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        //logger.debug("The list of reminders " + list);
        session.close();

        return list;
    }
    /**
     * Finds entities by one of its properties.
     * @param propertyName the property name.
     * @param value the value by which to find.
     * @return
     */
    public List<T> findByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName),value));

        return session.createQuery(query).getResultList();
    }

    /**
     * Finds entities by multiple properties.
     * Inspired by https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
     * @param propertyMap property and value pairs
     * @return entities with properties equal to those passed in the map
     *
     *
     */
    public List<T> findByPropertyEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry entry: propertyMap.entrySet()) {
            predicates.add(builder.equal(root.get((String) entry.getKey()), entry.getValue()));
        }
        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        return session.createQuery(query).getResultList();
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }


    public List<T> getByPropertiesLike(String propertyName1, String value1, String propertyName2, String value2) {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath1 = root.get(propertyName1);
        Expression<String> propertyPath2 = root.get(propertyName1);

        CriteriaQuery<T> where = query.where((builder.like(propertyPath1, "%" + value1 + "%")), (builder.like(propertyPath1, "%" + value1 + "%")));

        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }
    /**
     *
     * @return
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}
