package nikitadakuko.lab.lab8.LocalRepo;

import java.util.List;

import io.reactivex.Flowable;
import nikitadakuko.lab.lab8.Model.User;

public interface IDatabaseDataSource {
    Flowable<User> getUserById(int userId);
    Flowable<List<User>> getAllUsers();

    void insertUser(User... users);

    void updateUser(User... users);

    void deleteUser(User user);

    void deleteAllUsers();
}
