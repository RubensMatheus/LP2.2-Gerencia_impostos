package imd.ufrn.br.controle;

import imd.ufrn.br.modelo.Pessoa;

public class GeradorImpostoRenda {
	
	private double totalTributo; // deixa como atributo??
	
	public GeradorImpostoRenda() {
		// TODO Auto-generated constructor stub
	}
	
	public double calculaValorTotalTributo(Pessoa pessoa){
		totalTributo = pessoa.getConta().calculaTributos() +
					   pessoa.getSeguro().calculaTributos() + 
					   pessoa.calculaTributos();

		return totalTributo;
	}
	

}
