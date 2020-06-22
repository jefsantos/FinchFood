package com.omelhordochile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class PessoaServiceApplicationTests {
	
	@Value("${paginacao.quantidade_por_pagina}")
	private int qdtPorPagina;

	@Test
	public void contextLoads() {
		assertEquals(25, qdtPorPagina);
	}

}
