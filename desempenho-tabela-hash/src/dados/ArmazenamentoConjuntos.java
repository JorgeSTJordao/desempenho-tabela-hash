package dados;

//Persistência dos dados (conjuntos)
public class ArmazenamentoConjuntos {
    final private Registro[][] conjuntoDados = new Registro[3][];

    //Especificação dos conjuntos
    private void criarConjuntos(int tamanhoVetor, int inicio, int fim){
        GeradorAleatorio geradorAleatorio = new GeradorAleatorio(tamanhoVetor);

        for (int i = inicio; i < fim; i++){
            conjuntoDados[i] = geradorAleatorio.inserirRegistros();
        }
    }

    //Inicializar a criação
    public void inserirConjuntos(){
        criarConjuntos(10, 0, 3);
    }

    //Retorna o conjunto
    public Registro[][] getConjuntoDados(){
        return conjuntoDados;
    }
}
