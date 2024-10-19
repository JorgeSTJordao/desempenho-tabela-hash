/*
ESPECIFICAÇÕES
Tamanho de vetores escolhidas para a tabela hash : 10, 100 e 1000
Variações de função hash:
Conjuntos de dados: 100 mil, 500 mil, 1 milhão, 5 milhões e 100 milhões
 */

import dados.ArmazenamentoConjuntos;

//Inicia o projeto
public class Main {
    public static void main(String[] args) {
        ArmazenamentoConjuntos am = new ArmazenamentoConjuntos();
        am.inserirConjuntos();

        System.out.println(am.getConjuntoDados()[0][0].codigo);
    }
}