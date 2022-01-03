# UML

Diagramas que representam a estrutura e o comportamento da aplicação. Podem ser de três tipos principais:

- [x] Class Diagrams;
- [x] Sequence Diagrams;
- [x] State Diagrams;

## 1 - Class Diagrams

Representa as classes e relação entre elas, bem como indicação das operações e dos atributos de cada uma.
Modelação conceptual do domínimo do software e os seus componentes.
A representação de cada classe vai ao encontro do que se aprende em Base de Dados:

<br/>
<p align = "center" >
  <img 
       title = "André Restivo UML"
       src = "../Images/inheritanceUML.png" 
       alt = "André Restivo UML" 
    />
</p>
<br>

Tópicos relevantes: <br>
- Para classes ou métodos abstractos, usar os seus nomes em *itálico*; <br>
- Cada método ou atributo é precedido por um símbolo. São eles: <br>
  - "+", se o método ou atributo for público; <br>
  - "-", se o método ou atributo for privado; <br>
  - "*", se o método ou atributo for protegido; <br>
- A estrutura para cada linha será sempre <br> `symbol methodName(listParameter : parameterType) returnType`; <br>
- Há associações bidirecionais (por padrão) e associações unidirecionais, com a seta a apontar para o objecto que conhece; <br>
- As interfaces possuem <<"Interface">> antes do nome da tabela e as suas implementações são sinalizadas por uma seta a tracejado; <br>
- As dependências também são identificadas por uma seta a tracejado, a apontar para a parte necessária; <br>

<br/>
<p align = "center" >
  <img 
       title = "André Restivo Dependency"
       src = "../Images/dependencyUML.png" 
       alt = "André Restivo Dependency" 
    />
</p>
<br>

## 2 - Sequence Diagrams

Representa a interação entre objectos numa ordem sequencial <br>

- Lifeline - representa o tempo sequencial (uma linha do tempo)
- Actors - qualquer entidade externa que interaja com o sistema
- Message - traduzida por uma seta preenchida ou tracejada
- Activation - retângulo em cima da lifeline que representa o período que demora a processar o pedido

<br/>
<p align = "center" >
  <img 
       title = "André Restivo Activation"
       src = "../Images/activationSequence.png" 
       alt = "André Restivo Activation" 
    />
</p>
<br>

## 3 - State Diagrams

Representa os diversos estados da aplicação (inicial, intermédio e final) <br>

<br/>
<p align = "center" >
  <img 
       title = "André Restivo Transition"
       src = "../Images/transitionUML.png" 
       alt = "André Restivo Transition" 
    />
</p>
<br>

Transitions: setas que possuem, na descrição, três coisas:

1 - O evento, que é uma chamada de uma função, um input; <br> 
2 - Uma Guard, uma condição que tem de ser verdadeira para que a transição seja feita; <br>
3 - Effect, o efeito da transição no objecto que se estava a manipular; <br>

<br/>
<p align = "center" >
  <img 
       title = "André Restivo State"
       src = "../Images/stateDiagram.png" 
       alt = "André Restivo State" 
    />
</p>
<br>

### Credits: <br>
[UML Class Diagrams](https://web.fe.up.pt/~arestivo/presentation/uml-classes/#1), by André Restivo <br>
[UML Sequence Diagrams](https://web.fe.up.pt/~arestivo/presentation/uml-sequence/#1), by André Restivo <br>
[UML State Diagram](https://web.fe.up.pt/~arestivo/presentation/uml-state/#13), by André Restivo <br>

**@ Fábio Araújo de Sá** <br/>
**2021/2022**