package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Classe de teste de operações de {@link GerenciadoraContas}
 * 
 * @author miguelrosa
 * @date 10 MAR 2023
 *
 */

public class GerenciadoraContasTest1 {

	private GerenciadoraContas gerContas;

	/**
	 * Teste unitário básico de pesquisa de cliente a parir do seu ID
	 * 
	 * @author miguelrosa
	 * @date 10 MAR 2023
	 */
	
	@Test
	public void testTransfereValor(){	
		// criação do cenário
		
		int valorTransferencia = 50;
		
		ContaCorrente cc1 = new ContaCorrente(1, 100, true);
		ContaCorrente cc2 = new ContaCorrente(2, 200, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(cc1);
		contas.add(cc2);

		gerContas = new GerenciadoraContas(contas);	
		
		
		double saldoCc1 = cc1.getSaldo();
		double saldoCc2 = cc2.getSaldo();
		
		// execução do teste
		boolean verificacaoTransferencia = gerContas.transfereValor(cc1.getId(), valorTransferencia, cc2.getId());
		
		// verifição do resultado
		if(verificacaoTransferencia == true) {
			assertThat(cc1.getSaldo(), is(saldoCc1 - valorTransferencia));
			assertThat(cc2.getSaldo(), is(saldoCc2 + valorTransferencia));
		}
	}
	

}
