package web.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pages.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestSteps {
    private static WebDriver driver;
    private HomePage homePage = new HomePage(driver);
    private LoginPage login = new LoginPage(driver);
    private ModalProdutoPage modal = new ModalProdutoPage(driver);
    private CarrinhoPage carrinho = new CarrinhoPage(driver);
    private PagamentoPage pagamento = new PagamentoPage(driver);
    @Before
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\83\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Dado("que estou na paginal inicial do site shoestok")
    public void que_estou_na_paginal_inicial_do_site_shoestok() {
        homePage.carregarPaginaInicial();
    }
    @Quando("nao estou logado")
    public void nao_estou_logado() {
         assertTrue(homePage.notLogado());
    }
    @E("faço uma pesquiso pelo produto {string}")
    public void faço_uma_pesquiso_pelo_produto(String produto) {
        homePage.pesquisarPorItem(produto);
    }

    @Entao("o resultado da pesquisa trara {int} item")
    public void o_resultado_da_pesquisa_trara_item(Integer int1) {
       // assertEquals(" 1 resultado",homePage.qtsResutadoDaPesquisa());
        homePage.descResutadoDaPesquisa("Mocassim Couro Shoestock Gravata Masculino".toUpperCase());
        System.out.println(homePage.qtsResutadoDaPesquisa());

    }

    // fluxo adicionar item no carrinho
    @Quando("estou logado")
    public void estou_logado() throws InterruptedException {
        login.fazerLogin();
        assertTrue(homePage.isLogado());
    }

    @E("clico no produto apresentado")
    public void clico_no_produto_apresentado() {
        homePage.clicarProdutoByNome("Mocassim Couro Shoestock Gravata Masculino");
    }

    @E("seleciono a cor {string} e {string} do produto")
    public void seleciono_a_cor_e_do_produto(String string, String string2) {
        modal.selecionarCor("Caramelo");
        modal.selecionarTamanho(40);
        modal.obterPrecoProdutoModal();


    }

    @E("clico no botao comprar")
    public void clico_no_botao_comprar() throws InterruptedException {
        modal.clickComprar();
        Thread.sleep(3000);

    }

    @Entao("valido as informacoes da pagina do carrinho")
    public void valido_as_informacoes_da_pagina_do_carrinho() throws InterruptedException {
    //validacoes do carrinho
        assertEquals("Mocassim Couro Shoestock Gravata Masculino".toUpperCase(),carrinho.obterNomeProduto().toUpperCase());
        assertEquals("Tamanho: 40",carrinho.obterTamanhoProduto());
        assertEquals("1",carrinho.obterQuantidadeProduto());
        assertEquals("Cor: Caramelo",carrinho.obterCorProduto());
        assertEquals("R$ 114,90",carrinho.valorTotalCarrinho());
        assertEquals("R$ 0,00",carrinho.desconto());
        assertEquals("R$ 114,90",carrinho.vlrSubTotalProdutos());
    }

    @Entao("clico no botao continuar")
    public void clico_no_botao_continuar() {
        carrinho.continuar();

    }

    @Entao("valido as informacoes da pagina de pagamento")
    public void valido_as_informacoes_da_pagina_de_pagamento() {
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
        driver.quit();
    }

}