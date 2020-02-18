package edu.preschool.util.persistence;
import edu.preschool.util.entity.Admin;

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

public class AdminDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     */
    public Admin getById(int id) {
        Session session = sessionFactory.openSession();
        Admin user = session.get( Admin.class, id );
        session.close();
        return user;
    }
    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<Admin> getByLastName(String lastName) {

        logger.debug("Searching for: {}", lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<Admin> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }
    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public void saveOrUpdate(Admin user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public int insert(Admin user) {
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
    public void delete(Admin user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<Admin> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class );
        Root<Admin> root = query.from( Admin.class );
        List<Admin> users = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Admin> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class );
        Root<Admin> root = query.from( Admin.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Admin> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Admin> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery( Admin.class );
        Root<Admin> root = query.from( Admin.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Admin> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}
