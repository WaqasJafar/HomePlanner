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

import java.util.ArrayList;

public class CustomAdapter_of_recycleview extends FirebaseRecyclerAdapter<AddContractorHelper,CustomAdapter_of_recycleview.MyViewHolder> {
  
public  CustomAdapter_of_recycleview(FirebaseRecyclerOptions<AddContractorHelper> options){
    super(options);

}



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull AddContractorHelper model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.city.setText(model.getCity());
        holder.number.setText(model.getNumber());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (model.getAc_type().equals("Contractors")){
                    Intent intent1=new Intent(v.getContext(),ContractorDetails.class);
                    intent1.putExtra("contractornumber",model.getNumber());
                    intent1.putExtra("contractorname",model.getName());
                    intent1.putExtra("contractorcity",model.getCity());
                    intent1.putExtra("contractoremail",model.getEmail());
                    v.getContext().startActivity(intent1);
                }

                if (model.getAc_type().equals("User")){
                    Toast.makeText(v.getContext(), "", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }


//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
//
////        final AddContractorHelper contractor = carlist.get(position);
//
//        holder.name.setText(AddContractorHelper.getName());
//        holder.email.setText(contractor.getEmail());
//        holder.city.setText(contractor.getCity());
//        holder.number.setText(contractor.getNumber());
////        final byte[] carImage = car.getCarimage();
////        Bitmap bitmap = BitmapFactory.decodeByteArray(carImage, 0, carImage.length);
////        holder.image.setImageBitmap(bitmap);
//
//
//
//
//
////        Recyclerview onClickListener
//        holder.relative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:" + contractor.getNumber()));
//                context.startActivity(intent);
//            }
//        });
//
//
//    }



//    @Override
//    public int getItemCount() {
//        return carlist.size();
//    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,email,city,number;
        RelativeLayout relative;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.c_icon);
            name=(TextView) itemView.findViewById(R.id.name);
            email=(TextView)itemView.findViewById(R.id.email);
            city=(TextView)itemView.findViewById(R.id.city);
            number=(TextView)itemView.findViewById(R.id.number);
//            number=itemView.findViewById(R.id.contact_number);
            relative=itemView.findViewById(R.id.part);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
            relative.setAnimation(translate_anim);
        }

    }

}
