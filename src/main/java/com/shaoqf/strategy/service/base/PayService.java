package com.shaoqf.strategy.service.base;

import com.shaoqf.strategy.base.PayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    private PayStrategy strategy;

    public PayService(PayStrategy strategy){
        this.strategy = strategy;
    }

    public String pay(double amount) {
        return strategy.pay(amount);
    }

    public void setStrategy(PayStrategy strategy) {
        this.strategy = strategy;
    }
}
