package dados_academicos;

import usuarios.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static main.CriaDisciplinas.getDisciplinaPorIndice;
import static main.CriaTurmas.getTurmaPorIndice;

public class Disciplina {
	// As disciplinas devem ter 3 notas (que podem ser dadas como array list).
	private String nome;
	private double notas[];
	private double media = 0;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina(String nome) {
		this.nome = nome;
		this.notas = new double[3];
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public void calcularMedia(){
		double somaAux = 0;
		for(int i=0; i<3;i++){
			somaAux += notas[i];
		}
		this.media = somaAux/3;
	}

	@Override
	public String toString() {
		String mediaFormatada = String.format("%.2f", media);
		return "Disciplina{" +
				"nome='" + nome + '\'' +
				", notas=" + Arrays.toString(notas) +
				", media=" + mediaFormatada +
				'}';
	}
}
