package fr.uppa.platscuisines.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "platscuisines")
public class  Dish implements Serializable {
    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    @PrimaryKey
    private int idPlat;
    @ColumnInfo
    private String nomPlat;
    @ColumnInfo
    private int conditionnePour2;
    @ColumnInfo
    private int conditionnePour4;
    @ColumnInfo( name = "conditionnePour6")
    private int conditionnePour6;
    @ColumnInfo
    private int conditionnePour8;
    @ColumnInfo
    private int conditionnePour12;

    public Dish(String nomPlat, int conditionnePour2, int conditionnePour4, int conditionnePour6, int conditionnePour8, int conditionnePour12) {
        this.nomPlat = nomPlat;
        this.conditionnePour2 = conditionnePour2;
        this.conditionnePour4 = conditionnePour4;
        this.conditionnePour6 = conditionnePour6;
        this.conditionnePour8 = conditionnePour8;
        this.conditionnePour12 = conditionnePour12;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public int getConditionnePour2() {
        return conditionnePour2;
    }

    public void setConditionnePour2(int conditionnePour2) {
        this.conditionnePour2 = conditionnePour2;
    }

    public int getConditionnePour4() {
        return conditionnePour4;
    }

    public void setConditionnePour4(int conditionnePour4) {
        this.conditionnePour4 = conditionnePour4;
    }

    public int getConditionnePour6() {
        return conditionnePour6;
    }

    public void setConditionnePour6(int conditionnePour6) {
        this.conditionnePour6 = conditionnePour6;
    }

    public int getConditionnePour8() {
        return conditionnePour8;
    }

    public void setConditionnePour8(int conditionnePour8) {
        this.conditionnePour8 = conditionnePour8;
    }

    public int getConditionnePour12() {
        return conditionnePour12;
    }

    public void setConditionnePour12(int conditionnePour12) {
        this.conditionnePour12 = conditionnePour12;
    }


}
