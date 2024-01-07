package com.shaoqf.strategy.service.payStrategy;

import com.shaoqf.strategy.base.PayStrategy;
import com.shaoqf.strategy.utils.enums.PayType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("ALIPAY")
public class AlipayPayStrategy implements PayStrategy {

    @Override
    public String pay(double amount) {
        return "使用 ".concat(PayType.ALIPAY.getDesc()).concat(" 支付了").concat(String.valueOf(amount)).concat("元");
    }
}
