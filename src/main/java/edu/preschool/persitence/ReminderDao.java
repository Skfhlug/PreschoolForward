package edu.preschool.persitence;

import edu.preschool.entity.Reminder;
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

public class ReminderDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     */
    public Reminder getById(int id) {
        Session session = sessionFactory.openSession();
        Reminder Reminder = session.get( Reminder.class, id );
        session.close();
        return Reminder;
    }
    /**
     * Gets all reminders.
     *
     * @return the all reminders
     */
    public List<Reminder> getByLastName(String lastName) {

        logger.debug("Searching for: {}", lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> query = builder.createQuery(Reminder.class);
        Root<Reminder> root = query.from(Reminder.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<Reminder> reminders = session.createQuery(query).getResultList();
        session.close();
        return reminders;
    }
    /**
     * update user
     * @param Reminder  User to be inserted or updated
     */
    public void saveOrUpdate(Reminder Reminder) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(Reminder);
        transaction.commit();
        session.close();

    }

    /**
     * update user
     * @param Reminder  User to be inserted or updated
     */
    public int insert(Reminder Reminder) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(Reminder);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a reminder
     * @param reminder reminder to be deleted
     */
    public void delete(Reminder reminder) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reminder);
        transaction.commit();
        session.close();

    }


    /** Return a list of all reminders
     *
     * @return All reminders
     */
    public List<Reminder> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> query = builder.createQuery(Reminder.class );
        Root<Reminder> root = query.from( Reminder.class );
        List<Reminder> reminders = session.createQuery( query ).getResultList();

        logger.debug("The list of reminders " + reminders);
        session.close();

        return reminders;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Reminder> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> query = builder.createQuery(Reminder.class );
        Root<Reminder> root = query.from( Reminder.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Reminder> reminders = session.createQuery( query ).getResultList();

        session.close();
        return reminders;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Reminder> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> query = builder.createQuery( Reminder.class );
        Root<Reminder> root = query.from( Reminder.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Reminder> reminders = session.createQuery( query ).getResultList();
        session.close();
        return reminders;
    }

}
