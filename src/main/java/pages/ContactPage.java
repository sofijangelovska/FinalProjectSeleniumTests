package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div[1]/h2");
    private By addressName = By.cssSelector("div.MuiBox-root.css-0 > p:nth-of-type(1)");
    private By email = By.xpath("//p[contains(text(), 'ev@')]");
    private By phoneNumber = By.cssSelector("div.MuiBox-root.css-0 > p:nth-of-type(3)");

    public String getTextFromPageTitle() {
        return getTextFromElement(pageTitle);
    }

    public String getTextFromAddress() {
        return getTextFromElement(addressName);
    }

    public String getTextFromEmail() {
        return getTextFromElement(email);
    }

    public String getTextPhoneNumber() {
        return getTextFromElement(phoneNumber);
    }
}
