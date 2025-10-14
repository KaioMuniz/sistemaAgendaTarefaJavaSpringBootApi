package br.com.kaiomuniz.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Objeto de requisição para atualização de uma tarefa existente")
public class TarefaPutRequest {

    @Schema(description = "Nome da tarefa", example = "Atualizar documentação do projeto")
    private String nome;

    @Schema(description = "Data da tarefa (formato: yyyy-MM-dd)", example = "2025-10-20")
    private String data;

    @Schema(description = "Prioridade da tarefa (BAIXA, MEDIA ou ALTA)", example = "MEDIA")
    private String prioridade;

    @Schema(description = "ID da categoria associada à tarefa", example = "550e8400-e29b-41d4-a716-446655440000")
    private String categoriaId;

    @Schema(description = "Indica se a tarefa foi finalizada", example = "true")
    private Boolean finalizado;
}
