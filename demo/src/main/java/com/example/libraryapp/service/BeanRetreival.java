package com.example.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class BeanRetreival {
    private final ApplicationContext context;
    @Autowired
    public BeanRetreival(ApplicationContext context)
    {
        this.context=context;
    }
    public<T> T getBean(Class<T> beanClass)
    {
        return context.getBean(beanClass);
    }
}
