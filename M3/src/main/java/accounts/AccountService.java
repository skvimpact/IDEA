package accounts;

import dbService.DBException;
import dbService.DBService;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, String> sessionIdToLogin;
    private final DBService dbService;

    public AccountService(DBService dbService) {
        sessionIdToLogin = new HashMap<>();
        this.dbService = dbService;
    }

    //  User
    public void addNewUser(UserProfile userProfile) {
        try {
            dbService.addUser(userProfile.getLogin(), userProfile.getPass());
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLogin(String login) {
        UserProfile userProfile = null;
        try {
            userProfile = dbService.getUserProfileByUserLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return(userProfile);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        UserProfile userProfile = null;
        final String login = sessionIdToLogin.get(sessionId);
        if(login != null) {
            try {
                userProfile = dbService.getUserProfileByUserLogin(login);
            } catch (DBException e) {
                e.printStackTrace();
            }
        }
        return(userProfile);
    }


    //  Session
    public void addSession(String sessionId, String login) {
        sessionIdToLogin.put(sessionId, login);
    }

    public void deleteSession(String sessionId) {
        sessionIdToLogin.remove(sessionId);
    }


}
