package imd.ufrn.br.dao;

import java.util.ArrayList;

import imd.ufrn.br.controle.GeradorImpostoRenda;
import imd.ufrn.br.modelo.Pessoa;

public class PessoaDAO {
	
	private ArrayList<Pessoa> pessoas;
	
	public PessoaDAO() {
		this.pessoas = new ArrayList<>();
	}

    public void cadastrarPessoa(Pessoa pessoa) {
    	pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
    	pessoas.remove(pessoa);
    }
    
    public void listarPessoas() {
    	
    	System.out.println("\n-------------- LISTA DE PESSOAS --------------");
    	
    	for(Pessoa pessoa : pessoas) {
    		System.out.println("Nome: "+ pessoa.getNome());
    		System.out.print("Salário: ");
    		System.out.printf("%.2f", pessoa.getSalario());
    		System.out.println("\n" + pessoa.getConta());
    		System.out.println(pessoa.getSeguro());
    		System.out.println("---------------------------------------------\n");
    	}
    	
    }
    
    public void calcularTributosPessoas() {
    	GeradorImpostoRenda gerador = new GeradorImpostoRenda();
    	
    	System.out.println("-------------- TRIBUTOS DAS PESSOAS --------------");
    	
    	for(Pessoa pessoa : pessoas) {
    		System.out.println("Nome: "+ pessoa.getNome());
    		System.out.print("Tributos: ");
    		System.out.printf("%.2f", gerador.calculaValorTotalTributo(pessoa));
    		System.out.println("\n--------------------------------------------------\n");
    	}
    }
    
	
	public void imprimeImpostoTotal() {
		
		GeradorImpostoRenda gerador = new GeradorImpostoRenda();
		
		double totalImposto = 0;
		double maiorImposto = 0;
		double maiorValorSeguro = 0;
		
		Pessoa pessoaImposto = null;
		Pessoa pessoaBeneficiado = null;
		
		for(Pessoa pessoa : pessoas) {
			double auxImposto = gerador.calculaValorTotalTributo(pessoa);
			double auxSeguro = pessoa.getSeguro().getValor();
    		
    		if (auxImposto > maiorImposto) {
				maiorImposto = auxImposto;
				pessoaImposto = pessoa;
			}
			
			if (auxSeguro > maiorValorSeguro) {
				maiorValorSeguro = auxSeguro;
				pessoaBeneficiado = pessoa;
			}
			
    		totalImposto += auxImposto;
    	}
		
		System.out.println("-------------- IMPRIME IMPOSTO TOTAL --------------");
		System.out.println("Total de imposto a ser recolhido: " + totalImposto);
		System.out.println("Pessoa que pagará o maior imposto: " + pessoaImposto.getNome());
		System.out.println("Imposto a ser pago: "+ maiorImposto);
		System.out.println("Beneficiado com maior valor de seguro: " + pessoaBeneficiado.getNome());
		System.out.println("Valor do seguro: "+  maiorValorSeguro);
		System.out.println("---------------------------------------------------\n");
		
	}

}
