package com.shaoqf.strategy.service.base;

import com.shaoqf.strategy.base.ImportStrategy;
import org.springframework.stereotype.Service;

@Service
public class ImportService {

    private ImportStrategy strategy;

    public void setStrategy(ImportStrategy strategy) {
        this.strategy = strategy;
    }

    public String readFile(double amount){
        return strategy.readFile(amount);
    }

    public String handleData(double amount){
        return strategy.handleData(amount);
    }

    public String convert(double amount){
        return strategy.convert(amount);
    }

    public String save(double amount){
        return strategy.save(amount);
    }
}
