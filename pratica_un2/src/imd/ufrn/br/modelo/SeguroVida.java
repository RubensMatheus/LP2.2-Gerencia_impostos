package imd.ufrn.br.modelo;

public class SeguroVida implements ITributavel {
	
	private int numero;
    private String beneficiado;
    private double valor;
    private double taxa;

	public SeguroVida() {
		this.taxa = 31.50;
	}
	
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(String beneficiado) {
		this.beneficiado = beneficiado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}


	@Override
	public double calculaTributos() {
		return taxa;
	}
	
	@Override
    public String toString() {
        return "[Seguro] " + "numero = " + numero + ", beneficiado = " + beneficiado +  ", valor = " + valor + ", taxa = " + taxa;
    }

}
