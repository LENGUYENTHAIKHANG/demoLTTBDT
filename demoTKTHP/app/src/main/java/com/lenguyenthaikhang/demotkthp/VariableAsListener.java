package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VariableAsListener extends AppCompatActivity {
ImageView img;
Button on, off;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_as_listener);
        addView();
        on.setOnClickListener(myclick);
        off.setOnClickListener(myclick);
    }
    private View.OnClickListener myclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.on){
                img.setImageResource(R.drawable.actions_help_hint_icon);
            }
            else if(v.getId()==R.id.off){
                img.setImageResource(R.drawable.actions_help_hint_icon1);
            }

        }
    };

    private void addView() {
        on= findViewById(R.id.on);
        off= findViewById(R.id.off);
        img= findViewById(R.id.img);
    }
}