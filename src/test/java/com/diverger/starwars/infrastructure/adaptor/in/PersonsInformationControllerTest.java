package com.diverger.starwars.infrastructure.adaptor.in;

import com.diverger.starwars.StarwarsApplication;
import com.diverger.starwars.infrastructure.adapter.in.http.PersonsInformationController;
import com.diverger.starwars.usecase.PersonInformationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@ContextConfiguration(classes = StarwarsApplication.class)
@SpringBootTest(classes = PersonsInformationController.class)
public class PersonsInformationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonInformationUseCase personInformationUseCase;


}
