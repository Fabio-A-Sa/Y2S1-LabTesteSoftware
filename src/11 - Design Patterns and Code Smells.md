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

- Long Method - métodos maiores de 15 linhas normalmente podem ser partidos em várias outras partes e não permite uma verificação de erros rápida

- Large Classes - normalmente as classes longas são aquelas que fazem de tudo um pouco, o que causa alguma confusão no código no geral

- Primitive Obsession - uso excessivo de primitivas, não usando os correspondentes objectos

Long Parameter List - métodos que são chamados com uma grande lista de parametros, mais
que quatro já não é adequado

Data clumbs - partes diferentes do código possuem grupos de identicas variáveis, originando
mais erros e mais problemas ao refactorar




**@ Fábio Araújo de Sá** <br/>
**2021/2022**