package com.stanley.lus.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanLifeCycleTest {
	
	public static void main(String[] args) {
		 
        System.out.println("现在开始初始化容器");
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("testbean.xml");
        System.out.println("容器初始化成功");    
//        //得到Preson，并使用
//        Person person = factory.getBean("person",Person.class);
//        System.out.println(person);
        
        BeanLife beanlife = (BeanLife) factory.getBean("beanlife"); 
		beanlife.doSomething(); 
		
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
	
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml"); 
		BeanLife beanlife = (BeanLife) context.getBean("beanlife"); 
		beanlife.doSomething(); 
		//销毁bean 
		((ClassPathXmlApplicationContext)context).registerShutdownHook();
	}
	
	public void test1(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); 
		ClassPathResource resource = new ClassPathResource("bean.xml");
		reader.loadBeanDefinitions(resource);
	}
}
