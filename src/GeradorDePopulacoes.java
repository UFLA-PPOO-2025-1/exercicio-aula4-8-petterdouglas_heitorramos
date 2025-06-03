import java.util.List;
import java.util.Random;
import java.awt.Color;

public class GeradorDePopulacoes {
    // A probabilidade de uma raposa ser criada em qualquer posição da grade.
    private static final double PROBABILIDADE_CRIACAO_RAPOSA = 0.04;
    // A probabilidade de um coelho ser criado em qualquer posição.
    private static final double PROBABILIDADE_CRIACAO_COELHO = 0.08;
    private static final double PROBABILIDADE_CRIACAO_CACADORES = 0.02;
    // Número máximo de caçadores
    private static final int NUMERO_MAX_CACADORES = 50;

    /**
     * Define as cores de cada espécie de animal nas visões do simulador
     * 
     * @param visao
     */
    public static void definirCores(VisaoSimulador visao) {
        visao.definirCor(Coelho.class, Color.ORANGE);
        visao.definirCor(Raposa.class, Color.BLUE);
        visao.definirCor(Cacador.class, Color.RED);
    }

    /**
     * Povoa aleatoriamente o campo com seres vivos.
     */
    public static void povoar(Campo campo, List<Ator> seresVivos) {
        Random rand = Randomizador.obterRandom();
        campo.limpar();
        int num_cacadores = 0;
        for (int linha = 0; linha < campo.obterComprimento(); linha++) {
            for (int coluna = 0; coluna < campo.obterLargura(); coluna++) {
                double numeroAleatorio = rand.nextDouble();
                if (numeroAleatorio < PROBABILIDADE_CRIACAO_CACADORES && num_cacadores < NUMERO_MAX_CACADORES) {
                    Localizacao localizacao = new Localizacao(linha, coluna);
                    Cacador cacador = new Cacador(campo, localizacao);
                    seresVivos.add(cacador);
                    num_cacadores++;
                } else if (numeroAleatorio <= PROBABILIDADE_CRIACAO_RAPOSA) {
                    Localizacao localizacao = new Localizacao(linha, coluna);
                    Raposa raposa = new Raposa(true, campo, localizacao);
                    seresVivos.add(raposa);
                } else if (numeroAleatorio <= PROBABILIDADE_CRIACAO_COELHO) {
                    Localizacao localizacao = new Localizacao(linha, coluna);
                    Coelho coelho = new Coelho(true, campo, localizacao);
                    seresVivos.add(coelho);
                }
                // caso contrário cria blocos vazios
            }
        }
    }
}
