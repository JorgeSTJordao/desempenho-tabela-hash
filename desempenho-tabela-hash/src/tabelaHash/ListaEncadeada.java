package tabelaHash;

public class ListaEncadeada {

    public No raiz;

    public ListaEncadeada(){
        this.raiz = null;
    }

    public int inserirNo(int codigo){
        No no = new No();

        if (raiz == null){
            raiz = no;
            raiz.getRegistroNo().setCodigo(codigo);

            return 0;
        } else {
            //Inicia pelo nó raiz
            No atual = raiz;

            while (atual.getProximo() != null){
                atual = atual.getProximo();
            }

            //Atualiza o próximo valor, considerando que é um nó nulo
            atual.setProximo(no);
            atual = atual.getProximo();

            //Atualiza o registro do nó que antes era nulo
            atual.getRegistroNo().setCodigo(codigo);
        }
        return 1;
    }

}
