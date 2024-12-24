package org.test.Dataprovider;

import org.testng.annotations.DataProvider;

//TestNg data provider integration in selenium
public class Hello2 {
	
	@DataProvider(name = "userData")
	public Object[][] datas()
	{
		Object[][] obj=new Object[][] {{"sasi@gmail.com","Sasi@123"},{"arima@gmail.com","arima@123"},{"Saravanan@gmail.com","saro@123"},
			{"raja@gmail.com","raja@123"}};
		return obj;
	}

}
