# Unit Testing

### Como testar um sistema?

1 - Uso de testes: para verificar o comportamento do sistema em runtime <br>
2 - Uso de revisões e inspeções: para avaliar algo que não é executável <br>

    Antigamente testava-se o software sob o ponto de vista do utilizador, ignorando qualquer implementação interna que 
    não fosse visível. Havia escrita de código, muitas vezes na main, que exercitava o código a testar.
    As principais desvantagens do método são:
    - A dificuldade da manutenção do sistema;
    - Não dava para fazer um roleback do sistema antes de ser manipulado;
    - Muito pouco automatizado, levando muito tempo a preparar e executar as verificações;

Atualmente as frameworks `JUnit` e `Spock` garantem uma automatização de testes e permitem que o desenvolvedor se foque somente nos testes e não na implementação. Há, por isso, três etapas principais no processo da escrita de um teste: <br>
##### setup() / @Before: comando que é executado antes de cada teste, para preparar o sistema
##### test() / @Test: o teste propriamente dito, com asserts ou verificações
##### cleanUp() / @After: para preservar as suas propriedades que possam ter sido modificadas ao longo do teste

### Bugs and Debugging

- [X] Human Error - uma ação humana que gera um defeito no sistema; <br>
- [X] Faults - omissão de software por erro humano; <br>
- [X] Error - estado não esperado do sistema que eventualmente pode levar a uma falha; <br>
- [X] Failture - uma falha observada; <br>

### Bugs or Features?

Perceber as necessidades do cliente pode não estar alinhado com a especificação dada.
Diferentes interpretações (a linguagem natural é ambígua) levam a que determinadas porções de código possam ser bug para um e feature para outro.
Uma constante comunicação com o cliente, para especificações precisas, é necessário para um correcto software.

### White and Black Testing

`Black Box testing` - Não sabemos como está implementado o código <br>
`White Box testing` - Temos acesso ao código, conhece a implementação <br>

#### 1 - Black Box

##### 1.1 - Equivalence partitioning
Generalizar os testes para valores que estejam dentro da mesma partição

##### 1.2 - Boundary value analysis
Avaliar os limites de cada partição, no ponto exato e em valores próximos aos valores de fronteira

#### 2 - White Box

##### 2.1 - Statement coverage
Testes que executam os caminhos pelo menos uma vez

##### 2.2 - Branch coverage
Todas as condições booleanas são avaliadas pelo menos uma vez (não combinadas)

##### 2.3 - Path coverage
Todas as condições booleanas são avaliadas, com todas as combinações possíveis de falso e verdadeiro. Todos os caminhos independentes são executados pelo menos uma vez.

##### 2.4 - Condition Coverage
As condições booleanas combinadas são testadas com todas as combinações possíveis. Exemplo: para if (a and b) eram necessários 4 testes.
<br>

## Dependency injection
Uma forma de isolar as classes, para que a implementação de uma não interfira totalmente
no resultado de um conjunto de testes de outra.

### Test Doubles
objectos que ajudam a minimizar a complexidade dos testes e de certa forma a que os testes sejam independentes do resto do sistema. `JMockit` e `Spock` são duas frameworks que implementam e manipulam estes dois tipos. São exemplos:

#### 1 - Stubs
Objectos que imitam os do sistema, capazes de retornar valores predefinidos

#### 2 - Mocks
É possível testar como a função é chamada, com que argumentos, como é o seu estado, comportamento e quantas vezes o método é chamado.

## Component Testing
A maior parte das falhas deriva da interação entre unidades de código. Aqui os unit testings não conseguem apanhar os vários erros, teremos de usar o teste de interface. Dois tipos de Testing:

- All Together Testing: <br>
Através do Big Bang Integration, se houver uma forte dependência entre as unidades. 
  - Vantagens: precisamos de poucos testes, mais rápido; 
  - Desvantagens: se algo falhar não se sabe de onde vem o erro;

- Step-by-Step Testing: <br>
Através do Bottom Up Integration e Top Down Integration, se não houver grande dependência entre as unidades.
  - Vantagens: é mais fácil detectar erros em casos mais isolados;
  - Desvantagem: ter mais testes, demorar mais tempo, muitas unidades;

  - Bottom Up Integration - combina testes de componentes que convém testar primeiro e depois tudo junto. Uma desvantagem é que como existem muitas unidades, não é possível testar as combinações todas.
  - Top Down Integration - testar o sistema como um todo e recorrendo a mocks para as dependências necessárias

## Continuous Integration
Através de testes de software, builds privados e builds públicos para que exista colaboração com a equipa.

- `Mainline` - master/main do código no git
- `Develop` - branch de desenvolvimento, a usar por todos os colaboradores. Só se dá merge na main do projecto se passar nos testes no escopo privado (unit testing)
- `Integration build` - um build periódico, para garantir que o código modificado por todos continua a funcionar correctamente em conjunto
- `Smoke test` - testes para garantir que nada foi quebrado aquando do merge do código modificado por todos

**@ Fábio Araújo de Sá** <br/>
**2021/2022**