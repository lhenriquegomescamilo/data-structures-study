package array;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos;
    private int totalDeAlunos = 0;


    Vetor() {
        this.alunos = new Aluno[100];
    }

    Vetor(int size) {
        this.alunos = new Aluno[size];
    }

    /*
        Quanto mais alunos tem no vetor mais demorada vai ser a insersão
        Complexidade: O(n) -> Pois inserir um aluno depende do numero de elementos existestes na lista
     */

    /*
    public void adiciona(array.Aluno aluno) {
        for(int i = 0; i < alunos.length; i++) {
            if(alunos[i] == null) {
                alunos[i] = aluno;
                break;
            }
        }
    }
    */

    /*
        - Aqui temos um algoritmo de tempo constante pois estamos guardando sempre a posicao vazia em uma variavel
     */
    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    /*
         - Método para adicionar no vetor em uma posição especifica
         - É necessario pegar a posição que se quer  inserir e mover as posições ocupadas para a direita
         - a complexidade aqui é O(n) pois tbm depende da quantidade de elementos no array
     */
    void adiciona(int posicao, Aluno aluno) {
        this.garanteEspaco();
        if(!posicaoValida(posicao)) {
            throw new IllegalArgumentException("posicao invalida");
        }

        for(int i = totalDeAlunos -1; i >= posicao; i-=1) {
            alunos[i+1] = alunos[i];
        }
        alunos[posicao] = aluno;
    }

    public Aluno pega(int posicao) {
        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao invalida");
        }
        return alunos[posicao];
    }

    public void remove(int posicao) {
        for(int i = posicao; i < this.totalDeAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
        }
        totalDeAlunos--;
    }
    /*
        A complexidade aqui sempre vai ser O(n) pois o tempo de execução varia de acordo com a quantidade de elementos
     */
    public boolean contem(Aluno aluno) {
        for (int i = 0; i < totalDeAlunos; i++) {
            if(aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return totalDeAlunos;
    }

    public String toString() {
        return Arrays.toString(alunos);
    }

    // Verifica se posição no vetor está ocupada.
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0  && posicao <= totalDeAlunos;
    }

    private void garanteEspaco() {
        if(totalDeAlunos == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for(int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
    }
}
