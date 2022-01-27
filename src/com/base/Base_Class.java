package com.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver krish;

//BROWSER METHOD
	@SuppressWarnings("deprecation")
	public static WebDriver getbrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + ("\\driver\\chromedriver.exe"));
				krish = new ChromeDriver();

			} else if (browsername.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + ("driver\\msedgedriver.exe"));
				krish = new EdgeDriver();

			} else {
				System.out.println("invalid browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		krish.manage().window().maximize();
		krish.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return krish;

	}

	// GET URL
	public static void geturl(String value) {
		try {
			krish.get(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SEND KEYS
	public static void sendkeys(WebElement element, CharSequence value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CLICK
	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// DROP DOWN
	public static void dropdown(String ae, WebElement value, String get) {
		try {
			if (ae.equalsIgnoreCase("value")) {
				Select d1 = new Select(value);
				d1.selectByValue(get);
			} else if (ae.equalsIgnoreCase("text")) {
				Select d1 = new Select(value);
				d1.selectByVisibleText(get);

			} else {
				System.out.println("invalid dropbox");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

// ROBOT
	public static void robot(String press) throws Throwable {
		Robot er = new Robot();
		try {
			if (press.equalsIgnoreCase("down")) {
				er.keyPress(KeyEvent.VK_DOWN);

				er.keyRelease(KeyEvent.VK_DOWN);

			} else if (press.equalsIgnoreCase("enter")) {
				er.keyPress(KeyEvent.VK_ENTER);
			} else {
				System.out.println("Invalid Robot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ACTION
	public static void action(String mouse, WebElement value, WebElement element) {
		Actions io = new Actions(krish);
		try {
			if (mouse.equalsIgnoreCase("move")) {
				io.moveToElement(value).perform();

			} else if (mouse.equalsIgnoreCase("right click")) {
				io.contextClick(element).perform();
			} else {
				System.out.println("Invalid Action");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// BACK
	public static void back() {
		try {
			krish.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// JAVA SCRIPT
	public static void javaScript(String text, WebElement element, String click) {
		JavascriptExecutor po = (JavascriptExecutor) krish;
		try {
			if (text.equalsIgnoreCase("textbox")) {
				po.executeScript("arguments[0].setAttribute('value','')", element);

			} else if (text.equalsIgnoreCase("textbox1")) {
				po.executeScript("arguments[0].setAttribute('value','')", element);
			} else if (click.equalsIgnoreCase("click")) {
				po.executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Invalid Script");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// scrollUP
	public static void scrollUp(String up, WebElement element) {
		JavascriptExecutor tr = (JavascriptExecutor) krish;
		try {
			if (up.equalsIgnoreCase("scrollUp")) {
				tr.executeScript("arguments[0].scrollIntoView();", element);

			} else {
				System.out.println("INVALID DATA");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SCROLLDOWN
	public static void scrollDown(String down, WebElement element) {
		JavascriptExecutor yu = (JavascriptExecutor) krish;
		try {
			if (down.equalsIgnoreCase("scrollDown")) {
				yu.executeScript("arguments[0].scrollIntoView();", element);

			} else {
				System.out.println("INVALID DATA");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// FORWARD

	public static void forward() {
		try {
			krish.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// REFRESH

	public static void refresh() {
		try {
			krish.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// NAVIGATE TO

	public static void navigate(String url) {
		try {
			krish.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// close
	public static void close() {
		try {
			krish.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Quit
	public static void quit() {
		try {
			krish.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// windowsHandle

	public static void window() {
		try {
			String handle = krish.getWindowHandle();
			System.out.println(handle);
			String title = krish.switchTo().window(handle).getTitle();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*********get titles************");
	}

	// WINDOW HANDLES
	public static void windows() {
		Set<String> handles = krish.getWindowHandles();
		try {
			for (String data : handles) {
				System.out.println(handles);
				String title = krish.switchTo().window(data).getTitle();
				System.out.println(title);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SELECTED WINDOW

	public static void selectWindow(String value) {
		Set<String> handles = krish.getWindowHandles();
		for (String data : handles) {
			String title2 = krish.switchTo().window(data).getTitle();
			System.out.println(handles);

		}
		for (String data : handles) {
			if (krish.switchTo().window(data).getTitle().equals(value)) {
				break;

			}

		}

	}

	// FRAMES
	public static void frame(String index, String value, String name, WebElement outer) {
		try {
			if (index.equalsIgnoreCase("index")) {
				krish.switchTo().frame(value);

			} else if (index.equalsIgnoreCase("string")) {
				krish.switchTo().frame(name);

			} else if (index.equalsIgnoreCase("web")) {
				krish.switchTo().frame(outer);

			} else if (index.equalsIgnoreCase("parent")) {
				krish.switchTo().parentFrame();

			} else {
				System.out.println("INVALID FRAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// FRAME OUT
	public static void frameOut() {
		try {
			krish.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SCREENSHOT
	public static void screenShot() throws Throwable {
		TakesScreenshot sq = (TakesScreenshot) krish;
		try {
			File re = sq.getScreenshotAs(OutputType.FILE);
			File rt = new File("C:\\Users\\ajayk\\eclipse-workspace\\BaseClass\\screenshot\\test.png");
			FileUtils.copyFile(re, rt);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
