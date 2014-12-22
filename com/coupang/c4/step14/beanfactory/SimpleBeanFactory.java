package com.coupang.c4.step14.beanfactory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.coupang.c4.step14.ResourceUtil;

public class SimpleBeanFactory{
	private String propertyPath;
	private Properties pro = new Properties();
	private Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

	public SimpleBeanFactory(String propertyPath) {
		this.propertyPath = propertyPath;
	}

	public <T> Object getInstance(Class<T> type) {

		Constructor<T> constructor = null;
		try {
			constructor = type.getDeclaredConstructor();
			constructor.setAccessible(true);
			
			if (map.containsKey(type) == true) {
				return map.get(type);
			}
			else{
				map.put(type, constructor.newInstance());
			}

			return map.get(type);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Object getInstance(String beanName) {

		try {
			pro.load(ResourceUtil.resourceAsInputStream(propertyPath));

			return getInstance(Class.forName(pro.getProperty(beanName)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}