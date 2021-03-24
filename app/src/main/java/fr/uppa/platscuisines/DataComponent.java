package fr.uppa.platscuisines;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {fr.uppa.platscuisines.Appmodule.class})
public interface DataComponent {
    void inject(MainActivity mainActivity);
}