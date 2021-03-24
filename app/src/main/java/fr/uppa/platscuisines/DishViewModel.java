package fr.uppa.platscuisines;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;

import fr.uppa.platscuisines.models.Dish;
import fr.uppa.platscuisines.models.DishBuilder;

public class DishViewModel extends BaseObservable {
    private final Dish dish;

    public DishViewModel(){
        this.dish = new DishBuilder().setNomPlat("Test Dish").setConditionnePour6(1).createDish();
    }

    public Dish getDish() {
        return dish;
    }


    public boolean getConditionnePour2() {
        return dish.getConditionnePour2()!= 0;
    }
    public void setConditionnePour2(boolean conditionnePour2) {
        dish.setConditionnePour2(conditionnePour2?1:0);
        notifyChange();
    }
    public boolean getConditionnePour4() {
        return dish.getConditionnePour4()!= 0;
    }
    public void setConditionnePour4(boolean conditionnePour4) {
        dish.setConditionnePour4(conditionnePour4?1:0);
        notifyChange();
    }
    public boolean getConditionnePour6() {
        return dish.getConditionnePour6()!= 0;
    }

    public void setConditionnePour6(boolean conditionnePour6) {
        dish.setConditionnePour6(conditionnePour6?1:0);
        notifyChange();
    }
    public boolean getConditionnePour8() {
        return dish.getConditionnePour8()!= 0;
    }
    public void setConditionnePour8(boolean conditionnePour8) {
        dish.setConditionnePour8(conditionnePour8?1:0);

    }
    public boolean getConditionnePour12() {
        return dish.getConditionnePour12()!= 0;
    }
    public void setConditionnePour12(boolean conditionnePour12) {
        dish.setConditionnePour12(conditionnePour12?1:0);
        notifyChange();
    }

    public void handleOK(View view){
        Intent intent = new Intent(view.getContext(), DisplayDishActivity.class);
        boolean error = false;
        String errorMsg = null;
        if (dish.getNomPlat()==null || dish.getNomPlat().isEmpty()){
            errorMsg = "Enter the Dish's name";
            error=true;
        } else if(!getConditionnePour2() && !getConditionnePour4() && !
                getConditionnePour6() &&
                !getConditionnePour8() && !getConditionnePour12()){
            errorMsg = "Select at least a pack presentation";
            error = true;
        }
        if(error){
            Toast toast = Toast.makeText(view.getContext(), errorMsg,
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return;
        }
        intent.putExtra("dish", dish);
        view.getContext().startActivity(intent);
    }
}
