package com.leonardo.mvpagi.ms_insurance.infra.client;

import com.leonardo.mvpagi.ms_insurance.infra.controllers.dtos.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-customer", url = "${client-service.url}")
public interface FindCustomerClient {

    @GetMapping("/customers/cpf/{cpf}")
    CustomerDto findCustomerByCpf(@PathVariable String cpf);
}
