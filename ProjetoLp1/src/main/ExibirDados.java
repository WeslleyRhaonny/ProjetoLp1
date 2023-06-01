package main;

import dados_academicos.Turma;
import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;

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

    public static void exibirProfessores(ArrayList<Professor> professores) {
        // Exibir dados dos alunos
        System.out.println("\nDados dos professores:");
        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }
}
