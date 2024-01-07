package com.shaoqf.strategy.service.payStrategy;

import com.shaoqf.strategy.base.PayStrategy;
import com.shaoqf.strategy.utils.enums.PayType;
import org.springframework.stereotype.Service;

@Service("PAYPAL")
public class PayPalPayStrategy implements PayStrategy {

    @Override
    public String pay(double amount) {
        return "使用 ".concat(PayType.PAYPAL.getDesc()).concat(" 支付了").concat(String.valueOf(amount)).concat("元");
    }
}
