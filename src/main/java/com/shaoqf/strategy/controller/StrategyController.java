package com.shaoqf.strategy.controller;

import com.shaoqf.strategy.demos.web.BasicController;
import com.shaoqf.strategy.service.base.PayService;
import com.shaoqf.strategy.base.PayStrategy;
import com.shaoqf.strategy.utils.enums.PayType;
import com.shaoqf.strategy.base.SpringContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/strategy")
public class StrategyController extends BasicController {

    // 支付方式(ALIPAY-支付宝; WECHAT-微信支付; PAYPAL-宝付)
    @PostMapping("/pay")
    public String pay(@RequestParam("type") PayType type, @RequestParam("amount") double amount) {
        PayService payService = SpringContext.getBean(PayService.class); // 从应用上下文中获取PayService对象

        PayStrategy strategy = (PayStrategy) SpringContext.getPayBean(type); // 从应用上下文中根据枚举获取对应策略对象

        payService.setStrategy(strategy); // 切换到对应的策略对象

        return payService.pay(amount);//调用对应的服务方法，执行策略对象的算法
    }
}
