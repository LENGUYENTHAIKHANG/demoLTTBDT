package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OnclickXML extends AppCompatActivity {
Button btn1, btn2 ,btn3, btn4;
EditText edt1, edt2,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_x_m_l);
        linkView();


    }



    private void linkView() {
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        tv1= findViewById(R.id.tv1);
    }

    public void tong(View view) {
        int a = Integer.parseInt(edt1.getText()+"");
        int b = Integer.parseInt(edt2.getText()+"");
        tv1.setText((a+b)+"");
    }

    public void hieu(View view) {
        int a = Integer.parseInt(edt1.getText()+"");
        int b = Integer.parseInt(edt2.getText()+"");
        tv1.setText((a-b)+"");
    }

    public void nhan(View view) {
        int a = Integer.parseInt(edt1.getText()+"");
        int b = Integer.parseInt(edt2.getText()+"");
        tv1.setText((a*b)+"");
    }

    public void chia(View view) {
        int a = Integer.parseInt(edt1.getText()+"");
        int b = Integer.parseInt(edt2.getText()+"");

        tv1.setText((a/b)+"");
    }
}