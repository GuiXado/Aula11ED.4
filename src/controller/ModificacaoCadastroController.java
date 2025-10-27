package controller;

import java.io.*;

import br.gui.listagenerica.Lista;
import model.Cadastro;

public class ModificacaoCadastroController {

	
	public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws IOException {
		Lista<Cadastro> lista = new Lista<>();
		
		BufferedReader ler = new BufferedReader(new FileReader("C:\\temp\\cadastro.csv"));
		
		String linha;
		while ((linha = ler.readLine()) != null) {
	        String[] dados = linha.split(";");
	        
	        String cpf = dados[0];
	        String nome = dados[1];
	        int idade = Integer.parseInt(dados[2]);
	        double limite = Double.parseDouble(dados[3].replace(",", "."));

	        if (idade >= idadeMin && idade <= idadeMax && limite > limiteCredito) {
	            Cadastro c = new Cadastro(cpf, nome, idade, limite);
	            try {
					lista.addLast(c);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
	        }
		}
		ler.close();
			
		String nomeArquivo = "Idade " + idadeMin + "-" + idadeMax + " limite " + limiteCredito + ".csv";	
		novoArquivo(lista,  nomeArquivo);
		
	}
	
	private void novoArquivo(Lista<Cadastro> lista, String nomeArquivo) throws IOException {
		File arquivo = new File("C:\\temp\\" + nomeArquivo);
		BufferedWriter gravar = new BufferedWriter(new FileWriter(arquivo));
		//StringBuffer buffer = new StringBuffer();
		int contador = 0;
		Cadastro cliente;
		int tam = lista.size();
		try {
			while (contador < tam) {
				cliente = lista.get(contador);
				
				gravar.write(cliente.CPF + ";" + cliente.nome + ";" + cliente.idade + ";" + 
						String.format("%.2f", cliente.limiteCredito).replace(".", ","));
				gravar.newLine();
				contador++;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			gravar.close();
		}
	}
	
}
