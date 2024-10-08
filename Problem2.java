package lista_v2;
import java.util.ArrayList;

public class Problem2 {

    public static ArrayList<Integer> buscaSequencial(int[] array, int chave) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                indices.add(i); 
            }
        }
        return indices;
    }

    public static ArrayList<Integer> buscaBinaria(int[] array, int chave) {
        ArrayList<Integer> indices = new ArrayList<>();
        int posInicial = 0;
        int posFinal = array.length - 1;

        while (posInicial <= posFinal) {
            int posMeio = (posInicial + posFinal) / 2;
            
            if (array[posMeio] == chave) {
                indices.add(posMeio);
                
                int esquerda = posMeio - 1;
                while (esquerda >= 0 && array[esquerda] == chave) {
                    indices.add(esquerda);
                    esquerda--;
                }
                
                int direita = posMeio + 1;
                while (direita < array.length && array[direita] == chave) {
                    indices.add(direita);
                    direita++;
                }
                break; 
            } else if (array[posMeio] < chave) {
                posInicial = posMeio + 1;
            } else {
                posFinal = posMeio - 1;
            }
        }

        return indices; 
    }

    public static void main(String[] args) {
        int[] array = {18, 21, 27, 30, 38, 48, 51, 52, 62, 67, 74, 96};
        int chave = 48;

        ArrayList<Integer> resultadoSequencial = buscaSequencial(array, chave);
        System.out.println("Busca Sequencial - Chave " + chave + " encontrada nas posições: " + resultadoSequencial);

        ArrayList<Integer> resultadoBin = buscaBinaria(array, chave);
        System.out.println("Busca Binária - Chave " + chave + " encontrada nas posições: " + resultadoBin);
    }
}
