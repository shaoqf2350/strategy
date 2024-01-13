package com.shaoqf.strategy.utils.enums;
public enum ImportType {
    VOUCHER("VOUCHER","凭证导入"),
    JOURNAL("JOURNAL","日记账导入"),
    INVOICE("INVOICE","发票导入"),
    OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT("OLDACCOUNTS","旧账导入_柠檬云_云会计_科目"),
    OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECTBALANCE("OLDACCOUNTS","旧账导入_柠檬云_云会计_科目余额"),
    OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_VOUCHER("OLDACCOUNTS","旧账导入_柠檬云_云会计_凭证"),
    OLDACCOUNTS_JINDIE_JINGDOUYUN_SUBJECT("OLDACCOUNTS","旧账导入_金蝶_精斗云_科目"),
    OLDACCOUNTS_JINDIE_JINGDOUYUN_SUBJECTBALANCE("OLDACCOUNTS","旧账导入_金蝶_精斗云_科目余额"),
    OLDACCOUNTS_JINDIE_JINGDOUYUN_VOUCHER("OLDACCOUNTS","旧账导入_金蝶_精斗云_凭证");

    private String type;
    private String desc;
    ImportType(String type, String desc){
        this.type = type;
        this.desc = desc;
    }
    public String getType(){
        return type;
    }
    public String getDesc(){
        return desc;
    }

    public static ImportType getValue(String code) {
        for (ImportType payType : ImportType.values()) {
            if (payType.getType().equals(code)) {
                return payType;
            }
        }
        return null;
    }
}
