package fr.uppa.platscuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import fr.uppa.platscuisines.models.Dish;

public class DisplayDishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dish);

        Dish dish = (Dish) getIntent().getSerializableExtra("dish");
        TextView dishNameView = findViewById(R.id.dishNameText);
        ListView packList = findViewById(R.id.listPacks);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);
        Log.d("test","Test, everything is ok");
        if(dish.getConditionnePour2()==1) {
            adapter.add(getString(R.string.pack_2));
            Log.d("Get2", "Getting 2!");
        }
        if(dish.getConditionnePour4()==1) {
            adapter.add(getString(R.string.pack_4));
            Log.d("Get4", "Getting 4!");
        }
        if(dish.getConditionnePour6()==1) {
            adapter.add(getString(R.string.pack_6));
            Log.d("Get6", "Getting 6!");
        }
        if(dish.getConditionnePour8()==1) {
            adapter.add(getString(R.string.pack_8));
            Log.d("Get8", "Getting 8!");
        }
        if(dish.getConditionnePour12()==1) {
            adapter.add(getString(R.string.pack_12));
            Log.d("Get12", "Getting 12!");
        }
        packList.setAdapter(adapter);
        dishNameView.setText(dish.getNomPlat());
        Log.d("End","This is the normal end!");


    }
}