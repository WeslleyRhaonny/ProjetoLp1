package main;

import dados_academicos.Disciplina;
import dados_academicos.Turma;
import usuarios.Administrativo;
import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static main.CriaDisciplinas.*;
import static main.CriaTurmas.*;
import static main.ExibirDados.*;
import static main.Verificadores.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		criaTurmas(); // Chama método que cria as turmas especificadas.
		criaDisciplinas(); // Chama método que cria disciplinas especificadas.
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		ArrayList<Professor> professores = new ArrayList<>();
		ArrayList<Administrativo> administrativos = new ArrayList<>();

		//Intanciação das classes para testes
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno1.setNome("Eliane");
		aluno1.setEmail("eli@gmail.com");	
		aluno1.setTelefone("81992052310");
		aluno1.setMatricula("12345");
		aluno2.setNome("Weslley");
		aluno2.setEmail("weslley@gmail.com");	
		aluno2.setTelefone("83982052789");
		aluno2.setMatricula("56789");
		alunos.add(aluno1);
		alunos.add(aluno2);

		Professor professor1 = new Professor();
		Professor professor2 = new Professor();
		professor1.setNome("Herick");
		professor1.setEmail("herick@gmail.com");
		professor1.setTelefone("83994568745");
		professor1.setMatricula("125083");
		professor1.setCpf("12345678900");
		professor2.setNome("João");
		professor2.setEmail("joao@gmail.com");
		professor2.setTelefone("83984123785");
		professor2.setMatricula("895426");
		professor2.setCpf("10212578900");

		Turma turmaTeste1 = getTurmaPorIndice(0);
		Turma turmaTeste2 = getTurmaPorIndice(1);
		turmaTeste1.adicionarAluno(aluno1);
		turmaTeste2.adicionarAluno(aluno2);
		turmaTeste1.setProfessor(professor1);
		turmaTeste2.setProfessor(professor2);
		Turma[] turmas1 = new Turma[2];
		turmas1[0] = turmaTeste1;
		professor1.setTurmasprof(turmas1);
		Turma[] turmas2 = new Turma[2];
		turmas2[1] = turmaTeste2;
		professor2.setTurmasprof(turmas2);
		professores.add(professor1);
		professores.add(professor2);

		Administrativo administrativo1 = new Administrativo();
		Administrativo administrativo2 = new Administrativo();
		administrativo1.setNome("Mel");
		administrativo1.setEmail("mel@gmail.com");
		administrativo1.setTelefone("83991256481");
		administrativo1.setMatricula("15825");
		administrativo1.setCpf("12468748272");
		administrativo2.setNome("Jujuba");
		administrativo2.setEmail("jujuba@gmail.com");
		administrativo2.setTelefone("83965238978");
		administrativo2.setMatricula("18652");
		administrativo2.setCpf("10245869252");
		administrativos.add(administrativo1);
		administrativos.add(administrativo2);
		
		boolean continuar = true;
		while (continuar) {
			// Menu de opções
			System.out.println("\nMenu:");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Cadastrar professor");
			System.out.println("3. Cadastrar administrativo");
			System.out.println("4. Dados dos alunos");
			System.out.println("5. Dados das turmas");
			System.out.println("6. Dados dos professores");
			System.out.println("7. Dados dos administrativos");
			System.out.println("8. Folha de pagamento");
			System.out.println("9. Pesquisar usuário específico");
			System.out.println("10. Cadastrar notas de um aluno específico");
			System.out.println("11. Visualizar histórico de uma aluno específico");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = 0;
			do {
				try {
					opcao = scanner.nextInt();
					if (opcao < 0 || opcao > 11) {
						System.out.println("A opção deve ser um valor inteiro maior ou igual a 0 e menor ou igual a 11");
						System.out.println("Digite novamente a opção: ");
						continue; // Retorna ao início do loop
					} else {
						break; // Sai do loop se a opção for válida
					}
				} catch (InputMismatchException e) {
					System.out.println("\nOpção inválida.");
					System.out.println("Digite novamente a opção: ");
					scanner.nextLine(); // Limpa o buffer do scanner
					continue; // Retorna ao início do loop
				}
			} while (true);

			switch (opcao) {
				case 1:
					// Cadastra Aluno
					Aluno aluno = new Aluno();
					aluno.cadastrarAluno();
					alunos.add(aluno);
					System.out.println("Digite o número da turma para adicionar o aluno: ");
					for (int i = 0; i < turmas.size(); i++) {
						Turma turma = turmas.get(i);
						System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
					}
					scanner.nextLine();
					String numTurma = scanner.nextLine();
					int numTurmaInt = 1;
					
					boolean verificaNumTurma = isNumeric(numTurma);
					if (verificaNumTurma == true){
						numTurmaInt = Integer.parseInt(numTurma);
					}

					do{
						if (numTurmaInt <= 0 || numTurmaInt > 6 || verificaNumTurma == false){
							System.out.println("Turma inválida");
							System.out.println("\nDigite o número da turma para adicionar o aluno: ");
							numTurma = scanner.nextLine();
						}
						
						verificaNumTurma = isNumeric(numTurma);
						if (verificaNumTurma == true){
							numTurmaInt = Integer.parseInt(numTurma);
						}
					}while(numTurmaInt <= 0 || numTurmaInt > 6 || verificaNumTurma == false);
					
					Turma turmaSelecionada = Turma.buscarTurmaPorIndice(numTurmaInt - 1, turmas);

					if (turmaSelecionada != null) {
						turmaSelecionada.adicionarAluno(aluno);
						System.out.println("\nAluno adicionado com sucesso!");
					} else {
						System.out.println("Número de turma inválido!");
					}
					break;
					
				case 2:
					// Cadastra Professor
					Professor professor = new Professor();
					professor.cadastrarProf();
					professores.add(professor);
					professor.vincularTurma(professor);
					break;
					
				case 3:
					// Cadastra Administrativo
					Administrativo adm = new Administrativo();
					adm.cadastrarAdm();
					administrativos.add(adm);
					break;
				case 4:
					// Dados dos alunos
					exibirAlunos(alunos);
					break;
					
				case 5:
					exibindoTurmas();
					break;
					
				case 6:
					// Dados dos professores
					exibirProfessores(professores);
					break;
					
				case 7:
					// Dados dos administrativos
					exibirAdministrativos(administrativos);
					break;

				case 8:
					// Folha de pagamento
					double totalSalarios = 0.0;
				
					System.out.println("\nFolha de Pagamento:");
					System.out.println("\nProfessores:");
					for (Professor prof : professores) {
						System.out.printf("\n%s - Salário: R$ %.2f", prof.getNome(), prof.calculaSalario());
						totalSalarios += prof.calculaSalario();
					}
				
					System.out.println("\n\nFuncionários Administrativos:");
					for (Administrativo administrativo : administrativos) {
						System.out.printf("%s - Salário: R$ %.2f\n", administrativo.getNome(), administrativo.getSalario());
						totalSalarios += administrativo.getSalario();
					}
					
					System.out.printf("\nValor total da folha de pagamento: R$ %.2f\n", totalSalarios);
					break;
	
				case 9:
					// Pesquisar por usuário específico
					System.out.print("\nDigite o nome do usuário que deseja pesquisar: ");
					String nomeUsuario = scanner.next();
					boolean founded = false;
				
					for (Aluno aluno_a : alunos) {
						if (aluno_a.getNome().equalsIgnoreCase(nomeUsuario)) {
							System.out.println("\nDados do Aluno:");
							System.out.println(aluno_a);
							founded = true;
						}
					}

						for (Professor profes : professores) {
							if (profes.getNome().equalsIgnoreCase(nomeUsuario)) {
								System.out.println("\nDados do Professor:");
								System.out.println(profes);
								founded = true;
							}
						}

						for (Administrativo administrativo : administrativos) {
							if (administrativo.getNome().equalsIgnoreCase(nomeUsuario)) {
								System.out.println("\nDados do Administrativo:");
								System.out.println(administrativo);
								founded = true;
							}
						}
				
					if (!founded) {
						System.out.println("\nUsuário não encontrado!");
					}
					break;

				case 10:
					// Cadastrar notas de um aluno
					System.out.print("\nDigite o nome do aluno que deseja cadastrar notas: ");
					String nome_aluno = scanner.next();
					boolean finded = false;
					Aluno d_aluno = null;

					for (Aluno i_aluno : alunos) {
						if (i_aluno.getNome().equalsIgnoreCase(nome_aluno)) {
							d_aluno = i_aluno;
							finded = true;
						}
					}

					if (!finded) {
						System.out.println("\nUsuário não encontrado!");
						break;
					}

					System.out.println("1 - Português");
					System.out.println("2 - Matemática");
					System.out.println("3 - Ciências");
					System.out.println("4 - História");
					System.out.println("5 - Geografia");
					System.out.println("Digite o índice correspondente a disciplina.");
					int indice = scanner.nextInt();
					Disciplina disciplinaSelecionada = CriaDisciplinas.getDisciplinaPorIndice(indice - 1);
					d_aluno.cadastraNotas(disciplinaSelecionada);
					break;

				case 11:
					// Visualizar histórico de um aluno
					System.out.print("\nDigite o nome do aluno que deseja visualizar o histórico: ");
					String aluno_name = scanner.next();
					boolean n_finded = false;
					Aluno n_aluno = null;

					for (Aluno j_aluno : alunos) {
						if (j_aluno.getNome().equalsIgnoreCase(aluno_name)) {
							n_aluno = j_aluno;
							n_finded = true;
						}
					}

					if (!n_finded) {
						System.out.println("\nUsuário não encontrado!");
						break;
					}

					n_aluno.gerarHistorico();
					break;
				case 0:
					// Sair
					continuar = false;
					break;
					
				default:
					// Opção inválida
					System.out.println("Opção inválida!");
			}
		}
		scanner.close();
	}
}