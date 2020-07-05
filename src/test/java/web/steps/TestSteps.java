package web.steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import web.pages.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static web.core.DriverFactory.getDriver;
import static web.core.DriverFactory.killDriver;
import static web.core.Parametros.*;
import static web.pages.PageObject.capturaImagem;

public class TestSteps {
    Map<String, String> dados;
    String Tamanho;
    String Cor;
    String Preco;
    String SubTotal;
    String Quantidade;
    String nomeProduto;
    String pagina;
    String url;

    private static WebDriver driver;
    private HomePage homePage = new HomePage(driver);
    private LoginPage login = new LoginPage(driver);
    private CheckoutPage checkout = new CheckoutPage(driver);
    private CarrinhoPage carrinho = new CarrinhoPage();
    private PagamentoPage pagamento = new PagamentoPage(driver);
    private PageObject pageObjetc = new PageObject();

    @Given("^que estou na paginal inicial do site shoestok$")
    public void queEstouNaPaginalInicialDoSiteShoestok(DataTable dataTable) throws Throwable {
        getDriver().get(URL_SHOESTOCK);


    }


    @When("^estou logado$")
    public void estouLogado() throws Throwable {
        login.fazerLogin();
        assertTrue(homePage.isLogado());
        capturaImagem("estou logado");
    }
    @Given("^nao estou logado$")
        public void naoEstouLogado() throws Throwable {
        assertTrue(homePage.notLogado());
        capturaImagem("nao estou logado");
    }

    @Then("^faco uma pesquiso pelo nome do produto \"([^\"]*)\"$")
    public void faco_uma_pesquiso_pelo_nome_do_produto(String produto) throws Throwable {
        homePage.pesquisarPorItem(produto);
        capturaImagem("pesquisa com sucesso");
    }
    @Then("^sera apresentado o resultado da pesquisa$")
    public void seraApresentadoOResultadoDaPesquisa() throws Throwable {
        // assertEquals(" 1 resultado",homePage.qtsResutadoDaPesquisa());
        homePage.descResutadoDaPesquisa("Mocassim Couro Shoestock Gravata Masculino".toUpperCase());
        System.out.println(homePage.qtsResutadoDaPesquisa());
        assertThat(homePage.quantidadeProdutosEncontrados(), Matchers.greaterThan(0));
        System.out.println("Resultado da pesquisa: " + homePage.quantidadeProdutosEncontrados());
        capturaImagem("naoEstouLogado");

    }

    @Given("^clico no produto apresentado$")
    public void clicoNoProdutoApresentado() throws Throwable {
        homePage.selecionarProdutoDesejado("Mocassim Couro Shoestock Gravata Masculino");
        capturaImagem("pagina de checkout");
    }

    @Given("^seleciono a cor \"([^\"]*)\" e \"([^\"]*)\" do produto$")
    public void selecionoACorEDoProduto(String cor, int tam) throws Throwable {
        checkout.selecionarCor(cor);
        checkout.selecionarTamanho(tam);
        checkout.precoProduto();
        checkout.tamanhoSelecionado();
        checkout.corSelecionada();
capturaImagem("selecionoACorEDoProduto");
    }

    @Given("^clico no botao comprar$")
    public void clicoNoBotaoComprar() throws Throwable {
        carrinho = checkout.clickComprar();
        Thread.sleep(3000);
        capturaImagem("clicoNoBotaoComprar");

    }

    @Then("^valido as informacoes da pagina do carrinho$")
    public void valido_as_informacoes_da_pagina_do_carrinho(DataTable dataTable) throws Throwable {

        List<Map<String, String>> dadosCarrinho = dataTable.asMaps(String.class, String.class);
        dados = dadosCarrinho.get(0);
        //validacoes do carrinho
          assertEquals(dados.get("nomeProduto").toUpperCase(),carrinho.obterNomeProduto().toUpperCase());
          assertEquals(dados.get("Tamanho"),carrinho.obterTamanhoProduto());
          assertEquals(dados.get("Quantidade"),carrinho.obterQuantidadeProduto());
          assertEquals(dados.get("Cor"),carrinho.obterCorProduto());
          assertEquals(dados.get("Preco"),carrinho.valorTotalCarrinho());
          assertEquals(dados.get("Desconto"),carrinho.desconto());
          assertEquals(dados.get("SubTotal"),carrinho.vlrSubTotalProdutos());
          capturaImagem("valido_as_informacoes_da_pagina_do_carrinho");


    }




    @Then("^clico no botao continuar$")
    public void clicoNoBotaoContinuar() throws Throwable {
        carrinho.continuar();
        capturaImagem("clicoNoBotaoContinuar");
    }
    @Then("^valido as informacoes da pagina de pagamento$")
    public void validoAsInformacoesDaPaginaDePagamento(DataTable dataTable) throws Throwable {
        List<Map<String, String>> dadosCarrinho = dataTable.asMaps(String.class, String.class);
        dados = dadosCarrinho.get(0);

        //validacoes pagamento
        assertEquals(dados.get("nomeProduto"),pagamento.nomeProduto());
        assertEquals(dados.get("Tamanho"),pagamento.tamanhoProduto());
        assertEquals(dados.get("Cor"),pagamento.corProduto());
        assertEquals(dados.get("Preco"),pagamento.valorProduto());
        assertTrue(pagamento.isVisivelCartaoCredito());
        assertTrue(pagamento.isVisivelNomeTitular());
        assertTrue(pagamento.isVisivelValidadeMes());
        assertTrue(pagamento.isVisivelValidadeAno());
        assertTrue(pagamento.isVisivelCodSeguranca());
        assertTrue(pagamento.isVisivelNParcelas());
        capturaImagem("validoAsInformacoesDaPaginaDePagamento");
        carrinho.limparCarrinho();
        capturaImagem("limparCarrinho");

   }
    @After
    public static void finalizar() {
        killDriver();
    }
}