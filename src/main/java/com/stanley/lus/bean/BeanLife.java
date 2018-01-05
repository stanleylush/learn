package com.stanley.lus.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** * @name Bean生命周期 */
public class BeanLife implements BeanNameAware,BeanFactoryAware,
	ApplicationContextAware,InitializingBean,DisposableBean{ 

	private String beanProperty; //私有属性 
	private String beanName; //接收BeanNameAware的beanName传入 
	private BeanFactory beanFactory; //接收BeanFactoryAware的beanFactory传入 
	private ApplicationContext applicationContext; //接收ApplicationContextAware的applicationContext传入 

	/** * 构造函数 */ 
	public BeanLife(String beanProperty){ 
		System.out.println("com.stanley.lus.bean.BeanLife.BeanLife(String beanProperty)："+beanProperty); 
	} 
	/** * bean属性get */ 
	public String getBeanProperty() { 
		return beanProperty; 
	} 
	/** * bean填充属性 */ 
	public void setBeanProperty(String beanProperty) { 
		System.out.println("com.stanley.lus.bean.BeanLife.setBeanProperty(String beanProperty)："+beanProperty); 
		this.beanProperty = beanProperty; 
	} 
	/** * init-method关联方法 */ 
	public void begin(){ 
		System.out.println("init-method:begin"); 
	} 
	/** * destroy-method关联方法 */ 
	public void end(){ 
		System.out.println("destroy-method:end"); 
	} 
	/** * 准备就绪的bean,使用Bean做些事情 */ 
	public void doSomething(){ 
		System.out.println("com.stanley.lus.bean.BeanLife.doSomething()"); 
	} 
	/** 
	 * Spring将BeanFactory容器实例传入 
	 */ 
	public void setBeanFactory(BeanFactory arg0) throws BeansException { 
		this.beanFactory=arg0; 
		System.out.println("org.springframework.beans.factory.BeanFactoryAware.setBeanFactory(BeanFactory)："+this.beanFactory.toString()); 
	} 
	/** * Spring将Bean的ID传入 */ 
	public void setBeanName(String arg0) { 
		this.beanName = arg0; 
		System.out.println("org.springframework.beans.factory.BeanNameAware.setBeanName(String)："+this.beanName); 
	} 
	/** * Spring将应用上下文的引用传入 */ 
	public void setApplicationContext(ApplicationContext arg0) throws BeansException { 
		this.applicationContext = arg0; 
		System.out.println("org.springframework.context.ApplicationContextAware.setApplicationContext(ApplicationContext)："+this.applicationContext.getApplicationName()); 
	} 
	/** * 属性设置完毕后 */ 
	public void afterPropertiesSet() throws Exception { 
		System.out.println("org.springframework.beans.factory.InitializingBean.afterPropertiesSet()"); 
	} 
	/** * Bean销毁 */ 
	public void destroy() throws Exception { 
		System.out.println("org.springframework.beans.factory.DisposableBean.destroy()"); 
	}
}