package fr.uppa.platscuisines;

@Singleton
@Component(modules = {AppModule.class})
public interface DataComponent {
    void inject(MainActivity mainActivity);
}