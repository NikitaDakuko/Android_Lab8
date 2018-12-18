package nikitadakuko.lab.lab8.LocalRepo;

import java.util.List;

import io.reactivex.Flowable;
import nikitadakuko.lab.lab8.Model.User;

public class UserRepository implements IDatabaseDataSource {

    private IDatabaseDataSource localDataSource;

    private static UserRepository instance;

    public UserRepository(IDatabaseDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    public static UserRepository getInstance(IDatabaseDataSource localDataSource){
        if(instance == null){
            instance = new UserRepository(localDataSource);
        }
        return instance;
    }

    @Override
    public Flowable<User> getUserById(int userId) {
        return localDataSource.getUserById(userId);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return localDataSource.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        localDataSource.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        localDataSource.updateUser(users);
    }

    @Override
    public void deleteUser(User user) {
        localDataSource.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        localDataSource.deleteAllUsers();
    }
}
