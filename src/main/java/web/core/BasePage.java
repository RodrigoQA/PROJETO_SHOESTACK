package web.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.core.DriverFactory.getDriver;

public class BasePage {
   private WebDriver driver;

    public void visibilityOfElementLocatedFluentWait(String css){
        FluentWait Wait = new FluentWait(getDriver()).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));


    }
    public void visibilityOfElementLocatedWait(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
    public void esperarElemento(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean elementoEstaVisivel(String byId) {
        FluentWait Wait = new FluentWait(getDriver()).withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(byId)));

        if (Wait != null) {
            return true;
        } else
            return false;
    }

}
