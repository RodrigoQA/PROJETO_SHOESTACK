
  Feature: Realizar busca de produto
  Como usuario não logado
  Eu desejo realizar buscas de produtos disponiveis
  Para assim escolher qual desejo comprar


  @realizarBusca
  Scenario: Deve realizar uma busca atraves da barra de pesquisa

    Given que estou na paginal inicial do site shoestok
    When nao estou logado
    Then faco uma pesquiso pelo produto "mocassim shoestock masculino"
    Then o resultado da pesquisa trara 1 item



