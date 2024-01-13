package com.shaoqf.strategy.service.importStrategy;

import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 凭证导入
 */
@Primary
@Service("VOUCHER")
public class VoucherStrategy implements ImportStrategy {

    @Override
    public String checkFormat(double amount) {
        return ImportType.VOUCHER.getDesc().concat(", 验证数据格式及表头:").concat(String.valueOf(amount));
    }

    @Override
    public String readFile(double amount) {
        return ImportType.VOUCHER.getDesc().concat(", 读取数据:").concat(String.valueOf(amount));
    }

    @Override
    public String handleData(double amount) {
        return ImportType.VOUCHER.getDesc().concat(", 处理数据:").concat(String.valueOf(amount));
    }

    @Override
    public String convert(double amount) {
        return ImportType.VOUCHER.getDesc().concat(", 转换Bean到通用Bean:").concat(String.valueOf(amount));
    }

    @Override
    public String saveDB(double amount) {
        return ImportType.VOUCHER.getDesc().concat(", 保存数据库:").concat(String.valueOf(amount));
    }
}
