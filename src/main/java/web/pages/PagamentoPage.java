package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static web.core.DriverFactory.getDriver;

public class PagamentoPage extends PageObject {
    private WebDriver driver;


    private By descriscaoProduto = By.cssSelector("div.product-info .product-name.name");
    private By valorProduto = By.cssSelector("#bankslip-price");
    private By tamanhoProduto = By.xpath("(//li[contains(.,'Tamanho: ')])[2]");
    private By cor = By.xpath("(//li[contains(.,'Cor: ')])[2]");
    private By qts = By.cssSelector(".ns-w1.product-qtd']");
    private By numberCartao = By.id("creditcard-number");
    private By titularCartao = By.id("creditcard-owner");
    private By validadeMes = By.id("creditcard-expiration-month");
    private By validadeAno = By.id("creditcard-expiration-year");
    private By codCartao = By.id("creditcard-securitycode");
    private By nParcelas = By.id("creditcard-installments-number");



    public PagamentoPage(WebDriver driver) {
        this.driver = driver;
    }

    public  String nomeProduto() {
     esperarElemento();
     return getDriver().findElement(descriscaoProduto).getText();

    }
    public String valorProduto() {
        return getDriver().findElement(valorProduto).getText();

    }

    public String corProduto(){
       return getDriver().findElement(cor).getText();
    }

    public String tamanhoProduto(){
        return  getDriver().findElement(tamanhoProduto).getText();

    }

    public String quantidadeProduto(){
     return  getDriver().findElement(qts).getAttribute("value");

    }
    public boolean isVisivelCartaoCredito(){
       return getDriver().findElement(numberCartao).isDisplayed();

    }


    public boolean isVisivelNomeTitular(){
        return  getDriver().findElement(titularCartao).isDisplayed();

    }
    public boolean isVisivelValidadeMes(){
        return  getDriver().findElement(validadeMes).isDisplayed();

    }
    public boolean isVisivelValidadeAno(){
        return  getDriver().findElement(validadeAno).isDisplayed();

    }
    public boolean isVisivelCodSeguranca(){
        return  getDriver().findElement(codCartao).isDisplayed();

    }
    public boolean isVisivelNParcelas(){
        return  getDriver().findElement(nParcelas).isDisplayed();

    }


}
