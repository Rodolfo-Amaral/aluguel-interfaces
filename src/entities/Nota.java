package entities;

public class Nota {
	private Double valorBase;
	private Double imposto;
	
	public Nota () {
	}
	
	public Nota(Double valorBase, Double imposto) {
		this.valorBase = valorBase;
		this.imposto = imposto;
	}

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase(Double valorBase) {
		this.valorBase = valorBase;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double getValorTotal() {
		return getValorBase() + getImposto();
	}

}
