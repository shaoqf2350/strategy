package com.shaoqf.strategy.base;

import com.shaoqf.strategy.utils.enums.ImportType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext applicationcontext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringContext.applicationcontext == null) {
            SpringContext.applicationcontext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationcontext() {
        return applicationcontext;
    }

    public static Object getImportBean(ImportType pt){
        return getApplicationcontext().getBean(pt.getType());
    }

    public static <T>T getBean(Class<T>clazz) {
        return getApplicationcontext().getBean(clazz);
    }
}