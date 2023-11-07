package dao;

import modelo.Pessoa;
import controle.GeradorImpostoRenda;
import java.util.ArrayList;

public class PessoaDAO {
	
	private ArrayList<Pessoa> pessoas;
	private GeradorImpostoRenda gerador;
	
	public PessoaDAO() {
		this.pessoas = new ArrayList<>();
		this.gerador = new GeradorImpostoRenda();
	}

    public void cadastrarPessoa(Pessoa pessoa) {
    	pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
    	pessoas.remove(pessoa);
    }
    
    public void listarPessoas() {
    	
    	System.out.println("-------------- LISTA DE PESSOAS --------------");
    	
    	for(Pessoa pessoa : pessoas) {
    		System.out.println("Nome: "+ pessoa.getNome() + "Salário: ");
    		System.out.printf("%.2f", pessoa.getSalario());
    		System.out.println(pessoa.getConta());
    		System.out.println(pessoa.getSeguro());
    		System.out.println("---------------------------------------------");
    	}
    	
    }
    
    public void calcularTributosPessoas() {
    	System.out.println("-------------- TRIBUTOS DAS PESSOAS --------------");
    	
    	for(Pessoa pessoa : pessoas) {
    		System.out.println("Nome: "+ pessoa.getNome());
    		System.out.println("Tributos: "+ gerador.calculaValorTotalTributo(pessoa));
    		System.out.println("--------------------------------------------------");
    	}
    }
    
	
	public void imprimeImpostoTotal() {
		
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
		System.out.println("Pessoa que pagará o maior imposto: " + pessoaImposto.getNome()
							+ "Imposto a ser pago: "+ maiorImposto);
		System.out.println("Beneficiado com maior valor de seguro: " + pessoaBeneficiado.getNome()
							+ "Valor do seguro: "+ maiorValorSeguro);
		System.out.println("---------------------------------------------------");
		
	}

}
