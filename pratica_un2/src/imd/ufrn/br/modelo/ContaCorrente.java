package imd.ufrn.br.modelo;

public class ContaCorrente implements ITributavel{

	private String agencia;
    private String numero;
    private double saldo;

	public ContaCorrente() {
		// TODO Auto-generated constructor stub
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(double valor) {
        if(valor <= saldo) {
        	System.out.println("Saque realizado na conta: " + this + " de " +  valor);
            saldo -= valor;
        } else {
        	System.out.println("Não foi possível realizar o saque em " + this + ". Valor: " + valor);
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado na conta: " + this + "de " +  valor);
    }

    public boolean transferir(double valor, ContaCorrente cc) {
        if(valor <= saldo && cc != null) {
            this.sacar(valor);
            cc.depositar(valor);
            
            System.out.println("Transferência entre " + this + " e " + cc + " realizada no valor de " + valor);
            
            return true;
        }
        
        System.out.println("Não foi possível realizar a transferência entre contas! Parâmetros inválidos");
        return false;
    }
    
    @Override
	public double calculaTributos() {
		return saldo * 0.0038;
	}
    
    @Override
    public String toString() {
        return "[ContaCorrente] " +  "agencia = " + agencia + ", numero = " + numero;
    }


}
