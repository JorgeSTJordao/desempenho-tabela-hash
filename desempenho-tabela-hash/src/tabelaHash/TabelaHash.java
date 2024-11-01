package tabelaHash;

import dados.Registro;

public class TabelaHash {
    public ListaEncadeada[] tabelaHash;
    public int tamanho;
    public int tipoHash;

    public int tamanhoTabela;
    public int totalColisoes;

    public TabelaHash(int tamanhoTabela,int tamanho, int hash){
        this.tamanho = tamanho;
        this.tamanhoTabela = tamanhoTabela;
        this.tabelaHash = new ListaEncadeada[tamanhoTabela];
        this.tipoHash = hash;
        this.totalColisoes = 0;
    }

    //Seleciona o hash desejado a partir do construct
    public int h(int chave){
        if (tipoHash == 0)
            return chave % tamanhoTabela;
        else if (tipoHash == 1) {
            double numero_ouro = (2.2360679774997896964091736687313 - 1) / 2;
            return (int) (tamanhoTabela * ((chave * numero_ouro) % 1));
        }
        else {
            int parte1 = chave / 1000000; // 3 primeiros dígitos
            int parte2 = (chave / 1000) % 1000; // 3 dígitos do meio
            int parte3 = chave % 1000; // 3 últimos dígitos


            // Primeiramente, faremos a separação dos 9 digitos em 3 partes iguais
            // Agora, realizamos a soma destas 3 partes
            int soma_partes = parte1 + parte2 + parte3;

            // Por fim, retornamos o resto da divisão desta soma pelo tamanho da tabela
            return soma_partes % tamanhoTabela;
        }
    }

    //Transforma os registros em uma lista encadeada
    public void iniciarInsercao(Registro[] conjunto){
        int j = 0;

        while (j < tamanho){
            int i = h(conjunto[j].getCodigo());

            if (tabelaHash[i] == null) {
                ListaEncadeada listaEncadeada = new ListaEncadeada();
                tabelaHash[i] = listaEncadeada;
            }

            //Total de colisões
            totalColisoes += tabelaHash[i].inserirNo(conjunto[j].getCodigo());

            j++;
        }
    }


    public void buscarValorAleatorio(int codigo){

        int numComparacaos = 0;

        long inicioContagem = System.nanoTime();

        int posicao = h(codigo);

        No atual = tabelaHash[posicao].raiz;

        while (atual != null) {
            if (atual.getRegistroNo().getCodigo() == codigo){
                long contagemFinalMilissegundos = System.nanoTime() - inicioContagem;

                System.out.println(
                        "Código buscado: " + codigo + " | " +
                        "Posicão:" + posicao + " | " +
                        "Quantidade comparações: " + numComparacaos + " | " +
                        "Tempo levado: " + contagemFinalMilissegundos + " ns");

                return;
            }

            atual = atual.getProximo();
            numComparacaos += 1;

        }
    }

}
