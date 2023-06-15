package usuarios;

import java.util.Scanner;

import static main.Verificadores.*;

public class Administrativo extends Funcionario {

    @Override
    public String toString() {
        String salarioFormatado = String.format("%.2f", salario);
        return super.toString() +
                ", CPF: " + cpf +
                ", Matrícula: " + matricula +
                ", Salário: R$ " + salarioFormatado;
    }

    public void cadastrarAdm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o nome do administrativo: ");
        String nome = scanner.nextLine();
		do{
			if(nome.length() == 0) {
				System.out.println("\nO campo nome não pode ser vazio. ");
				System.out.print("\nDigite o nome do administrativo: ");
				nome = scanner.nextLine();
			}
		}while(nome.length() == 0);
        setNome(nome);

        System.out.print("Digite o email do administrativo: ");
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
        System.out.print("Digite o telefone do administrativo: ");
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

        System.out.print("Digite a matrícula do administrativo: ");
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

        System.out.print("Digite o cpf do administrativo: ");
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

        System.out.println("\nAdministrativo cadastrado com sucesso");
    }
}
