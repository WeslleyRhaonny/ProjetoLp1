package main;

import dados_academicos.Turma;
import main.ExibirDados;
import usuarios.Administrativo;
import usuarios.Aluno;
import usuarios.Professor;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaTurmas.*;
import static main.ExibirDados.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		criaTurmas();
		
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
			System.out.println("10. Visualizar histórico de um aluno específico");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			//faltando implementar 10
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					// Cadastra aluno
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
					// Cadastra professor
					Professor professor = new Professor();
					professor.cadastrarProf();
					professores.add(professor);
					professor.vincularTurma(professor);
					break;
					
				case 3:
					Administrativo adm = new Administrativo();
					adm.cadastrarAdm();
					administrativos.add(adm);
					break;
				case 4:
					exibirAlunos(alunos);
					break;
					
				case 5:
					System.out.println("Qual turma você deseja imprimir?\n");
					for (int i = 0; i < turmas.size(); i++) {
						Turma turma = turmas.get(i);
						System.out.println((i + 1) + ". " + turma.getSerie() + " - " + turma.getTurno());
					}
					System.out.println("7. Exibir todas as turmas");
					int indiceTurma = scanner.nextInt();
					if(indiceTurma<7 && indiceTurma>0) {
						exibirTurmaSelecionada(indiceTurma);
					} else if(indiceTurma == 7){
						exibirTurmas();
					}
					else
						System.out.println("Turma Inválida!");
					break;
					
				case 6:
					exibirProfessores(professores);
					break;
					
				case 7:
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
					boolean encontrado = false;
				
					for (Aluno aluno_a : alunos) {
						if (aluno_a.getNome().equalsIgnoreCase(nomeUsuario)) {
							System.out.println("\nDados do Aluno:");
							System.out.println(aluno_a);
							encontrado = true;
							break;
						}
					}
				
					if (!encontrado) {
						for (Professor profes : professores) {
							if (profes.getNome().equalsIgnoreCase(nomeUsuario)) {
								System.out.println("\nDados do Professor:");
								System.out.println(profes);
								encontrado = true;
								break;
							}
						}
					}
				
					if (!encontrado) {
						for (Administrativo administrativo : administrativos) {
							if (administrativo.getNome().equalsIgnoreCase(nomeUsuario)) {
								System.out.println("\nDados do Administrativo:");
								System.out.println(administrativo);
								encontrado = true;
								break;
							}
						}
					}
				
					if (!encontrado) {
						System.out.println("\nUsuário não encontrado!");
					}
					break;

				case 0:
					continuar = false;
					break;
					
				default:
					System.out.println("Opção inválida!");
			}
		}
	}
}