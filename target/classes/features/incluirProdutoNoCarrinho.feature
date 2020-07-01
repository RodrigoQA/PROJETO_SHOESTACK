#language:pt
Funcionalidade: Adicionar produto no carrinho com sucesso
  Como usuario não logado
  Eu desejo adicionar um produto no carrinho
  Para que eu possa continuar comprando


  @AddCarrinho
  Cenario: Deve adicionar produto no carrinho com sucesso

    Dado que estou na paginal inicial do site shoestok
    Quando estou logado
    E faço uma pesquiso pelo produto "mocassim shoestock masculino"
    E clico no produto apresentado
    E seleciono a cor "cor" e "tamanho" do produto
    E clico no botao comprar
    Entao valido as informacoes da pagina do carrinho
    E clico no botao continuar
    Entao valido as informacoes da pagina de pagamento







