
  Feature: Realizar busca de produto
    Como usuario não logado
    Eu desejo realizar buscas de produtos disponiveis
    Para assim escolher qual desejo comprar

    Background:
      Given que estou na paginal inicial do site shoestok
        |pagina |"https://www.shoestock.com.br/|
    @realizarBusca
    Scenario: Deve realizar uma busca atraves da barra de pesquisa
      When nao estou logado
      Then faco uma pesquiso pelo nome do produto "Mocassim Couro Shoestock Gravata Masculino"
      Then sera apresentado o resultado da pesquisa



