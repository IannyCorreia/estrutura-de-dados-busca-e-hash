package lista_v2.problem9;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(8);
        
        tabelaHash.put(52, new Aluno(52, "Pedro")); 
        tabelaHash.put(45, new Aluno(45, "Ycaro"));
        tabelaHash.put(64, new Aluno(64, "Felix")); 
        tabelaHash.put(34, new Aluno(34, "Sabrina")); 
        tabelaHash.put(69, new Aluno(69, "Kaleb")); 
        tabelaHash.put(11, new Aluno(11, "Eva")); 
        tabelaHash.put(10, new Aluno(10, "Noah")); 

        Aluno aluno45 = tabelaHash.get(45);
        if (aluno45 != null) {
            System.out.println("Buscar 45: Encontrado: " + aluno45);
        } else {
            System.out.println("Buscar 45: Não encontrado");
        }

        Aluno aluno75 = tabelaHash.get(75);
        if (aluno75 != null) {
            System.out.println("Buscar 75: Encontrado: " + aluno75);
        } else {
            System.out.println("Buscar 75: Não encontrado");
        }

        Aluno removido = tabelaHash.remove(11);
        if (removido != null) {
            System.out.println("Removido: " + removido);
        } else {
            System.out.println("Remover: Aluno não encontrado");
        }

        System.out.println("Estado atual da tabela hash:");
        tabelaHash.imprimirTabela();
    }
}
