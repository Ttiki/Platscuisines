package fr.uppa.platscuisines;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface DataComponent {
    void inject(MainActivity mainActivity);
    void inject(DishViewActivity activity);

}
