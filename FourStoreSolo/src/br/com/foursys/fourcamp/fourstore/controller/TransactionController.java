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
		
		//muda CPF para não informado caso usuário digite 0
		if(CPF.equals("0")) {
			CPF = "Não informado.";
		}
		
		//atualiza método de pagamento
		switch(paymentMethod) {	
		case 1:
			updatedPayment = PaymentMethod.MONEY;
			System.out.println("Pagamento em dinheiro...");
			break;
		case 2:
			updatedPayment = PaymentMethod.DEBITCARD;
			System.out.println("Pagamento no cartão de débito...");
			break;
		case 3:
			updatedPayment = PaymentMethod.CREDITCARD;
			System.out.println("Pagamento no cartão de crédito...");
			break;
		case 4:
			updatedPayment = PaymentMethod.PIX;
			System.out.println("Pagamento por pix...");
			break;
		default:
			result = "Método de pagamento inválido";
			return result;
		}
		
		//cria produto (sku e quantidade)
		Product product = new Product(sku, qtt);
		
		//cria objeto com os dados digitados pelo usuário
		Transaction transaction = new Transaction(updatedPayment, "dinheiro", 0.0, CPF, product);

		//chama método da venda do objeto criado
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
