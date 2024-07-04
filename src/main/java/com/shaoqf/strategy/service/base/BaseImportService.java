package com.shaoqf.strategy.service.base;

import com.shaoqf.strategy.base.ImportStrategy;
import org.springframework.stereotype.Service;

/**
 * 策略所属服务(由该服务调用具体策略中的方法)
 */
@Service
public class BaseImportService {

    private ImportStrategy strategy;

    public void setStrategy(ImportStrategy strategy) {
        this.strategy = strategy;
    }

    public String readFile(double amount){
        return strategy.readFile(amount);
    }
    public String checkFormat(double amount){
        return strategy.checkFormat(amount);
    }
    public String handleData(double amount){
        return strategy.handleData(amount);
    }
    public String convert(double amount){
        return strategy.convert(amount);
    }
    public String saveBathToDB(double amount){
        return strategy.saveBathToDB(amount);
    }
}
