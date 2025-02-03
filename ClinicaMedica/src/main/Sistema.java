package main;
import entities.*;

import java.time.LocalDate;

import javax.swing.JOptionPane;


public class Sistema {
	public static void main(String[] args) {
		String optionString;
		int optionBegin, optionPacienteBegin, optionMedicoBegin;
		do {
			optionString = JOptionPane.showInputDialog(null, "CLINICA MÉDICA\n\n"
														   + "1 - PORTAL DO PACIENTE\n"
														   + "2 - PORTAL DO MEDICO\n"
														   + "0 - SAIR DO SISTEMA");
			optionBegin = Integer.parseInt(optionString);
			switch (optionBegin) {
			case 1: {
				do {
					optionString = JOptionPane.showInputDialog(null, "PORTAL DO PACIENTE\n\n"
																   + "1 - CADASTRAR PACIENTE\n"
																   + "2 - VER PACIENTE\n"
																   + "3 - ATUALIZAR PACIENTE\n"
																   + "4 - REMOVER PACIENTE\n"
																   + "5 - ACESSAR PACIENTE\n"
																   + "6 - VER TODOS OS PACIENTES\n"
																   + "0 - VOLTAR");
					optionPacienteBegin = Integer.parseInt(optionString);
					
					switch (optionPacienteBegin) {
					case 1:
						
						String createNome = JOptionPane.showInputDialog("CADASTRAR PACIENTE\n\nINSIRA O NOME");
						String createCPF = JOptionPane.showInputDialog("CADASTRAR PACIENTE\n\nINSIRA O CPF");
						String createDataNascimento = JOptionPane.showInputDialog("CADASTRAR PACIENTE\n\nINSIRA A DATA DE NASCIMENTO");
						Paciente novoPaciente = new Paciente(createNome, createCPF, null);
						boolean createVerificacao = RegistroCadastro.createPaciente(novoPaciente);
						
						if(createVerificacao) 
							JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO");
						else 
							JOptionPane.showMessageDialog(null, "CADASTRO NAO REALIZADO\nCPF FORNECIDO JA EXISTE NO SISTEMA");
						
						break;
					
					case 2:
						String readCPF = JOptionPane.showInputDialog("VER PACIENTE\n\nINFORME O CPF DO PACIENTE");
						RegistroCadastro.readPaciente(readCPF);
						break;
					
					case 3:
						String updateCPF = JOptionPane.showInputDialog("ATUALIZAR PACIENTE\n\nINFORME O CPF DO PACIENTE");
						RegistroCadastro.updatePaciente(updateCPF);
						break;
						
					case 4:
						String removeCPF = JOptionPane.showInputDialog("REMOVER PACIENTE\n\nINFORME O CPF DO PACIENTE");
						boolean removeVerificacao = RegistroCadastro.deletePaciente(removeCPF);
						
						if(removeVerificacao) 
							JOptionPane.showMessageDialog(null, "REMOCAO REALIZADA COM SUCESSO"); 
						else 
							JOptionPane.showMessageDialog(null, "REMOCAO NAO REALIZADA\nCPF FORNECIDO NAO EXISTE NO SISTEMA");
						
						break;
						
					case 5:
						String accessCPF = JOptionPane.showInputDialog("ACESSAR PACIENTE\n\nINFORME O CPF DO PACIENTE");
						RegistroCadastro.accessPaciente(accessCPF);
						break;
						
					case 6:
						RegistroCadastro.readAllPacientes();
						break;
	
					default:
						if(optionPacienteBegin != 0) 
							JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
						break;
					}
				} while (optionPacienteBegin != 0);
				break;
			}
			case 2: {
				do {
					optionString = JOptionPane.showInputDialog(null, "PORTAL DO MEDICO\n\n"
																   + "1 - CADASTRAR MEDICO\n"
																   + "2 - VER MEDICO\n"
																   + "3 - ATUALIZAR MEDICO\n"
																   + "4 - REMOVER MEDICO\n"
																   + "5 - ACESSAR MEDICO\n"
																   + "6 - VER TODOS OS MEDICOS\n"
																   + "0 - VOLTAR");
					optionMedicoBegin = Integer.parseInt(optionString);
					
					switch (optionMedicoBegin) {
					case 1:
						
						String createNome = JOptionPane.showInputDialog("CADASTRAR MEDICO\n\nINSIRA O NOME");
						String createCPF = JOptionPane.showInputDialog("CADASTRAR MEDICO\n\nINSIRA O CPF");
						String createDataNascimento = JOptionPane.showInputDialog("CADASTRAR MEDICO\n\nINSIRA A DATA DE NASCIMENTO");
						String createCRM = JOptionPane.showInputDialog("CADASTRAR MEDICO\n\nINSIRA O CRM");
						String createEspecialidade = JOptionPane.showInputDialog("CADASTRAR MEDICO\n\nINSIRA A ESPECIALIDADE");
						Medico novoMedico = new Medico(createNome, createCPF, null, createCRM, createEspecialidade);
						boolean createVerificacao = RegistroCadastro.createMedico(novoMedico);
						
						if(createVerificacao) 
							JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO");
						else 
							JOptionPane.showMessageDialog(null, "CADASTRO NAO REALIZADO\nCPF FORNECIDO JA EXISTE NO SISTEMA");
						
						break;
						
					case 2:
						String readCPF = JOptionPane.showInputDialog("VER MEDICO\n\nINFORME O CPF DO MEDICO");
						RegistroCadastro.readMedico(readCPF);
						break;
					
					case 3:
						String updateCPF = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME O CPF DO MEDICO");
						RegistroCadastro.updateMedico(updateCPF);
						break;		
					case 4:
						String removeCPF = JOptionPane.showInputDialog("REMOVER MEDICO\n\nINFORME O CPF DO MEDICO");
						boolean removeVerificacao = RegistroCadastro.deleteMedico(removeCPF);
						
						if(removeVerificacao) 
							JOptionPane.showMessageDialog(null, "REMOCAO REALIZADA COM SUCESSO"); 
						else 
							JOptionPane.showMessageDialog(null, "REMOCAO NAO REALIZADA\nCPF FORNECIDO NAO EXISTE NO SISTEMA");
						
						break;
						
					case 5:
						String accessCPF = JOptionPane.showInputDialog("ACESSAR MEDICO\n\nINFORME O CPF DO MEDICO");
						RegistroCadastro.accessMedico(accessCPF);
						break;
						
					case 6:
						RegistroCadastro.readAllMedicos();;
						break;
	
					default:
						if(optionMedicoBegin != 0) 
							JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
						break;
					}
				} while (optionMedicoBegin != 0);
				break;
			}

			default:
				if(optionBegin != 0) {
					
				} else {
					JOptionPane.showMessageDialog(null, "SISTEMA FINALIZADO");
				}
			}
		} while(optionBegin != 0);
	}
}
