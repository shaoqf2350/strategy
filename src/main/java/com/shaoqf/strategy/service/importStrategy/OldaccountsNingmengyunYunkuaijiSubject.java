package com.shaoqf.strategy.service.importStrategy;

import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT")
public class OldaccountsNingmengyunYunkuaijiSubject implements ImportStrategy {

    @Override
    public String checkFormat(double amount) {
        return ImportType.OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT.getDesc().concat(", 验证数据格式及表头:").concat(String.valueOf(amount));
    }

    @Override
    public String readFile(double amount) {
        return ImportType.OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT.getDesc().concat(", 读取数据:").concat(String.valueOf(amount));
    }

    @Override
    public String handleData(double amount) {
        return ImportType.OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT.getDesc().concat(", 处理数据:").concat(String.valueOf(amount));
    }

    @Override
    public String convert(double amount) {
        return ImportType.OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT.getDesc().concat(", 转换Bean到通用Bean:").concat(String.valueOf(amount));
    }

    @Override
    public String saveDB(double amount) {
        return ImportType.OLDACCOUNTS_NINGMENGYUN_YUNKUAIJI_SUBJECT.getDesc().concat(", 保存数据库:").concat(String.valueOf(amount));
    }
}
