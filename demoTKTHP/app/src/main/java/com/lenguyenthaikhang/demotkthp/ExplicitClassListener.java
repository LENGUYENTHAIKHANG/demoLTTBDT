package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitClassListener extends AppCompatActivity {
EditText edt1 , edt2;
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_class_listener);
        linkview();
        btn1.setOnClickListener(new myevent1());
        btn2.setOnClickListener(new myevent2());
        btn3.setOnClickListener(new myevent3());
    }

    private void linkview() {
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
    }

    private class myevent1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int a = Integer.parseInt(edt1.getText()+"");
            edt2.setText(((a-32)*(9/5))+"");

        }
    }

   private class myevent2 implements View.OnClickListener {
      @Override
       public void onClick(View v) {
           int b = Integer.parseInt(edt2.getText()+"");
           edt1.setText((b*(9/5)+32)+"");
       }
   }

    private class myevent3 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            edt1.setText("");
            edt2.setText("");
        }
    }
}