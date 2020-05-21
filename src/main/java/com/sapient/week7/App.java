package com.sapient.week7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {
        Mobile mobile;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        mobile = (Mobile) context.getBean("mobile");
        mobile.checkMobile();
        mobile.makeMobile();
        mobile.verifyMobile();
    }
}
