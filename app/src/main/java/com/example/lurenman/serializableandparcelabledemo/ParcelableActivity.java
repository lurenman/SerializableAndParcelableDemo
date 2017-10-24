package com.example.lurenman.serializableandparcelabledemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lurenman.serializableandparcelabledemo.entity.MyParcelable;

/**
 * @author: baiyang.
 * Created on 2017/10/24.
 * 这个可以参考一下
 * http://www.cnblogs.com/yezhennan/p/5527506.html
 * ：虽然Parcelable的性能要强于Serializable,但是仍然有特殊的情况需要使用Serializable,而不去使用Parcelable,
 * 因为Parcelable无法将数据进行持久化,因此在将数据保存在磁盘的时候,仍然需要使用后者,因为前者无法很好的将数据进行持久化.
 * (原因是在不同的Android版本当中,Parcelable可能会不同,因此数据的持久化方面仍然是使用Serializable)
 */

public class ParcelableActivity extends BaseActivity {
    private static final String TAG = "ParcelableActivity";
    private TextView tv_content;
//    private TextView tv_put;
//    private TextView tv_get;
//    private File mSdFileAbsolutePath;

    @Override
    protected void initVariables() {
       // mSdFileAbsolutePath = new File(this.getExternalFilesDir(null), "Parcelable.txt");
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_parcelable);
        tv_content = (TextView) findViewById(R.id.tv_content);
//        tv_put = (TextView) findViewById(R.id.tv_put);
//        tv_get = (TextView) findViewById(R.id.tv_get);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                MyParcelable myParcelable = (MyParcelable) bundle.get("MyParcelable");
                int id = myParcelable.getId();
                String name = myParcelable.getName();
                tv_content.setText("id:" + id + "\n" + "name:" + name);
            }
        }

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
//        //存数据
//        tv_put.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FileOutputStream ostream = null;
//                try {
//                    ostream = new FileOutputStream(mSdFileAbsolutePath.toString());
//                       /*  创建输出流  */
//                    ObjectOutputStream p = new ObjectOutputStream(ostream);
//                    MyParcelable myParcelable= new MyParcelable();
//                    myParcelable.setId(2222222);
//                    myParcelable.setName("全职猎人");
//                    p.writeObject(myParcelable);
//                    p.writeObject("你猜你猜");
//                    p.flush();
//                    ostream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, e.toString());
//                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//        //取
//        // 数据
//        tv_get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              /*  打开文件并设置成从中读取对象。  */
//                FileInputStream istream = null;
//                try {
//                    istream = new FileInputStream(mSdFileAbsolutePath.toString());
//                    ObjectInputStream q = new ObjectInputStream(istream);
//                    MyParcelable myParcelable = (MyParcelable) q.readObject();
//                    String title = (String) q.readObject();
//                    Toast.makeText(getApplicationContext(), "" + myParcelable.getId() + myParcelable.getName() + title, Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, e.toString());
//                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    protected void loadData() {

    }
}
