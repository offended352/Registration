package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpField {
    private WebDriver driver;
    private WebDriverWait wait;


    public SignUpField(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("http://rozetka.com.ua");
    }

    @FindBy(xpath = "//a[@class='header-topline__user-link link-dashed']")
    private WebElement linkDashed;

    By registerLink = By.xpath("//a[@class='auth-modal__register-link']");

    public void getStarted() {
        linkDashed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerLink));

    }
}
