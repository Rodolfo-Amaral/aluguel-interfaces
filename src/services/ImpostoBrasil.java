package services;

public class ImpostoBrasil implements TaxServices {

	public double imposto(double qtde) {
		if (qtde <= 100) {
			return qtde * 0.2;
		}
		else {
			return qtde *0.15;
		}
		
	}

}
