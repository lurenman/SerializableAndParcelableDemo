package com.example.lurenman.serializableandparcelabledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lurenman.serializableandparcelabledemo.entity.MyParcelable;
import com.example.lurenman.serializableandparcelabledemo.entity.Person;

public class MainActivity extends AppCompatActivity {

    private TextView tv_Serializable;
    private TextView tv_Parcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();

    }

    private void initViews() {
        tv_Serializable = (TextView) findViewById(R.id.tv_Serializable);
        tv_Parcelable = (TextView) findViewById(R.id.tv_Parcelable);

    }

    private void initEvents() {
        tv_Serializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p = new Person();
                p.setId(1111111);
                p.setName("海贼王");
                Intent intent = new Intent(MainActivity.this, SerializableActivity.class);
                intent.putExtra("Person", p);
                startActivity(intent);
            }
        });
        tv_Parcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyParcelable myParcelable = new MyParcelable();
                myParcelable.setId(232323);
                myParcelable.setName("大话西游");
                Intent intent = new Intent(MainActivity.this, ParcelableActivity.class);
                intent.putExtra("MyParcelable", myParcelable);
                startActivity(intent);
            }
        });

    }
}
