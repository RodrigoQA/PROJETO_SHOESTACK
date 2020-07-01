#language:pt
Funcionalidade: Realizar busca de produto
  Como usuario não logado
  Eu desejo realizar buscas de produtos disponiveis
  Para assim escolher qual desejo comprar


  @realizarBusca
  Cenario: Deve realizar uma busca atraves da barra de pesquisa

    Dado que estou na paginal inicial do site shoestok
    Quando nao estou logado
    E faço uma pesquiso pelo produto "mocassim shoestock masculino"
    Entao o resultado da pesquisa trara 1 item



