package br.com.kaiomuniz.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.kaiomuniz.entities.Categoria;
import br.com.kaiomuniz.factories.ConnectionFactory;

public class CategoriaRepository {

	// Método para consultar todas as categorias
	public List<Categoria> findAll() throws Exception {

		var sql = """
					select id, nome from categoria
					order by nome asc
				""";

		var connection = ConnectionFactory.getConnection();

		var statement = connection.prepareStatement(sql);
		var result = statement.executeQuery();

		var lista = new ArrayList<Categoria>();

		while (result.next()) {

			var categoria = new Categoria();

			categoria.setId(UUID.fromString(result.getString("id")));
			categoria.setNome(result.getString("nome"));

			lista.add(categoria);
		}

		connection.close();
		return lista;
	}
}
