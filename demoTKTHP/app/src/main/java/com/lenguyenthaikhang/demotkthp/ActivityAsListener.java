package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityAsListener extends AppCompatActivity implements View.OnClickListener {
Button btn1;
EditText edt1,edt2;
TextView t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_listener);

        linkView();


        btn1.setOnClickListener(this);




    }

    private void linkView() {
        btn1= findViewById(R.id.btn1);

        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        t3= findViewById(R.id.t3);
        t4= findViewById(R.id.t4);
    }

    @Override
    public void onClick(View v) {

        double H = Double.parseDouble(edt1.getText()+"");
        double W = Double.parseDouble(edt2.getText()+"");
        double BMI = W/Math.pow(H,2);
        String chuandoan="";
        if (BMI<18){
            chuandoan="bạn gầy";
        }
        else if (BMI<=24.9){
            chuandoan="bạn bình thường ";
        }
        else if (BMI<=29.9){
            chuandoan="bạn béo phì độ 1";

        }
        else if (BMI<=34.9){
            chuandoan="bạn béo phì độ 2";
        }
        else {
            chuandoan="bạn béo phì độ 3";
        }
        DecimalFormat df = new DecimalFormat("#.0");
        t3.setText(df.format(BMI));
        t4.setText(chuandoan);
    }
}