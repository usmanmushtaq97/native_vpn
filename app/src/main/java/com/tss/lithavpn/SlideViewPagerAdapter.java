package com.tss.lithavpn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;
    List<PlainModels> plainModelsList;

    public SlideViewPagerAdapter(Context ctx, List< PlainModels > plainModelsList) {
        this.ctx = ctx;
        this.plainModelsList = plainModelsList;
    }

    @Override
    public int getCount() {
        return plainModelsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.plainsitems,container,false);

        TextView title=view.findViewById(R.id.textView_plain);
        TextView desc=view.findViewById(R.id.des_tv);
        TextView price=view.findViewById(R.id.tv_price);
        TextView sub_tv=view.findViewById(R.id.sub_tv);

        price.setText(plainModelsList.get(position).getPrice());
        title.setText(plainModelsList.get(position).duration);
        desc.setText(plainModelsList.get(position).descriptions);
        sub_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, HomeActivity.class);
                ctx.startActivity(intent);


            }
        });
//
//        ImageView next=view.findViewById(R.id.next);
//        ImageView back=view.findViewById(R.id.back);
//
//        Button btnGetStarted=view.findViewById(R.id.btnGetStarted);
//        btnGetStarted.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ctx,MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//                ctx.startActivity(intent);
//            }
//        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SlideActivity.viewPager.setCurrentItem(position+1);
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SlideActivity.viewPager.setCurrentItem(position-1);
//            }
//        });




        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
