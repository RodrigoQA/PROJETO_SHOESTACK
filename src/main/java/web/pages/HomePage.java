package web.pages;

import web.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.core.DriverFactory;

import static web.core.DriverFactory.*;

public class HomePage extends BasePage {
     WebDriver driver;


    private By btnEntrar = By.xpath("//*[contains(text(),'Entrar')]"); //yaman
    private By barraDePesquisa = By.cssSelector(".input-label #search-input"); //yaman
    private By buscar = By.xpath("//*[contains(text(),'Buscar')]");//yaman
    private By qtsResultado = By.cssSelector("span.block"); //yaman
    private By descricaoProduto = By.cssSelector(".item-card__description__product-name");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLogado() {
        return !"Entrar".contentEquals(getDriver().findElement(btnEntrar).getText());
    }
    public boolean notLogado() {
        getDriver().findElement(btnEntrar).getText();
        return "ENTRAR".contentEquals(getDriver().findElement(btnEntrar).getText());

    }


    public void pesquisarPorItem(String produto)  {
        esperarElemento();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".input-label #search-input")));
        getDriver().findElement(barraDePesquisa).sendKeys(produto);
        getDriver().findElement(buscar).click();

    }

      public String qtsResutadoDaPesquisa() {
          getDriver().findElement(descricaoProduto).getText();
        String resut = getDriver().findElement(qtsResultado).getText();
        resut = resut.replace("Exibindo: 1 - 1 de","");
        return resut;

    }
    public boolean descResutadoDaPesquisa(String descricao) {
        String desc = getDriver().findElement(descricaoProduto).getText();
        System.out.println(desc.toUpperCase());
        return desc == descricao;
    }


    public void clicarProdutoByNome(String produto) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+produto+"')]")).click();
    }
}

