package br.com.kaiomuniz.entities;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class Tarefa {
	
	private UUID id;
	private String nome;
	private LocalDate data;
	private Prioridade prioridade;
	private Categoria categoria;
	private Boolean finalizado;

}
