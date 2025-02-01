package entities;

import java.time.LocalDate;

public class Medico extends PessoaFisica{
	private String CRM, especialidade;
	
	public void setCRM(String CRM) {
		this.CRM = CRM;
	}
	
	public String getCRM() {
		return CRM;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public Medico(String nome, String CPF, LocalDate dataNascimento,String CRM, String especialidade) {
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.CRM = CRM;
		this.especialidade = especialidade;
	}
}
