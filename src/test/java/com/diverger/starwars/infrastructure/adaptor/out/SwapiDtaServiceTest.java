package com.diverger.starwars.infrastructure.adaptor.out;

import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class SwapiDtaServiceTest {

    @MockBean
    private SwapiFeignClient swapiFeignClient;

    //@MockBean ----> crear un @Bean de   RestClient  para poder simularlo

    //En SwapiFeignClient  recibir como Autowire el Bean de   RestClient
}
