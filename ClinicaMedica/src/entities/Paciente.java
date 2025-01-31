package entities;

import java.time.LocalDate;

public class Paciente extends PessoaFisica {
	public Paciente(String nome, String CPF, LocalDate dataNascimento) {
		setNome(nome);
		setCPF(CPF);
		setDataNascimento(dataNascimento);
	}
}
