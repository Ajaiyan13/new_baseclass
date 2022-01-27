package com.base;

import com.pom.PomClass;

public class PomDemo_1 extends Base_Class {

	public static void main(String[] args) throws Throwable {
		getbrowser("chrome");
		geturl("https://www.google.com/");

		PomClass op = new PomClass(krish);

		sendkeys(op.getSearch(), "amazon");
		click(op.getClick());
		click(op.getAmazon());
		action("move", op.getMouse(), null);
		click(op.getImage());
		sendkeys(op.getText(), "mobile");
		robot("down");
		robot("down");
		robot("down");
		robot("enter");
		action("RIGHT CLICK", null, op.getLink());
		robot("down");
		robot("enter");
		window();
		selectWindow("Amazon.in : mobile stand for table");
		screenShot();

	}

}
