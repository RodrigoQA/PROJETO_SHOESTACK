package web.pages;

import web.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalProdutoPage extends BasePage {
    private WebDriver driver;


    private By mensagemProdutoAdicionado = By.id("myModalLabel");
    private By getPreco = By.xpath("//*[@id='buy-box']/div[2]/div[2]/div/span/strong");
    private By listaValoresInformados = By.cssSelector("div.divide-right .col-md-6:nth-child(2) span strong");
    private By comprar = By.cssSelector("#buy-button-now.buy-button-now.button-no-float");
    private By corAzul = By.xpath("//*[@class='ns-color ns-color-bg-azul 44']");
    private By corCaramelo = By.xpath("//*[@class='ns-color ns-color-bg-caramelo 44']");

    public ModalProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String validarMensagemProdutoAdicionado() {
        FluentWait Wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
        return driver.findElement(mensagemProdutoAdicionado).getText();
    }

    public String obterPrecoProdutoModal(){
        esperarElemento();
        return driver.findElement(getPreco).getText();


    }
    public void selecionarCor(String cor){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='ns-color ns-color-bg-azul 44']")));
        if (cor == "Azul"){
            driver.findElement(corAzul).click();
        }else if (cor =="Caramelo"){
            driver.findElement(corCaramelo).click();
        }
    }

    public String obterTamanhoProduto(){
        return driver.findElements(listaValoresInformados).get(0).getText();
    }
    public String obterCorProduto(){
        return driver.findElements(listaValoresInformados).get(1).getText();
    }

    public void clickComprar() throws InterruptedException {
       Thread.sleep(2000);
        driver.findElement(comprar).click();

    }

    public void selecionarTamanho(int number) {
        esperarElemento();
        if (number == 37){
            number = 1;
        }else if (number ==38) {
            number = 2;
        }else if(number == 39) {
            number = 3;
        }else if (number == 40) {
            number = 4;
        }else if(number == 41) {
            number = 5;
        }else if (number ==42) {
            number = 6;
        }else if(number == 43) {
            number = 7;
        }
        else if(number == 44) {
        number = 8;
       }
        driver.findElement(By.xpath("//*[@id='buy-box']/section[2]/div/ul/li["+number+"]/a")).click();
}
}
