# CONFIGURAÇÃO DO CHROMEDRIVER #
<h2>Configurar o caminho do driver a ser executado</h2>
<br>
<h2>*Windows</h2>
- Incluir a pasta 'drivers' na raiz do projeto e nomear o arquivo como 'chromedriver.exe'
- ou aponte o local do chromedriver.exe na class TestSteps
<br>
<h2>*Linux</h2>
- Incluir a pasta 'drivers' na raiz do projeto e nomear o arquivo como 'chromedriver'
<br>
<h2>*MAC OS</h2>
- Incluir a pasta 'drivers' na raiz do projeto e nomear o arquivo como 'chromedriver'

- *Wrn: <br> 
1.0 A versão do chromedriver deve ser a mesma do browser instalado. <br>
1.1 Caso tenha mais de uma versão do chromedriver instalado excluir o arquivo<br>
1.2 Em caso de linux verificar se possui o chromedriver instalado via apt-get



# CONFIGURAÇÃO DE AMBIENTE DE DESENVOLVIMENTO INTEGRADO #
<h2> IDE </h2>
Plugin's <br>
- Junit <br>
- Cucumber for Java

# CLASSE RUNNER MAIN #
<h2> Configurar web.runner </h2>
 - Acessar 'Run' <br>
 - Edit configurations <br>
 - Selecionar 'JUNIT' <br>
 - Incluir novo com nome 'Runner' <br>
 - Test kind: 'Class' <br>
 - Class: 'web.runner.Runner' <br>
 - VM options: '-ea' <br>
 - Working diretory: '$MODULE_WORKING_DIR$' 
 
 <h2> Tags </h2>
 - Alterar a tag a ser executado na classe web.runner <br>
 - A opção 'tags = ("@AddCarrinho")' identifica qual tag sera executada
 
 <h2> Parametros </h2>
 
 O projeto possui alguns parametros entre eles o da pagaina de checkout, é possivel escolher o tamanho e cor do produto 
 Porem é preciso se atentar, Ao alterar os parametros deve-se alterar tambem os asserts referentes a eles.

<h2> After </h2>

Devido o teste ficar gerando itens no carrinho a medida que é executado,
foi necessario criar um hook apos a finalização dos testes, sendo assim apos a execução do
cenario de adicionar item no carrinho a automação limpa a sacola.

 
 
 
 
