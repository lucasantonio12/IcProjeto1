/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.ArrayList;



/**
 *
 * @author lucas
 */
public class PrincipalPSO {
    static final double ALFA = 0.5; //inercia
    static final double BETA = 2.05; //memoria
    static final double GAMA = 2.05; //cooperacao
    static final double VMAX = 6; //velocidade maxima
    static final boolean VELCONTROL = true; //se controla ou nao a velocidade
    
    static final int QTDPARTICULAS = 1000;
    static final int QTDITERACOES = 400;
    static final int QTDATRIBUTOS = 6;   
  

     public static void main(String[] args) {
        Nuvem nuvemParticulas = new Nuvem(QTDPARTICULAS);
        nuvemParticulas.executarPSO();
        //ArrayList<Integer> selecionados = nuvemParticulas.getMelhorSolucaoNuvem();
        //FeatureSelection fs = new FeatureSelection(BASE.NOMEBASE, MODELO);
        //fs.removerAtributos(selecionados, true, "PSO");
        System.out.println("------PROCESSO CONCLUIDO------");
    }
}
