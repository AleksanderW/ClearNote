package cnote.pack.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import cnote.pack.model.Note;


@Database(entities = Note.class, version = 1)
public abstract class DB extends RoomDatabase {
    public abstract DAO notesDao();

    public static final String DATABSE_NAME = "notesDb";
    private static DB instance;

    public static DB getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, DB.class, DATABSE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}