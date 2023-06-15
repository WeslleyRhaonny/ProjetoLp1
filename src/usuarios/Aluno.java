package usuarios;

import dados_academicos.Disciplina;

import java.util.ArrayList;
import java.util.Scanner;

import static main.Verificadores.*;


public class Aluno extends Usuario {
	//Para os alunos é preciso registrar a matrícula e histórico escolar.
	
	private String matricula;
	// Cada aluno tem um histórico. O hitórico pode ser um array de disciplinas, e cada disciplina tem uma nota.
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void cadastrarAluno() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nDigite o nome do aluno: ");
		String nome = scanner.nextLine();
		do{
			if(nome.length() == 0) {
				System.out.println("\nO campo nome não pode ser vazio. ");
				System.out.print("\nDigite o nome do aluno: ");
				nome = scanner.nextLine();
			}
		}while(nome.length() == 0);
		setNome(nome);

		System.out.print("Digite o email do aluno: ");
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
		System.out.print("Digite o telefone do aluno: ");
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
		

		System.out.print("Digite a matrícula do aluno: ");
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
			System.out.println("Digite as notas para a disciplina " + disciplina.getNome() + " considerando a ',' para os números decimais:");

			double[] arrayNotas = new double[3];
			for (int i = 0; i < 3; i++) {
				System.out.print("Digite a nota " + (i + 1) + ": ");
				double nota = 0;
				do {
					try{
						nota = leitor.nextDouble();
						arrayNotas[i] = nota;
						if(nota<0 || nota>10){
							System.out.println("A nota deve ser maior ou igual a 0 e menor ou igual a 10");
							System.out.println("Digite novamente a nota " + (i+1) + ": ");
							nota = leitor.nextDouble();
						}
					} catch (Exception e) {
                		System.out.println("\nNota inválida.");
						leitor.nextLine(); // Limpar o buffer
						i = i - 1;
        				continue;
            		}

				}while(nota<0 || nota>10);
			}
			disciplina.setNotas(arrayNotas);
			disciplina.calcularMedia();
			disciplinas.add(disciplina);
		}
	}
	public void gerarHistorico(){
		System.out.println("Nome do aluno: " + super.getNome());
		for(int i = 0; i<disciplinas.size();i++) {
			System.out.println(disciplinas.get(i));
		}
	}
}
