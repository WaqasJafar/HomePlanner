package com.builder.onlineestimater;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.collection.LLRBNode;

public class Custome_rating_adapter extends FirebaseRecyclerAdapter<ratinghelper,Custome_rating_adapter.MyViewHolder> {

    public  Custome_rating_adapter(FirebaseRecyclerOptions<ratinghelper> options){

        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull ratinghelper model) {

        holder.personname.setText(model.getPersonname());
        holder.ratingtext.setText(model.getRatingtxt());
        holder.ratingBar.setNumStars(model.getRating());
//        holder.city.setText(model.getCity());
//        holder.number.setText(model.getNumber());




        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent1=new Intent(v.getContext(),ContractorDetails.class);
//                intent1.putExtra("contractornumber",model.getNumber());
//                intent1.putExtra("contractorname",model.getName());
//                intent1.putExtra("contractorcity",model.getCity());
//                intent1.putExtra("contractoremail",model.getEmail());
//                v.getContext().startActivity(intent1);


            }
        });
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_item, parent, false);
        return new Custome_rating_adapter.MyViewHolder(view);
    }



    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView personname,ratingtext;
        RelativeLayout relative;
        RatingBar ratingBar;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ratingtext=(TextView) itemView.findViewById(R.id.ratingtext);
            personname=(TextView)itemView.findViewById(R.id.personname);
//            city=(TextView)itemView.findViewById(R.id.city);
//            number=(TextView)itemView.findViewById(R.id.number);
//            number=itemView.findViewById(R.id.contact_number);
            relative=itemView.findViewById(R.id.part);
            ratingBar=itemView.findViewById(R.id.ratingstar);

            Animation translate_anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            relative.setAnimation(translate_anim);
        }

    }

}
