package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPage extends BasePage {

    private By eventPhoto = By.className("MuiImageListItem-img");
    private By eventTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/ul/li/div/div/div[1]");
    private By eventDate = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/ul/li/div/div/div[2]");

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromTitle() {
        return getTextFromElement(eventTitle);
    }

    public String getEventDate() {
        return getTextFromElement(eventDate);
    }

    public String getSrcFromImage() {
        return driver.findElement(eventPhoto).getDomAttribute("src");
    }

    public void clickEvent() {
        clickElement(eventPhoto);
    }

}
