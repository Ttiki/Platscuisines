package fr.uppa.platscuisines.models;

public class DishOrderItemBuilder {
    private int id;
    private String dishName;
    private int quantityFor2;
    private int quantityFor4;
    private int quantityFor6;
    private int quantityFor8;
    private int quantityFor12;

    public DishOrderItemBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DishOrderItemBuilder setDishName(String dishName) {
        this.dishName = dishName;
        return this;
    }

    public DishOrderItemBuilder setQuantityFor2(int quantityFor2) {
        this.quantityFor2 = quantityFor2;
        return this;
    }

    public DishOrderItemBuilder setQuantityFor4(int quantityFor4) {
        this.quantityFor4 = quantityFor4;
        return this;
    }

    public DishOrderItemBuilder setQuantityFor6(int quantityFor6) {
        this.quantityFor6 = quantityFor6;
        return this;
    }

    public DishOrderItemBuilder setQuantityFor8(int quantityFor8) {
        this.quantityFor8 = quantityFor8;
        return this;
    }

    public DishOrderItemBuilder setQuantityFor12(int quantityFor12) {
        this.quantityFor12 = quantityFor12;
        return this;
    }

    public DishOrderItem createDishOrderItem() {
        return new DishOrderItem(id, dishName, quantityFor2, quantityFor4, quantityFor6, quantityFor8, quantityFor12);
    }
}