package lista_v2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem4 {

    public static int buscaBinaria(int[] array, int chave) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (array[meio] == chave) {
                return meio;
            } else if (array[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int tamanho = 100000;
        int[] array = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(10001);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um valor entre de 0 ate 10.000 para buscar: ");
        int chave = scanner.nextInt();

        long inicioSemOrdenacao = System.currentTimeMillis();
        int resultadoSemOrdenacao = buscaBinaria(array, chave);
        long fimSemOrdenacao = System.currentTimeMillis();

        if (resultadoSemOrdenacao != -1) {
            System.out.println("Valor " + chave + " encontrado (sem ordenação) na posição: " + resultadoSemOrdenacao);
        } else {
            System.out.println("Valor " + chave + " não encontrado (sem ordenação).");
        }

        long tempoSemOrdenacao = fimSemOrdenacao - inicioSemOrdenacao;
        System.out.println("Tempo da busca binária sem ordenação: " + tempoSemOrdenacao + " milissegundos");

        long inicioOrdenacao = System.currentTimeMillis();
        Arrays.sort(array);
        long fimOrdenacao = System.currentTimeMillis();

        long inicioComOrdenacao = System.currentTimeMillis();
        int resultadoComOrdenacao = buscaBinaria(array, chave);
        long fimComOrdenacao = System.currentTimeMillis();

        if (resultadoComOrdenacao != -1) {
            System.out.println("Valor " + chave + " encontrado (com ordenação) na posição:   " + resultadoComOrdenacao);
        } else {
            System.out.println("Valor " + chave + " não encontrado (com ordenação).");
        }

        long tempoComOrdenacao = fimComOrdenacao - inicioComOrdenacao;
        System.out.println("Tempo para busca binária com ordenação: " + tempoComOrdenacao + " milissegundos");

        long tempoOrdenacao = fimOrdenacao - inicioOrdenacao;
        System.out.println("Tempo para ordenar o vetor: " + tempoOrdenacao + " milissegundos");

        scanner.close();
    }
}
