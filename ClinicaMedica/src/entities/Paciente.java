package entities;

import java.time.LocalDate;

public class Paciente extends PessoaFisica {
	public Paciente(String nome, String CPF, LocalDate dataNascimento) {
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
	}
}
