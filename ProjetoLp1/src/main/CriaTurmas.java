package main;

import dados_academicos.Turma;

import java.util.ArrayList;

public class CriaTurmas {
    public static ArrayList<Turma> turmas = new ArrayList<>();

    public static void criaTurmas(){
        turmas.add(new Turma("2º ano", "Manhã"));
        turmas.add(new Turma("2º ano", "Tarde"));
        turmas.add(new Turma("3º ano", "Manhã"));
        turmas.add(new Turma("3º ano", "Tarde"));
        turmas.add(new Turma("4º ano", "Manhã"));
        turmas.add(new Turma("4º ano", "Tarde"));
    }
}