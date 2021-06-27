package com.lenguyenthaikhang.demotkthp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class ViewSubclassing extends AppCompatActivity {

LinearLayout iii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subclassing);
        view();
        Button btn1 = new androidx.appcompat.widget.AppCompatButton(this) {
            @Override
            public boolean performClick() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();

                System.exit(1);
                return super.performClick();
            }



        };
        btn1.setText("close");
        LinearLayout layout= (LinearLayout)findViewById(R.id.iii);
        layout.addView(btn1);



    }

    private void view() {

        iii= findViewById(R.id.iii);

    }
}