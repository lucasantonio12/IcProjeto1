package genetico;

import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author lucas
 */
public class Individuo implements Comparable<Individuo>{
    
    private final Random random = new Random();
    private Double aptidao;
    
    private double qtdDinheiro;
    private double qtdPeso;
    
    public Individuo(){
        do{
            this.setQtdDinheiro();
            this.setQtdPeso();
        } while (!validar());
        avaliar();
    }
    
    public Individuo(double[] genes){
        qtdDinheiro = genes[0];
        qtdPeso = genes[1];
        
        if(random.nextDouble() <= Genetico.TAXADEMUTACAO){
            int posAleatoria = random.nextInt(genes.length);
            mutacao(posAleatoria);
        }
        avaliar();
    }
    
    private boolean validar(){
        return  qtdPeso<= 15;
    }
    
    private void avaliar() {
        aptidao = qtdDinheiro;
    }
    
     private void mutacao(int posicao) {
        do {
            if (posicao == 0) {
                this.setQtdDinheiro();
            } else if (posicao == 1) {
                this.setQtdPeso();
            }
        } while (!validar());
    }

    public void setQtdDinheiro() {
        this.qtdDinheiro = random.nextDouble();
    }

    public void setQtdPeso() {
        this.qtdPeso = random.nextDouble();
    }
    
    public double getAptidao(){
        return aptidao;
    }
    
    public double[] getGenes() {
        return new double[]{qtdDinheiro, qtdPeso};
    }
    
    
    @Override
    public String toString() {
        return "Cromossomo " + Arrays.toString(getGenes()) + " Aptidao: " + aptidao + "\n";
    }

    @Override
    public int compareTo(Individuo i) {
        return this.aptidao.compareTo(i.aptidao);
    }
}
