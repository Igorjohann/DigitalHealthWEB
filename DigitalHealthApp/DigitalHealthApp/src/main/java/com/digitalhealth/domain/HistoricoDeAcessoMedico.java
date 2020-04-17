package com.digitalhealth.domain;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.persistence.Embeddable;

import com.digitalhealth.credenciais.CredenciaisMedicos;






@Embeddable
public class HistoricoDeAcessoMedico {
	
		
		
	
	
	public static void gravaLista(ArrayList<Medico> lista, boolean isCSV) {
		FileWriter arq = null;		
		Formatter saida = null;		
		boolean deuRuim = false;	
		String nomeArquivo;			
		
		if (isCSV) {
			nomeArquivo= "Medico.csv";	
		}
		else {
			nomeArquivo= "Medico.txt";
		}
		
	
		try {
			arq = new FileWriter(nomeArquivo, true); 
			saida = new Formatter(arq);
		}
		catch (IOException erro) {
			System.err.println("Erro ao abrir arquivo");
			System.exit(1);  
		}
		
 
		try {
			
			for (Medico m : lista) {
				
				if (isCSV) {
					saida.format("%s;%s;%s%s%n",m.getNomeMedico(), m.getEmail(), m.getTelefone(), m.getCredenciais().getCrmMedico());	
				}
				else {
					saida.format(" %s %s %s %s %s $s %n",m.getNomeMedico(), m.getEmail(), m.getTelefone(),m.getEspecialidade(), m.getCpf(), m.getCredenciais().getCrmMedico());	
				}	
			}
		}
		catch (FormatterClosedException erro) {
			System.err.println("Erro ao gravar no arquivo");
	           deuRuim= true;
	    }
		finally { 
				  
			saida.close();
			try {
				arq.close();
			}
			catch (IOException erro) {
				System.err.println("Erro ao fechar arquivo.");
				deuRuim = true;
			}
			if (deuRuim) {
				System.exit(1);
			}
		}
	}
		
		
	public static void leExibeArquivo(boolean isCSV) {
		FileReader arq= null;		// objeto FileReader - representa o arquivo a ser lido
		Scanner entrada = null;		// objeto Scanner - para ler do arquivo
		String nomeArquivo;			// nome do arquivo
		boolean deuRuim= false;		// indica se deu erro
		
		if (isCSV) {
			nomeArquivo= "Medico.csv";	// nome do arquivo, se for CSV
		}
		else {
			nomeArquivo= "Medico.txt";	// nome do arquivo, se for TXT
		}

		// Abre o arquivo para leitura
		try {
			arq = new FileReader(nomeArquivo);
			if (isCSV) {
				// se o arquivo for CSV, usa como delimitador de campo o ';' e o fim de registro
				entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
			}
			else {
				// se o arquivo for TXT, usa como delimitador de campo o ' ' e o fim de registro
				entrada = new Scanner(arq);
			}
		}
		catch (FileNotFoundException erro) {
			System.err.println("Arquivo não encontrado");
			System.exit(1); // encerra o programa, com status de erro
		}
		
		// Lê os registros do arquivo e exibe os dados lidos na console
		try {
			// Exibe na console os títulos das colunas
			System.out.printf("%15s %15s %15s %15s\n", "NomeMedico", "email","telefone", "crm");
			// Enquanto tem registro a ser lido
			while (entrada.hasNext()) {
				String nomeMedico = entrada.next();
				String email = entrada.next();
				String telefone = entrada.next();
				String crm = entrada.next();
				System.out.printf("%15s%15s%15s%15s\n", nomeMedico, email, telefone, crm );
			
			}
		}
	    catch (NoSuchElementException erro)
	    {
	        System.err.println("Arquivo com problemas.");
	        deuRuim = true;
	    }
	    catch (IllegalStateException erro)
	    {
	        System.err.println("Erro na leitura do arquivo.");
	        deuRuim = true;
	    }
	 	finally {
	 		entrada.close();
	 		try {
	 			arq.close();
	 		}
	 		catch (IOException erro) {
				System.err.println("Erro ao fechar arquivo.");
				deuRuim = true;
			}
	 		if (deuRuim) {
	 			System.exit(1);
	 		}
	 	}
	}

	
//		public static void main(String[] args) {
//			
//			ArrayList<Medico> lista = new ArrayList <Medico>();
//			
//			Medico m1 = new Medico("Barbara", "991053227", "barbarasoa@", "cirurgião", 478700000 , new CredenciaisMedicos("52004", "chocolate"));
//			lista.add(m1);
//			Medico m2 = new Medico("Rodrigo", "991678527","rodrigo@", "geral", 478700000, new CredenciaisMedicos("54504", "abacaxi"));
//			lista.add(m2);
//			gravaLista(lista, false);
//			leExibeArquivo(false);
//			lista.clear();
//			
//		}
//	
		
	
	
		

		

}
