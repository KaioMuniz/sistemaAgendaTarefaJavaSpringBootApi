package br.com.kaiomuniz.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de requisição para criação de uma nova tarefa")
public class TarefaPostRequest {

    @Schema(description = "Nome da tarefa", example = "Estudar Spring Boot")
    private String nome;

    @Schema(description = "Data da tarefa (formato: yyyy-MM-dd)", example = "2025-10-13")
    private String data;

    @Schema(description = "Prioridade da tarefa (BAIXA, MEDIA ou ALTA)", example = "ALTA")
    private String prioridade;

    @Schema(description = "ID da categoria associada à tarefa", example = "550e8400-e29b-41d4-a716-446655440000")
    private String categoriaId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
}
