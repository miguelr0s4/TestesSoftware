package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste de operações de {@link GerenciadoraClientes}
 * 
 * @author miguelrosa
 * @date 10 MAR 2023
 *
 */

public class GerenciadoraClientesTest1 {

	private GerenciadoraClientes gerClientes;

	/**
	 * Teste unitário básico de transferência de valor
	 * 
	 * @author miguelrosa
	 * @date 10 MAR 2023
	 */
	
	@Test
	public void testPesquisaCliente(){	
		// criação do cenário
		Cliente cliente01 = new Cliente (1, "Miguel Rosa", 27, "miguel@rosa.com", 1, true);
		Cliente cliente02 = new Cliente (2, "Victor Vilardo", 28, "victor@vilardo.com", 2, true);

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientes);	
		
		// execução do teste
		Cliente clientePesquisa = gerClientes.pesquisaCliente(1);
		
		// verifição do resultado
		assertThat(clientePesquisa.getId(), is(1));
	}
	
	
	/**
	 * Teste unitário básico de remoção de um cliente a parir de um ID
	 * 
	 * @author miguelrosa
	 * @date 17 MAR 2023
	 */
	
	@Test
	public void testRemoveCliente(){	
		// criação do cenário
		Cliente cliente01 = new Cliente (1, "Miguel Rosa", 27, "miguel@rosa.com", 1, true);
		Cliente cliente02 = new Cliente (2, "Victor Vilardo", 28, "victor@vilardo.com", 2, true);

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		int tamanhoLista;
		
		gerClientes = new GerenciadoraClientes(clientes);	

		// execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(1);
		tamanhoLista = clientes.size();
		
		if(clienteRemovido == true) {
			// verifição do resultado
			assertThat(tamanhoLista, is(1));
			
			// ou
			//assertThat(gerClientes.getClientesDoBanco().size(), is(1));
			//assertThat(clienteRemovido, is(true));
			//assertTrue(clienteRemovido, is(true))
			
			//  pesquisa pelo excluído e vê se tá null
			//assertNull(gerClientes.pesquisaCliente(2));
		}
		
	}
	
	

	
}
