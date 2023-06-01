package main;

import dados_academicos.Turma;
import main.ExibirDados;
import usuarios.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

import static main.CriaTurmas.*;
import static main.ExibirDados.exibirAlunos;
import static main.ExibirDados.exibirTurmas;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		criaTurmas();
		ArrayList<Aluno> alunos = new ArrayList<>();

		boolean continuar = true;
		while (continuar) {
			// Menu de opções
			System.out.println("\nMenu:");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Dados dos alunos");
			System.out.println("3. Dados das turmas");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
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
						System.out.println("Aluno adicionado com sucesso!");
					} else {
						System.out.println("Número de turma inválido!");
					}
					break;
				case 2:
					exibirAlunos(alunos);
					break;
				case 3:
					exibirTurmas();
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