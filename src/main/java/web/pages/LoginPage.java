package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(btnEntrar).click();
        driver.findElement(getlogin).click();
        driver.findElement(getEmail).sendKeys("quality.assurance@test.com");
        driver.findElement(getPassword).sendKeys("123psw@");
        driver.findElement(acessarConta).click();

    }
}
