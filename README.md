# iConverte, um aplicativo Android Multi-Modular 

O iConvertor é um projeto de aplicação Androidque utiliza a arquitetura MVVM, Hilt para injeção de dependências, Retrofit para trabalhar com API e Shared Preferences para armazenamento de dados.

## Arquitetura

A arquitetura do projeto segue o padrão MVVM (Model-View-ViewModel):

- *Model*: Representa a camada de dados e lógica de negócios.
- *View*: Representa a camada de interface do usuário.
- *ViewModel*: Atua como um intermediário entre a View e o Model, gerenciando a lógica de apresentação.

## Tecnologias Utilizadas

- *Hilt*: Utilizado para injeção de dependências, facilitando a gestão de dependências e promovendo a reutilização de código.
- *Material Design*: Utilizado para criar componentes de interface do usuário modernos e consistentes.
- *JetPack Navigation*: Utilizado para gerenciar a navegação entre as telas da aplicação.
- *Retrofit*: Utilizado para realizar chamadas de API de forma simples e eficiente.
- *Shared Preferences*: Utilizado para armazenar dados simples e persistentes.

## Configuração do Projeto

### Pré-requisitos

- Android Studio 4.1 ou superior
- Gradle 6.5 ou superior
