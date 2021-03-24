package fr.uppa.platscuisines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import fr.uppa.platscuisines.db.DishDAO;
import fr.uppa.platscuisines.db.SQLiteDB;
import fr.uppa.platscuisines.models.Dish;
import fr.uppa.platscuisines.models.DishBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DishDAO dishDao = SQLiteDB.getInstance().getDishDao();
        Dish dish =new Dish("burger de remy",0,1,0,1,1);
        //dishDao.insert(dish);
        List<Dish> all = dishDao.getAll();
        Log.i("myapplication","nb de plats dispos:" + all.size();
    }

    /*public void handleOK(View view) {
        Intent intent = new Intent(this, DisplayDishActivity.class);
        EditText dishName = findViewById(R.id.dishName);
        SwitchCompat packof2 = findViewById(R.id.packof2);
        SwitchCompat packof4 = findViewById(R.id.packof4);
        SwitchCompat packof6 = findViewById(R.id.packof6);
        SwitchCompat packof8 = findViewById(R.id.packof8);
        SwitchCompat packof12 = findViewById(R.id.packof12);
        boolean error = false;
        String errorMsg = null;
        if (dishName.getText().toString().isEmpty()) {
            errorMsg = "Entrez un nom de plat svp";
            dishName.requestFocus();
            error = true;
        } else if (!packof2.isChecked() && !packof4.isChecked() && !packof6.isChecked() &&
                !packof8.isChecked() && !packof12.isChecked()) {
            errorMsg = "Sélectionnez au moins un pack svp";
            dishName.requestFocus();
            error = true;
        }


        if (error) {
            Toast toast = Toast.makeText(getApplicationContext(), errorMsg,
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return;
        }
        Dish dish = new DishBuilder().setNomPlat(dishName.getText().toString()).
                setConditionnePour2(packof2.isChecked() ? 1 : 0).
                setConditionnePour4(packof4.isChecked() ? 1 : 0).
                setConditionnePour6(packof6.isChecked() ? 1 : 0).
                setConditionnePour8(packof8.isChecked() ? 1 : 0).
                setConditionnePour12(packof12.isChecked() ? 1 : 0).createDish();
        intent.putExtra("dish", dish);
        startActivity(intent);
    }*/

    public void handleOK(View view)
    {
        Intent intent = new Intent(this, DisplayDishActivity.class);
        EditText dishName = findViewById(R.id.dishName);
        //Validate the input
        if (dishName.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please, enter the Dish Name!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return;
        }
        Dish dish = SQLiteDB.getInstance().getDishDao().
                findByName(dishName.getText().toString());
        if (dish == null) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Unknown Dish, Try again!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return;
        }
        intent.putExtra("dish", dish);
        startActivity(intent);
    }

}