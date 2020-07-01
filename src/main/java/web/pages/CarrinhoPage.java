package web.pages;

import web.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage {

    private WebDriver driver;

    private By nomeProduto = By.cssSelector(".product-details__info h3");
    private By tamanhoProduto = By.xpath("//p[contains(@class,'custom__text')][1]");
    private By corProduto = By.xpath("//p[contains(@class,'custom__text')][2]");
    private By removerProdutoList = By.xpath("//*[@class='remove-from-cart']");
    private By vlrTotalProduto =  By.xpath("//div[contains(@qa-auto,'cart-price')]");
    private By subTotal = By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/ul/li[1]/div[2]/div[1]");
    private By QtsProduto =  By.cssSelector(".product-qtd__input");
    private By continuar = By.cssSelector(".btn.btn--primary.btn--block");
    private By sacola = By.cssSelector(".cart-count-badge");
    private By remover = By.cssSelector(".remove-icon");
    private By home = By.cssSelector("img.logo");
    private By desconto = By.xpath("//div[@qa-auto='cart-discount']");
    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removerProdutoDoCarrinho(int item) throws InterruptedException {
        driver.findElements(removerProdutoList).get(item).click();
        esperarElemento();
    }

    public String valorTotalCarrinho() {
        esperarElemento();
        return driver.findElement(vlrTotalProduto).getText();

    }


    public String obterQuantidadeProduto() {
        String quantidadeProduto = driver.findElement(QtsProduto).getAttribute("value");
        System.out.println(quantidadeProduto);
        return quantidadeProduto;
    }
    public String obterNomeProduto() throws InterruptedException {
       esperarElemento();
        String desc = driver.findElement(nomeProduto).getText();
        System.out.println(desc);
        return desc;

    }
    public String obterTamanhoProduto(){
        String text = driver.findElement(tamanhoProduto).getText();
        System.out.println(text);
        return text;
    }
    public String obterCorProduto(){
        esperarElemento();
        String text = driver.findElement(corProduto).getText();
        System.out.println(text);
        return text;
    }
    public String vlrSubTotalProdutos(){
        return driver.findElement(subTotal).getText();
    }
    public String desconto(){
        return driver.findElement(desconto).getText();
    }

    public void continuar() {
        driver.findElement(continuar).click();
    }
     public void limparCarrinho(){
        driver.findElement(home).click();
        esperarElemento();
        driver.findElement(sacola).click();
        driver.findElement(remover).click();

    }
}