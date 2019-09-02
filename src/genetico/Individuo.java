package genetico;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class Individuo implements Comparable<Individuo> {

    private final Random random = new Random();
    private Double aptidao;
    private Double aptidaoMax;
    double pesoMaximo = 0;
    private final static int[] PESO = {1, 20, 3, 8, 5, 10};
    private final static int[] VALOR = {10, 15, 12, 13, 20, 30};

    private final int qtdTotal = 15;
    private int[] cromossomo;

    public Individuo() {

        do {
            cromossomo = new int[6];
            this.setCromossomo();
        } while (!validar());
        avaliar();
    }

    public Individuo(int[] genes) {

        cromossomo = genes;
        //testa se deve fazer mutacao
        do {
            if (random.nextDouble() <= Genetico.TAXADEMUTACAO) {
                int posAleatoria = random.nextInt(genes.length); //define gene que sera mutado
                mutacao(posAleatoria);
            }
        } while (!validar());
        avaliar();
    }

    private boolean validar() {
        double pesodo_cromo = 0.0;
        pesoMaximo = 0.0;
        for (int i = 0; i < 6; i++) {
            if (cromossomo[i] == 1) {
                pesodo_cromo += PESO[i];
            }
        }
        pesoMaximo = pesodo_cromo;
        return pesodo_cromo <= qtdTotal;
    }

    private void avaliar() {
        aptidao = 0.0;
        aptidaoMax = 0.0;
        for (int i = 0; i < 6; i++) {
            if (cromossomo[i] == 1) {
                aptidao += VALOR[i];
            }
            //System.out.println("print teste" + valor[i]  + " " +  aptidao);
        }
        aptidaoMax = aptidao;
    }

    private void mutacao(int posicao) {
        do {
            if (cromossomo[posicao] == 0) {
                cromossomo[posicao] = 1;
            } else if (cromossomo[posicao] == 1) {
                cromossomo[posicao] = 0;
            }

        } while (!validar());
    }

    public int[] getCromossomo() {
        return cromossomo;
    }

    public int[] getGenes() {
        return cromossomo;
    }

    private void setCromossomo() {
        boolean y = random.nextBoolean();
        for (int i = 0; i < 6; i++) {
            if (y == true) {
                cromossomo[i] = 1;
            } else if (y == false) {
                cromossomo[i] = 0;
            }

        }
    }

    public Double getAptidao() {
        return aptidao;
    }

    @Override
    public String toString() {
        return "Cromossomo " + Arrays.toString(getCromossomo()) + " Aptidao: " + aptidaoMax + " Peso: " + pesoMaximo + "\n";
    }

    @Override
    public int compareTo(Individuo i) {
        return this.aptidao.compareTo(i.aptidao);
    }
}
