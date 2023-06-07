package usuarios;

import dados_academicos.Turma;
import main.CriaTurmas;
import usuarios.Funcionario;
import java.util.Scanner;

import static main.CriaTurmas.*;

public class Professor extends Funcionario {

	protected Turma turmasprof[];
	
	public Professor() {
		this.turmasprof = new Turma[2]; // Inicializa o array de turmas com tamanho 2
	}
	
	public double calculaSalario() {
		return super.salario*2.3;
	}
	
	public void cadastrarProf(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nDigite o nome do professor: ");
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

		System.out.println("\nProfessor cadastrado com sucesso");
	}

	public void vincularTurma(Professor professor) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nDigite o número da turma para vincular o professor: ");
		for (int i = 0; i < turmas.size(); i++) {
			Turma turma = turmas.get(i);
			System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
		}
		
		int indiceTurma=3;
		char verificador = 'n';
		
		do {
			
			indiceTurma = scanner.nextInt();
			Turma turmaSelecionada = getTurmaPorIndice(indiceTurma - 1);
			
			if (turmaSelecionada != null) {
				boolean isTurnoPar = indiceTurma % 2 == 0;
				boolean isTurmaSelecionadaTurnoPar = turmaSelecionada.getTurno().equals("Manhã");
				
				if(isTurnoPar == true && turmasprof[0] == null && turmaSelecionada.getProfessor()==null) {
					turmasprof[0]= turmaSelecionada;
					System.out.println("Turma vinculada!");
				}else if(isTurnoPar == false && turmasprof[1] == null && turmaSelecionada.getProfessor()==null) {
					turmasprof[1]= turmaSelecionada;
					System.out.println("Turma vinculada!");
				}else {
					System.out.println("Não foi possível vincular a essa turma.");
				}
				turmaSelecionada.setProfessor(professor);
			}
				
//				if ((isTurnoPar && !isTurmaSelecionadaTurnoPar) || (!isTurnoPar && isTurmaSelecionadaTurnoPar)) {
//					// Turma válida para vinculação
//					turmasprof[0] = turmaSelecionada;
//					turmaSelecionada.setProfessor(professor);
//					System.out.println("Professor vinculado à turma com sucesso!");
//				} else {
//					System.out.println("Turma inválida! Selecione uma turma com turno diferente.");
//				}
//			} else {
//				System.out.println("Número de turma inválido!");
//			} 
			
			if((turmasprof[0] == null || turmasprof[1] == null)) {
				System.out.println("\nDeseja vincular mais turmas? \nDigite 'S' para Sim ou 'N' para Não.");
				verificador = scanner.next().charAt(0);
				if(verificador == 'S' || verificador == 's') {
					System.out.println("\nDigite o número da turma para vincular o professor: ");
					for (int i = 0; i < turmas.size(); i++) {
						Turma turma = turmas.get(i);
						System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
					}
				}
			}
		}while(((indiceTurma<1 || indiceTurma>6) || verificador == 'S' || verificador == 's') && (turmasprof[0] == null || turmasprof[1] == null));
	}

	public String toString() {
    	StringBuilder turmasString = new StringBuilder();
    
    	for (Turma turma : turmasprof) {
        	if (turma != null) {
            	turmasString.append(turma.getSerie())
                	.append(" - ")
                	.append(turma.getTurno())
                	.append(", ");
        	}
    	}
    
    	String turmas = turmasString.toString();
    	if (!turmas.isEmpty()) {
        	turmas = turmas.substring(0, turmas.length() - 2); // Remove a vírgula e espaço extra no final
    	}

		String salarioFormatado = String.format("%.2f", calculaSalario());

    	return super.toString() + ", Número de Matrícula: " + getMatricula() + ", CPF: " + getCpf() + ", Salário: R$ " + salarioFormatado + ", Turmas: " + turmas;
	}
	
	//public String toString() {
		//return super.toString() + ", Número de Matrícula: " + getMatricula() + ", CPF: " + getCpf() + ", Salário: " + calculaSalario() + ", Turmas:" + turmasprof[0] ", " + turmasprof[1];
		// RESOLVER: Como mostrar a turma no toString do professor?
	//}
}
