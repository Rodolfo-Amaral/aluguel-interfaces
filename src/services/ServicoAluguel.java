package services;

import entities.AluguelDoCarro;
import entities.Nota;

public class ServicoAluguel {
	private Double precoDiario;
	private Double precoHora;
	
	private TaxServices iss;

	public ServicoAluguel(Double precoDiario, Double precoHora, TaxServices iss) {
		this.precoDiario = precoDiario;
		this.precoHora = precoHora;
		this.iss = iss;
	}
	public void faturamento(AluguelDoCarro aluguelDoCarro) {
		long dI = aluguelDoCarro.getDiaAlugado().getTime();
		long dF = aluguelDoCarro.getDiaDevolvido().getTime();
		double horas = (double)(dI - dF) / 1000 / 60 / 60;
		
		double valorBase;
		if (horas <= 12) {
			valorBase = precoHora * Math.ceil(horas);
		}
		else {
			valorBase = precoDiario * Math.ceil(horas / 24);
		}
		double imposto = iss.imposto(valorBase);
		
		aluguelDoCarro.setRecibo(new Nota(valorBase, imposto));
	}

}
