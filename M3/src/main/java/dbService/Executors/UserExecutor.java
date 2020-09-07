package dbService.Executors;

import dbService.dao.UsersDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class UserExecutor{
    private SessionFactory sessionFactory;

    public UserExecutor(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> T run(UserHandler<T> handler)  throws SQLException {
        Session session = sessionFactory.openSession();
        UsersDAO dao = new UsersDAO(session);
        T value = handler.handle(dao);
        session.close();
        return value;
    }

/*
    public void execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
    }

    public <T> T execQuery(String query,
                           ResultHandler<T> handler)
            throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();

        return value;
    }
    */
}

/*
    public UserProfile getUserProfileByUserId(long id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            UsersDAO dao = new UsersDAO(session);
            UserDataSet dataSet = dao.getUserDataSetById(id);
            session.close();
            return dataSet;

            if (dataSet != null)
                return new UserProfile(dataSet.getLogin(), dataSet.getPassword());
            else
                return null;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }


 */