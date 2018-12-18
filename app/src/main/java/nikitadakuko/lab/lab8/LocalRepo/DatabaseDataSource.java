package nikitadakuko.lab.lab8.LocalRepo;

import java.util.List;

import io.reactivex.Flowable;
import nikitadakuko.lab.lab8.Model.User;
import nikitadakuko.lab.lab8.Model.UserDAO;

public class DatabaseDataSource implements IDatabaseDataSource  {


    private UserDAO userDAO;
    private static DatabaseDataSource instance;

    public DatabaseDataSource(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public static DatabaseDataSource getInstance(UserDAO userDAO){
        if(instance == null){
            instance = new DatabaseDataSource(userDAO);
        }
        return instance;
    }

    @Override
    public Flowable<User> getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        userDAO.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        userDAO.updateUser(users);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }
}
