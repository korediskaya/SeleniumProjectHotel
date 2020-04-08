import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.FourStarsPage;
import com.hotels.pages.HomePage;
import com.hotels.util.Constants;

@Listeners(com.hotels.listeners.TestAllureListener.class)
public class FourStarsPageTest {

	Logger log = Logger.getLogger("Test for Four Stars Hotels");
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	FourStarsPage fourStarsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		fourStarsPage = homePage.selectLocationforFourStars();
		fourStarsPage = homePage.sendValuesforFourStars();
		fourStarsPage = new FourStarsPage(driver);

	}

	@Test(priority = 1, enabled = true, description = "Page Title Verification for Four Stars Hotels")
	public void verifyTitle() {
		log.info("Page Title Verification for Four Stars Hotels starts");
		String title = fourStarsPage.getTitleThreeStars();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ALL_STARS_TITLE);
		log.info("Page Title Verification for Four Stars HotelsFinishes");

	}

	@Test(priority = 2, enabled = true, description = "Headar Verification for Four Stars Hotels")

	public void getHeader() {
		log.info("Headar Verification for Four Stars Hotels starts");
		String header = fourStarsPage.getHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.ALL_STARS_HEADER,
				"Header Verification for Four Stars Hotels is Incorrect");
		log.info("Headar Verification for Four Stars Hotels Finishes");

	}

	@Test(priority = 3, enabled = true, description = "Collectiong the List for Four Stars Hotels")
	public void fourStarHotelsList() throws InterruptedException {
		log.info("Lets take a break for collecting all list");
		fourStarsPage.selection();
		Thread.sleep(2000);
		fourStarsPage.bottomPage();
		fourStarsPage.HotelNameList();
		log.info("Collectiong the List for Four Stars Hotels Finishes");

	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit();

	}

}
