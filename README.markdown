Web Test GMaps Project
======================

Uma aplicação feita para estudo visando aprender como funciona a API do GoogleMaps.

Configurando o projeto
=====================

O projeto por padrão é configurado para o banco de dados PostgreSQL, mas por ser uma aplicação que faz o uso de Hibernate, basta mudar as configurações no arquivo de contexto do Spring para trabalhar com qualquer banco.

Passos:

1. Importe o projeto no  [Eclipse Java EE IDE for Web Developers (Testado a partir do Helios)](http://www.eclipse.org/downloads/) ou superior;
OBS: JAVA 8
2.  Baixe as dependências do projeto Maven (Botão direito no Projeto -> Maven -> Update project...);
3.  Crie o banco `trixmaps` com a ferramenta escolhida (no caso a usada para a aplicação em que foi utilizado o `PostgreSQL`, foi o PGAdmin);
5.  Configurações de informações do banco (user = postgres, pass = postgres, porta = 5432)  
6.  A aplicação não possui autenticação, logo não precisa adicionar nada no banco antes de iniciar a aplicação.
7.  Deploy da aplicação no `Apache Tomcat 7.x` e inicie o servidor.
8.  Acesse a aplicação através da url [http://localhost:8080/trixmaps] (http://localhost:8080/trixmaps) ;

Informação adicional
=====================

1. O schema do banco de dados da aplicação, `trixmaps`, será criado pelo Hibernate ao iniciar a aplicação a primeira vez.

Tecnologias Usadas
==============
1. JSF 2.x
2. Hibernate 4.x
3. Spring 4.x
4. Bootstrap (para testes de responsividade do site)
5. AJAX (do próprio Primefaces)
