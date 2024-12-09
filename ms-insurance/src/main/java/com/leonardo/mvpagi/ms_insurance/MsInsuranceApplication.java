package com.leonardo.mvpagi.ms_insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInsuranceApplication.class, args);
	}

}
