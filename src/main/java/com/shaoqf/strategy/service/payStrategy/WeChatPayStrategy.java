package com.shaoqf.strategy.service.payStrategy;

import com.shaoqf.strategy.base.PayStrategy;
import com.shaoqf.strategy.utils.enums.PayType;
import org.springframework.stereotype.Service;

@Service("WECHAT")
public class WeChatPayStrategy implements PayStrategy {

    @Override
    public String pay(double amount) {
        return "使用 ".concat(PayType.WECHAT.getDesc()).concat(" 支付了").concat(String.valueOf(amount)).concat("元");
    }
}
