package org.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedAll implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
		if(retryAnalyzer==null)
		{
			annotation.setRetryAnalyzer(Failed.class);
		}
	}

}
