package usuarios;

import dados_academicos.Turma;
import main.CriaTurmas;
import usuarios.Funcionario;
import java.util.Scanner;

import static main.CriaTurmas.*;
public class Professor extends Funcionario {

	private Turma turmasprof[];
	public Professor() {
		this.turmasprof = new Turma[2]; // Inicializa o array de turmas com tamanho 2
	}
	public double calculaSalario() {
		return super.salario*0.3;
	}
	
	public void cadastrarProf(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome do professor: ");
		String nome = scanner.nextLine();
		setNome(nome);

		System.out.print("Digite o email do professor: ");
		String email = scanner.nextLine();
		setEmail(email);

		System.out.print("Digite o telefone do professor: ");
		String telefone = scanner.nextLine();
		setTelefone(telefone);

		System.out.print("Digite a matrícula do professor: ");
		String matricula = scanner.nextLine();
		setMatricula(matricula);

		System.out.print("Digite o cpf do professor: ");
		String cpf = scanner.nextLine();
		setCpf(cpf);

		System.out.println("Professor cadastrado com sucesso");
	}

	public void vincularTurma(Professor professor) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o número da turma para vincular o professor: ");
		for (int i = 0; i < turmas.size(); i++) {
			Turma turma = turmas.get(i);
			System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
		}

		int indiceTurma = scanner.nextInt();
		Turma turmaSelecionada = getTurmaPorIndice(indiceTurma - 1);

		if (turmaSelecionada != null) {
			boolean isTurnoPar = indiceTurma % 2 == 0;
			boolean isTurmaSelecionadaTurnoPar = turmaSelecionada.getTurno().equals("Manhã");

			if ((isTurnoPar && !isTurmaSelecionadaTurnoPar) ||
					(!isTurnoPar && isTurmaSelecionadaTurnoPar)) {
				// Turma válida para vinculação
				turmasprof[0] = turmaSelecionada;
				turmaSelecionada.setProfessor(professor);
				System.out.println("Professor vinculado à turma com sucesso!");
			} else {
				System.out.println("Turma inválida! Selecione uma turma com turno diferente.");
			}
		} else {
			System.out.println("Número de turma inválido!");
		}
	}
}
