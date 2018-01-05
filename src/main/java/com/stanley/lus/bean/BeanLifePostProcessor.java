package com.stanley.lus.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/** 
 * @name BeanPostProcessor实现 进行监控Spring容器Bean实例化注入时的回调方法定制
 */
public class BeanLifePostProcessor implements BeanPostProcessor{ 
	/** 
	* 实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务 
	* @param bean Bean对象 
	* @param beanName Bean的ID 
	*/ 
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException { 
		System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessBeforeInitialization(Object, String)："+beanName); 
		return bean; 
	} 
	/** 
	* 实例化、依赖注入、初始化完毕时执行 
	* @param bean Bean对象 
	* @param beanName Bean的ID 
	*/ 
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException { 
		System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessAfterInitialization(Object, String)："+beanName); 
		return bean; 
	} 
}
