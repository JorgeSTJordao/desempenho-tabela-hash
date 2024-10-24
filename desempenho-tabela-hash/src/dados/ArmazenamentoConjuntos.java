package dados;

import java.util.Random;

//Persistência dos dados (conjuntos)
public class ArmazenamentoConjuntos {
    final private Registro[][] conjuntoDados = new Registro[9][];
    private Registro[] unicoConjuntoDados;

    //Retorna uma lista com os 9 conjuntos, porém sem mudança de SEED
    private void criarConjuntos(int tamanhoVetor, int inicio, int fim, int seed){
        GeradorAleatorio geradorAleatorio = new GeradorAleatorio(tamanhoVetor);

        for (int i = inicio; i < fim; i++){
            Random random = new Random(seed);

            conjuntoDados[i] = geradorAleatorio.inserirRegistros(random);
        }
    }

    //Retorna um único conjunto, porém o SEED é escolhido e de forma manual a cada execução
    private void criarConjunto(int tamanhoVetor, int seed){
        GeradorAleatorio geradorAleatorio = new GeradorAleatorio(tamanhoVetor);

        unicoConjuntoDados = new Registro[tamanhoVetor];

        Random random = new Random(seed);

        unicoConjuntoDados = geradorAleatorio.inserirRegistros(random);
    }
    //Inicializar a criação
    //100 mil, 0 - 3
    //500 mil, 3 - 6
    //1 milhão, 6 - 9
    //5 milhões, 9 - 12
    //100 milhões, 12 - 15
    public void inserirConjuntos(int tamanho, int inicio, int fim, int seed){
        //criarConjuntos(tamanho, inicio, fim, seed);
    }

    public void inserirConjunto(int tamanho, int seed) {
        criarConjunto(tamanho, seed);
    }


        //Retorna o conjunto
    public Registro[][] getConjuntoDados(){
        return conjuntoDados;
    }

    public Registro[] getUnicoConjuntoDados() { return unicoConjuntoDados; }
}
