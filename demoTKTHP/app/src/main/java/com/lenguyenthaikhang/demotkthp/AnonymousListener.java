package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnonymousListener extends AppCompatActivity {
Button btn1;
EditText edt1;
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_listener);
        btn1 = findViewById(R.id.btn1);
        edt1 = findViewById(R.id.edt1);
        tv1 = findViewById(R.id.tv1);
        addEvent();
    }

    private void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can[]={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
                String chi[]={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
                String dl = edt1.getText().toString();
                int n = Integer.parseInt(dl);
                String am = can[n%10]+"  "+chi[n%12];
                tv1.setText(am);


            }
        });
    }
}