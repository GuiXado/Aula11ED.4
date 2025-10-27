package model;

public class Cadastro {
		public String CPF;
		public String nome;
		public int idade;
		public double limiteCredito;
		
		public Cadastro() {}

		public Cadastro(String CPF, String nome, int idade, double limiteCredito) {
			this.CPF = CPF;
			this.nome = nome;
			this.idade = idade;
			this.limiteCredito = limiteCredito;
		}

		@Override
		public String toString() {
			return "Cadastro [CPF= " + CPF + ", nome= " + nome + ", limiteCredito= " + limiteCredito + "]";
		}
	
}
