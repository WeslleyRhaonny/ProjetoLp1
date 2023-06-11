package main;

import dados_academicos.Disciplina;

import java.util.ArrayList;

public class CriaDisciplinas {
    public static ArrayList<Disciplina> disciplina = new ArrayList<>();

    public static void criaDisciplinas(){
        disciplina.add(new Disciplina("Português"));
        disciplina.add(new Disciplina("Matemática"));
        disciplina.add(new Disciplina("Ciências"));
        disciplina.add(new Disciplina("História"));
        disciplina.add(new Disciplina("Geografia"));
    }

    public static Disciplina getDisciplinaPorIndice(int indice) {
        if (indice >= 0 && indice < disciplina.size()) {
            return disciplina.get(indice);
        }
        return null;
    }
}
