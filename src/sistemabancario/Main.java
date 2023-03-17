package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		inicializaSistemaBancario();
		
		Scanner sc = new Scanner(System.in);
		
		boolean continua = true;
		
		
		while (continua) {
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
				case 1:
					System.out.println("Digite o ID do cliente: ");
					int idCliente = sc.nextInt();
					Cliente cliente = gerClientes.pesquisaCliente(idCliente);
					
					if (cliente != null) {
						System.out.println(cliente.toString());
					}else {
						System.out.println("Cliente não encontrado.");
					}
					
					break;
					
				case 2:
					System.out.println("Digite o ID da conta: ");
					int idConta = sc.nextInt();
					ContaCorrente conta = gerContas.pesquisaConta(idConta);
					
					break;
					
				case 3:
					System.out.println("Digite o ID do cliente a ser ativado: ");
					int idCliente2 = sc.nextInt();
					Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
					
					if(cliente2 != null) {
						cliente2.setAtivo(true);
						System.out.println("Cliente ativado com sucesso!");
					}else {
						System.out.println("Cliente não encontrado.");
					}
					
					break;
					
				case 4:
					System.out.println("Digite o ID do cliente a ser desativado: ");
					int idCliente3 = sc.nextInt();
					Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
					
					if(cliente3 != null) {
						cliente3.setAtivo(false);
						System.out.println("Cliente desativado com sucesso!");
					}else {
						System.out.println("Cliente não encontrado.");
					}
					
					break;
					
				case 5:
					continua = false;
					System.out.println("Obrigado por usar nosso Banco!");
					
					break;
					
				default:
					System.out.println("Opção inválida.");
					
					break;
			}
		}

	}

		
	private static void printMenu() {
		System.out.println("Escolha a operação ");
		System.out.println("1) Consultar um cliente ");
		System.out.println("2) Consultar uma conta ");
		System.out.println("3) Ativar um cliente ");
		System.out.println("4) Desativar um cliente ");
		System.out.println("5) Sair ");	
		
	}

	private static void inicializaSistemaBancario() {
			List<ContaCorrente> contas = new ArrayList<>();
			List<Cliente> clientes = new ArrayList<>();
			
			ContaCorrente cc1 = new ContaCorrente (1, 0, true);
			ContaCorrente cc2 = new ContaCorrente (2, 0, true);
			
			contas.add(cc1);
			contas.add(cc2);
	
			Cliente c1 = new Cliente (1, "Miguel Rosa", 27, "miguel@rosa.com", cc1.getId(), true);
			Cliente c2 = new Cliente (2, "Victor Vilardo", 28, "victor@vilardo.com", cc2.getId(), true);
			
			clientes.add(c1);
			clientes.add(c2);
			
			gerClientes = new GerenciadoraClientes(clientes);
			gerContas = new GerenciadoraContas(contas);

		}
	}