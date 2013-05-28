package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {


	private Sessao s;
	
	
	@Before
	public void setup(){
		this.s = new Sessao();
	}
	
	@Test
	public void deveVenderIngressoSeHaVagas() throws Exception {
		this.s.setTotalIngressos(2);

        Assert.assertTrue(this.s.podeReservar(1));
	}

	@Test
	public void naoDeveVenderIngressoSeNaoHaVagas() throws Exception {
		this.s.setTotalIngressos(2);

		Assert.assertFalse(this.s.podeReservar(3));
	}

	@Test
	public void deveVenderIngressoSeNumeroVagasIgualIngressos() throws Exception {
		this.s.setTotalIngressos(3);

		Assert.assertTrue(this.s.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		this.s.setTotalIngressos(5);

		this.s.reserva(3);
		Assert.assertEquals(2, this.s.getIngressosDisponiveis().intValue());
	}
}
