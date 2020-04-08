import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HomePage;
import com.hotels.pages.ThreeStarsPage;
import com.hotels.util.Constants;

@Listeners(com.hotels.listeners.TestAllureListener.class)
public class ThreeStarsPageTest {

	Logger log = Logger.getLogger("Test for Three Stars Hotels");
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	ThreeStarsPage threeStarsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);

		homePage = new HomePage(driver);
		threeStarsPage = homePage.selectLocationForThreeStars();
		threeStarsPage = homePage.sendValuesForThreeStars();
		threeStarsPage = new ThreeStarsPage(driver);

	}

	@Test(priority = 1, enabled = false, description = "Page Title Verification for Three Stars Hotels")
	public void verifyTitle() {
		log.info("Page Title Verification for Three Stars Hotels starts");
		String title = threeStarsPage.getTitleThreeStars();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ALL_STARS_TITLE);
		log.info("Page Title Verification for Three Stars HotelsFinishes");

	}

	@Test(priority = 2, enabled = false, description = "Headar Verification for Three Stars Hotels")

	public void getHeader() {
		log.info("Headar Verification for Three Stars Hotels starts");
		String header = threeStarsPage.getHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.ALL_STARS_HEADER,
				"Header Verification for Three Stars Hotels is Incorrect");
		log.info("Headar Verification for Three Stars Hotels Finishes");

	}

	@Test(priority = 3, enabled = true, description = "Collectiong the List for Three Stars Hotels")
	public void threeStarHotelsList() throws InterruptedException {
		log.info("Lets take a break for collecting all list");
		threeStarsPage.selection();
		Thread.sleep(2000);
		threeStarsPage.bottomPage();
		threeStarsPage.HotelNameList();
		log.info("Collectiong the List for Three Stars Hotels Finishes");

	}

	@AfterMethod(enabled = false)
	public void tearDown() {
		driver.quit();

	}

}
