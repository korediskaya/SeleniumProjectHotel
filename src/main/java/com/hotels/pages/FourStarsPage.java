package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hotels.util.Constants;
import com.hotels.util.ElementUtil;

public class FourStarsPage {
	WebDriver driver;
	ElementUtil elementUtil;

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	// span[text()='3-star']
	// By HotelTitle = By.xpath("//h3[@class='p-name']");

	By FourStar = By.xpath("//input[@id='f-star-rating-4']");
	By Distance = By.xpath("//a[text()='Distance']");
	By CityCenter = By.xpath("//a[text()='City center']");
	By HotelTitle = By.xpath("//div[@class='description resp-module']");
	By HotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(),'City center')]");
	By Header = By.xpath("//h1[@class='destination-title']");
	String HotelName = "Hilton";
	Double requestedMile = 10.0;

	public FourStarsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getTitleThreeStars() {
		return elementUtil.waitForGetPageTitle(Constants.ALL_STARS_TITLE);
	}

	public String getHeader() {
		return elementUtil.doGetText(Header);
	}

	public void selection() {
		elementUtil.doClick(Distance);
		elementUtil.doClick(CityCenter);
		elementUtil.doClick(FourStar);

	}

	public void bottomPage() throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60) {
				break;
			}
			// y value '1000' can be altered
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(3000);
		}

	}

	// Main Method

	public void HotelNameList() {

		List<WebElement> hotelsList = driver.findElements(HotelTitle);
		List<WebElement> hotelMiles = driver.findElements(HotelMiles);

		for (int i = 0; i < hotelMiles.size(); i++) {
			String text = hotelMiles.get(i).getText();

			String hotelMiles1 = text.replaceAll("[a-zA-Z ]", "");
			String hotelsListAll = hotelsList.get(i).getText();

			double x = Double.parseDouble(hotelMiles1);

			if (x < requestedMile && hotelsListAll.contains(HotelName)) {

				for (int j = 0; j < hotelsList.size(); j++) {
					System.out.println(hotelsListAll);
					break;
				}

			}

		}
	}

}