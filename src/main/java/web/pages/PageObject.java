package web.pages;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.core.Parametros;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static web.core.DriverFactory.getDriver;

public class PageObject implements Page {
    static String imagem = null;
    private static WebDriver driver;
    private Page page;
    private WebDriverWait waitDriver;
    static ByteArrayInputStream byteArrayInputStream = null;

    public PageObject(Page page) {
    }

    public PageObject() {

    }


    @Override
    public void tearDown() {

    }

    @Override
    public void navigateTo(String url) {

    }



    @Override
    public WebDriverWait getWaitDriver() {
        return null;
    }

    public static void capturaImagem(String nomeImagem) {

        if (Parametros.CAPTURA_TELA.equalsIgnoreCase("ligado")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imagem = nomeImagem + ".png";

            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("allure-results/" + imagem));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(FileUtils.readFileToByteArray(scrFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Allure.addAttachment(nomeImagem, byteArrayInputStream);
        }

    }

    public void visibilityOfElementLocatedFluentWait(String css) {
        FluentWait Wait = new FluentWait(getDriver()).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));


    }

    public void visibilityOfElementLocatedWait(String xpath) {
        WebDriverWait wait = new WebDriverWait((WebDriver) getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public void esperarElemento() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean elementoEstaVisivel(String css) {
        FluentWait Wait = new FluentWait(getDriver()).withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));

        if (Wait != null) {
            return true;
        } else
            return false;
    }

    public void clicarProdutoByNome(String produto) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + produto+ "')]")).click();
    }

    public void setColor(String cor){
        getDriver().findElement(By.xpath("//*[@data-property-name='"+cor+"']")).click();

    }
}