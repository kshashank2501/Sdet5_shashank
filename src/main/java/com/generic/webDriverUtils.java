package com.generic;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtils {
		
	
	static WebDriver driver;




	public webDriverUtils(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * @author AMAR-G
	 * This method will wait unless and until webpage is loaded or not.
	 * if loaded in given time then control will go to next line 
	 * note:wait for entire webpage
	 */
	public void pageloadtimeout() 
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.MILLISECONDS);
	}
	/**
	 * @author AMAR-G
	 * This method will maximise the window
	 * 	 */

	public void maximisewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @author AMAR-G
	 * This method slecting value from DD
	 * this method will ony work when tagname is select
	 * @param element
	 * @param value
	 */
	public static void selectValuefromDD(WebElement element,String value) 
	{
		Select select = new Select(element);
		select.selectByValue(value);

	}
	/**
	 * @author AMAR-G
	 * This method will select value from DD base4d on INdex Value
	 * @param element
	 * @param index
	 */


	public void selectbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}
	/**
	 * this method is selecting text from DD based on Visible text
	 * @param text
	 * @param element
	 */
	public void selectbyvisibleText(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This methos is going to do mouse hover
	 * @param target
	 */
	public void movetoElement1(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();

	}
	
	/**
	 * This methos is going to do mouse hover
	 * @param target
	 */
	public void movetoElement(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();

	}
	/**
	 * @author AMAR-G
	 * This method will close the browser
	 * @throws InterruptedException 
	 */
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}

	/**
	 * This method is for explicit wait
	 * @param element
	 */
	public static void waitforelement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param index
	 */

	public void switchtoframe(int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoframe(String StringorId) {
		driver.switchTo().frame(StringorId);
	}
	public void switchtoframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void drangAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public static  void switchTowindow(String title) {
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String currentwindow=iterator.next();
			String currenttitle=driver.switchTo().window(currentwindow).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}


	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public static void waitandclick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
}

