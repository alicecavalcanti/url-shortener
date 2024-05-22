# Plataforma para encurtar url

## Instalação do sistema

1- Clone o repositório: git clone.

2- Abra em uma IDE de código. Sugestão: Intellij.

3- Baixe o MongoDB Community Server para ter acesso ao banco de dados.
    O link para download: https://www.mongodb.com/try/download/community

4- Baixe uma ferramenta para testes de requisições HTTP. Sugestão: Httpie

## Acesso a url encurtada

1-  Faça um "run" da classe principal("UrlshortenerApplication") da aplicação chamada.

2- Tenha acesso ao banco de dados, abrindo MongoDB Community Server e entrando no banco de dados atráves
do user padrão : username=admin | password=123 . Você pode encontrar mais dessas configurações no arquivo application.properties.


![Captura de tela 2024-05-22 044111](https://github.com/alicecavalcanti/url-shortener/assets/110575974/8dc102f3-deb2-4a34-bb0d-d43320d3a93a)


3- Abra o httpie (ou a ferramenta que você escolheu) e cole o endpoint da controller (ShorteningUrlController), você terá que colar a url 
que você deseja encurtar e pegue o link encurtado gerado como resposta para usar.

2- Quando você abrir o  MongoDB Community Server, terá acesso a média de acesso dessa url por dia, total de acesso a url e também quantos acessos por dia essa url tem.
