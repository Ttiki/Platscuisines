package fr.uppa.platscuisines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

import fr.uppa.platscuisines.db.DishDAO;
import fr.uppa.platscuisines.models.Dish;
import fr.uppa.platscuisines.models.DishOrderItem;
import fr.uppa.platscuisines.models.DishOrderItemBuilder;
import fr.uppa.platscuisines.models.SaveOrderFacade;

public class DishViewActivity extends AppCompatActivity implements Observer {
    @Inject
    DishDAO dishDAO;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Inject
    SaveOrderFacade saveOrderFacade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_view);
        ((MyApplication)getApplication()).getDataComponent().inject(this);
        List<Dish> dishes = dishDAO.getAll();
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(
                this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DishItemAdapter(getApplicationContext(), dishes);
        mRecyclerView.setAdapter(mAdapter);

        saveOrderFacade.addObserver(this);
        saveOrderFacade.clearOrder();

    }

    public void addDishToOrder(View view){
        int platId = (int) view.getTag();
        Dish dish = dishDAO.findById(platId);
        if(dish == null){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Error, the dish doesn't exist in the database!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        }
        saveOrderFacade.addItem(new DishOrderItemBuilder().setId(dish.getIdPlat()).
                setDishName(dish.getNomPlat()).setQuantityFor2(1).setQuantityFor4(1).

                setQuantityFor6(1).setQuantityFor8(1).setQuantityFor12(1).createDishOrderItem());
        Toast toast = Toast.makeText(getApplicationContext(),
                dish.getNomPlat()+ ", added!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void sendOrder(View view){
        if(saveOrderFacade.orderSize()<=0){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Not dishes have yet been added to the order!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return;
        }
        saveOrderFacade.saveOrder(this);
        saveOrderFacade.sendOrder(this);
        saveOrderFacade.clearOrder();
    }

    @Override
    public void update(Observable observable, Object o) {
        FloatingActionButton button = findViewById(R.id.sendOrder);
        if(saveOrderFacade.orderSize()==0)
            button.hide();
        else
            button.show();
    }
}