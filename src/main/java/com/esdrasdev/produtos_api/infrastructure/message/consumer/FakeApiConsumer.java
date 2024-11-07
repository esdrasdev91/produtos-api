package com.esdrasdev.produtos_api.infrastructure.message.consumer;

import com.esdrasdev.produtos_api.business.service.ProdutoService;
import com.esdrasdev.produtos_api.dto.ProductsDTO;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FakeApiConsumer {

    private final ProdutoService produtoService;

    @KafkaListener(topics = "${topico.fake-api.consumer.nome}", groupId = "${topico.fake-api.consumer.group-id}")
    public void recebeProdutosDTO(ProductsDTO productsDTO) {
        try{
            produtoService.salvaProdutoConsumer(productsDTO);
        } catch (Exception exception) {
            throw new BusinessException("Erro ao consumir mensagem do kafka ");
        }
    }

}
