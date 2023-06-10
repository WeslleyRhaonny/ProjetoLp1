package main;

import dados_academicos.Disciplina;
import dados_academicos.Turma;
import usuarios.Administrativo;
import usuarios.Aluno;
import usuarios.Professor;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static main.CriaTurmas.getTurmaPorIndice;

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

    public static void exibirHistorico(Aluno aluno, ArrayList<Disciplina> disciplinas){

    }

}
