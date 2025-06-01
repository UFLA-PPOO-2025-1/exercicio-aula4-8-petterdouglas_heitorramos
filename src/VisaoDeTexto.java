import java.awt.Color;

public class VisaoDeTexto implements VisaoSimulador {

    private EstatisticasCampo estatisticas;

    public VisaoDeTexto() {
        estatisticas = new EstatisticasCampo();
    }

    @Override
    public void definirCor(Class<?> classeAnimal, Color cor) {
        // método não necessário nessa classe
    }

    @Override
    public boolean ehViavel(Campo campo) {
        return estatisticas.ehViavel(campo);
    }

    // Mostra no terminal a quantidade de raposas e coelhos existem em um
    // determinado passo
    @Override
    public void mostrarStatus(int passo, Campo campo) {
        estatisticas.reiniciar();
        System.out.println("Passo " + passo + " - " + estatisticas.obterDetalhesPopulacao(campo));
    }

    @Override
    public void reiniciar() {
        estatisticas.reiniciar();
    }

    @Override
    public void reabilitarOpcoes() {
        // método não necessário nessa classe
    }
}