package com.shaoqf.strategy.utils.enums;

public enum PayType {
    ALIPAY("ALIPAY","支付宝"),
    PAYPAL("PAYPAL","宝付"),
    WECHAT("WECHAT","微信");

    private String type;
    private String desc;
    PayType(String type,String desc){
        this.type = type;
        this.desc = desc;
    }
    public String getType(){
        return type;
    }
    public String getDesc(){
        return desc;
    }

    public static PayType getValue(String code) {
        for (PayType payType : PayType.values()) {
            if (payType.getType().equals(code)) {
                return payType;
            }
        }
        return PayType.ALIPAY; // 默认
    }
}
