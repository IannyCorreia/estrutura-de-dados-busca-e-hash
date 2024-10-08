package lista_v2;

import java.util.Random;
import java.util.Scanner;

public class Problem3{

    public static void main(String[] args) {
        int tamanho = 100000;
        int[] array = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(10001);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor a ser buscado (entre 0 e 10.000): ");
        int chave = scanner.nextInt();

        long inicio = System.currentTimeMillis();
        int resultado = buscaSequencial(array, chave);
        long fim = System.currentTimeMillis();

        if (resultado != -1) {
            System.out.println("Valor " + chave + " encontrado na posição: " + resultado);
        } else {
            System.out.println("Valor " + chave + " não encontrado.");
        }

        long tempo = fim - inicio;
        System.out.println("Tempo para busca sequencial: " + tempo + " milissegundos");

        scanner.close();
    }

    public static int buscaSequencial(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                return i; 
            }
        }
        return -1; 
    }
}
