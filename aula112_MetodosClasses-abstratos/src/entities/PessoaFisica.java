package entities;

public class PessoaFisica extends Contribuintes {

	private Double gastoComSaude;
	
	public PessoaFisica(){
		super();
	}

	public PessoaFisica(String name, Double rendaAnual, Double gastoComSaude) {
		super(name, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}

	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	@Override
	public double calcImpostos() {
		double totalImpostos;
		if (rendaAnual <= 20000.00) {
			totalImpostos = (rendaAnual * 0.15) + (gastoComSaude * 0.5);
		} else {
			totalImpostos = (rendaAnual * 0.25) + (gastoComSaude * 0.5);
		}
		return totalImpostos;
	}

}
