package com.shaoqf.strategy.utils.enums;
public enum ImportType {
    VOUCHER("VOUCHER","凭证导出"),
    JOURNAL("JOURNAL","日记账导出"),
    INVOICE("INVOICE","发票导出");

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
        return ImportType.JOURNAL; // 默认
    }
}
