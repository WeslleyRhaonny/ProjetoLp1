package usuarios;

import dados_academicos.Disciplina;
import dados_academicos.Historico;
import usuarios.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaDisciplinas.getDisciplinaPorIndice;

public class Aluno extends Usuario {
	//Para os alunos é preciso registrar a matrícula e histórico escolar.
	
	private String matricula;
	private Historico historico;
	// Cada aluno tem um histórico. O hitórico pode ser um array de disciplinas, e cada disciplina tem uma nota.
	private Disciplina[] disciplinas = new Disciplina[5];
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

		System.out.print("\nDigite o nome do aluno: ");
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

	public void cadastraNotas(Disciplina disciplinaSelecionada){
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o inice desejado:");
		int indice = leitor.nextInt();
		disciplinas = getDisciplinaPorIndice(indice-1);
		double arraynota[] = new double[3];
		for (int i = 0; i < 3; i++){
			System.out.println("Digite a nota " + (i+1) + ": ");
			arraynota[i] = leitor.nextDouble();
		}
		disciplinaSelecionada.setNotas(arraynota);
	}

}
