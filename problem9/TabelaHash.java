package lista_v2.problem9;
import java.util.ArrayList;

class TabelaHash {
    private ArrayList<Aluno>[] tabela;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArrayList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ArrayList<>();
        }
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    public void put(int chave, Aluno valor) {
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula() == chave) {
                alunos.set(i, valor);
                return;
            }
        }

        alunos.add(valor);
        System.out.println("Inserido: " + valor + " na posição " + hash);
        imprimirTabela();
    }

    public Aluno get(int chave) {
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == chave) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno remove(int chave) {
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula() == chave) {
                Aluno removido = alunos.remove(i);
                System.out.println("Removido: " + removido);
                imprimirTabela();
                return removido;
            }
        }
        return null;
    }

    public void imprimirTabela() {
        System.out.print("Tabela Hash: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + ": " + tabela[i] + " | ");
        }
        System.out.println();
    }
}
