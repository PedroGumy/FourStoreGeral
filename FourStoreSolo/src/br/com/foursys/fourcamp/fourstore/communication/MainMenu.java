package br.com.foursys.fourcamp.fourstore.communication;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.TransactionController;

public class MainMenu {
	Integer opt;
	Scanner sc = new Scanner(System.in);
	ProductController productController;

	// exibe menu
	public void mainMenu() {
		while (true) {
			System.out.print("##--------------MENU FOURSTORE--------------##\n");
			System.out.print("|--------------------------------------------|\n");
			System.out.print("| Opção 1 - Cadastrar produto novo           |\n");
			System.out.print("| Opção 2 - Registrar adição no estoque      |\n");
			System.out.print("| Opção 3 - Listar todos os produtos         |\n");
			System.out.print("| Opção 4 - Registrar remoção de estoque     |\n");
			System.out.print("| Opção 5 - Efetuar venda                    |\n");
			System.out.print("| Opção 0 - Sair                             |\n");
			System.out.print("|--------------------------------------------|\n");
			System.out.print("|              Digite uma opção:             |\n");
			System.out.print("|--------------------------------------------|\n");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				userCallCreate();
				break;
			case 2:
				userCallAdd();
				break;

			case 3:
				userCallListAll();
				break;

			case 4:
				userCallRemove();
				break;

			case 5:
				userCallSell();
				break;

			case 0:
				System.out.println("Obrigado por utilizar nosso sistema!");
				System.exit(0);
				break;
			}

		}
	}

	public void userCallCreate() {
		sc.nextLine();

		String sku;
		Double price;
		Integer qtt;
		String type;
		String size;
		String color;
		String category;
		String department;

		System.out.println("Informe  a sku do produto:");
		sku = sc.nextLine();

		System.out.println("Informe  o preço do produto:");
		price = sc.nextDouble();

		System.out.println("Informe  a quantidade do produto:");
		qtt = sc.nextInt();

		System.out.println("Informe  o tipo do produto:");
		sc.nextLine();
		type = sc.nextLine();

		System.out.println("Informe  o tamanho do produto:");
		size = sc.nextLine();

		System.out.println("Informe  a cor do produto:");
		color = sc.nextLine();

		System.out.println("Informe  a categoria do produto:");
		category = sc.nextLine();

		System.out.println("Informe  o departamento do produto:");
		department = sc.nextLine();

		productController = new ProductController();
		System.out.println(productController.addProduct(sku, price, qtt, type, size, color, category, department));

	}

	public void userCallAdd() {
		System.out.println("Informe a SKU do produto: ");
		sc.nextLine();
		String sku = sc.nextLine();

		System.out.println("Informe a quantidade a adicionar ao estoque: ");
		Integer qtt = sc.nextInt();
		productController = new ProductController();
		System.out.println(productController.callAdd(sku, qtt));

	}

	public void userCallListAll() {
		productController = new ProductController();
		System.out.println(productController.callListAll());
	}

	public void userCallRemove() {
		System.out.println("Informe a SKU do produto:");
		sc.nextLine();
		String sku = sc.nextLine();

		System.out.println("Informe a quantidade a reduzir do estoque: ");
		Integer qtt = sc.nextInt();
		productController = new ProductController();
		System.out.println(productController.callRemove(sku, qtt));
	}

	public void userCallSell() {

		System.out.println("Informe o SKU do produto que deseja comprar: ");
		sc.nextLine();
		String sku = sc.nextLine();

		System.out.println("Informe a quantidade que deseja comprar: ");
		Integer qtt = sc.nextInt();
		
		
		
		System.out.println("Informe seu CPF ou digite 0 para continuar: ");
		String CPF = sc.next();
		
		System.out.println("Informe o método de pagamento:\n"
				+ "1- Dinheiro à vista;\n"
				+ "2- Cartão de Débito;\n"
				+ "3- Cartão de Crédito;\n"
				+ "4- Pix.");
		Integer paymentMethod = sc.nextInt();
		
		//criar métodos para pegar cada pagamento
		
		TransactionController transactionController = new TransactionController();
		System.out.println(transactionController.sell(sku, qtt, CPF, paymentMethod));
		
		

	}

}
