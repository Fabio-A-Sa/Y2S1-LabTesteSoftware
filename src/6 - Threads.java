// Created on November, 2021
// @author: Fábio Araújo de Sá

/**
 * Treads:
 * Execução de código em paralelo, através de diferentes processos. Têm a sua própria stack mas
 * têm acesso a todos os dados partilhados
 */

class usingThreads {

    public static void run() {

        Model m = new Model();
        View v = new View();

        new Thread() {
            public void run () {
                while (m.a < 1000) {
                    m.increment();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (m.a < 1000) {
                    v.draw(m);
                }
            }
        }.start();
    }
}

class Model {
    int a = 0, b = 0;
    public void increment() {
        a++;
        b++;
    }
}

class View {
    public void draw (Model m) {
        System.out.println(m.a + " " + m.b);
    }
}

abstract class Fruta {

    String nome;
    int tamanho;
    public Fruta (String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
}

class Banana extends Fruta {

    String qualidade;
    public Banana (String nome, int tamanho, String qualidade) {
        super(nome, tamanho);
        this.qualidade = qualidade;
    }
}