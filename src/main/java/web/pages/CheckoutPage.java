package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
    private By corAzul = By.xpath("//*[@class='ns-color ns-color-bg-azul 44']");
    private By corCaramelo = By.xpath("//*[@class='ns-color ns-color-bg-caramelo 44']");
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
        visibilityOfElementLocatedWait("//*[@class='ns-color ns-color-bg-azul 44']");
        if (color.contains("Azul")) {
            getDriver().findElement(corAzul).click();
        } else if (color.contains("Caramelo")) {
            getDriver().findElement(corCaramelo).click();
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


    public CarrinhoPage clickComprar()  {

            esperarElemento();
           try {
              if(!elementoEstaVisivel("#buy-button-now.buy-button-now.button-no-float"));
               getDriver().findElement(comprar).click();
           }catch (NoSuchElementException e) {
               System.out.println(e.getMessage() + "desculpe mas nao temos mais esse tamanho");
               killDriver();

           }
        return new CarrinhoPage();
    }
        public void selecionarTamanho(int number) throws NoSuchElementException{
            esperarElemento();

            if (number == 37) {
                number = 1;
            } else if (number == 38) {
                number = 2;
            } else if (number == 39) {
                number = 3;
            } else if (number == 40) {
                number = 4;
            } else if (number == 41) {
                number = 5;
            } else if (number == 42) {
                number = 6;
            } else if (number == 43) {
                number = 7;
            } else if (number == 44) {
                number = 8;
            }
         getDriver().findElement(By.xpath("//*[@id='buy-box']/section[2]/div/ul/li[" + number + "]/a")).click();


       }



    }

