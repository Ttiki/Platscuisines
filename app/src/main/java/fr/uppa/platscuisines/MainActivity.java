package fr.uppa.platscuisines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fr.uppa.platscuisines.databinding.ActivityMainBinding;
import fr.uppa.platscuisines.db.DishDAO;
import fr.uppa.platscuisines.db.SQLiteDB;
import fr.uppa.platscuisines.models.Dish;
import fr.uppa.platscuisines.models.DishBuilder;

public class MainActivity extends AppCompatActivity {
    public DishViewModel viewModel;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main); viewModel
                = new DishViewModel(); binding.setViewModel(
                viewModel);
    }
}
