package dados_academicos;

import usuarios.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaDisciplinas.getDisciplinaPorIndice;
import static main.CriaTurmas.getTurmaPorIndice;

public class Disciplina {
	// As disciplinas devem ter 3 notas (que podem ser dadas como array list).
	protected String nome;
	private double notas[];
	private double media;

	protected ArrayList<Aluno> alunos;

	public Disciplina(String nome) {
		this.notas = new double[3];
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
}
