/*
ESPECIFICAÇÕES
Tamanho de vetores escolhidas para a tabela hash : 10, 100 e 1000
Variações de função hash:
Conjuntos de dados: 100 mil, 500 mil, 1 milhão, 5 milhões e 100 milhões
 */

import dados.ArmazenamentoConjuntos;
import dados.Registro;
import tabelaHash.TabelaHash;

import java.util.Random;
import java.util.Scanner;

//Inicia o projeto
public class Main {


    public static void main(String[] args) {
        ArmazenamentoConjuntos am = new ArmazenamentoConjuntos();

        int[] tamanhosTabelas = {500000, 750000, 999999}; //Tamanhos das tabelas hash
        int[] tamanhos = {1000000, 5000000, 20000000}; //Tamanhos dos conjutos
        String[] tipoHash = {"Divisão", "Multiplicação", "Divisão por nº primo"};

        //Tamanhos da tabela hash
        for (int i = 0; i < 3; i++){

            //Tamanhos dos conjuntos
            for (int j = 0; j < 3; j++){
                am.inserirConjunto(tamanhos[j], 125);

                for (int w = 0; w < 3; w++){
                    System.out.println("Tamanho da tabela hash: " + tamanhosTabelas[i] +
                            " | Tamanho dos conjuntos: " + tamanhos[i] +
                            " | Hash: " + tipoHash[w]);

                    permutacoes(tamanhosTabelas[i], tamanhos[j], w, am);

                    System.out.print("\n");
                }
            }
        }

        //am.inserirConjunto(tamanho1, 125);
        //am.inserirConjunto(tamanho2, 125);
        //am.inserirConjunto(tamanho3, 125);

        //permutacoes(tamanhoTabela1, tamanho1, 0, am);
        //permutacoes(tamanhoTabela1, tamanho1, 1, am);
        //permutacoes(tamanhoTabela1, tamanho1, 2, am);
        //permutacoes(tamanhoTabela1, tamanho2, 0, am);
        //permutacoes(tamanhoTabela1, tamanho2, 1, am);
        //permutacoes(tamanhoTabela1, tamanho2, 2, am);
        //permutacoes(tamanhoTabela1, tamanho3, 0, am);
        //permutacoes(tamanhoTabela1, tamanho3, 1, am);
        //permutacoes(tamanhoTabela1, tamanho3, 2, am);

        //permutacoes(tamanhoTabela2, tamanho1, 0, am);
        //permutacoes(tamanhoTabela2, tamanho1, 1, am);
        //permutacoes(tamanhoTabela2, tamanho1, 2, am);
        //permutacoes(tamanhoTabela2, tamanho2, 0, am);
        //permutacoes(tamanhoTabela2, tamanho2, 1, am);
        //permutacoes(tamanhoTabela2, tamanho2, 2, am);
        //permutacoes(tamanhoTabela2, tamanho3, 0, am);
        //permutacoes(tamanhoTabela2, tamanho3, 1, am);
        //permutacoes(tamanhoTabela2, tamanho3, 2, am);

        //permutacoes(tamanhoTabela3, tamanho1, 0, am);
        //permutacoes(tamanhoTabela3, tamanho1, 1, am);
        //permutacoes(tamanhoTabela3, tamanho1, 2, am);
        //permutacoes(tamanhoTabela3, tamanho2, 0, am);
        //permutacoes(tamanhoTabela3, tamanho2, 1, am);
        //permutacoes(tamanhoTabela3, tamanho2, 2, am);
        //permutacoes(tamanhoTabela3, tamanho3, 0, am);
        //permutacoes(tamanhoTabela3, tamanho3, 1, am);
        //permutacoes(tamanhoTabela3, tamanho3, 2, am);
    }

    public static void permutacoes(
            int tamanhoTabela,
            int tamanho,
            int hash,
            ArmazenamentoConjuntos am)
    {
        TabelaHash tabelaHash = new TabelaHash(tamanhoTabela, tamanho, hash);

        //Cálculo do tempo
        long inicioContagem = System.currentTimeMillis();

        tabelaHash.iniciarInsercao(am.getUnicoConjuntoDados());

        long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

        System.out.println("Tempo total (ms): " + contagemFinalMilissegundos);
        System.out.println("Total de colisões: " + tabelaHash.totalColisoes);

        int[] codigosAleatorios = getValoresAleatorios(am, tamanho);

        //Identificar 5 código diferentes + qtde comparações
        for (int i = 0; i < 5; i++){
            int codigo = codigosAleatorios[i];

            tabelaHash.buscarValorAleatorio(codigo);
        }

    }

    public static int[] getValoresAleatorios(ArmazenamentoConjuntos am, int tamanho){
        int[] valores = new int[5];

        Random selecao = new Random();

        for (int i = 0; i < 5; i++){
            int indiceSelecionado = selecao.nextInt(tamanho);
            valores[i] = am.getUnicoConjuntoDados()[indiceSelecionado].getCodigo();
        }

        return valores;
    }
}