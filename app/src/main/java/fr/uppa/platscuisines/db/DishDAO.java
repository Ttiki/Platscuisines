package fr.uppa.platscuisines.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import fr.uppa.platscuisines.models.Dish;

@Dao
public interface DishDAO {
    @Query("SELECT * FROM platscuisines")
    List<Dish> getAll();

    @Query("SELECT * FROM platscuisines WHERE nomPlat LIKE '%' || :name || '%' LIMIT 1")
    Dish findByName(String name);
    @Query("SELECT * FROM platscuisines WHERE idPlat=:idPlat")
    Dish findById(String idPlat);

}
