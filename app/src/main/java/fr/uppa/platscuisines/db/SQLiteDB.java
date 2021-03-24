package fr.uppa.platscuisines.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import fr.uppa.platscuisines.MyApplication;
import fr.uppa.platscuisines.MyApplication;
import fr.uppa.platscuisines.models.Dish;

@Database(entities = Dish.class, version = 1, exportSchema = false)
public abstract class SQLiteDB extends RoomDatabase {
    private static SQLiteDB instance = null;
    public static synchronized SQLiteDB getInstance() {
        if (instance == null) {
            instance = Room.databaseBuilder(MyApplication.getAppContext(),
                    SQLiteDB.class,
                    "platscuisines.db")
                    //.openHelperFactory(new AssetSQLiteOpenHelperFactory())
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    public abstract DishDAO getDishDao();
}
