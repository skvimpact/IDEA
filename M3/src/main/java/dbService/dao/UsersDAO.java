package dbService.dao;

import dbService.dataSets.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    /*
    public UserDataSet get(long id) throws HibernateException {
        return (UserDataSet) session.get(UserDataSet.class, id);
    }

    public long getUserId(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return ((UserDataSet) criteria.add(Restrictions.eq("name", login)).uniqueResult()).getId();
    }
*/

    public UserDataSet getUserDataSetById(long id) {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) session.get(UserDataSet.class, id);//criteria.add(Restrictions.eq("id", id)).uniqueResult();
    }

    public UserDataSet getUserDataSetByLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public long insertUser(String login, String password) throws HibernateException {
        return (Long) session.save(new UserDataSet(login, password));
    }

    public List<UserDataSet> readAll() {
        //Session session = sessionFactory.openFactory
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (List<UserDataSet>) criteria.list();
    }
}

