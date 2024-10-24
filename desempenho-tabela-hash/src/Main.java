/*
ESPECIFICAÇÕES
Tamanho de vetores escolhidas para a tabela hash : 10, 100 e 1000
Variações de função hash:
Conjuntos de dados: 100 mil, 500 mil, 1 milhão, 5 milhões e 100 milhões
 */

import dados.ArmazenamentoConjuntos;
import tabelaHash.TabelaHash;

import java.util.Scanner;

//Inicia o projeto
public class Main {


    public static void main(String[] args) {
        ArmazenamentoConjuntos am = new ArmazenamentoConjuntos();
        int tamanho1 = 1000000;
        int tamanho2 = 5000000;
        int tamanho3 = 20000000;

        int tamanhoTabela1 = 1000;
        int tamanhoTabela2 = 10000;
        int tamanhoTabela3 = 100000;

        am.inserirConjunto(tamanho1, 2432);
        //am.inserirConjunto(tamanho2, 46563);
        //am.inserirConjunto(tamanho3, 46563);

        //am.inserirConjuntos(tamanho1, 0, 3);
        //am.inserirConjuntos(tamanho2, 3, 6);
        //am.inserirConjuntos(tamanho3, 6, 9);

        permutacoes(tamanhoTabela1, tamanho1, 0, am);
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

        long start = System.currentTimeMillis();

        tabelaHash.iniciarInsercao(am.getUnicoConjuntoDados());

        long elapsedTimeMillis = System.currentTimeMillis()-start;

        System.out.println("Tempo total: " + elapsedTimeMillis / 1000);
        System.out.println(tabelaHash.totalColisoes);

        Scanner scanner = new Scanner(System.in);
        int codigo = 0;

        while (codigo != -1) {
            System.out.print("Digite o código: ");
            codigo = scanner.nextInt();

            String codigoEncontrado = tabelaHash.buscaHashing(codigo);
            System.out.println(codigoEncontrado);
        }

    }
}