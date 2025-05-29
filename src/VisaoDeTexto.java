import java.awt.Color;

public class VisaoDeTexto implements VisaoSimulador {

    private EstatisticasCampo estatisticas;

    public VisaoDeTexto(){
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

    @Override
    public void mostrarStatus(int passo, Campo campo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarStatus'");
    }

    @Override
    public void reiniciar() {
        
    }

    @Override
    public void reabilitarOpcoes() {
        // método não necessário nessa classe
    }
} 