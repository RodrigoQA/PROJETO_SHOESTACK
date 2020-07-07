package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

import static web.core.DriverFactory.getDriver;
import static web.core.DriverFactory.killDriver;

public class CheckoutPage extends PageObject {
    static String imagem = null;
    private static WebDriver driver;
    private WebDriverWait waitDriver;
    static ByteArrayInputStream byteArrayInputStream = null;


    private By getDescricao = By.cssSelector(".short-description h1");
    private By getPreco = By.xpath("//*[@id='buy-box']/div[2]/div[2]/div/span/strong");
    private By getCorSelecionada = By.cssSelector(".sku-select-title");
    private By getTamanhoSelecionado = By.cssSelector("#buy-box > section.product-size-selector > div > ul li.active");
    private By comprar = By.cssSelector("#buy-button-now.buy-button-now.button-no-float");
    private By indisponivel = By.cssSelector("#action-buttons .title");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String descricaoPruoduto() {
        return getDriver().findElement(getDescricao).getText();
    }

    public String precoProduto() {
        esperarElemento();
        return getDriver().findElement(getPreco).getText();
    }

    public void selecionarCor(String color) {
        visibilityOfElementLocatedFluentWait(".tcell");
        if (color.contains("Azul")) {
            setColor("Azul");
        } else if (color.contains("Caramelo")) {
            setColor("Caramelo");
        } else if (color.contains("Preto")) {
            setColor("Preto");
        } else if (color.contains("Café")) {
            setColor("Café");
        } else if (color.contains("Branco")) {
            setColor("Branco");
        }
    }

    public String corSelecionada() {
        return getDriver().findElement(getCorSelecionada).getText();
    }

    public String tamanhoSelecionado() {
        String tam = getDriver().findElement(getTamanhoSelecionado).getText();
        System.out.println(tam);
        return tam;
    }


    public CarrinhoPage clickComprar() {

        esperarElemento();
        try {
            if (!elementoEstaVisivel("#buy-button-now.buy-button-now.button-no-float")) ;
            getDriver().findElement(comprar).click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage() + "desculpe mas nao temos mais esse tamanho");
            killDriver();

        }
        return new CarrinhoPage();
    }

    public void selecionarTamanho(int number) {
        esperarElemento();
        WebElement disponivel = getDriver().findElement(By.xpath("(//a[contains(@data-size,'size-" + number + "')])[1]"));
        if (disponivel.getAttribute("qa-option").equals("unavailable")) {
            System.out.println("Desculpe, mas esse numero não esta disponivel");
            killDriver();
        } else {
            disponivel.click();
        }


    }

}