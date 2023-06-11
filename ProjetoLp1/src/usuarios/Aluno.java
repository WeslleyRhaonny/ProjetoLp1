package usuarios;

import dados_academicos.Disciplina;
import dados_academicos.Historico;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario {
	//Para os alunos é preciso registrar a matrícula e histórico escolar.
	
	private String matricula;
	private Historico historico;
	// Cada aluno tem um histórico. O hitórico pode ser um array de disciplinas, e cada disciplina tem uma nota.
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();

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
		scanner.close();
	}

	public String toString() {
		return super.toString() + ", Número de Matrícula: " + matricula;
	}

	public void cadastraNotas(Disciplina disciplina) {
		boolean disciplinaExistente = false;
		for (Disciplina d : disciplinas) {
			if (d.getNome().equals(disciplina.getNome())) {
				disciplinaExistente = true;
				break;
			}
		}
		if (disciplinaExistente==true) {
			System.out.println("Já há notas cadastradas para esta disciplina");
		}
		else {
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite as notas para a disciplina " + disciplina.getNome() + ":");

			double[] arrayNotas = new double[3];
			for (int i = 0; i < 3; i++) {
				double nota = 0;
				System.out.print("Digite a nota " + (i + 1) + ": ");
				nota = leitor.nextDouble();
				do {
					arrayNotas[i] = nota;
					if(nota<0 || nota>10){
						System.out.println("A nota deve ser maior ou igual a 0 e menor ou igual a 10");
						System.out.println("Digite novamente a nota " + (i+1) + ": ");
						nota = leitor.nextDouble();
					}
				}while(nota<0 || nota>10);
			}
			disciplina.setNotas(arrayNotas);
			disciplina.calcularMedia();
			disciplinas.add(disciplina);
			leitor.close();
		}
	}
	public void gerarHistorico(){
		System.out.println("Nome do aluno: " + super.getNome());
		for(int i = 0; i<disciplinas.size();i++) {
			System.out.println(disciplinas.get(i));
		}
	}
}
