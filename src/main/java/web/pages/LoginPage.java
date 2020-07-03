package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.core.DriverFactory;

import static web.core.DriverFactory.getDriver;

public class LoginPage {
    private WebDriver driver;

    private By btnEntrar = By.xpath("//*[contains(text(),'Entrar')]"); //yaman
    private By getEmail = By.xpath("//*[@id='username'][@name='username']");
    private By getlogin = By.xpath("//*[contains(text(),'Login')]");
    private By getPassword = By.name("password");
    private By acessarConta = By.cssSelector("button#login-button");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fazerLogin() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(btnEntrar).click();
        getDriver().findElement(getlogin).click();
        getDriver().findElement(getEmail).sendKeys("quality.assurance@test.com");
        getDriver().findElement(getPassword).sendKeys("123psw@");
        getDriver().findElement(acessarConta).click();

    }
}
