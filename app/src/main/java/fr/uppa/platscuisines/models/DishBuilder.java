package fr.uppa.platscuisines.models;

public class DishBuilder {

    private String nomPlat;
    private int conditionnePour2;
    private int conditionnePour4;
    private int conditionnePour6;
    private int conditionnePour8;
    private int conditionnePour12;

    public String getNomPlat() {
        return nomPlat;
    }

    public int getConditionnePour2() {
        return conditionnePour2;
    }

    public int getConditionnePour4() {
        return conditionnePour4;
    }

    public int getConditionnePour6() {
        return conditionnePour6;
    }

    public int getConditionnePour8() {
        return conditionnePour8;
    }

    public int getConditionnePour12() {
        return conditionnePour12;
    }

    public DishBuilder setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
        return this;
    }

    public DishBuilder setConditionnePour2(int conditionnePour2) {
        this.conditionnePour2 = conditionnePour2;
        return this;
    }

    public DishBuilder setConditionnePour4(int conditionnePour4) {
        this.conditionnePour4 = conditionnePour4;
        return this;
    }

    public DishBuilder setConditionnePour6(int conditionnePour6) {
        this.conditionnePour6 = conditionnePour6;
        return this;
    }

    public DishBuilder setConditionnePour8(int conditionnePour8) {
        this.conditionnePour8 = conditionnePour8;
        return this;
    }

    public DishBuilder setConditionnePour12(int conditionnePour12) {
        this.conditionnePour12 = conditionnePour12;
        return this;
    }

    public Dish createDish() {
        return new Dish(nomPlat, conditionnePour2, conditionnePour4, conditionnePour6, conditionnePour8, conditionnePour12);
    }
}