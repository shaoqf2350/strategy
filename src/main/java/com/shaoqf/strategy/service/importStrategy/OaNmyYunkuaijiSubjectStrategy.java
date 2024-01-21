package com.shaoqf.strategy.service.importStrategy;

import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.utils.enums.ImportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 旧账导入_柠檬云_云会计_科目
 */
@Slf4j
@Service("OA_NMY_YUNKUAIJI_SUBJECT")
public class OaNmyYunkuaijiSubjectStrategy implements ImportStrategy {

    @Override
    public String checkFormat(double amount) {
        String str = ImportType.OA_NMY_YUNKUAIJI_SUBJECT.getDesc().concat(", 验证数据格式及表头:").concat(String.valueOf(amount));
        log.info(str);
        return str;
    }

    @Override
    public String readFile(double amount) {
        String str = ImportType.OA_NMY_YUNKUAIJI_SUBJECT.getDesc().concat(", 读取数据:").concat(String.valueOf(amount));
        log.info(str);
        return str;
    }

    @Override
    public String handleData(double amount) {
        String str = ImportType.OA_NMY_YUNKUAIJI_SUBJECT.getDesc().concat(", 处理数据:").concat(String.valueOf(amount));
        log.info(str);
        return str;
    }

    @Override
    public String convert(double amount) {
        String str = ImportType.OA_NMY_YUNKUAIJI_SUBJECT.getDesc().concat(", 转换Bean到通用Bean:").concat(String.valueOf(amount));
        log.info(str);
        return str;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public String saveDB(double amount) {
        String str = ImportType.OA_NMY_YUNKUAIJI_SUBJECT.getDesc().concat(", 保存数据库:").concat(String.valueOf(amount));
        log.info(str);
        return str;
    }
}
