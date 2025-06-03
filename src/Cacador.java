import java.util.Iterator;
import java.util.List;

public class Cacador implements Ator {

    // A localização do animal.
    private Localizacao localizacao;
    // O campo ocupado.
    private Campo campo;
    //
    private static final int NUMERO_MAX_DISPAROS = 3;

    public Cacador(Campo campo, Localizacao localizacao) {
        this.campo = campo;
        this.localizacao = localizacao;
    }

    @Override
    public void agir(List<Ator> atores) {
        cacar();
        Localizacao novaLocalizacao = campo.localizacaoVizinhaAleatoria(localizacao);
        if (novaLocalizacao != null) {
            definirLocalizacao(novaLocalizacao);
        }
    }

    private void definirLocalizacao(Localizacao novaLocalizacao) {
        if (localizacao != null) {
            campo.limpar(localizacao);
        }
        localizacao = novaLocalizacao;
        campo.colocar(this, novaLocalizacao);
    }

    @Override
    public boolean estaAtivo() {
        return true;
    }

    public void cacar() {
        List<Localizacao> vizinhas = campo.localizacoesVizinhas(localizacao);
        Iterator<Localizacao> it = vizinhas.iterator();
        int tiros = 0;

        while (it.hasNext() && tiros < NUMERO_MAX_DISPAROS) {
            Localizacao onde = it.next();
            Object alvo = campo.obterObjetoEm(onde);
            if (alvo instanceof Coelho) {
                Coelho coelho = (Coelho) alvo;
                if (coelho.estaAtivo()) {
                    coelho.morrer();
                    tiros++;
                }
            } else if (alvo instanceof Raposa) {
                Raposa raposa = (Raposa) alvo;
                if (raposa.estaAtivo()) {
                    raposa.morrer();
                    tiros++;
                }
            }
        }
    }
}
