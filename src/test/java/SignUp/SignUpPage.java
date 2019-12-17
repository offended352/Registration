package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[@class='auth-modal__register-link']")
    private WebElement registerLink;

    @FindBy(xpath = "//fieldset[@class='form__row js-name']//input[@type='text']")
    private WebElement userName;

    @FindBy(xpath = "//fieldset[@class='form__row js-contact']//input[@type='text']")
    private WebElement emailName;

    @FindBy(xpath = "//div[@class='form__row_with_button']//input[@type='password']")
    private WebElement passwordName;

    @FindBy(xpath = "//div[@class='form__row auth-modal__form-bottom']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='validation-message'][contains(text(),'Введите свое имя на кириллице')]")
    private WebElement userNameError;

    @FindBy(xpath = "//p[@class='validation-message'][contains(text(),'Введите свою эл. почту')]")
    private WebElement emailError;

    By submitLocator = By.xpath("//div[@class='form__row auth-modal__form-bottom']//button[@type='submit']");
    By emailVerification = By.className("email-verification__top");
    By validationMessage = By.xpath("//form-error[@class='validation-message']");

    public void openSignUpForm() {
        registerLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitLocator));
    }

    public void fillUserName(String nameUser) {
        userName.sendKeys(nameUser);
    }

    public void fillEmail(String nameEmail) {
        emailName.sendKeys(nameEmail);
    }

    public void fillPassword(String namePassword) {
        passwordName.sendKeys(namePassword);
    }

    public void submitSignUp() {
        submitButton.click();
    }

    public void checkSignUpSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailVerification));
    }

    //Errors

    public void checkErrorsFields() {
        driver.findElement(By.xpath("//label[contains(text(),'Ваше имя')]//following-sibling::input")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Эл. почта')]//following-sibling::input")).click();
        driver.findElement(By.xpath("//input[@type='password']")).click();
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(validationMessage));
    }

    public String getErrorUserName() {
        return userNameError.getText();
    }

    public String getErrorEmail() {
        return emailError.getText();
    }
}
