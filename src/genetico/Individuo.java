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
    
    private final static int [] qtdPeso = {1, 2, 3, 4, 5, 6};
    private final static int [] valor = {10, 15, 12, 13, 20, 30};
   
    
    private int qtdTotal = 25;
    private int[] cromossomo;
    private int somaPeso;
    
    public Individuo(){
        cromossomo = new int[qtdTotal];
        do{
            this.setCromossomo(cromossomo);
        } while (!validar());
        avaliar();
    }
    
    public Individuo(int[] cromossomo){
      
       for(int i = 0; i < cromossomo.length; i++){
           if(random.nextDouble() <= Genetico.TAXADEMUTACAO)
               mutacao(cromossomo[i]);         
        }
    }
    
    private boolean validar(){
        
        return  somaPeso <= qtdTotal;
    }
    
    private void avaliar() {
        aptidao = valor;
    }
    
     private void mutacao(int posicao) {
        do {
            if (cromossomo[posicao] == 1) {
                cromossomo[posicao] = 0;
            } else {
                 cromossomo[posicao] = 1;
            }
        } while (!validar());
    }

    public int[] getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(int[] cromossomo) {
        for (int i = 0; i < cromossomo.length; i++){
            if(random.nextBoolean()){
                cromossomo[i] = 1;
            }else{
                cromossomo[i] = 0;
            } 
        }
    }

    public void setQtdPeso(int qtdPeso) {
        this.qtdPeso = qtdPeso;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }
         
   
    public double getAptidao(){
        return aptidao;
    }
 
    @Override
    public String toString() {
        return "Cromossomo " + Arrays.toString(getCromossomo()) + " Aptidao: " + aptidao + "\n";
    }

    @Override
    public int compareTo(Individuo i) {
        return this.aptidao.compareTo(i.aptidao);
    }
}
