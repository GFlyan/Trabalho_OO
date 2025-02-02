package entities;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.LinkedList;

public class PessoaFisica {
	protected String nome, CPF;
	protected LocalDate dataNascimento;
	protected LinkedList<Consulta> historicoMedico = new LinkedList<Consulta>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
				   
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void addConsulta(Consulta consulta) {
		historicoMedico.add(consulta);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void getHistoricoMedico() {
		if(historicoMedico.size() > 0) {
			for(Consulta consultas : historicoMedico) {
				System.out.println(consultas);
			}
		}
	}
}
