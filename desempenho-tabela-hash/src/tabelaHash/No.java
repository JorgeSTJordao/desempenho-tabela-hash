package tabelaHash;

import dados.Registro;

public class No {

    private RegistroNo registroNo;
    private No proximo;

    public No(){
        registroNo = new RegistroNo(0);
        proximo = null;
    }

    public RegistroNo getRegistroNo(){
        return registroNo;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}
