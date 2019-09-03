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
public class Particula implements Comparable<Particula> {

    private final int[] posicaoAtual;
    private double valorPosicaoAtual;

    private final int[] melhorPosicao;
    private Double valorMelhorPosicao;

    private final double[] velocidade;

    private final static int[] PESO = {1, 20, 3, 8, 5, 10};
    private final static int[] VALOR = {10, 15, 12, 13, 20, 30};

    public Particula() {
        /*
        posicaoAtual = new int[];
        melhorPosicao = new int[];
        velocidade = new double[];

        valorMelhorPosicao = new Double(0);
         */
        posicaoAtual = new int[PrincipalPSO.QTDATRIBUTOS];
        melhorPosicao = new int[PrincipalPSO.QTDATRIBUTOS];
        velocidade = new double[PrincipalPSO.QTDATRIBUTOS];

        inicializarPosicao();
        inicializarVelocidade();
        valorMelhorPosicao = new Double(0);
    }

    private void inicializarPosicao() {
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (Math.random() < 0.5) {
                posicaoAtual[i] = 0;
            } else {
                posicaoAtual[i] = 1;
            }
        }
    }

    private boolean validar() {
        double pesodo_cromo = 0.0;

        for (int i = 0; i < 6; i++) {
            if (posicaoAtual[i] == 1) {
                pesodo_cromo += PESO[i];
            }
        }

        return pesodo_cromo <= 15;
    }

    private void inicializarVelocidade() {
        for (int i = 0; i < velocidade.length; i++) {
            velocidade[i] = 1;
        }
    }

    public ArrayList<Integer> getAtributos() {
        ArrayList<Integer> atributos = new ArrayList<>();
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (posicaoAtual[i] == 0) {
                atributos.add(i + 1); //[1;qtdAtributos]
            }
        }
        return atributos;
    }

    public void avaliarSolucao() {
        valorPosicaoAtual = 0.0;
   
        for (int i = 0; i < posicaoAtual.length; i++) {
            if (posicaoAtual[i] == 1) {
                valorPosicaoAtual += VALOR[i];
            }
            //System.out.println("print teste" + valor[i]  + " " +  aptidao);
        }
      
            if (valorPosicaoAtual > valorMelhorPosicao) {
                valorMelhorPosicao = valorPosicaoAtual;
                System.arraycopy(posicaoAtual, 0, melhorPosicao, 0, posicaoAtual.length);
            }
        
    }

    public void setValorPosicaoAtual(double v) {
        valorPosicaoAtual = v;
    }

    public void atualizarVelocidade() {
        for (int i = 0; i < velocidade.length; i++) {
            velocidade[i] = PrincipalPSO.ALFA * velocidade[i]
                    + PrincipalPSO.BETA * Math.random() * (melhorPosicao[i] - posicaoAtual[i])
                    + PrincipalPSO.GAMA * Math.random() * (Nuvem.melhorPosicaoNuvem[i] - posicaoAtual[i]);

            if (PrincipalPSO.VELCONTROL) {
                //limita a velocidade entre [-VMAX;VMAX]
                if (velocidade[i] > PrincipalPSO.VMAX) {
                    velocidade[i] = PrincipalPSO.VMAX;
                } else if (velocidade[i] < -PrincipalPSO.VMAX) {
                    velocidade[i] = -PrincipalPSO.VMAX;
                }
            }
        }
    }

    public void atualizarPosicao() {
        double s;
        for (int i = 0; i < posicaoAtual.length; i++) {
            //funcao sigmoid sobre a velocidade
            s = (1 / (1 + Math.exp(-velocidade[i])));

            if (Math.random() < s) {
                posicaoAtual[i] = 1;
            } else {
                posicaoAtual[i] = 0;
            }
        }
    }

    public double getValorPosicaoAtual() {
        return valorPosicaoAtual;
    }

    public double getValorMelhorPosicao() {
        return valorMelhorPosicao;
    }

    public int[] getMelhorPosicao() {
        return melhorPosicao;
    }

    //Compara as particulas pela melhor solucao que cada uma tem
    @Override
    public int compareTo(Particula o) {
          return valorMelhorPosicao.compareTo(o.getValorMelhorPosicao());
       
    }

}
