package com.shaoqf.strategy.base;

import lombok.Data;

@Data
public class BaseImportBean {

    private String name;

    private String msg;

    public BaseImportBean(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }
}
