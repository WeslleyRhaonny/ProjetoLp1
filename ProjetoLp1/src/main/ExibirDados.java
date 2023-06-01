package main;

import dados_academicos.Turma;
import usuarios.Aluno;

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
}
