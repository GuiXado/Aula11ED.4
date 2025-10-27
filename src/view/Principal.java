package view;

import java.io.IOException;

import controller.ModificacaoCadastroController;

public class Principal {

	public static void main(String[] args) {
		ModificacaoCadastroController mc = new ModificacaoCadastroController();

        try {
			mc.novoCadastro(41, 60, 8000.00);
			mc.novoCadastro(31, 40, 5000.00);
			mc.novoCadastro(21, 30, 3000.00);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
