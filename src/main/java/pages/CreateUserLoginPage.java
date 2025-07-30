package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateUserLoginPage extends BasePage {

    private By formTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By changeStateButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");
    private By errorMessage2 = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private By errorMessage3 = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[2]");

    public CreateUserLoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromTitle() {
        return getTextFromElement(formTitle);
    }

    public void insertEmail(String email) {
        insertText(emailField, email);
    }

    public void insertPassword(String password) {
        insertText(passwordField, password);
    }

    public void clickGoButton() {
        clickElement(goButton);
    }

    public void clickChangeStateButton() {
        clickElement(changeStateButton);
    }

    //error message
    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }

    public String getErrorMessage2() {
        return getTextFromElement(errorMessage2);
    }

    public String getErrorMessage3() {
        return getTextFromElement(errorMessage3);
    }

    public CreateUserLoginPage clearEmailField() {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        return this;
    }

    public CreateUserLoginPage clearPasswordField() {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        return this;
    }
}
