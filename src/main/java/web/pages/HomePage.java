package web.pages;

import web.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private WebDriver driver;
    LoginPage login = new LoginPage(driver);


    private By btnEntrar = By.xpath("//*[contains(text(),'Entrar')]"); //yaman
    private By barraDePesquisa = By.cssSelector(".input-label #search-input"); //yaman
    private By buscar = By.xpath("//*[contains(text(),'Buscar')]");//yaman
    private By qtsResultado = By.cssSelector("span.block"); //yaman
    private By descricaoProduto = By.cssSelector(".item-card__description__product-name");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void carregarPaginaInicial() {
        driver.get("https://www.shoestock.com.br/");

    }
    public boolean isLogado() {
        return !"Entrar".contentEquals(driver.findElement(btnEntrar).getText());
    }
    public boolean notLogado() {
        driver.findElement(btnEntrar).getText();
        return "ENTRAR".contentEquals(driver.findElement(btnEntrar).getText());

    }


    public void pesquisarPorItem(String produto)  {
        esperarElemento();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".input-label #search-input")));
        driver.findElement(barraDePesquisa).sendKeys(produto);
        driver.findElement(buscar).click();

    }

      public String qtsResutadoDaPesquisa() {
        driver.findElement(descricaoProduto).getText();
        String resut = driver.findElement(qtsResultado).getText();
        resut = resut.replace("Exibindo: 1 - 1 de","");
        return resut;

    }
    public boolean descResutadoDaPesquisa(String descricao) {
        String desc = driver.findElement(descricaoProduto).getText();
        System.out.println(desc.toUpperCase());
        return desc == descricao;
    }


    public void clicarProdutoByNome(String produto) {
        driver.findElement(By.xpath("//span[contains(text(),'"+produto+"')]")).click();
    }
}

