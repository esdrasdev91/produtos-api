package com.esdrasdev.produtos_api.infrastructure.client;

import com.esdrasdev.produtos_api.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public class FakeApiClient {

    @GetMapping("/products")
    public List<ProductsDTO> buscaListaProdutos();

}
