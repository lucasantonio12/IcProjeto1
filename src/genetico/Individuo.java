package genetico;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lucas
 */
public class Individuo implements Comparable<Individuo> {

    private final Random random = new Random();
    private Double aptidao;
    long timeInicio;
    long timeFinal;
    private Double aptidaoMax;
    double pesoMaximo = 0;
    private final static int[] PESO = {1,10,2,20,40,50,1,2,3,8,7,9,18,14,1,5,16,24,15,16,13,25,24,32,12,17,19,9,6,8,7,4};
    private final static int[] VALOR = {2,45,12,26,23,15,17,18,19,4,2,3,5,6,7,8,9,14,15,50,14,16,23,25,28,49,12,1,8,7,8,9};

    private final int qtdTotal = 50;
    private int[] cromossomo;
    
    private final int quantidade = 32;
    public Individuo() {
        timeInicio = System.currentTimeMillis();
        do {
            cromossomo = new int[quantidade];
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
        for (int i = 0; i < cromossomo.length; i++) {
            if (cromossomo[i] == 1) {
                pesodo_cromo += PESO[i];
            }
        }
        pesoMaximo = pesodo_cromo;
        return pesodo_cromo <= qtdTotal;
    }

    private void avaliar() {
        aptidao = 0.0;     
        for (int i = 0; i < cromossomo.length; i++) {
            if (cromossomo[i] == 1) {
                aptidao += VALOR[i];
            }
            //System.out.println("print teste" + valor[i]  + " " +  aptidao);
        }
       
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
        timeFinal = System.currentTimeMillis();
        long elapsTime = timeFinal - timeInicio;
 
        return   " Aptidao: " + aptidao + " peso: " + pesoMaximo +" Tempo: "+ elapsTime + "\n";
    }

    @Override
    public int compareTo(Individuo i) {
        return this.aptidao.compareTo(i.aptidao);
    }
}
