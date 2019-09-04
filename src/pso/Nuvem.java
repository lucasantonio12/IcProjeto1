/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.ArrayList;

import java.util.Collections;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lucas
 */

public class Nuvem {

    private final ArrayList<Particula> particulas;

    static int[] melhorPosicaoNuvem;

    private double valorMelhorPosicaoNuvem;
    long timeInicio;
    long timeFinal;
    
    public Nuvem(int qtdParticulas) {
        timeInicio = System.currentTimeMillis();
        particulas = new ArrayList<>();
        for (int i = 0; i < PrincipalPSO.QTDPARTICULAS; i++) {
            particulas.add(new Particula());
        }

        melhorPosicaoNuvem = new int[PrincipalPSO.QTDATRIBUTOS];
    }
    
     
    
    public void executarPSO() {
        System.out.println("------EXECUTANDO PSO------");
        for (int i = 0; i < PrincipalPSO.QTDITERACOES; i++) {
         

            //verificar qual a melhor solucao da nuvem
            for (Particula p : particulas) {
                p.avaliarSolucao();//Cada particula verifica se seu melhor mudou
                
            }

            // ordenar nuvem (ordem decrescente)
            Collections.sort(particulas, Collections.reverseOrder());

            //Verifica se a particula com melhor solucao individual eh melhor que a da nuvem
            if (particulas.get(0).getValorMelhorPosicao() > valorMelhorPosicaoNuvem) {
                valorMelhorPosicaoNuvem = particulas.get(0).getValorMelhorPosicao();
                System.arraycopy(particulas.get(0).getMelhorPosicao(), 0, melhorPosicaoNuvem, 0, melhorPosicaoNuvem.length);
            }

            for (Particula p : particulas) {
                p.atualizarVelocidade();
                p.atualizarPosicao();
            }
            resumoIteracao(i);
        }
    }

    private void resumoIteracao(int iteracao) {
        timeFinal = System.currentTimeMillis();
        long elapsTime = timeFinal - timeInicio;
        System.out.println("Iteracao " + iteracao + "| Melhor " + valorMelhorPosicaoNuvem + " Tempo: " + elapsTime );
    }

    public ArrayList<Integer> getMelhorSolucaoNuvem() {
        ArrayList<Integer> selecionados = new ArrayList<>();
        for (int i = 0; i < melhorPosicaoNuvem.length; i++) {
            if (melhorPosicaoNuvem[i] == 0) {
                selecionados.add(i + 1); //[1;qtdAtributos]
            }
        }
        return selecionados;
    }

}
