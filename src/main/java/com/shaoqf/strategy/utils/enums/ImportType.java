package com.shaoqf.strategy.utils.enums;

public enum ImportType {
    VOUCHER("VOUCHER","凭证导入"),
    JOURNAL("JOURNAL","日记账导入"),
    INVOICE("INVOICE","发票导入"),
    OA_NMY_YUNKUAIJI_SUBJECT("OA_NMY_YUNKUAIJI_SUBJECT","旧账导入_柠檬云_云会计_科目"),
    OA_NMY_YUNKUAIJI_SUBJECTBALANCE("OA_NMY_YUNKUAIJI_SUBJECTBALANCE","旧账导入_柠檬云_云会计_科目余额"),
    OA_NMY_YUNKUAIJI_VOUCHER("OA_NMY_YUNKUAIJI_VOUCHER","旧账导入_柠檬云_云会计_凭证"),
    OA_JD_JINGDOUYUN_SUBJECT("OA_JD_JINGDOUYUN_SUBJECT","旧账导入_金蝶_精斗云_科目"),
    OA_JD_JINGDOUYUN_SUBJECTBALANCE("OA_JD_JINGDOUYUN_SUBJECTBALANCE","旧账导入_金蝶_精斗云_科目余额"),
    OA_JD_JINGDOUYUN_VOUCHER("OA_JD_JINGDOUYUN_VOUCHER","旧账导入_金蝶_精斗云_凭证");

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
