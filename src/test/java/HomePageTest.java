import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HomePage;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("some problems before method");
			e.printStackTrace();
		}

	}

	@Test(priority = 1, enabled = true, description = "Selecting Values")
	public void HomePage() throws InterruptedException {
		homePage.selectLocationForThreeStars();
		homePage.sendValuesForThreeStars();

	}
	
	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit();
}

}