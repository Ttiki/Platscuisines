package fr.uppa.platscuisines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import fr.uppa.platscuisines.models.Dish;

public class DishItemAdapter extends RecyclerView.Adapter<DishItemAdapter.ViewHolder> {
    public List<Dish> dishes;
    private final Context context;

    public DishItemAdapter(Context context, List<Dish> dishes) {
        this.dishes = dishes;
        this.context = context;
    }
    @Override
    public DishItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.dish_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Dish dish = dishes.get(position);
        viewHolder.dishName.setText(dish.getNomPlat());
        viewHolder.packOf2.setEnabled(dish.getConditionnePour2() == 1);
        viewHolder.packOf4.setEnabled(dish.getConditionnePour4() == 1);
        viewHolder.packOf6.setEnabled(dish.getConditionnePour6() == 1);
        viewHolder.packOf8.setEnabled(dish.getConditionnePour8() == 1);
        viewHolder.packOf12.setEnabled(dish.getConditionnePour12() == 1);
        viewHolder.addToOrder.setTag(dish.getIdPlat());
        viewHolder.moreInfo.setTag(dish.getIdPlat());
        Glide.with(context)
                .load("https://github.com/mbsanchez/PlatsCuisines/raw/master/imgs/" +
                        dish.getIdPlat() + ".png")
                .apply(new RequestOptions()
                        .placeholder(R.drawable.not_found))
                .into(viewHolder.dishImage);
    }
    @Override
    public int getItemCount() {
        return dishes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dishName;
        public TextView packOf2;
        public TextView packOf4;
        public TextView packOf6;
        public TextView packOf8;
        public TextView packOf12;
        public ImageView dishImage;
        public TextView addToOrder, moreInfo;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            dishName = itemLayoutView.findViewById(R.id.dishItemTitle);
            packOf2 = itemLayoutView.findViewById(R.id.pack2);
            packOf4 = itemLayoutView.findViewById(R.id.pack4);
            packOf6 = itemLayoutView.findViewById(R.id.pack6);
            packOf8 = itemLayoutView.findViewById(R.id.pack8);
            packOf12 = itemLayoutView.findViewById(R.id.pack12);
            dishImage = itemLayoutView.findViewById(R.id.dishImage);
            addToOrder = itemLayoutView.findViewById(R.id.addDishAction);
            moreInfo = itemLayoutView.findViewById(R.id.moreInfoAction);
        }
    }
}