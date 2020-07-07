Feature:Adicionar produto no carrinho com sucesso
  Como usuario não logado
  Eu desejo adicionar um produto no carrinho
  Para que eu possa continuar comprando
  Background:
    Given que estou na paginal inicial do site shoestok
    |pagina |"https://www.shoestock.com.br/|

  @AddCarrinho
  Scenario Outline:Deve adicionar produto no carrinho com sucesso
    When estou logado
    Then faco uma pesquiso pelo nome do produto "<nomeProduto>"
    Then sera apresentado o resultado da pesquisa
    Then clico no produto apresentado "<nomeProduto>"
    Then seleciono a cor "<Cor>" e "<Tamanho>" do produto
    Then clico no botao comprar
    Then valido as informacoes da pagina do carrinho
      |Tamanho  |Cor  |Preco  |Desconto  |SubTotal  |Quantidade  |nomeProduto  |
      |<Tamanho>|<Cor>|<Preco>|<Desconto>|<SubTotal>|<Quantidade>|<nomeProduto>|
    Then clico no botao continuar
    Then valido as informacoes da pagina de pagamento
      |Tamanho  |Cor  |Preco  |Desconto  |SubTotal  |Quantidade  |nomeProduto  |
      |<Tamanho>|<Cor>|<Preco>|<Desconto>|<SubTotal>|<Quantidade>|<nomeProduto>|

    Examples:
      |Tamanho|Cor     |Preco    |Desconto  |SubTotal  |Quantidade|nomeProduto                                   |
      |39     |Café    |R$ 229,90|R$ 0,00   |R$ 229,90  |1         |Bota Coturto Couro Shoestock Básica Masculina|
      |41     |Azul    |R$ 229,90|R$ 0,00   |R$ 229,90  |1         |Mocassim Couro Shoestock Gravata Masculino   |
      |39     |Caramelo|R$ 114,90|R$ 0,00   |R$ 114,90  |1         |Mocassim Couro Shoestock Gravata Masculino   |




