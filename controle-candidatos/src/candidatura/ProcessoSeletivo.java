package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args)
    {
        String[] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};
        for (String candidato : candidatos) {

        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu= false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else {
                System.out.println("Candidato " + candidato + " atendeu a ligação");
            }

        } while (continuarTentando && tentativasRealizadas<3);
        if (atendeu)
            System.out.println("Conseguimos contato com o " + candidato + "na tentativa " + tentativasRealizadas);
        else
            System.out.println("Não onseguimos contato com o " + candidato + ", numero maximo de tentativas " + tentativasRealizadas);
    }

    //Metodo auxiliar para ligação
    static  boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};
        System.out.println("Candidatos Selecionados:");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° " + (indice + 1) + " é: " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos(){
        String[] candidatos = {"João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " Salário Pretendido: " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
         else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");

        }
    }
}