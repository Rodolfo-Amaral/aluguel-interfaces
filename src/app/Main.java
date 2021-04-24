package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.AluguelDoCarro;
import entities.Veiculo;
import excecoes.DataInvalida;
import services.ImpostoBrasil;
import services.ServicoAluguel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Dados do aluguel:");
		System.out.println("Modelo do carro: ");
		String modelo = sc.nextLine();
		try {
			System.out.println("Data e hora da locação: ");
			Date partida = sdf.parse(sc.nextLine());
			System.out.println("Data de hora da devolução: ");
			Date devolucao = sdf.parse(sc.nextLine());
			
			AluguelDoCarro ac = new AluguelDoCarro(partida, devolucao, new Veiculo(modelo));
			
			System.out.println("Preço por hora: ");
			double precoHora = sc.nextDouble();
			System.out.println("Preço diário: ");
			double precoDiario = sc.nextDouble();
			
			ServicoAluguel servicoAluguel = new ServicoAluguel(precoDiario, precoHora, new ImpostoBrasil());
			
			servicoAluguel.faturamento(ac);		
			System.out.println("FATURAMENTO");
			System.out.println("Valor base: " + String.format("%.2f", ac.getRecibo().getValorBase()));
			System.out.println("Impostos: " + String.format("%.2f", ac.getRecibo().getImposto()));
			System.out.println("Valor total: " + String.format("%.2f", ac.getRecibo().getValorTotal()));			
		}
		catch (ParseException e) {
			System.out.println("ERRO: Favor digitar uma data e hora válidos (dd/mm/aaaa HH:mm)");
		}
		catch (DataInvalida d) {
			System.out.println("Erro: " + d.getMessage());
		}
		catch (RuntimeException r) {
			System.out.println("Erro inesperado :(");
		}
		sc.close();
	}
}
