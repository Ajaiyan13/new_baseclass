package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass {
	public static WebDriver krish;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement search;

	@FindBy(xpath = "//input[@name='btnK']")
	private WebElement click;

	@FindBy(xpath = "//h3[text()='Amazon.in']")
	private WebElement amazon;

	@FindBy(id = "nav-link-prime")
	private WebElement mouse;

	@FindBy(xpath = "//div[@class='student-nav-content-img']")
	private WebElement image;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement text;
	
	@FindBy(xpath = "//a[text()='Mobiles']")
	private WebElement link;

	public WebElement getLink() {
		return link;
	}

	public WebElement getText() {
		return text;
	}

	public WebElement getImage() {
		return image;
	}

	public static WebDriver getKrish() {
		return krish;
	}

	public WebElement getMouse() {
		return mouse;
	}

	public WebElement getAmazon() {
		return amazon;
	}

	public PomClass(WebDriver krish2) {
		this.krish = krish2;
		PageFactory.initElements(krish2, this);
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getClick() {
		return click;
	}

}
