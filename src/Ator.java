import java.util.*;;

public interface Ator {
    // método agir recebe uma lista de atores por parâmetro e não retorna nada.
    public void agir (List<Ator> atores);

    // função que retorna o estado atual do ator, se está ativo ou não
    public boolean estaAtivo ();
}