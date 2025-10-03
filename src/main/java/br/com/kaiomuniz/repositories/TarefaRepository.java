package br.com.kaiomuniz.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.kaiomuniz.entities.Tarefa;

public class TarefaRepository {

	public void insert(Tarefa Tarefa) throws Exception {
	}

	public boolean update(Tarefa Tarefa) throws Exception {
		return false;
	}

	public boolean delete(UUID id) throws Exception {
		return false;
	}

	public List<Tarefa> findAll(LocalDate dataMin, LocalDate dataMax) throws Exception {
		return null;
	}
}
