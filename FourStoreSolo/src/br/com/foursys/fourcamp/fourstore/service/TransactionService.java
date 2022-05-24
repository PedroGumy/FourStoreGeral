package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionService {

	ProductService productService = new ProductService();

	public boolean sell(Transaction transaction) {

		//multiplica valor do produto pela quantidade desejada
		transaction.setPaymentValue(productService.getPrice(transaction.getProduct())
				* transaction.getProduct().getQtt());

		//verifica se getPrice deu certo
		if (transaction.getPaymentValue() == 0.0) {
			return false;
		} else {
			//remove do estoque
			if (productService.callRemove(transaction.getProduct())) {
				return true;
			}else {
				return false;
			}
		}

	}

}