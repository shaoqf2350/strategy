package com.shaoqf.strategy.service.base;

import com.alibaba.fastjson.JSONArray;
import com.shaoqf.strategy.bean.base.BaseImportBean;
import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.base.SpringContext;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseImportService {

    private static final int MSGSIZE = 4; // 最大步骤数

    @Transactional(rollbackFor=Exception.class)
    public String importExcel(ImportType type, double amount){
        Optional<ImportType> typeOpt = Optional.ofNullable(type);

        if (typeOpt.isPresent()) {
            List<BaseImportBean> arrBib = new ArrayList<>(MSGSIZE);

            ImportService sv = SpringContext.getBean(ImportService.class); // 从应用上下文中获取PayService对象

            ImportStrategy strategy = (ImportStrategy) SpringContext.getImportBean(type); // 从应用上下文中根据枚举获取对应策略对象

            sv.setStrategy(strategy); // 切换到对应的策略对象

            try {
                //调用对应的服务方法，执行策略对象的算法
                String res0 = sv.checkFormat(amount);//校验格式
                String res1 = sv.readFile(amount);//读取excel数据
                String res2 = sv.handleData(amount);//数据处理逻辑
                String res3 = sv.convert(amount);//对象封装成统一对象
                String res4 = sv.saveDB(amount);//数据库操作

                BaseImportBean bib0 = new BaseImportBean("checkFormat", res0);
                BaseImportBean bib1 = new BaseImportBean("readFile", res1);
                BaseImportBean bib2 = new BaseImportBean("handleData", res2);
                BaseImportBean bib3 = new BaseImportBean("convert", res3);
                BaseImportBean bib4 = new BaseImportBean("save", res4);

                arrBib.add(bib0);
                arrBib.add(bib1);
                arrBib.add(bib2);
                arrBib.add(bib3);
                arrBib.add(bib4);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return JSONArray.toJSONString(arrBib);
        }

        return "ImportType is Null!";
    }

}
