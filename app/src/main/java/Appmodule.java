package fr.uppa.platscuisines;

@Module
public class Appmodule {
    private Context context;
    public AppModule(Application app) {
        this.context = app;
    }
    @Provides
    public Context provideContext() {
        return context;
    }
    @Provides
    public DishDao provideDishDao(){
        return SqliteDb.getInstance(). getDishDao();
    }
}
