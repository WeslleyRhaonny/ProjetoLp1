package usuarios;

import usuarios.Usuario;

public class Funcionario extends Usuario {
	// Para os funcionários da escola (professores e administrativos) deve-se registrar CPF e salário.
	
	String cpf;
	double salario = 1300; //O salário do professor e dos demais funcionários é baseado em uma quantidade fixa de salário mínimo.
	
	
}
