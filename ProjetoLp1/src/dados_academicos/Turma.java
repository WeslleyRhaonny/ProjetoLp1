package dados_academicos;

import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;

public class Turma {

	private String serie;
	private String turno;
	private Professor professor;
	private ArrayList<Aluno> alunos = new ArrayList<>();


	public Turma(String serie, String turno) {
		this.serie = serie;
		this.turno = turno;
	}
	
	public String getSerie() {
		return serie;
	}

	public String getTurno() {
		return turno;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public Professor getProfessor() {
		return professor;
	}
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public static Turma buscarTurmaPorIndice(int indice, ArrayList<Turma> turmas) {
		if (indice >= 0 && indice < turmas.size()) {
			return turmas.get(indice);
		} else {
			return null;
		}
	}
	
	public String toString() {
		return "Serie: " + serie + ", Turno: " + turno + ", Professor: " + professor + ", Alunos: " + alunos;
	}
}
