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

#### 1 - Composing Methods

- Extract method / variable - extrair linhas repetidas em vários locais e constituir um método em separado;
- Inline method / variable - simplificar determinadas comparações de modo a só ocuparem uma linha;
- Replace Temporary with Query - transformar comparações soltas num método próprio;
- Split temporary variables - para uma melhor compreensão do código;
- Remove assignmments to Parameters - usar e manipular variáveis locais em vez de parâmetros passados ao método;
- Substitute algorithm - simplificar o código para uma futura manutenção;

#### 2 - Moving features between Objects

- Move method or class - quando determinados métodos são usados mais na classe que não é de origem;
- Extract method or class - mover o método ou atributo para a zona onde é mais utilizado;
- Hide Delegate - evitar dependências em classes terceiras;
- Remove middle man - remover uma classe ou método intermédio que pouco faz;
- Introduce foreign method - é melhor ter vários métodos do que um método que faça tudo;
- Introduce local extension - criar uma nova classe que contenha os métodos necessários de outra;

#### 3 - Simplifying Conditional Expressions

- Consolidate Conditional Expression - optar somente por if..else, when..then, em vez do tradicional switch ou mais ifs;
- Consolidate Duplicate Conditional Fragment - juntar tudo numa condição, usando operador ternário;
- Decompose Conditional - criar um if..else, com break, continue em vez de uma linha complexa de código;
- Replace Conditional with Polymorphism - criar classes derivadas de uma geral de modo a partir as definições condicionais;
- Remove Control Flag - às vezes não é necessário usar variáveis booleanas quando se pode ter somente ifs e elses;
- Replaced Nested Conditional with Guard Clauses - avaliar as condições mais prováveis e deixar o retorno final livre de ifs;
- Introduce Null Object - ter um objecto nulo que exibe o comportamento padrão do sistema;
- Introduce Assertion - colocar asserts caso essa parte do código precise mesmo de ser verdadeira, em vez de um simples if..else;

#### 4 - Simplifying method calls

- Add / Remove Parameter - colocar nas chamadas de métodos os parâmetros somente necessários;
- Rename Method - escolher um nome que já indique o que o método faz;
- Separate Query from Modifier - separar métodos que retornam coisas de métodos que modifificam coisas;
- Parameterize Method - generalizar um método e colocar parâmetros específicos para situações específicas. É o funcionamento da class T em C++;
- Introduce Parameter Object - substituir vários parâmetros por um objecto que os contenha;
- Preserve Whole Object - passar o objecto inteiro em vez de os seus parâmetros, quando são muitos;
- Remove Settings Method - o Objecto deve ser definido aquando da sua criação, remover os métodos que façam isso futuramente;
- Replace Parameters with Explicit Methods - criar um setter para o valor X e outro para o valor Y, em vez de um setter para os dois;
- Replace Parameter with Method Call - splitar o método que trabalha com vários parâmetros em vários só trabalhando com um;
- Hide Method - tornar o método privado ou protegido quando é usado somente por um número restrito de classes;
- Replace Error Code with Exception - se um método retornar algo inesperado, lançar uma excepção em vez de o detectar por if..else após o retorno;
- Replace Exception with Test - às vezes não é necessário retornar uma excepção, basta retornar um valor lógico que nunca poderia ser o resultado. Por exemplo retornar -1 quando acontece um index out of the bound;

#### 5 - Dealing with generalizations

- Pull up field;
- Pull up method;
- Pull up constructor body;
- Push down field;
- Push down method;
- Extract subclasses;
- Extract superclasses;
- Extract interfaces;
- Colapse hierarchy;
- Form Template Method;
- Replace Inheritance with delegation;
- Replace delegation with inheritance;
<br>

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