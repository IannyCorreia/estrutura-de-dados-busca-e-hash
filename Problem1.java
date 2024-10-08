package lista_v2;

public class Problem1 {
    public static int buscaSequencial(int[] array, int chave){
        int i = 0;
        while(i< array.length){
            if(array[i] == chave){
                return i;
            }
            i++;
        }
        return -1;

    }
}
