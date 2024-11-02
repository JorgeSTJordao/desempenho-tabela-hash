package dados;

import java.util.Random;

//Persistência dos dados (conjuntos)
public class ArmazenamentoConjuntos {


    final private Registro[][] conjuntoDados = new Registro[3][];

    public void criarConjunto(int[] tamanhos){

        GeradorAleatorio geradorAleatorio;

        for (int i = 0; i < 3; i++){
            Random random = new Random(43);

            geradorAleatorio = new GeradorAleatorio(tamanhos[i]);

            conjuntoDados[i] = geradorAleatorio.inserirRegistros(random);
        }
    }

    public Registro[][] getUnicoConjuntoDados() {
        return conjuntoDados;
    }
}
