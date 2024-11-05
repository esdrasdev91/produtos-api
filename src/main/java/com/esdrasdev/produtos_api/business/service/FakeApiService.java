package com.esdrasdev.produtos_api.business.service;

import com.esdrasdev.produtos_api.business.converter.ProdutoConverter;
import com.esdrasdev.produtos_api.dto.ProductsDTO;
import com.esdrasdev.produtos_api.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;
    private final ProdutoConverter converter;
    private final ProdutoService produtoService;

    @NotificacaoErro
    public List<ProductsDTO> buscaProdutos() {
        try {


            List<ProductsDTO> dto = cliente.buscaListaProdutos();
            dto.forEach(produto -> {
                        Boolean retorno = produtoService.existsPorNome(produto.getNome());
                        if (retorno.equals(false)) {
                            produtoService.salvaProdutos(converter.toEntity(produto));
                        } else {
                            throw new ConflictException("Produto já existente no banco de dados " + produto.getNome());
                        }
                    }

            );
            return produtoService.buscaTodosProdutos();
        }catch (ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar e gravar produtos no banco de dados");
        }
    }

}
