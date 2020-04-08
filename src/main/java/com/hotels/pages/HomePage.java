package com.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.hotels.basepage.BasePage;
import com.hotels.util.Constants;
import com.hotels.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// td[@data-date='2020-3-15']
	// td[@data-date='2020-3-28']
	By CityName = By.xpath("//input[@id='qf-0q-destination']");
	By CheckIn = By.xpath("	//input[@id='qf-0q-localised-check-in']");
	By CheckOut = By.xpath("//input[@id='qf-0q-localised-check-out']");
	By Rooms = By.xpath("//select[@id='qf-0q-rooms']");
	By Adults = By.xpath("//select[@id='qf-0q-room-0-adults']");
	By Children = By.xpath("//select[@id='qf-0q-room-0-children']");
	By Child1 = By.xpath("//select[@id='qf-0q-room-0-child-0-age']");
	By Child2 = By.xpath("//select[@id='qf-0q-room-0-child-1-age']");
	By Search = By.xpath("//button[@class='cta cta-strong']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_HEADER);
	}

	public ThreeStarsPage selectLocationForThreeStars() {
		driver.findElement(CityName).sendKeys("Cinc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(CityName).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(CityName).sendKeys(Keys.ENTER);
		return new ThreeStarsPage(driver);

	}

	public ThreeStarsPage sendValuesForThreeStars() {

		elementUtil.doSendKeys(CheckIn, "4/27/2020");
		elementUtil.doSendKeys(CheckOut, "4/30/2020");
		elementUtil.selectValue(driver, Adults, "1");
		elementUtil.selectValue(driver, Adults, "2");
		elementUtil.selectValue(driver, Children, "2");
		elementUtil.selectValue(driver, Child1, "4");
		elementUtil.selectValue(driver, Child2, "14");
		elementUtil.doClick(Search);

		return new ThreeStarsPage(driver);

	}

	public FourStarsPage selectLocationforFourStars() {
		driver.findElement(CityName).sendKeys("Cinc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(CityName).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(CityName).sendKeys(Keys.ENTER);
		return new FourStarsPage(driver);

	}

	public FourStarsPage sendValuesforFourStars() {

		elementUtil.doSendKeys(CheckIn, "4/27/2020");
		elementUtil.doSendKeys(CheckOut, "4/30/2020");
		elementUtil.selectValue(driver, Rooms, "1");
		elementUtil.selectValue(driver, Adults, "2");
		elementUtil.selectValue(driver, Children, "2");
		elementUtil.selectValue(driver, Child1, "4");
		elementUtil.selectValue(driver, Child2, "14");
		elementUtil.doClick(Search);

		return new FourStarsPage(driver);

	}
}
