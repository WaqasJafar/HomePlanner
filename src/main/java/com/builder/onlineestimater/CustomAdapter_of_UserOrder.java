package com.builder.onlineestimater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CustomAdapter_of_UserOrder extends FirebaseRecyclerAdapter<Mystore,CustomAdapter_of_UserOrder.MyViewHolder>  {

    public  CustomAdapter_of_UserOrder(FirebaseRecyclerOptions<Mystore> options){
        super(options);

    }

    @NonNull
    @Override
    public CustomAdapter_of_UserOrder.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new CustomAdapter_of_UserOrder.MyViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull CustomAdapter_of_UserOrder.MyViewHolder holder, int position, @NonNull Mystore model) {
        holder.name.setText(model.getName());
        holder.price.setText(model.getTotalpricematerial());
        holder.date.setText(model.getCurrentdate());
        holder.number.setText(model.getNumber());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent1=new Intent(v.getContext(),Order_Detail.class);
                    intent1.putExtra("number",model.getNumber());
                    intent1.putExtra("name",model.getName());
                    intent1.putExtra("date",model.getCurrentdate());
                    intent1.putExtra("price",model.getTotalpricematerial());
                    intent1.putExtra("time",model.getCurrentTime());
                 intent1.putExtra("brick",model.getBrick());
                intent1.putExtra("cement",model.getCement());
                intent1.putExtra("iron",model.getIron());
                intent1.putExtra("bajri",model.getBajri());
                intent1.putExtra("sand",model.getSand());

                    v.getContext().startActivity(intent1);






            }
        });
    }




    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,price,date,number;
        RelativeLayout relative;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.c_icon);
            name=(TextView) itemView.findViewById(R.id.name);
            price=(TextView)itemView.findViewById(R.id.price);
            date=(TextView)itemView.findViewById(R.id.date);
            number=(TextView)itemView.findViewById(R.id.number);
//            number=itemView.findViewById(R.id.contact_number);
            relative=itemView.findViewById(R.id.part);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            relative.setAnimation(translate_anim);
        }

    }

}
