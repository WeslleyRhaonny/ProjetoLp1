package main;

import dados_academicos.Turma;
import usuarios.Administrativo;
import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaTurmas.getTurmaPorIndice;
import static main.CriaTurmas.turmas;


public class ExibirDados {
	
	public static void exibirAlunos(ArrayList<Aluno> alunos) {
        // Exibir dados dos alunos
        System.out.println("\nDados dos Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public static void exibirTurmas() {

        // Exibir dados das turmas
        System.out.println("\nDados das Turmas:");
        for (Turma turma : CriaTurmas.turmas) {
            System.out.println(turma);
        }
    }
    
    public static void exibindoTurmas() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Qual turma você deseja imprimir?\n");
		for (int i = 0; i < turmas.size(); i++) {
			Turma turma = turmas.get(i);
			System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
		}
		System.out.println("7. Exibir todas as turmas");
		int indiceTurma = scanner.nextInt();
		if(indiceTurma<7 && indiceTurma>0) {
			exibirTurmaSelecionada(indiceTurma);
		} else if(indiceTurma == 7){
			exibirTurmas();
		}
		else
			System.out.println("Turma Inválida!");
    }

    public static void exibirTurmaSelecionada(int indiceTurma) {

        // Exibir dados das turmas
        System.out.println("\nDados das Turmas:");
        System.out.println(getTurmaPorIndice(indiceTurma-1));
    }

    public static void exibirProfessores(ArrayList<Professor> professores) {
        // Exibir dados dos alunos
        System.out.println("\nDados dos professores:");
        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }
    
    public static void exibirAdministrativos(ArrayList<Administrativo> administrativos) {
    	System.out.println("\nDados dos Administrativos:");
    	for(Administrativo administrativo : administrativos) {
    		System.out.println(administrativo);
    	}
    }

}
