#language:en
Feature:Adicionar produto no carrinho com sucesso
  Como usuario não logado
  Eu desejo adicionar um produto no carrinho
  Para que eu possa continuar comprando


  @AddCarrinho
   Scenario: Deve adicionar produto no carrinho com sucesso
    Given que estou na paginal inicial do site shoestok
    When estou logado
    Then faco uma pesquiso pelo produto "mocassim shoestock masculino"
    Then clico no produto apresentado
    Then seleciono a cor "Caramelo" e "40" do produto
    Then clico no botao comprar
    Then valido as informacoes da pagina do carrinho
    Then clico no botao continuar
    Then valido as informacoes da pagina de pagamento







