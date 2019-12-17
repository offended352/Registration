package SignUp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class SignUpRozetka extends WebDriverSettings {

    @Test
    public void signUp() {

        SignUpField signUpField = PageFactory.initElements(driver, SignUpField.class);
        signUpField.open();
        signUpField.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.openSignUpForm();

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String email = "dmytronarvaniy" + n + "@gmail.com";

        signUpPage.fillUserName("Дмитрий");
        signUpPage.fillEmail(email);
        signUpPage.fillPassword("QweQwe123123");

        signUpPage.submitSignUp();
        signUpPage.checkSignUpSuccess();

    }

    @Test
    public void signUpFailure() {

        SignUpField signUpField = PageFactory.initElements(driver, SignUpField.class);
        signUpField.open();
        signUpField.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.openSignUpForm();
        signUpPage.checkErrorsFields();

        String userNameError = signUpPage.getErrorUserName();
        Assert.assertEquals(userNameError, "Введите свое имя на кириллице");

        String emailError = signUpPage.getErrorEmail();
        Assert.assertEquals(emailError, "Введите свою эл. почту");

        String passwordError = null;
        Assert.assertEquals(passwordError, null);

    }
}
