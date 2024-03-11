<img src="https://github.com/TaisPorto/EletricCar/blob/main/app/src/main/java/com/example/eletriccar/ui/adapter/prints/Screenshot_1710107407.png" alt="Imagem de Exemplo" width="150">  <img src="https://github.com/TaisPorto/EletricCar/blob/main/app/src/main/java/com/example/eletriccar/ui/adapter/prints/Screenshot_1710107414.png" alt="Imagem de Exemplo" width="150">  <img src="https://github.com/TaisPorto/EletricCar/blob/main/app/src/main/java/com/example/eletriccar/ui/adapter/prints/Screenshot_1710107423.png" alt="Imagem de Exemplo" width="150"> <img src="https://github.com/TaisPorto/EletricCar/blob/main/app/src/main/java/com/example/eletriccar/ui/adapter/prints/Screenshot_1710107429.png" alt="Imagem de Exemplo" width="150"> <img src="https://github.com/TaisPorto/EletricCar/blob/main/app/src/main/java/com/example/eletriccar/ui/adapter/prints/Screenshot_1710107454.png" alt="Imagem de Exemplo" width="150">

Este é um aplicativo para gerenciar informações sobre carros elétricos  no qual os usuários podem acessar uma ampla gama de informações sobre diferentes modelos de carros elétricos, como preço, potência, autonomia da bateria, tempo de recarga e até mesmo ver fotos dos carros. Este aplicativo foi desenvolvido para auxiliar aqueles que estão considerando comprar um carro elétrico e desejam comparar diferentes modelos. Neste aplicativo é possivel efetuar o calculo de autonomia funcionalidade que  permite aos usuários estimar a quantidade de quilômetros que podem percorrer com base no preço do kWh e na distância percorrida. Isso é útil para proprietários de carros elétricos que desejam planejar viagens ou estimar os custos de carregamento. Os usuários podem marcar carros como favoritos e acessar facilmente suas informações posteriormente.  A interface do usuário com abas deslizantes proporciona uma experiência de navegação intuitiva, permitindo que os usuários alternem facilmente entre diferentes seções do aplicativo.

## Tecnologias Utilizadas

O aplicativo foi construído com as seguintes tecnologias e componentes:

- * Retrofit: É uma biblioteca para Android que facilita o consumo de serviços web RESTful. Retrofit simplifica muito o processo de fazer solicitações de rede em aplicativos Android, tornando mais fácil recuperar e enviar dados para uma API web.
    

- * GsonConverterFactory (do Retrofit): GsonConverterFactory é uma classe do Retrofit que converte automaticamente objetos Java para JSON e vice-versa. Essa conversão é usada para processar os dados JSON recebidos das solicitações da API web.
    

- * ViewPager2 (do AndroidX): ViewPager2 é uma versão atualizada do ViewPager original, que é usada para criar interfaces de usuário com abas deslizantes. Ele oferece melhorias de desempenho e suporte para layouts verticais, além de outras melhorias em comparação com o ViewPager original.
    

- * RecyclerView (do AndroidX): RecyclerView é uma biblioteca de suporte que oferece uma maneira mais avançada e flexível de exibir listas de dados. Ele é usado para exibir a lista de carros elétricos e a lista de favoritos dentro do aplicativo.
    

- * AsyncTask (do Android): AsyncTask é uma classe no Android que permite executar operações longas em segundo plano e, em seguida, atualizar a interface do usuário na thread principal. É usado principalmente para tarefas como o cálculo de autonomia, onde é necessário evitar bloquear a interface do usuário durante o processamento.
    

## Recursos Principais

- * Cadastro e Visualização de Carros Elétricos: Os usuários podem cadastrar novos carros elétricos no sistema, fornecendo informações como preço, potência, autonomia da bateria, tempo de recarga e URL de foto. Eles podem visualizar uma lista de carros elétricos disponíveis, tanto online (através de uma API) quanto localmente (salva no banco de dados do aplicativo).
 
- * Cálculo de Autonomia:
    O aplicativo oferece uma funcionalidade para calcular a autonomia de um carro elétrico com base nos quilômetros percorridos e no preço do kWh. Gerenciamento de Favoritos.

- * Os usuários podem marcar carros como favoritos, armazenando essas informações localmente no aplicativo para referência futura.
 
- * Interface Intuitiva com Abas Deslizantes:
    O aplicativo utiliza ViewPager2 e Fragments para criar uma interface com abas deslizantes, permitindo que os usuários naveguem facilmente entre diferentes   telas, como a lista de carros e a lista de favoritos.
 
- * Conexão com API Externa (Retrofit):
 O aplicativo se conecta a uma API externa para obter informações sobre carros elétricos, permitindo aos usuários acessar uma ampla gama de modelos e dados.
 
- *  Banco de Dados Local (SQLite):
     Utiliza o SQLite como banco de dados local para armazenar informações sobre carros elétricos cadastrados e favoritos dos usuários, garantindo acesso rápido e   offline a esses dados.

## Como Executar o Aplicativo

Para executar o aplicativo em seu ambiente de desenvolvimento, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Abra o projeto em um ambiente de desenvolvimento Android, como o Android Studio.
3. Execute o aplicativo em um emulador ou dispositivo Android.

Sinta-se à vontade para explorar e contribuir para o projeto. Se tiver alguma dúvida ou sugestão, não hesite em abrir uma [issue](https://github.com/seuusuario/seurepositorio/issues).

Esses são os principais recursos deste aplicativo, que visam fornecer aos usuários uma experiência completa e informativa sobre carros elétricos, além de ferramentas úteis para ajudá-los em suas decisões de compra e utilização. 


## Author
Taís Porto Eleutério (follow me on [Linkedin](https://www.linkedin.com/in/taisporto/))

## License
```
The MIT License (MIT)

Copyright (c) 2021 Roque Buarque Junior

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
