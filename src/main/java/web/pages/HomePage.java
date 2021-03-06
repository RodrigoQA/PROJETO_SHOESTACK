package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static web.core.DriverFactory.getDriver;

public class HomePage extends PageObject {
    WebDriver driver;
    CarrinhoPage carrinho = new CarrinhoPage();
    public HomePage(Page page) {
       super(page);
    }
    List<WebElement> listaProdutos = new ArrayList();

    private By btnEntrar = By.xpath("//*[contains(text(),'Entrar')]"); //yaman
    private By barraDePesquisa = By.cssSelector(".input-label #search-input"); //yaman
    private By buscar = By.xpath("//*[contains(text(),'Buscar')]");//yaman
    private By qtsResultado = By.cssSelector("span.block"); //yaman
    private By produtosEncontrados =By.cssSelector("#item-list .item-card");
    private By descricaoProduto = By.cssSelector(".item-card__description__product-name");
    private By itensSacola = By.cssSelector(".cart-count-badge span");
    private By remover = By.cssSelector(".remove-icon");




    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public boolean isLogado() {
        return !"Entrar".contentEquals(getDriver().findElement(btnEntrar).getText());
    }
    public boolean notLogado() {
        getDriver().findElement(btnEntrar).getText();
        return "ENTRAR".contentEquals(getDriver().findElement(btnEntrar).getText());

    }


    public void pesquisarPorItem(String produto) {
        // verificar se o carrinho está vazio
        String itens = getDriver().findElement(itensSacola).getText();
        if (Integer.parseInt(itens) != 0) {
            getDriver().findElement(itensSacola).click();
            WebElement lixeira = getDriver().findElement(remover);
            lixeira.click();
            esperarElemento();
            visibilityOfElementLocatedFluentWait(".search .search__input");
            getDriver().findElement(By.cssSelector(".search .search__input")).sendKeys(produto);
            esperarElemento();
            getDriver().findElement(By.cssSelector("button.search__button")).click();
        }else {
            visibilityOfElementLocatedFluentWait(".input-label #search-input");
            getDriver().findElement(barraDePesquisa).sendKeys(produto);
            esperarElemento();
            getDriver().findElement(buscar).click();
        }
   }

      public String qtsResutadoDaPesquisa() {
          getDriver().findElement(descricaoProduto).getText();
        String resut = getDriver().findElement(qtsResultado).getText();
        resut = resut.replace("Exibindo: 1 - 1 de","");
        return resut;
    }
    private void carregarListaProdutos() {
        listaProdutos = getDriver().findElements(produtosEncontrados);
    }
    public int quantidadeProdutosEncontrados() {
        carregarListaProdutos();
        return listaProdutos.size();
    }
    public boolean descResutadoDaPesquisa(String descricao) {
        String desc = getDriver().findElement(descricaoProduto).getText();
        System.out.println(desc.toUpperCase());
        return desc == descricao;
    }


    public void selecionarProdutoDesejado(String produto) {
     clicarProdutoByNome(produto);    }
}

