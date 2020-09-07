package dbService.Executors;

import dbService.dao.UsersDAO;

import java.sql.SQLException;

public interface UserHandler<T> {
    T handle(UsersDAO dao) throws SQLException;
}
/*
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
*/