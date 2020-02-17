package edu.preschool.util.persistence;
import edu.preschool.util.entity.Admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdminDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<Admin> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);

        List<Admin> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }
    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<Admin> getUsersByLastName(String lastName) {

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
}
