package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static web.core.DriverFactory.getDriver;


public class CarrinhoPage extends PageObject {

    private WebDriver driver;

    private By nomeProduto = By.cssSelector(".product-details__info h3");
    private By tamanhoProduto = By.xpath("//p[@class='custom__text'][contains(.,'Tamanho:')]");
    private By corProduto = By.xpath("//p[@class='custom__text'][contains(.,'Cor:')]");
    private By removerProdutoList = By.xpath("//*[@class='remove-from-cart']");
    private By vlrTotalProduto =  By.xpath("//div[contains(@qa-auto,'cart-price')]");
    private By subTotal = By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/ul/li[1]/div[2]/div[1]");
    private By QtsProduto =  By.cssSelector(".product-qtd__input");
    private By continuar = By.cssSelector(".btn.btn--primary.btn--block");
    private By sacola = By.cssSelector(".cart-count-badge");
    private By remover = By.cssSelector(".remove-icon");
    private By homepage = By.cssSelector("img.logo");
    private By desconto = By.xpath("//div[@qa-auto='cart-discount']");


    public void removerProdutoDoCarrinho(int item) throws InterruptedException {
        getDriver().findElements(removerProdutoList).get(item).click();

    }

    public String valorTotalCarrinho() {
        esperarElemento();
        return getDriver().findElement(vlrTotalProduto).getText();

    }


    public String obterQuantidadeProduto() {
        String quantidadeProduto = getDriver().findElement(QtsProduto).getAttribute("value");
        System.out.println(quantidadeProduto);
        return quantidadeProduto;
    }
    public String obterNomeProduto() throws InterruptedException {
       esperarElemento();
        String desc = getDriver().findElement(nomeProduto).getText();
        System.out.println(desc);
        return desc;

    }
    public String obterTamanhoProduto(){
        esperarElemento();
        String text = getDriver().findElement(tamanhoProduto).getText();
       String tam = text.replace("Tamanho: ","");
        System.out.println(tam);
        return tam;
    }
    public String obterCorProduto(){
        visibilityOfElementLocatedWait("//p[@class='custom__text'][contains(.,'Cor:')]");
        String text = getDriver().findElement(corProduto).getText();
        String cor = text.replace("Cor: ","");
        System.out.println(cor);
        return cor;
    }
    public String vlrSubTotalProdutos(){
        return getDriver().findElement(subTotal).getText();
    }
    public String desconto(){
        return getDriver().findElement(desconto).getText();
    }

    public void continuar() {
        getDriver().findElement(continuar).click();
    }
     public void limparCarrinho(){
        getDriver().findElement(homepage).click();
        visibilityOfElementLocatedFluentWait(".cart-count-badge");
        getDriver().findElement(sacola).click();
        getDriver().findElement(remover).click();

     }
}
