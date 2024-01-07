package com.shaoqf.strategy.base;

import com.shaoqf.strategy.service.base.ImportService;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseImportService {

    @Transactional(rollbackFor=Exception.class)
    public String importExcel(ImportType type, double amount){
        ImportService sv = SpringContext.getBean(ImportService.class); // 从应用上下文中获取PayService对象

        ImportStrategy strategy = (ImportStrategy) SpringContext.getImportBean(type); // 从应用上下文中根据枚举获取对应策略对象

        sv.setStrategy(strategy); // 切换到对应的策略对象

        try {
            String res1 = sv.readFile(amount);//调用对应的服务方法，执行策略对象的算法
            String res2 = sv.handleData(amount);
            String res3 = sv.convert(amount);
            String res4 = sv.save(amount);

            System.out.println(res1);
            System.out.println(res2);
            System.out.println(res3);
            System.out.println(res4);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "";
    }

}
