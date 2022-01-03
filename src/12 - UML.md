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



### Credits: <br>
[UML Class Diagrams](https://web.fe.up.pt/~arestivo/presentation/uml-classes/#1), by André Restivo <br>
[UML Sequence Diagrams](https://web.fe.up.pt/~arestivo/presentation/uml-sequence/#1), by André Restivo <br>

**@ Fábio Araújo de Sá** <br/>
**2021/2022**