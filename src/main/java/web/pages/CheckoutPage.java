package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static web.core.DriverFactory.getDriver;
import static web.core.DriverFactory.killDriver;

public class CheckoutPage extends PageObject {
    private static WebDriver driver;
    private WebDriverWait waitDriver;

    private By getDescricao = By.cssSelector(".short-description h1");
    private By getPreco = By.xpath("//*[@id='buy-box']/div[2]/div[2]/div/span/strong");
    private By getCorSelecionada = By.cssSelector(".sku-select-title");
    private By getTamanhoSelecionado = By.cssSelector("#buy-box > section.product-size-selector > div > ul li.active");
    private By comprar = By.cssSelector("#buy-button-now.buy-button-now.button-no-float");
    private By tamanhoUnico = By.xpath("(//a[contains(@data-label,'Único')])[1]");
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

    public void selecionarCor(String cor) {
        visibilityOfElementLocatedFluentWait(".tcell");
        setColor(cor);
    }

    public String corSelecionada() {
        return getDriver().findElement(getCorSelecionada).getText();
    }

    public String tamanhoSelecionado() {
        String tam = getDriver().findElement(getTamanhoSelecionado).getText();
        System.out.println("Tamanho: "+tam);
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

    public void selecionarTamanho(String tamanho) throws Exception {
        esperarElemento();
        WebElement disponivel = getDriver().findElement(By.xpath("(//a[contains(@data-size,'size-" + tamanho + "')])[1]"));
        if (tamanho.equals("Único")){
            getDriver().findElement(tamanhoUnico).click();
        } else if (disponivel.getAttribute("qa-option").equals("unavailable")) {
            throw new Exception("Desculpe, mas esse numero não esta disponivel");

        } else {
            disponivel.click();
        }

    }

}