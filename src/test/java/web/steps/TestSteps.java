package web.steps;

import api.core.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import web.core.DriverFactory;
import web.pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSteps {

    private static WebDriver driver;
    private HomePage homePage = new HomePage(driver);
    private LoginPage login = new LoginPage(driver);
    private CheckoutPage modal = new CheckoutPage(driver);
    private CarrinhoPage carrinho = new CarrinhoPage();
    private PagamentoPage pagamento = new PagamentoPage(driver);
    private BaseTest base = new BaseTest();


    @Given("^que estou na paginal inicial do site shoestok$")
    public void queEstouNaPaginalInicialDoSiteShoestok() throws Throwable {
        DriverFactory.getDriver().get("https://www.shoestock.com.br/");

    }

    @When("^estou logado$")
    public void estouLogado() throws Throwable {
        login.fazerLogin();
        assertTrue(homePage.isLogado());
    }
    @Given("^nao estou logado$")
        public void naoEstouLogado() throws Throwable {
        assertTrue(homePage.notLogado());
    }

    @Then("^faco uma pesquiso pelo produto \"([^\"]*)\"$")
    public void facoUmaPesquisoPeloProduto(String produto) throws Throwable {
        homePage.pesquisarPorItem(produto);
    }
    @Then("^o resultado da pesquisa trara (\\d+) item$")
    public void oResultadoDaPesquisaTraraItem(int arg1) throws Throwable {
        // assertEquals(" 1 resultado",homePage.qtsResutadoDaPesquisa());
        homePage.descResutadoDaPesquisa("Mocassim Couro Shoestock Gravata Masculino".toUpperCase());
        System.out.println(homePage.qtsResutadoDaPesquisa());

    }

    @Given("^clico no produto apresentado$")
    public void clicoNoProdutoApresentado() throws Throwable {
        homePage.clicarProdutoByNome("Mocassim Couro Shoestock Gravata Masculino");
    }

    @Given("^seleciono a cor \"([^\"]*)\" e \"([^\"]*)\" do produto$")
    public void selecionoACorEDoProduto(String cor, int tam) throws Throwable {
        modal.selecionarCor(cor);
        modal.selecionarTamanho(tam);
        modal.obterPrecoProdutoModal();
    }

    @Given("^clico no botao comprar$")
    public void clicoNoBotaoComprar() throws Throwable {
        modal.clickComprar();
        Thread.sleep(3000);

    }

    @Then("^valido as informacoes da pagina do carrinho$")
    public void validoAsInformacoesDaPaginaDoCarrinho() throws Throwable {
        //validacoes do carrinho
        assertEquals("Mocassim Couro Shoestock Gravata Masculino".toUpperCase(),carrinho.obterNomeProduto().toUpperCase());
        assertEquals("Tamanho: 40",carrinho.obterTamanhoProduto());
        assertEquals("1",carrinho.obterQuantidadeProduto());
        assertEquals("Cor: Caramelo",carrinho.obterCorProduto());
        assertEquals("R$ 114,90",carrinho.valorTotalCarrinho());
        assertEquals("R$ 0,00",carrinho.desconto());
        assertEquals("R$ 114,90",carrinho.vlrSubTotalProdutos());
    }

    @Then("^clico no botao continuar$")
    public void clicoNoBotaoContinuar() throws Throwable {
        carrinho.continuar();
    }

    @Then("^valido as informacoes da pagina de pagamento$")
    public void validoAsInformacoesDaPaginaDePagamento() throws Throwable {
        //validacoes pagamento
        assertEquals("Mocassim Couro Shoestock Gravata Masculino",pagamento.nomeProduto());
        assertEquals("Tamanho: 40",pagamento.tamanhoProduto());
        assertEquals("Cor: Caramelo",pagamento.corProduto());
        assertEquals("R$ 114,90",pagamento.valorProduto());
        assertTrue(pagamento.isVisivelCartaoCredito());
        assertTrue(pagamento.isVisivelNomeTitular());
        assertTrue(pagamento.isVisivelValidadeMes());
        assertTrue(pagamento.isVisivelValidadeAno());
        assertTrue(pagamento.isVisivelCodSeguranca());
        assertTrue(pagamento.isVisivelNParcelas());
        carrinho.limparCarrinho();

    }
    @After
    public static void finalizar() {
        DriverFactory.killDriver();
    }
}