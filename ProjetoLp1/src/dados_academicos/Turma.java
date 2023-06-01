package dados_academicos;

import usuarios.Aluno;

import java.util.ArrayList;

public class Turma {

	private String serie;
	private String turno;
	private ArrayList<Aluno> alunos = new ArrayList<>();

	public String getSerie() {
		return serie;
	}

	public String getTurno() {
		return turno;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public Turma(String serie, String turno) {
		this.serie = serie;
		this.turno = turno;
	}

	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	public static Turma buscarTurmaPorIndice(int indice, ArrayList<Turma> turmas) {
		if (indice >= 0 && indice < turmas.size()) {
			return turmas.get(indice);
		} else {
			return null;
		}
	}
	public String toString() {
		return "Serie: " + serie + ", Turno: " + turno + ", Alunos: " + alunos;
	}
}
