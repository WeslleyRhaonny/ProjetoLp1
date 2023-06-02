package usuarios;

import usuarios.Funcionario;

import java.util.Scanner;

public class Administrativo extends Funcionario {
    public void cadastrarAdm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do administrativo: ");
        String nome = scanner.nextLine();
        setNome(nome);

        System.out.print("Digite o email do administrativo: ");
        String email = scanner.nextLine();
        setEmail(email);

        System.out.print("Digite o telefone do administrativo: ");
        String telefone = scanner.nextLine();
        setTelefone(telefone);

        System.out.print("Digite a matrícula do administrativo: ");
        String matricula = scanner.nextLine();
        setMatricula(matricula);

        System.out.print("Digite o cpf do administrativo: ");
        String cpf = scanner.nextLine();
        setCpf(cpf);
    }
}
