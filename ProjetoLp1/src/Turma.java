import java.util.ArrayList;

public class Turma {
	
	String serie;
	String turno;
	ArrayList<Aluno> alunos = new ArrayList<>();
	
	public Turma(String serie, String turno) {
		this.serie = serie;
		this.turno = turno;
	}
}
