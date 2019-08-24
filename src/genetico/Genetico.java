package genetico;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author lucas
 */
public class Genetico {
    //configuracao dos parametros do AG
    public static final double TAXADEMUTACAO = 0.05;
    static final double TAXADECRUZAMENTO = 0.9;
    
    static final boolean ELITISMO = true;
    static final boolean ESTAGNA = true; //controle de estagnacao
    static final double VALORESTAGNA = 200;
    
    static final int TAMANHODAPOPULACAO = 400;
    static final int MAXIMODEGERACOES = 1000;
    
    //--------------------------
    
    private Populacao populacao = new Populacao();
    private final Random r = new Random();
    private int contEstagnar;
    private double melhorAptidaoAnterior = -1;
    
    
    
}
