package fr.uppa.platscuisines;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.uppa.platscuisines.db.DishDAO;
import fr.uppa.platscuisines.db.SQLiteDB;
import fr.uppa.platscuisines.models.SaveOrderFacade;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Application app) {
        this.context = app;
    }
    @Provides
    public Context provideContext() {
        return context;
    }
    @Provides
    public DishDAO provideDishDao(){
        return SQLiteDB.getInstance(). getDishDao();
    }

    @Provides
    @Singleton
    public SaveOrderFacade provideSaveOrderFacade(){
        return new SaveOrderFacade();
    }

}