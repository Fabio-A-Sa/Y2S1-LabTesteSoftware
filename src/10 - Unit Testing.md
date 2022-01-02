# Unit Testing

### Como testar um sistema?

1 - Uso de testes: para verificar o comportamento do sistema em runtime <br>
2 - Uso de revisões e inspeções: para avaliar algo que não é executável <br>

Antigamente testava-se o software sob o ponto de vista do utilizador, ignorando qualquer implementação interna que não fosse visível. Havia escrita de código, muitas vezes na main, que exercitava o código a testar.
As principais desvantagens do método são:
- A dificuldade da manutenção do sistema;
- Não dava para fazer um roleback do sistema antes de ser manipulado;
- Muito pouco automatizado, levando muito tempo a preparar e executar as verificações;

Atualmente as frameworks `JUnit` e `Spock` garantem uma automatização de testes e permitem que o desenvolvedor se foque somente nos testes e não na implementação. Há, por isso, três etapas principais no processo da escrita de um teste: <br>
#### setup() / @Before: comando que é executado antes de cada teste, para preparar o sistema
##### test() / @Test: o teste propriamente dito, com asserts ou verificações
##### cleanUp() / @After: para preservar as suas propriedades que possam ter sido modificadas ao longo do teste
<br>

### Bugs and Debugging

- [X] Human Error - uma ação humana que gera um defeito no sistema; <br>
- [X] Faults - omissão de software por erro humano; <br>
- [X] Error - estado não esperado do sistema que eventualmente pode levar a uma falha; <br>
- [X] Failture - uma falha observada; <br>
<br>

### Bugs or Features?

Perceber as necessidades do cliente pode não estar alinhado com a especificação dada.
Diferentes interpretações (a linguagem natural é ambígua), pode ser bug para um e feature para outro.
Leva a problemas de interpretação e de software
Constante comunicação com o cliente, para especificações precisas