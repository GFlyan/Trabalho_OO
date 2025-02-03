package entities;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class RegistroCadastro {
	private static LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
	private static LinkedList<Medico> medicos = new LinkedList<Medico>();
	
	private static int procurarCadastro(String CPF, String tipo) {
		int position = 0;
		if(tipo == "paciente") { 
			for(Paciente paciente : pacientes) {
				if(paciente.getCPF().equals(CPF)) {
					return position;
				}
				position++;
			}
		} else if (tipo == "medico"){
			for(Medico medico : medicos) {
				if(medico.getCPF().equals(CPF)) {
					return position;
				}
				position++;
			}
		}
		return -1;//Caso o CPF não exista no sistema
	}
	
	private static int procurarCadastro2(String CRM, String tipo) { //polimorfismo
		int position = 0;
		if(tipo == "medico") { 
			for(Medico medico : medicos) {
				if(medico.getCRM().equals(CRM)) {
					return position;
				}
				position++;
			}
		}
		return -1;//Caso o CPF não exista no sistema
	}
	
	public static boolean createPaciente(Paciente paciente) {
		if(procurarCadastro(paciente.getCPF(), "paciente") == -1) {
			pacientes.add(paciente);
			return true;
		}
		return false;
	}
	
	public static boolean createMedico(Medico medico) {
		if(procurarCadastro(medico.getCPF(), "medico") == -1) {
			medicos.add(medico);
			return true;
		}
		return false;
	}
	
	public static void readPaciente(String CPF) {
		int position = procurarCadastro(CPF, "paciente");
		if(position != -1) {
			Paciente paciente = pacientes.get(position);	
			JOptionPane.showMessageDialog(null, "NOME: " + paciente.getNome() + "\n" + "CPF:" + paciente.getCPF());
		} else 
			JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	public static void readMedico(String CPF) {
		int position = procurarCadastro(CPF, "medico");	
		if(position != -1) {
			Medico medico= medicos.get(position);
			JOptionPane.showMessageDialog(null, "NOME: " + medico.getNome() + "\n" + "CPF:" + medico.getCPF() + "\n" + "CRM: " + medico.getCRM() + "\n" + "ESPECIALIDADE: " + medico.getEspecialidade());
		} else 
			JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	public static void updatePaciente(String CPF) {
		int position = procurarCadastro(CPF, "paciente");
		if(position != -1) {
			String optionStr;
			int optionInt;
			do {
				optionStr = JOptionPane.showInputDialog(null, "ATUALIZAR PACIENTE\n\n1 - NOME\n2 - CPF\n3 - DATA DE NASCIMENTO\n0 - VOLTAR");
				optionInt = Integer.parseInt(optionStr);
				switch (optionInt) {
				case 1:
					String updateNome = JOptionPane.showInputDialog("ATUALIZAR PACIENTE\n\nINFORME O NOVO NOME");
					pacientes.get(position).setNome(updateNome);
					JOptionPane.showMessageDialog(null, "NOME DO PACIENTE ATUALIZADO");
					break;

				case 2:
					String updateCPF = JOptionPane.showInputDialog("ATUALIZAR PACIENTE\n\nINFORME O NOVO CPF");
					int verificaCPF = procurarCadastro(updateCPF, "paciente");
					if(verificaCPF == -1) {
						pacientes.get(position).setCPF(updateCPF);
						JOptionPane.showMessageDialog(null, "CPF DO PACIENTE ATUALIZADO");
					} else 
						JOptionPane.showMessageDialog(null, "ATUALIZACAO DE CPF NEGADA\n\nCPF JA EXISTE NO SISTEMA");
					break;
					
				case 3:
					String updateDataNascimento = JOptionPane.showInputDialog("ATUALIZAR PACIENTE\n\nINFORME A DATA DE NASCIMENTO");
					pacientes.get(position).setDataNascimento(null);
					JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO DO PACIENTE ATUALIZADA");
					break;
					
				default:
					if(optionInt != 0) JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
					break;
				}
			} while (optionInt != 0);
		} else 
			JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	public static void updateMedico(String CPF) {
		int position = procurarCadastro(CPF, "medico");
		if(position != -1) {
			String optionStr;
			int optionInt;
			do {
				optionStr = JOptionPane.showInputDialog(null, "ATUALIZAR MEDICO\n\n1 - NOME\n2 - CPF\n3 - DATA DE NASCIMENTO\n4 - CRM\n5 - ESCPECIALIDADE\n0 - VOLTAR");
				optionInt = Integer.parseInt(optionStr);
				switch (optionInt) {
				case 1:
					String updateNome = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME O NOVO NOME");
					medicos.get(position).setNome(updateNome);
					JOptionPane.showMessageDialog(null, "NOME DO MEDICO ATUALIZADO");
					break;

				case 2:
					String updateCPF = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME O NOVO CPF");
					int verificaCPF = procurarCadastro(updateCPF, "paciente");
					if(verificaCPF == -1) {
						medicos.get(position).setCPF(updateCPF);
						JOptionPane.showMessageDialog(null, "CPF DO MEDICO ATUALIZADO");
					} else 
						JOptionPane.showMessageDialog(null, "ATUALIZACAO DE CPF NEGADA\n\nCPF JA EXISTE NO SISTEMA");
					break;
					
				case 3:
					String updateDataNascimento = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME A DATA DE NASCIMENTO");
					pacientes.get(position).setDataNascimento(null);
					JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO DO MEDICO ATUALIZADA");
					break;
					
				case 4:
					String updateCRM = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME O NOVO CPF");
					int verificaCRM = procurarCadastro2(updateCRM, "medico");
					if(verificaCRM == -1) {
						medicos.get(position).setCRM(updateCRM);
						JOptionPane.showMessageDialog(null, "CRM DO MEDICO ATUALIZADO");
					} else 
						JOptionPane.showMessageDialog(null, "ATUALIZACAO DE CRM NEGADA\n\nCPF JA EXISTE NO SISTEMA");				
					break;
					
				case 5:
					String updateEspecialidade = JOptionPane.showInputDialog("ATUALIZAR MEDICO\n\nINFORME A NOVA ESPECIALIDADE");
					medicos.get(position).setEspecialidade(updateEspecialidade);
					JOptionPane.showMessageDialog(null, "ESPECIALIDADE DO MEDICO ATUALIZADO");
					break;
					
				default:
					if(optionInt != 0) JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
					break;
				}
			} while (optionInt != 0);
		} else 
			JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	
	
	
	public static boolean deletePaciente(String CPF) {
		int position = procurarCadastro(CPF, "paciente");
		if(position != -1) {
			pacientes.remove(position);
			return true;
		}
		return false;
	}
	
	public static boolean deleteMedico(String CPF) {
		int position = procurarCadastro(CPF, "medico");
		if(position != -1) {
			medicos.remove(position);
			return true;
		}
		return false;
	}
	
	public static void accessPaciente(String CPF) {
		int position = procurarCadastro(CPF, "paciente");
		if(position != -1) {
			String optionStr;
			int optionInt;
			do {
				optionStr = JOptionPane.showInputDialog("\n1 - DADOS DO PACIENTE\n2 - HISTORICO MEDICO\n3 - AGENDAR CONSULTA\n0 - VOLTAR");
				optionInt = Integer.parseInt(optionStr);
				switch (optionInt) {
				case 1:
					readPaciente(CPF);
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				default:
					if(optionInt != 0) 
						JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
					break;
				}
			} while(optionInt != 0);
		}
		else JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	public static void accessMedico(String CPF) {
		int position = procurarCadastro(CPF, "medico");
		if(position != -1) {
			String optionStr;
			int optionInt;
			do {
				optionStr = JOptionPane.showInputDialog("\n1 - DADOS DO MEDICO\n2 - HISTORICO MEDICO\n0 - VOLTAR");
				optionInt = Integer.parseInt(optionStr);
				switch (optionInt) {
				case 1:
					readMedico(CPF);
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				default:
					if(optionInt != 0) 
						JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
					break;
				}
			} while(optionInt != 0);
		}
		else JOptionPane.showMessageDialog(null, "CPF FORNECIDO NAO EXISTE NO SISTEMA");
	}
	
	
	
	
	public static void readAllPacientes() {
		int cod = 1;
		if(pacientes.isEmpty()) JOptionPane.showMessageDialog(null, "NAO HA PACIENTES CADASTRADOS");
		for(Paciente paciente : pacientes) {
			if(cod > 1) {
				String continuarString;
				do{
					continuarString = JOptionPane.showInputDialog("1 - CONTINUAR\n0 - VOLTAR");
					if(continuarString.equals("1") || continuarString.equals("0")) break;
					JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
				} while(!continuarString.equals("1") && !continuarString.equals("0"));
				if(continuarString.equals("0")) break;
			}
			JOptionPane.showMessageDialog(null, "NOME: " + paciente.getNome() + "\n" + "CPF:" + paciente.getCPF() + "\n\n" + "POSICAO DO PACIENTE NO SISTEMA: " + cod++ );
		}
	}
	
	public static void readAllMedicos() {
		int cod = 1;
		if(medicos.isEmpty()) JOptionPane.showMessageDialog(null, "NAO HA MEDICOS CADASTRADOS");
		for(Medico medico : medicos) {
			if(cod > 1) {
				String continuarString;
				do{
					continuarString = JOptionPane.showInputDialog("1 - CONTINUAR\n0 - VOLTAR");
					if(continuarString.equals("1") || continuarString.equals("0")) break;
					JOptionPane.showMessageDialog(null, "OPCAO INVALIDA");
				} while(!continuarString.equals("1") && !continuarString.equals("0"));
				if(continuarString.equals("0")) break;
			}
			JOptionPane.showMessageDialog(null, "NOME: " + medico.getNome() + "\n" + "CPF:" + medico.getCPF() + "\n" + "CRM: " + medico.getCRM() + "\n" + "ESPECIALIDADE: " + medico.getEspecialidade() + "\n\n" +  "POSICAO DO MEDICO NO SISTEMA: " + cod++);
		}
	}

}
