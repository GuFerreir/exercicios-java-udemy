package entities;

public class PessoaJuridica extends Contribuintes {
	
	private int numFuncionarios;

	public PessoaJuridica(){
		super();
	}
	
	public PessoaJuridica(String name, Double rendaAnual, int numFuncionarios) {
		super(name, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public int getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public double calcImpostos() {
		double totalImpostos;
		if (numFuncionarios <= 10) {
			totalImpostos = (rendaAnual * 0.16);
		} else {
			totalImpostos = (rendaAnual * 0.14);
		}
		return totalImpostos;
	}
	

}
