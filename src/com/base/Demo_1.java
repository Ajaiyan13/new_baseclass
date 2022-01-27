package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Demo_1 extends Base_Class {

	public static void main(String[] args) throws Throwable {
		getbrowser("chrome");
		geturl("http://demo.automationtesting.in/Frames.html");
		frame("index", "singleframe", null, null);
		sendkeys(krish.findElement(By.xpath("(//input[@type='text'])[1]")), "ajaykrish");
		frameOut();
		click(krish.findElement(By.xpath("(//a[@class='analystic'])[1]")));
		WebElement outer = krish.findElement(By.xpath("//iframe[@style='float: left;height: 300px;width:600px']"));
		frame("web", null, null, outer);
		WebElement inner = krish.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']"));
		frame("web", null, null, inner);
		sendkeys(krish.findElement(By.xpath("//input[@type='text']")), "krishnan");
		

	}

}
