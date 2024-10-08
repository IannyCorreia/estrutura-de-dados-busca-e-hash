package lista_v2.problem10;

public class TabelaHash {
    private Aluno[] tabela;
    private int tamanho;
    private int elementos;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Aluno[tamanho];
        this.elementos = 0;
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    private void redimensionar() {
        Aluno[] novaTabela = new Aluno[tamanho * 2];
        for (Aluno aluno : tabela) {
            if (aluno != null) {
                int index = aluno.getMatricula() % novaTabela.length;
                while (novaTabela[index] != null) {
                    index = (index + 1) % novaTabela.length;
                }
                novaTabela[index] = aluno;
            }
        }
        tabela = novaTabela;
        tamanho = novaTabela.length;
    }

    public void put(int chave, Aluno valor) {
        if (elementos >= tabela.length / 2) {
            redimensionar();
        }

        int index = hash(chave);
        while (tabela[index] != null) {
            if (tabela[index].getMatricula() == chave) {
                tabela[index] = valor;
                return;
            }
            index = (index + 1) % tamanho;
        }
        tabela[index] = valor;
        elementos++;
        imprimirTabela();
    }

    public Aluno get(int chave) {
        int index = hash(chave);
        while (tabela[index] != null) {
            if (tabela[index].getMatricula() == chave) {
                return tabela[index];
            }
            index = (index + 1) % tamanho;
        }
        return null;
    }

    public Aluno remove(int chave) {
        int index = hash(chave);
        while (tabela[index] != null) {
            if (tabela[index].getMatricula() == chave) {
                Aluno removido = tabela[index];
                tabela[index] = null;
                elementos--;
                rehash();
                return removido;
            }
            index = (index + 1) % tamanho;
        }
        return null;
    }

    private void rehash() {
        Aluno[] antigaTabela = tabela;
        tabela = new Aluno[tamanho];
        elementos = 0;

        for (Aluno aluno : antigaTabela) {
            if (aluno != null) {
                put(aluno.getMatricula(), aluno);
            }
        }
    }

    public void imprimirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");
            if (tabela[i] != null) {
                System.out.print(tabela[i]);
            } else {
                System.out.print("null");
            }
            System.out.println();
        }
        System.out.println();
    }
}
