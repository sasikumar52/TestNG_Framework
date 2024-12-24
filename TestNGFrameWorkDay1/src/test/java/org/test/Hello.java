package org.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hello {
	
	@Parameters({"userName","passWord"})
	@Test
	private void login(String x,String y) {
		System.out.println(x);
		System.out.println(y);

	}


}
