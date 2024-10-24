package dados;

//Estrutura fundamental da tabela Hash
public class Registro {

    //Código que simboliza a chave (sem usar algum tipo de hash)
    private int codigo;
    public String valor = "";

    public Registro(int codigo){
        this.codigo = codigo;
    }

    //Retorna a código
    public int getCodigo(){
        return codigo;
    }

    //Altera o código
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
}
