package tabelaHash;

import dados.Registro;

public class TabelaHash {
    public ListaEncadeada[] tabelaHash;
    public int tamanho;
    public int hash;

    public int tamanhoTabela;
    public int totalColisoes;

    public TabelaHash(int tamanhoTabela,int tamanho, int hash){
        this.tamanho = tamanho; //10, 100, 1000
        this.tamanhoTabela = tamanhoTabela;
        this.tabelaHash = new ListaEncadeada[tamanhoTabela];
        this.hash = hash;
        this.totalColisoes = 0;
    }

    //Seleciona o hash desejado a partir do construct
    public int h(int chave){
        if (hash == 0)
            return chave % tamanhoTabela;
        else if (hash == 1) {
            double numero_ouro = (2.2360679774997896964091736687313 - 1) / 2;
            return (int) (tamanhoTabela * ((chave * numero_ouro) % 1));
        }
        int fatorPrimo = 37;
        int resultado = (chave * fatorPrimo) % tamanhoTabela;

        return (resultado < 0) ? resultado + tamanhoTabela : resultado;
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

            totalColisoes += tabelaHash[i].inserirNo(conjunto[j].getCodigo());

            j++;
        }
    }

    public String buscaHashing(int chave){
        int i = h(chave);

        if(tabelaHash[i] == null)
            return "Null";
        else {
            No atual = tabelaHash[i].raiz;

            while (atual.getProximo() != null){
                atual = atual.getProximo();
            }

            if (atual.getRegistroNo().getCodigo() == chave)
                return "Posição: " + i + " | " + atual.getRegistroNo().getCodigo();

            return "Null";
        }
    }

    public void imprimirTabelaHash(){

        for (int i = 0; i < tamanhoTabela; i++){
            ListaEncadeada listaEncadeadaAtual = tabelaHash[i];

            if (tabelaHash[i] != null) {
                No atual = listaEncadeadaAtual.raiz;

                while (atual != null) {
                    System.out.print(atual.getRegistroNo().getCodigo() + " -> ");
                    atual = atual.getProximo();
                }
                //Total de colisões

                System.out.print("\n");
            }
        }
    }

}
