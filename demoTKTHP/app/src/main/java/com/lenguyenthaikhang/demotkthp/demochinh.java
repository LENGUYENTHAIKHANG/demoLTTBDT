package com.lenguyenthaikhang.demotkthp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class demochinh extends AppCompatActivity {
Button btn1,btn2,btn3;
LinearLayout lo;
EditText edt1 ,edt2,edt3,edt4,edt5,edt6,edt7;
    private DatabaseReference database;
    private String m_Text = "";
    private String Text = "";

private RelativeLayout lo1 = null;
private float x;
private float y;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demochinh);
        input();
        addView();
        eventlinhtinh();
        addEventforcus();
        addEventlongclick();
        addeventOnTouch();
        addeventonmenu();
        addeventcontextmenu();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("dulieu");

        //myRef.setValue("Hello, World!");


    }

    private void input() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mời bạn nhập mã sinh viên");


        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                edt2.setText(m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent myIntent = new Intent(demochinh.this,MainActivity.class);
                startActivity(myIntent);
            }
        });

        builder.show();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(demochinh.this);
            builder.setMessage("Bạn có muốn xóa hết thông tin và quay lại trang trước không?");
            builder.setTitle("Xác nhận");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog= builder.create();
            dialog.show();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }



    private void addeventcontextmenu() {

        registerForContextMenu(lo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ex:
                finish();
                System.exit(0);

            case R.id.b:
                Intent intent1 = new Intent(demochinh.this,MainActivity.class);
                startActivity(intent1);
        }
        return super.onContextItemSelected(item);
    }

    private void addeventonmenu() {
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(demochinh.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu1, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.au:
                                Toast.makeText(getApplicationContext(), ("LÊ NGUYỄN THÁI KHANG 5951071043\n " +
                                                                        "NGUYỄN HOÀNG NHẬT 5951071069\n " +
                                                                        "NGUYỄN ĐÌNH GIA KHẢI 5951071042 ")
                                                                        .toString(), Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.ws:
                                String url = "http://dept.utc2.edu.vn/bomoncntt/";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });

    }

    private void eventlinhtinh() {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");

                edt3.setText("");
                edt4.setText("");
                edt5.setText("");
                edt6.setText("");
                edt7.setText("");


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text= edt2.getText().toString();
                if (Text.equals("")){
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mã sinh viên" .toString(), Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Bạn đã khai báo thành công" .toString(), Toast.LENGTH_LONG).show();
                    database = FirebaseDatabase.getInstance().getReference();


                    String name = edt1.getText().toString();
                    String msv = edt2.getText().toString();
                    String namsinh = edt3.getText().toString();
                    String lop = edt4.getText().toString();
                    String que = edt5.getText().toString();
                    String sdt= edt6.getText().toString();
                    String email = edt7.getText().toString();

                    UserModel userModel = new UserModel(name,msv,namsinh,lop,que,sdt,email);

                    database.child("khang").child(msv).setValue(userModel);


                    //Intent myIntent	=	new Intent(getApplication(),view.class);
                    Intent myIntent = new Intent(demochinh.this,view.class);

                    Bundle myBundle	=	 new Bundle();
                    myIntent.putExtra("a",edt1.getText().toString());
                    myIntent.putExtra("b",edt2.getText().toString());
                    myIntent.putExtra("c",edt3.getText().toString());
                    myIntent.putExtra("d",edt4.getText().toString());
                    myIntent.putExtra("e",edt5.getText().toString());
                    myIntent.putExtra("f",edt6.getText().toString());
                    myIntent.putExtra("g",edt7.getText().toString());



                    myIntent.putExtra("mysum", myBundle);



                    startActivity(myIntent);

                }



            }
        });
    }

    private void addeventOnTouch() {
        lo1.setOnTouchListener(new View.OnTouchListener() {
            int i=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getX();
                y = event.getY();
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    btn2.setX(x);
                    btn2.setY(y);
                }
                return true;
            }
        });

    }

    private void addEventlongclick() {
        edt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập họ và tên của bạn",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        edt2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập mã sinh viên của bạn",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        edt3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập năm sinh",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        edt4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập tên lớp mà bạn theo học kèm theo khóa",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        edt5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập tên tỉnh mà bạn đang sinh sống ",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        edt6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập số điện thoại ",Toast.LENGTH_SHORT).show();
                return true;
            }
        }); edt7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Nhập Email để chúng tôi có thể liên lạc với bạn",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void addEventforcus() {
        edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt1.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt2.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt2.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt3.getText()!=null) {

                    Toast.makeText(getApplicationContext(), edt3.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt4.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt4.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt5.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt5.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt6.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt6.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        edt7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&& edt7.getText()!=null) {

                    Toast.makeText(getApplicationContext(),  edt7.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    private void addView() {
        btn1= findViewById(R.id.btn1);
        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        edt3= findViewById(R.id.edt3);
        edt4= findViewById(R.id.edt4);
        edt5= findViewById(R.id.edt5);
        edt6= findViewById(R.id.edt6);
        edt7= findViewById(R.id.edt7);
        btn2= findViewById(R.id.btn2);
        lo1= (RelativeLayout)findViewById(R.id.lo1);
        btn3= findViewById(R.id.btn3);
        lo= findViewById(R.id.lo);



       ;
    }


}