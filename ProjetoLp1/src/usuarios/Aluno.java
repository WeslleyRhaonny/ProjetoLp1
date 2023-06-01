package usuarios;

import dados_academicos.Historico;
import usuarios.Usuario;

import java.util.Scanner;

public class Aluno extends Usuario {
	//Para os alunos é preciso registrar a matrícula e histórico escolar.
	
	private String matricula;
	private Historico historico;
	// Cada aluno tem um histórico. O hitórico pode ser um array de disciplinas, e cada disciplina tem uma nota.

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public void cadastrarAluno() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome do aluno: ");
		String nome = scanner.nextLine();
		setNome(nome);

		System.out.print("Digite o email do aluno: ");
		String email = scanner.nextLine();
		setEmail(email);

		System.out.print("Digite o telefone do aluno: ");
		String telefone = scanner.nextLine();
		setTelefone(telefone);

		System.out.print("Digite a matrícula do aluno: ");
		String matricula = scanner.nextLine();
		setMatricula(matricula);
	}

	public String toString() {
		return super.toString() + ", Número de Matrícula: " + matricula;
	}
}
