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
        return ImportType.JOURNAL.getDesc().concat(", 读取数据:").concat(String.valueOf(amount));
    }

    @Override
    public String handleData(double amount) {
        return ImportType.JOURNAL.getDesc().concat(", 处理数据:").concat(String.valueOf(amount));
    }

    @Override
    public String convert(double amount) {
        return ImportType.JOURNAL.getDesc().concat(", 转换Bean到通用Bean:").concat(String.valueOf(amount));
    }

    @Override
    public String save(double amount) {
        return ImportType.JOURNAL.getDesc().concat(", 保存数据库:").concat(String.valueOf(amount));
    }
}
