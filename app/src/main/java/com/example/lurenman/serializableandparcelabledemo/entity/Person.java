package com.example.lurenman.serializableandparcelabledemo.entity;

import java.io.Serializable;

/**
 * @author: baiyang.
 * Created on 2017/10/24.
 */

public class Person implements Serializable {
    //这个UID就像一个标识一样，如果UID不同读文件的时候会报.InvalidClassException: 这个异常.
    private static final long serialVersionUID = 6085309111666301533L;
    // 成员变量
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
