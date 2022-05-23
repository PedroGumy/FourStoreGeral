package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;
import br.com.foursys.fourcamp.fourstore.service.TransactionService;

public class TransactionController {

	// cria objeto de transaction service
	TransactionService transactionService = new TransactionService();

	public String sell(String sku, Integer qtt, String CPF, Integer paymentMethod) {
		String result = "";
		PaymentMethod updatedPayment;
		
		//muda CPF para n�o informado caso usu�rio digite 0
		if(CPF.equals("0")) {
			CPF = "N�o informado.";
		}
		
		//atualiza m�todo de pagamento
		switch(paymentMethod) {	
		case 1:
			updatedPayment = PaymentMethod.MONEY;
			System.out.println("Pagamento em dinheiro...");
			break;
		case 2:
			updatedPayment = PaymentMethod.DEBITCARD;
			System.out.println("Pagamento no cart�o de d�bito...");
			break;
		case 3:
			updatedPayment = PaymentMethod.CREDITCARD;
			System.out.println("Pagamento no cart�o de cr�dito...");
			break;
		case 4:
			updatedPayment = PaymentMethod.PIX;
			System.out.println("Pagamento por pix...");
			break;
		default:
			result = "M�todo de pagamento inv�lido";
			return result;
		}
		
		//cria produto (sku e quantidade)
		Product product = new Product(sku, qtt);
		
		//cria objeto com os dados digitados pelo usu�rio
		Transaction transaction = new Transaction(updatedPayment, "dinheiro", 0.0, CPF, product);

		//chama m�todo da venda do objeto criado
		if(transactionService.sell(transaction)) {
			result = "tudo certo";
		}else {
			result = "deu merda";
		}
		
		return result;
	}
	
	
	//A DEFINIR
	public String validatePayment(Integer paymentMethod) {
		
		
		return null;
	}

}
