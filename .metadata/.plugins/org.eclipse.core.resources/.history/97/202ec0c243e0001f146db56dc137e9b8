package entities;

import java.util.ArrayList;

public class RegistroCadastro {
	private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private static ArrayList<Medico> medicos = new ArrayList<Medico>();
	
	static private boolean situacaoCadastral(String CPF, String tipo) {
		if(tipo == "paciente") { 
			for(Paciente paciente : pacientes) {
				if(paciente.getCPF() == CPF) {
					return true;
				}
			}
		} else if (tipo == "medico"){
			for(Medico medico : medicos) {
				if(medico.getCPF() == CPF) {
					return true;
				}
			}
		}
		return false;
	}
	
	static public boolean addPaciente(Paciente paciente) {
		if(!situacaoCadastral(paciente.getCPF(), "paciente")) {
			pacientes.add(paciente);
			return true;
		}
		return false;
	}
	
	static public boolean addMedico(Medico medico) {
		if(!situacaoCadastral(medico.getCPF(), "medico")) {
			medicos.add(medico);
			return true;
		}
		return false;
	}
}
