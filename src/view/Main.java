package view;

import model.Sale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sale sale = new Sale();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de vendas!");
        System.out.println("Produtos disponíveis:");
        System.out.println("Código | Produto                | Preço  | Estoque");
        System.out.println("-----------------------------------------------");
        System.out.println("at     | Arroz Tatiana          | R$30,00 | " + model.DataBase.getStock("at"));
        System.out.println("ff     | Feijão Fejó            | R$20,00 | " + model.DataBase.getStock("ff"));
        System.out.println("msa    | Macarrão Santa Amália  | R$15,00 | " + model.DataBase.getStock("msa"));

        while (true) {
            System.out.print("\nDigite o código do produto ou 'fim' para finalizar: ");
            String code = scanner.nextLine();
            if (code.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Digite a quantidade: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            if (!sale.createSaleItem(code, quantity)) {
                System.out.println("Tente novamente com uma quantidade válida.");
            }
        }

        System.out.print("Escolha a forma de pagamento (cc: Crédito, dc: Débito, c: Dinheiro/Pix): ");
        String paymentMethod = scanner.nextLine();
        sale.setPaymentMethod(paymentMethod);

        System.out.println("\nItens vendidos:");
        for (String item : sale.getItems()) {
            System.out.println(item);
        }

        System.out.println(String.format("\nTotal: R$%.2f", sale.getTotal()));
        System.out.println("Forma de pagamento: " + sale.getPaymentMethod());
        System.out.println(String.format("Valor final a pagar: R$%.2f", sale.getFinalPrice()));
    }
}
