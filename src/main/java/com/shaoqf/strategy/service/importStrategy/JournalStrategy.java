package com.shaoqf.strategy.service.importStrategy;

import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("JOURNAL")
public class JournalStrategy implements ImportStrategy {
    @Override
    public String readFile(double amount) {
        return "readFile ".concat(ImportType.JOURNAL.getDesc()).concat(", 支付").concat(String.valueOf(amount)).concat("元");
    }

    @Override
    public String handleData(double amount) {
        return "handleData ".concat(ImportType.JOURNAL.getDesc()).concat(", 支付").concat(String.valueOf(amount)).concat("元");
    }

    @Override
    public String convert(double amount) {
        return "convert ".concat(ImportType.JOURNAL.getDesc()).concat(", 支付").concat(String.valueOf(amount)).concat("元");
    }

    @Override
    public String save(double amount) {
        return "save ".concat(ImportType.JOURNAL.getDesc()).concat(", 支付").concat(String.valueOf(amount)).concat("元");
    }
}
