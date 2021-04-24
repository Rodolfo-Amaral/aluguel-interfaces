package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import excecoes.DataInvalida;

public class AluguelDoCarro {
	
	private Date diaAlugado;
	private Date diaDevolvido;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private Veiculo carro;
	private Nota recibo;
	
	public AluguelDoCarro () {
	}

	public AluguelDoCarro(Date diaAlugado, Date diaDevolvido, Veiculo carro) {
		if (!diaDevolvido.after(diaAlugado)) {
			throw new DataInvalida("O dia da devolução tem que ser uma data posterior ao dia alugado");
		}
		this.diaAlugado = diaAlugado;
		this.diaDevolvido = diaDevolvido;
		this.carro = carro;
	}

	public Date getDiaAlugado() {
		return diaAlugado;
	}

	public void setDiaAlugado(Date diaAlugado) {
		this.diaAlugado = diaAlugado;
	}

	public Date getDiaDevolvido() {
		return diaDevolvido;
	}

	public void setDiaDevolvido(Date diaDevolvido) {
		this.diaDevolvido = diaDevolvido;
	}

	public Veiculo getCarro() {
		return carro;
	}

	public void setCarro(Veiculo carro) {
		this.carro = carro;
	}

	public Nota getRecibo() {
		return recibo;
	}

	public void setRecibo(Nota recibo) {
		this.recibo = recibo;
	}
}
