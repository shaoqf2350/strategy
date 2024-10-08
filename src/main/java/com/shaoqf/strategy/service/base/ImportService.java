package com.shaoqf.strategy.service.base;

import com.alibaba.fastjson.JSONArray;
import com.shaoqf.strategy.base.BaseImportBean;
import com.shaoqf.strategy.base.ImportStrategy;
import com.shaoqf.strategy.base.SpringContext;
import com.shaoqf.strategy.utils.enums.ImportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ImportService {

    private static final Byte MAXSIZE = 5; // 最大步骤数-128到127之间

    public String importExcel(ImportType type, double amount){
        Optional<ImportType> typeOpt = Optional.ofNullable(type);

        if (typeOpt.isPresent()) {
            List<BaseImportBean> arrBib = new ArrayList<>(MAXSIZE);

            BaseImportService sv = SpringContext.getBean(BaseImportService.class); // 从应用上下文中获取BaseImportService对象

            ImportStrategy strategy = (ImportStrategy) SpringContext.getImportBean(type); // 从应用上下文中根据枚举获取具体策略对象

            sv.setStrategy(strategy); // 设置具体的策略对象之后,BaseImportService服务就可以执行对应策略里的方法

            try {
                //调用对应的服务方法，执行策略对象的算法
                String res0 = sv.readFile(amount);//读取excel数据
                String res1 = sv.checkFormat(amount);//校验文件格式及表头
                String res2 = sv.handleData(amount);//数据处理逻辑
                String res3 = sv.convert(amount);//对象封装成统一对象
                String res4 = sv.saveBathToDB(amount);//入库操作
//                String res5 = sv.after(amount);//事后操作

                arrBib.add(new BaseImportBean("checkFormat", res0));
                arrBib.add(new BaseImportBean("readFile", res1));
                arrBib.add(new BaseImportBean("handleData", res2));
                arrBib.add(new BaseImportBean("convert", res3));
                arrBib.add(new BaseImportBean("save", res4));

                arrBib.forEach(bib -> log.info(bib.getName().concat(": ").concat(bib.getMsg())));

            } catch (Exception ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
            }

            return JSONArray.toJSONString(arrBib);
        }

        return "";
    }

}
