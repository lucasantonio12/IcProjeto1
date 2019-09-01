/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetico;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lucas
 */
public class Populacao {
    
     private final ArrayList<Individuo> individuos;
     private int qtdPreco = 0;
    public Populacao() {
        individuos = new ArrayList<>();
    }

    public void iniciarPopulacao(int tamPop) {
        for (int i = 0; i < tamPop; i++) {
            individuos.add(new Individuo());
        }
        ordenarPopulacao();
    }
    
   
    public void ordenarPopulacao() {
        //crescente para casos de minimização
        Collections.sort(individuos,Collections.reverseOrder());
    }

    public Individuo getIndividuo(int pos) {
        return individuos.get(pos);
    }

    // coloca um individuo na proxima posicao disponivel da populacao
    public void setIndividuo(Individuo individuo) {
        individuos.add(individuo);
    }

    public void setIndividuos(ArrayList<Individuo> filhos) {
        individuos.addAll(filhos);
    }

    // numero de individuos existentes na populacao
    public int getNumIndividuos() {
        return individuos.size();
    }

}
