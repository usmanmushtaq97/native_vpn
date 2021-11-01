package com.tss.lithavpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;
public class HomeActivity extends AppCompatActivity {
   TextView tv_select_country;
   List<ModelCountry> list;
   AdapterCountry adapterCountry;
    ImageView imageView;
    SpinKitView spinKitView;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeac);
        tv_select_country = findViewById(R.id.tv_select_country);
        imageView = findViewById(R.id.imageView_unlock);
        spinKitView = findViewById(R.id.spin_kit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.ic_lock);
                spinKitView.setVisibility(View.INVISIBLE);
            }
        });
        list = new ArrayList<>();
        list.add(new ModelCountry(R.drawable.ca,"Canada"));
        list.add(new ModelCountry(R.drawable.unitedkigdom,"United Kingdom"));
        list.add(new ModelCountry(R.drawable.unitedstate,"United States"));
        list.add(new ModelCountry(R.drawable.germany,"Germany"));
        tv_select_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.select_country);
                RecyclerView recyclerView =(RecyclerView)dialog.findViewById(R.id.rv);;
                ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.imageButton8);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adapterCountry = new AdapterCountry(context, list);
                recyclerView.setAdapter(adapterCountry);

                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Dismissed..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                Window window = dialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }
}