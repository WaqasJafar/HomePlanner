package com.builder.onlineestimater;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MaterialCalculatorPage extends AppCompatActivity {
    EditText brick_cost,cement_cost,sand_cost,bajri_cost,iron_cost;
    Button btn_cost_done;
    ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_calculator_page);


        brick_cost=findViewById(R.id.brick_cost);
        cement_cost=findViewById(R.id.cement_cost);
        sand_cost=findViewById(R.id.sand_cost);
        bajri_cost=findViewById(R.id.bajri_cost);
        iron_cost=findViewById(R.id.iron_cost);
        btn_cost_done=findViewById(R.id.btn_cost_done);


btn_cost_done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if (brick_cost.getText().toString().equals("")|cement_cost.getText().toString().equals("")|sand_cost.getText().toString().equals("")|bajri_cost.getText().toString().equals("")|iron_cost.getText().toString().equals("")){
    Toast.makeText(MaterialCalculatorPage.this, "Please Fill All inputs or enter 0 ", Toast.LENGTH_SHORT).show();

}


else{


    int brick= Integer.parseInt(brick_cost.getText().toString());
    int cement=Integer.parseInt(cement_cost.getText().toString());
    int sand= Integer.parseInt(sand_cost.getText().toString());
    int ironroad=Integer.parseInt(iron_cost.getText().toString());
    int bajri=Integer.parseInt(bajri_cost.getText().toString());

    Intent intent=new Intent(MaterialCalculatorPage.this,PriceOfMaterialCalculatorPage.class);
    intent.putExtra("brick",brick);
    intent.putExtra("cement",cement);
    intent.putExtra("sand",sand);
    intent.putExtra("ironroad",ironroad);
    intent.putExtra("bajri",bajri);


    startActivity(intent);


}







    }
});





    }
}