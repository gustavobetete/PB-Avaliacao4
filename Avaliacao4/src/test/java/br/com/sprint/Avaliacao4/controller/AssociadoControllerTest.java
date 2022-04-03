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
public class AssociadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver201SeConseguirAdicionarUmAssociado() throws Exception {
        URI uri = new URI("/associados");
        String json = "{" +
                "\"nome\":\"Gilberto Nascimento JR\"," +
                "\"cargo\":\"VEREADOR\",\"data_Nascimento\":\"1967-10-25\",\"sexo\":\"MASCULINO\"" +
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
    public void deveriaDevolver400SeNaoConseguirAdicionarUmNovoAssociado() throws Exception {
        URI uri = new URI("/associados");
        String json = "{" +
                "\"nome\":\" \"," +
                "\"cargo\":\"VEREADOR\",\"data_Nascimento\":\"1967-10-25\",\"sexo\":\"MASCULINO\"" +
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
    public void deveriaDevolver200ETodosAssociados() throws Exception {
        URI uri = new URI("/associados");
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
        URI uri = new URI("/associados/131");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void deveriaDevolver200SeOAssociadoForDeletado() throws Exception {
        URI uri = new URI("/associados/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveriaDevolver404SeOIdDoAssociadoNaoExistir() throws Exception {
        URI uri = new URI("/associados/123");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void deveriaDevolver200SeAtualizarUmAssociado() throws Exception {
        URI uri = new URI("/associados/1");
        String json = "{" +
                "\"nome\":\"Gustavo Castiglioni \"," +
                "\"cargo\":\"PREFEITO\",\"data_Nascimento\":\"1944-10-25\",\"sexo\":\"MASCULINO\"" +
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
    public void deveriaDevolver400SeNaoAtualizarUmAssociado() throws Exception {
        URI uri = new URI("/associados/1");
        String json = "{" +
                "\"nome\":\" \"," +
                "\"cargo\":\"PREFEITO\",\"data_Nascimento\":\"1944-10-25\",\"sexo\":\"MASCULINO\"" +
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
