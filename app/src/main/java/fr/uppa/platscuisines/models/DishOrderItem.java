package fr.uppa.platscuisines.models;

public class DishOrderItem {
    private final int id;
    private final String dishName;
    private final int quantityFor2;
    private final int quantityFor4;
    private final int quantityFor6;
    private final int quantityFor8;
    private final int quantityFor12;

    public DishOrderItem(int id, String dishName, int quantityFor2, int quantityFor4, int quantityFor6, int quantityFor8, int quantityFor12) {
        this.id = id;
        this.dishName = dishName;
        this.quantityFor2 = quantityFor2;
        this.quantityFor4 = quantityFor4;
        this.quantityFor6 = quantityFor6;
        this.quantityFor8 = quantityFor8;
        this.quantityFor12 = quantityFor12;
    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public int getQuantityFor2() {
        return quantityFor2;
    }

    public int getQuantityFor4() {
        return quantityFor4;
    }

    public int getQuantityFor6() {
        return quantityFor6;
    }

    public int getQuantityFor8() {
        return quantityFor8;
    }

    public int getQuantityFor12() {
        return quantityFor12;
    }
}
