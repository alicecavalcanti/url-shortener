# Plataforma para encurtar url

## Instalação do sistema

1- Clone o repositório: git clone.

2- Abra em uma IDE de código. Sugestão: Intellij.

3- Baixe o MongoDB Community Server para ter acesso ao banco de dados.
    O link para download: https://www.mongodb.com/try/download/community

4- Baixe uma ferramenta para testes de requisições HTTP. Sugestão: Httpie

5- Instale a ferramenta docker.

## Acesso a url encurtada

1- Abra o docker e dentro do projeto no terminal digite (docker compose up) para subir o container docker do banco de dados.  

2-Faça um "run" da classe principal("UrlshortenerApplication") da aplicação chamada.

2- Tenha acesso ao banco de dados, abrindo MongoDB Community Server e entrando no banco de dados atráves
do user padrão : username=admin | password=123 . Você pode encontrar mais dessas configurações no arquivo application.properties.

![Captura de tela 2024-05-22 044111](https://github.com/alicecavalcanti/url-shortener/assets/110575974/8dc102f3-deb2-4a34-bb0d-d43320d3a93a)

3- Abra o httpie (ou a ferramenta que você escolheu). Cole o caminho (localhost:8080/shorten-url) no corpo da solicitação em formato JSON, selecione o metódo post e aperte em (send).

![Captura de tela 2024-05-22 094428](https://github.com/alicecavalcanti/url-shortener/assets/110575974/11d87676-87e2-40d2-931e-31bc3eb94212)


4- Pegue o link encurtado gerado como resposta para usar.

5- Quando você abrir o  MongoDB Community Server, terá acesso a média de acesso dessa url por dia, total de acesso a url e também quantos acessos por dia essa url tem.
