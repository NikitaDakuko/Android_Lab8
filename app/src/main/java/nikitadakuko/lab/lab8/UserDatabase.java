package nikitadakuko.lab.lab8;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import nikitadakuko.lab.lab8.Model.User;
import nikitadakuko.lab.lab8.Model.UserDAO;

import static nikitadakuko.lab.lab8.UserDatabase.DATABASE_VERSION;

@Database(entities = User.class, version = DATABASE_VERSION)
public abstract class UserDatabase extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Room-database";

    public abstract UserDAO userDAO();

    private static UserDatabase instane;

    public  static UserDatabase getInstane(Context context){
        if (instane == null){
            instane = Room.databaseBuilder(context, UserDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instane;
    }

}
