import dados.ArmazenamentoConjuntos;
import dados.Registro;
import tabelaHash.TabelaHash;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Random random = new Random(43);

        String[] tipoHash = {"Divisão", "Multiplicação", "Dobramento"};

        int[] tamanhosConjunto = {1000000, 5000000, 20000000};
        int[] tamanhosTabelaHash = {500000, 750000, 999999};
        int[] valoresEscolhidosEstaticos = new int[5];

        ArmazenamentoConjuntos am = new ArmazenamentoConjuntos();

        am.criarConjunto(tamanhosConjunto);

        //Tamanho da tabela hash
        for (int indiceTamanhoHash = 0; indiceTamanhoHash < 3; indiceTamanhoHash++){

            //Tamanho do conjunto
            for (int  indiceTamanho = 0; indiceTamanho < 3; indiceTamanho++){

                if (indiceTamanho == 0 && indiceTamanhoHash == 0) {

                    for (int z = 0; z < 5; z++){
                        int indiceAleatorio = random.nextInt(tamanhosConjunto[indiceTamanho]);

                        valoresEscolhidosEstaticos[z] = am.getUnicoConjuntoDados()[indiceTamanho][indiceAleatorio]
                                .getCodigo();
                    }
                }

                for (int codigoHash = 0; codigoHash < 3; codigoHash++){

                    System.out.println(
                            "Tipo de Hash: " + tipoHash[codigoHash] + "| " +
                            "Tamanho de Conjunto: " + tamanhosConjunto[indiceTamanho] + "| " +
                            "Tamanho de Tabela Hash: " + tamanhosTabelaHash[indiceTamanhoHash]
                    );

                    aplicarCombinacao(
                            codigoHash, //Tipo de hash
                            tamanhosConjunto[indiceTamanho], //Tamanho do conjunto
                            tamanhosTabelaHash[indiceTamanhoHash], //Tamanho da tabela
                            am.getUnicoConjuntoDados()[indiceTamanho], //Conjunto de dados
                            valoresEscolhidosEstaticos //Valores escolhidos aleatoriamento no início
                    );

                    System.out.println();
                }
            }
        }
    }

    public static void aplicarCombinacao(
            int tipoHash,
            int tamanhoConjunto,
            int tamanhoTabelaHash,
            Registro[] conjunto,
            int[] valoresEscolhidosEstaticos
    ) {
        TabelaHash tabelaHash = new TabelaHash(tamanhoTabelaHash, tamanhoConjunto, tipoHash);

        long inicioContagem = System.currentTimeMillis();

        tabelaHash.iniciarInsercao(conjunto);

        long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

        System.out.println("Tempo total para inserção: " + contagemFinalMilissegundos+ " ms") ;
        System.out.println("Nº total de Colisões: " + tabelaHash.totalColisoes + " colisões");

        for (int i = 0; i < 5; i++){
            tabelaHash.buscarValorAleatorio(valoresEscolhidosEstaticos[i]);
        }

    }
}