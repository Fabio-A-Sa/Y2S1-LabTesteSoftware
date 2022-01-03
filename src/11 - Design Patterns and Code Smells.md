# Design Patterns and Code Smells

### Factory Method
Definir uma interface para criar um objecto, mas deixar que as subclasses decidam
qual classe instanciar.
Evitar repetições de código e problemas caso esse mesmo código tenha que sofrer alterações.
Assim o código é modificado só num sítio e perpetuado por todo o projecto.

### Refactoring
Permite melhorar o desenho e estrutura do software, sem modificar o seu comportamento,
para que exista uma melhor compreensão do que faz e como faz.
Sempre que se faz uma refatorização, convém voltar a correr os testes para que não exista
problemas de quebra de determinados parâmetros.

### Code Smells
Algo pode levar a problemas futuros no código e por isso deverá ser feita uma
refactorização no sítio adequado o quanto antes. Não são detectados com base em unit testing.
Um bom site para aprender mais sobre code smells: `refactoring.guru`. Há vários exemplos de Code Smells:

#### 1 - Bloaters

- Long Method - métodos maiores de 15 linhas normalmente podem ser partidos em várias outras partes e não permite uma verificação de erros rápida;

- Large Classes - normalmente as classes longas são aquelas que fazem de tudo um pouco, o que causa alguma confusão no código geral;

- Primitive Obsession - uso excessivo de primitivas, não usando os correspondentes objectos;

- Long Parameter List - métodos que são chamados com uma grande lista de parametros, mais que quatro já não é adequado;

- Data clumbs - partes diferentes do código possuem grupos de identicas variáveis, originando mais erros e mais problemas ao refactorar;

#### 2 - Object Oriented Abusers

- Switch statements - abuso da utilizaçção de switch e de if..else em métodos;

- Temporary Field - uma classe que utiliza campos temporários, que ao não serem preenchidos podem causar problemas futuros na implementação;

- Refuse bequest - confusão de subclasses e superclasses que, apesar de usarem os mesmos métodos e atributos, são completamente diferentes. Exemplo: Animal(leg) -> (dog || chair);

- Alternative Classes with different interfaces - classes muito idênticas mas com interfaces diferentes;

#### 3 - Change Prevents

- Divergent change - necessidade de mudar muitas partes da classe para implementar uma nova feature ou método. É um sinal claro que existem problemas de estrutura no código e também dependências exageradas;

- Shotgun Surgery - parecido com a anterior, mas em vez de alterar só a classe, altera mais partes do código no seu todo;

- Parallel inheritance hierarchies - há necessidade de criar uma subclasse noutro lado do código quando se cria um primeira subclasse. Sinal que há dependências em demasia;

#### 4 - Dispensables

- Comments - comentários desnecessários, que só poluem o código em si;

- Duplicate code - em vez disso, criar uma classe ou um método em separado;

- Lazy class - classe que não faz muito ou nada, que ao ser apagada pouco transtorno traz ao código em si;

- Data classes - classes que só tenham getters e setters;

- Speculative Generality - implementar código que para já não é necessário, ou seja, há criação de lazy classes e temporary field;

#### 5 - Couples

- Feature envy - Necessidade de um método invocar métodos de outras classes para poder atuar. Indicação que é necessário transferir métodos para outras classes;

- Inappropriate Intimacy - quase o mesmo de cima. É um método que usa atributos de várias outras classes para poder funcionar tal como foi idealizado;

- Message chains - correntes de chamamentos entre classes, que poderiam fazer parte de uma classe auxiliar;

- Middle man - um método intermédio que não altera nenhum atributo;

### Como encontrar algumas deste code smells automaticamente?
- [x] `bettercodehub.com` - entrar com a conta do github;
- [x] `errorprone.info` - desenvolvida pela Google que implementa as regras do Google Standard Guide. No Gradle, colocar o código `id "org.kordamp.gradle.errorprone" version "0.47.0"` na parte das dependências;
- [x] `fbinfer.com` - desenvolvido pelo Facebook;

**@ Fábio Araújo de Sá** <br/>
**2021/2022**