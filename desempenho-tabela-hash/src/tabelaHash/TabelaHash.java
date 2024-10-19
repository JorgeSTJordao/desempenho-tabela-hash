package tabelaHash;

import dados.Registro;

public class TabelaHash {
    public Registro[] tabelaHash;
    public int tamanho;
    public int hash;

    public TabelaHash(int tamanho, int hash){
        this.tamanho = tamanho;
        this.tabelaHash = new Registro[tamanho];
        this.hash = hash;
    }

    //Seleciona o hash desejado a partir do construct
    public int h(int chave){
        return chave / tamanho;
    }

    public void iniciarInsercao(Registro[] conjunto){

        for (int i = 0; i < tamanho; i++){
            tabelaHash[i] = conjunto[i];
        }
    }

    public void insereHashing(int chave){

    }

    public int buscaHashing(int chave){
        int i = h(chave);

        while (tabelaHash[i].codigo != chave && tabelaHash[i] != null) {
            //
        }

        if(tabelaHash[i] == null)
            return -1;
        else
            return i;
    }

}
