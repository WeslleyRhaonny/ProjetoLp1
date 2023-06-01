package usuarios;

import usuarios.Funcionario;

import java.util.Scanner;

public class Administrativo extends Funcionario {
    public void cadastrarAdm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        setNome(nome);

        System.out.print("Digite o email do funcionário: ");
        String email = scanner.nextLine();
        setEmail(email);

        System.out.print("Digite o telefone do funcionário: ");
        String telefone = scanner.nextLine();
        setTelefone(telefone);

        System.out.print("Digite a matrícula do funcionário: ");
        String matricula = scanner.nextLine();
        setMatricula(matricula);

        System.out.print("Digite o cpf do funcionário: ");
        String cpf = scanner.nextLine();
        setCpf(cpf);
    }
}
