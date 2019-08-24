package genetico;

import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author lucas
 */
public class Individuo {
    
    private final Random r = new Random();
    private double aptidao;
    
    private double qtdDinheiro;
    private double qtdPeso;
    
    public Individuo(){
        do{
            this.qtdDinheiro();
            this.qtdPeso();
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
        double 
    }

    public void setQtdDinheiro(double qtdDinheiro) {
        this.qtdDinheiro = r.nextDouble();
    }

    public void setQtdPeso(double qtdPeso) {
        this.qtdPeso = r.nextDouble();
    }
    
    public double getAptidao(){
        return aptidao;
    }
}
