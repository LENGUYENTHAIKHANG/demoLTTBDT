package com.lenguyenthaikhang.demotkthp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class view extends AppCompatActivity {
Button btn8;
TextView ten,namsinh, email,sdt,msv,que,lop;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        addView();
        addevent();


    }

    private void addevent() {
      //  Bundle bundle = getIntent().getExtras();
       // ten.setText(bundle.getString("a"));
        Intent intent= getIntent();
        String a = intent.getStringExtra("a");
        String b = intent.getStringExtra("b");
        String c = intent.getStringExtra("c");
        String d = intent.getStringExtra("d");
        String e = intent.getStringExtra("e");
        String f = intent.getStringExtra("f");
        String g = intent.getStringExtra("g");
        ten.setText(a);
        msv.setText(b);
        namsinh.setText(c);
        lop.setText(d);
        que.setText(e);
        sdt.setText(f);
        email.setText(g);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(view.this,MainActivity.class);
                startActivity(myIntent);
            }
        });

    }


    private void addView() {
ten = findViewById(R.id.ten);
        namsinh = findViewById(R.id.namsinh);
        email = findViewById(R.id.email);
        sdt = findViewById(R.id.sdt);
        msv = findViewById(R.id.msv);
        que = findViewById(R.id.que);
        lop = findViewById(R.id.lop);
        btn8 = findViewById(R.id.btn8);

    }

}