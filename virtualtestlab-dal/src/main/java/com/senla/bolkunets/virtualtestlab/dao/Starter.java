package com.senla.bolkunets.virtualtestlab.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("spring-dao-context.xml");


    }
}
