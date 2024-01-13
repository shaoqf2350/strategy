package com.shaoqf.strategy.base;

public interface ImportStrategy {
    // 1.校验文件格式及表头
    // 2.读取文件
    // 3.处理数据
    // 4.数据转换封装成通用类型
    // 5.保存数据(通用类型)

    public String checkFormat(double amount);
    public String readFile(double amount);
    public String handleData(double amount);
    public String convert(double amount);
    public String saveDB(double amount);

}
