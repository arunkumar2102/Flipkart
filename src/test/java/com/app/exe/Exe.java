package com.app.exe;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.app.pageexe.LoginPageExe;

public class Exe extends LoginPageExe
{
	@Test
	public void Exe() throws InterruptedException
	{
		close();
		fashion();
		watAndAcc();
		menAndWomen();
		men();
		Thread.sleep(2000);
		watches();
		selectWatchModel(casio);
		
	}
}
