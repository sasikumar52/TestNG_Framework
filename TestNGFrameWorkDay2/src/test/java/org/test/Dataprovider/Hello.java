package org.test.Dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//TestNg Data Provider in same class
public class Hello {

	@Test(dataProvider = "userData")
	private void login(String x, String y, String z) {

		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
	@DataProvider(name = "userData")
	public Object[][] datas()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="sasi@gmail.com";
		obj[0][1]="sasi@123";
		obj[0][2]="JavaSelenium";
		
		obj[1][0]="arim@gmail.com";
		obj[1][1]="arim@123";
		obj[1][2]="React JS";
		return obj;	
	}
}
