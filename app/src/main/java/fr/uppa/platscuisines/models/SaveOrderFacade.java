package fr.uppa.platscuisines.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class SaveOrderFacade extends Observable {
    public static String ORDER_FILE_NAME = "order.csv";
    List<DishOrderItem> order;

    public SaveOrderFacade(){
        order = new ArrayList<>();
    }

    public void addItem(DishOrderItem item){
        order.add(item);
        setChanged();
        notifyObservers();
    }
    public int orderSize(){
        return order.size();
    }
    public void clearOrder(){
        order.clear();
        setChanged();
        notifyObservers();
    }
    public boolean saveOrder(Context context){
        try {
            File path = new File(context.getFilesDir(), "temp");
            if(!path.exists())
                path.mkdir();
            File file = new File(path, ORDER_FILE_NAME);
            if(file.exists())
                file.delete();
            OutputStreamWriter writer = new OutputStreamWriter(new
                    FileOutputStream(file));
            BufferedWriter bufwri = new BufferedWriter(writer);
            bufwri.write("ref,PlatNom,quantity2,quantity4,quantity6,quantity8,quantity12");
            bufwri.newLine();
            for(DishOrderItem item : order) {
                bufwri.write(item.getId()+","+item.getDishName()
                        +";"+item.getQuantityFor2()+","+
                        item.getQuantityFor4()+","+item.getQuantityFor6()+","+
                        item.getQuantityFor8()+","+item.getQuantityFor12());
                bufwri.newLine();
            }
            bufwri.close();
            Log.i("Path","Wrote to: "+context.getExternalFilesDir(null).getAbsolutePath());
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return false;
        }
        return true;
    }

    public void sendOrder(Context context){

    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        File path = new File(context.getFilesDir(), "temp");
        File file = new File(path, ORDER_FILE_NAME);
        Uri csvFile = FileProvider.getUriForFile(context, "fr.uppa.platscuisines.models", file);
        sharingIntent.setType("text/comma-separated-values");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, csvFile);
        sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sharingIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        context.startActivity(Intent.createChooser(sharingIntent, "Partager la commande avec..."));
    }
}
