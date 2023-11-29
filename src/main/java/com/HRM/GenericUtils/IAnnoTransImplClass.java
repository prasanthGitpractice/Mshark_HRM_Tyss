package com.HRM.GenericUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;


public class IAnnoTransImplClass implements IAnnotationTransformer
{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) 
	{

		annotation.setRetryAnalyzer(com.HRM.GenericUtils.RetryImplClass.class);

	}

}
