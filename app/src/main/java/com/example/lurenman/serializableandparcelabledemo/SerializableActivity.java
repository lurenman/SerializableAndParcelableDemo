package com.example.lurenman.serializableandparcelabledemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lurenman.serializableandparcelabledemo.entity.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: baiyang.
 * Created on 2017/10/24.
 */

public class SerializableActivity extends BaseActivity {
    private static final String TAG = "SerializableActivity";
    private TextView tv_content;
    private TextView tv_put;
    private TextView tv_get;
    private File mSdFileAbsolutePath;

    @Override
    protected void initVariables() {
        mSdFileAbsolutePath = new File(this.getExternalFilesDir(null), "Person.txt");
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_serializable);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_put = (TextView) findViewById(R.id.tv_put);
        tv_get = (TextView) findViewById(R.id.tv_get);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Person p = (Person) bundle.get("Person");
                int id = p.getId();
                String name = p.getName();
                tv_content.setText("id:" + id + "\n" + "name:" + name);
            }
        }
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //存数据
        tv_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream ostream = null;
                try {
                    ostream = new FileOutputStream(mSdFileAbsolutePath.toString());
                       /*  创建输出流  */
                    ObjectOutputStream p = new ObjectOutputStream(ostream);
                    Person person = new Person();
                    person.setId(2222222);
                    person.setName("全职猎人");
                    p.writeObject(person);
                    p.writeObject("你猜你猜");
                    p.flush();
                    ostream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, e.toString());
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        //取
        // 数据
        tv_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  打开文件并设置成从中读取对象。  */
                FileInputStream istream = null;
                try {
                    istream = new FileInputStream(mSdFileAbsolutePath.toString());
                    ObjectInputStream q = new ObjectInputStream(istream);
                    Person person = (Person) q.readObject();
                    String title = (String) q.readObject();
                    Toast.makeText(getApplicationContext(), "" + person.getId() + person.getName() + title, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, e.toString());
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
