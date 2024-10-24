package dados;

import java.util.Random;

//Gerador de conjuntos de número
public class GeradorAleatorio {

    public Registro[] conjuntoDados;
    public int tamanhoVetor;

    public GeradorAleatorio(int tamanhoVetor){
        this.tamanhoVetor = tamanhoVetor;
        this.conjuntoDados = new Registro[tamanhoVetor];
    }

    //Cria um conjunto de dados a partir do tamanho definido (Ex: 100 mil)
    public Registro[] inserirRegistros(Random random){

        for (int i = 0; i < tamanhoVetor; i++){
            int codigo = random.nextInt(1_000_000_000);

            Registro registro = new Registro(codigo);

            conjuntoDados[i] = registro;
        }

        return conjuntoDados;
    }

}
