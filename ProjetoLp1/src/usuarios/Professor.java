package usuarios;

import dados_academicos.Turma;
import java.util.Scanner;

import static main.CriaTurmas.*;
import static main.Verificadores.*;

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
		do{
			if(nome.length() == 0) {
				System.out.println("\nO campo nome não pode ser vazio. ");
				System.out.print("\nDigite o nome do professor: ");
				nome = scanner.nextLine();
			}
		}while(nome.length() == 0);
		setNome(nome);

		System.out.print("Digite o email do professor: ");
		String email = scanner.nextLine();
        boolean verificaEmail = validaEmail(email);

        do {
			if (verificaEmail == false) {
            	System.out.println("\nEmail inválido. ");
				System.out.print("\nDigite um email no formato xxxx@xxx.xxx: ");
            	email = scanner.nextLine();
            	verificaEmail = validaEmail(email);
			}
        }while(verificaEmail == false);
		setEmail(email);

		System.out.println("Formato do número de telefone: 11 dígitos, (DD) + (9xxxxxxxx).");
		System.out.print("Digite o telefone do professor: ");
		String telefone = scanner.nextLine();
		telefone = telefone.replaceAll(" ", "");
		telefone = telefone.replaceAll("\\D", ""); // Remove todos os caracteres não numéricos
		boolean verificaTelefone = isNumeric(telefone);

		do {
			if (verificaTelefone == false || telefone.length() != 11) {
				System.out.println("\nNúmero de telefone inválido.");
				System.out.println("\nDigite um número de telefone com 11 dígitos, (DD) + (9xxxxxxxx).");
				telefone = scanner.nextLine();
				telefone = telefone.replaceAll(" ", "");
				telefone = telefone.replaceAll("\\D", "");
				verificaTelefone = isNumeric(telefone);
			}
		} while (verificaTelefone == false || telefone.length() != 11);
		setTelefone(telefone);

		System.out.print("Digite a matrícula do professor: ");
		String matricula = scanner.nextLine();
		boolean verificaMatricula = isNumeric(matricula);

        do {
			if (verificaMatricula == false) {
				System.out.println("\nMatrícula inválida. ");
				System.out.print("\nDigite uma matrícula apenas com dígitos numéricos: ");
				matricula = scanner.nextLine();
				verificaMatricula = isNumeric(matricula);
			}
        }while(verificaMatricula == false);
		setMatricula(matricula);

		System.out.print("Digite o cpf do professor: ");
		String cpf = scanner.nextLine();
		cpf = cpf.replaceAll(" ", "");
		cpf = cpf.replaceAll("\\D", ""); // Remove todos os caracteres não numéricos
		boolean verificaCpf = isNumeric(cpf);

		do {
			if (verificaCpf == false || cpf.length() != 11) {
				System.out.println("\nNúmero de cpf inválido.");
				System.out.println("\nDigite um cpf com 11 dígitos.");
				cpf = scanner.nextLine();
				cpf = cpf.replaceAll(" ", "");
				cpf = cpf.replaceAll("\\D", "");
				verificaCpf = isNumeric(cpf);
			}
		} while (verificaCpf == false || cpf.length() != 11);
		setCpf(cpf);

		System.out.println("\nProfessor cadastrado com sucesso");
		//scanner.close();
	}

	public void vincularTurma(Professor professor) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nDigite o número da turma para vincular o professor: ");
		for (int i = 0; i < turmas.size(); i++) {
			Turma turma = turmas.get(i);
			System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
		}
		
		char verificador = 'n';
		String numTurma = scanner.nextLine();
		int numTurmaInt = 1;
		
		boolean verificaNumTurma = isNumeric(numTurma);
		if (verificaNumTurma == true){
			numTurmaInt = Integer.parseInt(numTurma);
		}
		do {
			do{
				if (numTurmaInt <= 0 || numTurmaInt > 6 || verificaNumTurma == false){
					System.out.println("Turma inválida");
					System.out.println("\nDigite o número da turma para vincular o professor: ");
					numTurma = scanner.nextLine();
				}
				
				verificaNumTurma = isNumeric(numTurma);
				if (verificaNumTurma == true){
					numTurmaInt = Integer.parseInt(numTurma);
				}
			}while(numTurmaInt <= 0 || numTurmaInt > 6 || verificaNumTurma == false);
		
		
			Turma turmaSelecionada = getTurmaPorIndice(numTurmaInt - 1);
			
			if (turmaSelecionada != null) {
				boolean isTurnoPar = numTurmaInt % 2 == 0;
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

			
			if((turmasprof[0] == null || turmasprof[1] == null)) {
				System.out.println("\nDeseja vincular mais turmas? \nDigite 'S' para Sim ou 'N' para Não.");
				verificador = scanner.next().charAt(0);
				scanner.nextLine();
				//if(verificador == 'S' || verificador == 's') {
					//System.out.println("\nDigite o número da turma para vincular o professor: ");
					//for (int i = 0; i < turmas.size(); i++) {
						//Turma turma = turmas.get(i);
						//System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
					//}
				//}
			}
		}while(((numTurmaInt<1 || numTurmaInt>6) || verificador == 'S' || verificador == 's') && (turmasprof[0] == null || turmasprof[1] == null));
		//scanner.close();
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
	
}
