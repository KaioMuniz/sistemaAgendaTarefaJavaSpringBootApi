package br.com.kaiomuniz.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.kaiomuniz.entities.Categoria;
import br.com.kaiomuniz.entities.Prioridade;
import br.com.kaiomuniz.entities.Tarefa;
import br.com.kaiomuniz.factories.ConnectionFactory;

public class TarefaRepository {

    public void insert(Tarefa tarefa) throws Exception {
        String sql = """
            INSERT INTO tarefa (id, nome, data, prioridade, finalizado, categoria_id)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, tarefa.getId());
            statement.setString(2, tarefa.getNome());
            statement.setDate(3, java.sql.Date.valueOf(tarefa.getData()));
            statement.setString(4, tarefa.getPrioridade().toString());
            statement.setBoolean(5, tarefa.getFinalizado());
            statement.setObject(6, tarefa.getCategoria().getId());
            statement.executeUpdate();
        }
    }

    public boolean update(Tarefa tarefa) throws Exception {
        String sql = """
            UPDATE tarefa
               SET nome = ?,
                   data = ?,
                   prioridade = ?,
                   finalizado = ?,
                   categoria_id = ?
             WHERE id = ?
        """;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tarefa.getNome());
            statement.setDate(2, java.sql.Date.valueOf(tarefa.getData()));
            statement.setString(3, tarefa.getPrioridade().toString());
            statement.setBoolean(4, tarefa.getFinalizado());
            statement.setObject(5, tarefa.getCategoria().getId());
            statement.setObject(6, tarefa.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean delete(UUID id) throws Exception {
        String sql = """
            DELETE FROM tarefa
             WHERE id = ?
        """;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<Tarefa> findAll(LocalDate dataMin, LocalDate dataMax) throws Exception {
        String sql = """
            SELECT 
                t.id AS idtarefa, 
                t.nome AS nometarefa, 
                t.data, 
                t.prioridade, 
                t.finalizado, 
                c.id AS idcategoria, 
                c.nome AS nomecategoria
            FROM tarefa t
            INNER JOIN categoria c ON t.categoria_id = c.id
            WHERE t.data BETWEEN ? AND ?
            ORDER BY t.data
        """;

        List<Tarefa> lista = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, java.sql.Date.valueOf(dataMin));
            statement.setDate(2, java.sql.Date.valueOf(dataMax));

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    var tarefa = new Tarefa();
                    var categoria = new Categoria();

                    tarefa.setId(UUID.fromString(result.getString("idtarefa")));
                    tarefa.setNome(result.getString("nometarefa"));
                    tarefa.setData(result.getDate("data").toLocalDate());
                    tarefa.setPrioridade(Prioridade.valueOf(result.getString("prioridade")));
                    tarefa.setFinalizado(result.getBoolean("finalizado"));

                    categoria.setId(UUID.fromString(result.getString("idcategoria")));
                    categoria.setNome(result.getString("nomecategoria"));
                    tarefa.setCategoria(categoria);

                    lista.add(tarefa);
                }
            }
        }

        return lista;
    }
}
