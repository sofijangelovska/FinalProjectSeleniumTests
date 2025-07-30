package evprimefrontendtests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ContactPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;

public class ContactPageTests {

    WebDriver driver;
    ContactPage contactPage;
    SidePanel sidePanel;
    private ChromeOptions options;

    @Before

    public void setUp() {
        //remove banner
        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        sidePanel = new SidePanel(driver);
        contactPage = new ContactPage(driver);
        contactPage.navigateTo("http://localhost:3000/");

    }

    @Test

    public void validateContactPage() throws InterruptedException {

        sidePanel.clickMenuIcon();
        Thread.sleep(5000);
        sidePanel.clickContactButton();
        Thread.sleep(5000);
        assertEquals("Want to reach out?", contactPage.getTextFromPageTitle());
        assertEquals("Rampo Lefkata 1", contactPage.getTextFromAddress());
        Thread.sleep(5000);
        assertEquals("ev@rampo.com", contactPage.getTextFromEmail());
        assertEquals("+389 75 500 000", contactPage.getTextPhoneNumber());
    }
}