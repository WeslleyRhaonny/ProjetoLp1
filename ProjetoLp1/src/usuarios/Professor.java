package usuarios;

import usuarios.Funcionario;

public class Professor extends Funcionario {
	
	public double calculaSalario() {
		return super.salario*0.3;
	}
	
	public void cadastraProf(){
	}
}
