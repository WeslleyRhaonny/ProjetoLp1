package usuarios;

public class Funcionario extends Usuario {
	// Para os funcionários da escola (professores e administrativos) deve-se registrar CPF e salário.
	
	protected String cpf;
	protected String matricula;
	double salario = 1300; //O salário do professor e dos demais funcionários é baseado em uma quantidade fixa de salário mínimo.

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
	
}
