package com.leonardo.mvpagi.ms_insurance.infra.client;

import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-customer", url = "${client-service.url}")
//@CircuitBreaker(name = "default", fallbackMethod = "fallbackFindCustomerByCpf")
public interface FindCustomerClient {

    @GetMapping("/customers/cpf/{cpf}")
    CustomerDto findCustomerByCpf(@PathVariable String cpf);

//    // Método fallback para Feign Client
//    default CustomerDto fallbackFindCustomerByCpf(String cpf, Throwable t) {
//        System.out.println("Falha ao chamar o Feign Client para buscar cliente");
//        return new CustomerDto();  // Retorna um objeto vazio ou um valor default
//    }
}
