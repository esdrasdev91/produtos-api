package com.esdrasdev.produtos_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductsDTO {

    @JsonProperty(value = "id")
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "entity_id")
    private String entityId;

    @JsonProperty(value = "title")
    private String nome;

    @JsonProperty(value = "price")
    private BigDecimal preco;

    @JsonProperty(value = "category")
    private String categoria;

    @JsonProperty(value = "description")
    private String descricao;

    @JsonProperty(value = "image")
    private String imagem;

}