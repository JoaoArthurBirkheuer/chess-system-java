# Sistema de Xadrez em Java

Este projeto implementa um sistema de xadrez em Java, contendo a maior parte das funcionalidades de um jogo de xadrez, como movimentação das peças, regras especiais (roque, en passant e promoção) e controle de turno. Ainda há pontos a serem aprimorados, como a finalização da partida (checkmate).

---

## Estrutura do Projeto

O projeto está organizado em três packages principais:

### 1. Package `application`
- **Program**:  
  - Classe principal que contém o método `main`.  
  - Gerencia o fluxo da partida em um loop que executa enquanto não há checkmate (a lógica de checkmate ainda está em desenvolvimento).  
  - Captura as entradas do usuário para indicar as jogadas e trata exceções específicas (como jogadas inválidas ou entrada incorreta).

- **UI**:  
  - Responsável pela interface com o usuário via terminal.  
  - Exibe o tabuleiro e as peças capturadas utilizando cores (ANSI escape codes).  
  - Lê a posição de origem e destino das jogadas e formata a saída para facilitar a visualização do estado do jogo.

### 2. Package `boardgame`
- **Board**:  
  - Representa o tabuleiro do jogo, garantindo que o número de linhas e colunas seja válido.  
  - Gerencia a colocação, remoção e consulta das peças no tabuleiro.  
  - Verifica se uma determinada posição existe ou se já há uma peça nela.

- **BoardException**:  
  - Exceção personalizada para erros relacionados ao funcionamento do tabuleiro (por exemplo, tentativa de acessar uma posição inválida).

- **Piece (classe abstrata)**:  
  - Define as propriedades básicas de uma peça de jogo, como a posição e os movimentos possíveis.  
  - Fornece métodos para verificar movimentos válidos e se há algum movimento possível.

- **Position**:  
  - Representa uma posição no tabuleiro utilizando coordenadas (linha e coluna).  
  - Permite a manipulação e exibição das coordenadas.

### 3. Package `chess`
- **ChessPiece (classe abstrata)**:  
  - Estende a classe `Piece` e adiciona atributos específicos do xadrez, como a cor da peça e a contagem de movimentos realizados.  
  - Define métodos auxiliares, como a verificação de peças adversárias.

- **ChessPosition**:  
  - Representa a posição das peças no formato tradicional do xadrez (ex.: a1, h8).  
  - Realiza a conversão entre a posição interna (usada no tabuleiro) e o formato de xadrez.

- **Color (enum)**:  
  - Define as duas cores possíveis para as peças: `WHITE` e `BLACK`.

- **ChessException**:  
  - Exceção específica para regras e erros do jogo de xadrez.

- **ChessMatch**:  
  - Gerencia a partida de xadrez, controlando o turno, o jogador atual, as jogadas realizadas e as regras especiais.  
  - Responsável pela validação dos movimentos, aplicação de jogadas (inclusive movimentos especiais como roque, en passant e promoção) e verificação de estado (check e checkmate).

#### Pacote Interno: `chess.pieces`
Contém as classes que implementam as peças específicas do xadrez:
- **King**:  
  - Implementa os movimentos do rei, incluindo a lógica para roque (tanto kingside quanto queenside).  
- **Pawn**:  
  - Define os movimentos e regras específicas do peão, como o avanço duplo no primeiro movimento, captura diagonal e a jogada en passant.
- **Outras Peças**:  
  - Classes como **Rook**, **Knight**, **Bishop** e **Queen** implementam os movimentos e regras de cada peça de forma similar e coerente com as regras do xadrez.

---

## Funcionalidades

- **Movimentação de Peças**:  
  Cada peça possui seus movimentos válidos definidos, verificando se a jogada está dentro dos limites do tabuleiro e se não há obstáculos ou peças amigas na trajetória.

- **Regras Especiais**:  
  - **Roque**: Implementado no movimento do rei, com verificação do movimento do rei e da torre.  
  - **En Passant**: Permitido quando um peão avança duas casas e fica vulnerável à captura especial pelo adversário.  
  - **Promoção**: Quando um peão atinge a última fileira, ele é promovido automaticamente (com opção de escolha entre Bishop, Knight, Rook e Queen).

- **Controle de Turnos e Verificação de Estado**:  
  - Alternância entre jogadores (branco e preto).  
  - Verificação de check e tentativa de evitar jogadas que coloquem o próprio rei em xeque.  
  - A lógica para finalização da partida (checkmate) ainda está em desenvolvimento.

- **Interface com o Usuário**:  
  - Exibição do tabuleiro com formatação colorida para facilitar a identificação das peças e dos movimentos possíveis.  
  - Leitura de entradas no formato tradicional (ex.: `a1`, `h8`) e validação dos dados fornecidos.

---

## Como Executar

### Requisitos
- **JDK**: O projeto foi desenvolvido utilizando o **JDK 22** (foi necessário realizar a migração do JDK 11 para o JDK 22).  
- **Terminal**: Para uma melhor experiência com as cores do terminal, recomenda-se utilizar o **Git Bash**.  
- **IDE ou Terminal**: Você pode compilar e executar o projeto tanto em uma IDE (como Eclipse ou IntelliJ) quanto diretamente pelo terminal.

### Passos para Execução
1. **Compilação**:  
   Compile todas as classes do projeto. Caso utilize o terminal, navegue até a pasta `src` e utilize o comando:
   ```bash
   javac -d bin $(find . -name "*.java")
   ```
2. **Execução**:  
   Navegue até a pasta `bin` e execute a classe principal:
   ```bash
   java application.Program
   ```
   Certifique-se de abrir o Git Bash na pasta `bin` para visualizar corretamente a interface com cores.

---

## Possíveis Melhorias

- **Finalização da Partida (Checkmate)**: A lógica de checkmate ainda está em desenvolvimento e pode ser aprimorada para encerrar a partida quando um jogador não tiver mais jogadas válidas.
- **Interface Gráfica**: Considerar o desenvolvimento de uma interface gráfica para melhorar a experiência do usuário.
- **Tratamento de Exceções**: Aprimorar as mensagens de erro e validações para tornar a interação mais intuitiva.
- **Testes Unitários**: Adicionar testes para validar as funcionalidades de cada classe e garantir a robustez do sistema.

---

## Considerações Finais

Este projeto demonstra um estudo aprofundado sobre o desenvolvimento de um jogo de xadrez utilizando conceitos de orientação a objetos em Java, como herança, encapsulamento e tratamento de exceções. Sinta-se à vontade para contribuir com melhorias ou adaptações conforme necessário.

