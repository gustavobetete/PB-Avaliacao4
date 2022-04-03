package br.com.sprint.Avaliacao4.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PartidoControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void deveriaDevolver201SeConseguirAdicionarUmPartido() throws Exception {
            URI uri = new URI("/partidos");
            String json = "{" +
                    "\"nome_Partido\":\"Partido da Social Democracia Brasileira\"," +
                    "\"sigla\":\"PSDB\",\"ideologia\":\"CENTRO\",\"data_Fundacao\":\"1988-06-25\"" +
                    "}";

            mockMvc
                    .perform(MockMvcRequestBuilders
                            .post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                            .status()
                            .is(201));
        }

    @Test
    public void deveriaDevolver400SeNaoConseguirAdicionarUmNovoPartido() throws Exception {
        URI uri = new URI("/partidos");
        String json = "{" +
                "\"nome_Partido\":\"Partido da Social Democracia Brasileira\"," +
                "\"sigla\":\"PSDB\",\"ideologia\":\"CENTRO\",\"data_Fundacao\":\"25/06/1988\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void deveriaDevolver200ETodosDoPartido() throws Exception {
        URI uri = new URI("/partidos");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveriaDevolver404CasoOIdNaoExista() throws Exception {
        URI uri = new URI("/partidos/122");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void deveriaDeletar200SeOPartidoForDeletado() throws Exception {
        URI uri = new URI("/partidos/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveriaDevolver404SeOIdDoPartidoNaoExistir() throws Exception {
        URI uri = new URI("/partidos/123");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void deveriaDevolver200SeAtualizarUmPartido() throws Exception {
        URI uri = new URI("/partidos/1");
        String json = "{" +
                "\"nome_Partido\":\"Testando\"," +
                "\"sigla\":\"ABCD\",\"ideologia\":\"ESQUERDA\",\"data_Fundacao\":\"1988-06-25\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveriaDevolver400SeNaoAtualizarUmPartido() throws Exception {
        URI uri = new URI("/associados/1");
        String json = "{" +
                "\"nome_Partido\":\"\"," +
                "\"sigla\":\"ABCD\",\"ideologia\":\"ESQUERDA\",\"data_Fundacao\":\"1988-06-25\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}

