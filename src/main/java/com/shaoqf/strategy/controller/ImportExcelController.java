package com.shaoqf.strategy.controller;

import com.shaoqf.strategy.demos.web.BasicController;
import com.shaoqf.strategy.service.base.BaseImportService;
import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/import")
public class ImportExcelController extends BasicController {

    @Resource
    BaseImportService baseImportService;

    // 导入文件
    @PostMapping("/files")
    public String importFiles(@RequestParam("type") ImportType type, @RequestParam("amount") double amount) {
        if (null == type) {
            return "ImportType is Null!";
        } else {
            return baseImportService.importExcel(type, amount);
        }
    }
}
