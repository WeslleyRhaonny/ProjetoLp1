package main;

import dados_academicos.Disciplina;
import dados_academicos.Turma;
import usuarios.Administrativo;
import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaDisciplinas.*;
import static main.CriaTurmas.*;
import static main.ExibirDados.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		criaTurmas(); // Chama método que cria as turmas especificadas.
		criaDisciplinas(); // Chama método que cria disciplinas especificadas.
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		ArrayList<Professor> professores = new ArrayList<>();
		ArrayList<Administrativo> administrativos = new ArrayList<>();
		
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
			int opcao = scanner.nextInt();

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

					int numTurma = scanner.nextInt();
					Turma turmaSelecionada = Turma.buscarTurmaPorIndice(numTurma - 1, turmas);

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
						System.out.printf("%s - Salário: R$ %.2f", prof.getNome(), prof.calculaSalario());
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
			scanner.close();
		}
	}
}