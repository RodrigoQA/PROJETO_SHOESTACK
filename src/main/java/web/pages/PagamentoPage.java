package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PagamentoPage extends BasePage {
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
     return driver.findElement(descriscaoProduto).getText();

    }
    public String valorProduto() {
        return driver.findElement(valorProduto).getText();

    }

    public String corProduto(){
       return driver.findElement(cor).getText();
    }

    public String tamanhoProduto(){
        return  driver.findElement(tamanhoProduto).getText();

    }

    public String quantidadeProduto(){
     return  driver.findElement(qts).getAttribute("value");

    }
    public boolean isVisivelCartaoCredito(){
       return driver.findElement(numberCartao).isDisplayed();

    }



    public boolean isVisivelNomeTitular(){
        return  driver.findElement(titularCartao).isDisplayed();

    }
    public boolean isVisivelValidadeMes(){
        return  driver.findElement(validadeMes).isDisplayed();

    }
    public boolean isVisivelValidadeAno(){
        return  driver.findElement(validadeAno).isDisplayed();

    }
    public boolean isVisivelCodSeguranca(){
        return  driver.findElement(codCartao).isDisplayed();

    }
    public boolean isVisivelNParcelas(){
        return  driver.findElement(nParcelas).isDisplayed();

    }


}
