package com.igorfernandes.bancospring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igorfernandes.bancospring.dto.PessoaDTO;
import com.igorfernandes.bancospring.repository.PessoaRepository;
import com.igorfernandes.bancospring.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest // Auto configuração das classes e configurações da aplicação
@AutoConfigureMockMvc // Auto configura o Spring MockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Cria uma instância por teste
class PessoaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    //  Data fictícia
    private LocalDate localDate = LocalDate.of(2000, 1, 1);

    @BeforeEach
    void setup() {
        pessoaRepository.deleteAll();
    }

    @Test
    void salvar() throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO("Teste", "Teste@gmail.com", "11111111111", localDate);

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(pessoaDTO)))
                .andDo(print()) // Opcional
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  Nome
    @Test
    void salvarNomeInvalidoTest() throws Exception {
        testarNome(null, "O nome não pode ser vazio!");
        testarNome("aa", "O nome precisa ter entre 3 e 40 caracteres!");
    }

    void testarNome(String nome, String respostaEsperada) throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO(nome, "Teste@gmail.com", "11111111111", localDate);

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(pessoaDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.nome").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  Email
    @Test
    void salvarEmailInvalido() throws Exception {
        // DRY - pessoa válida no banco
        salvar();

        testarEmail(null, "E-mail precisa ser fornecido!");
        testarEmail("Teste", "E-mail inválido!");
        testarEmail("Teste@@gmail.com", "E-mail inválido!");
        testarEmail("Teste@gmail.com", "Email já cadastrado!");
    }

    void testarEmail(String email, String respostaEsperada) throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO("aaa", email, "11111111111", localDate);

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(pessoaDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    //  CPF
    // Nota: Como setamos o ignoreRepeated = true na classe PessoaDTO
    // nós podemos registrar CPFs com números repetidos como "11111111111".

    @Test
    void salvarCPFInvalido() throws Exception {
        // DRY - pessoa válida no banco
        salvar();

        testarCPF(null, "CPF não pode ser vazio!");
        testarCPF("3", "CPF Inválido!"); // Caelum Stella
        testarCPF("34274324832487387", "CPF Inválido!"); // Caelum Stella
        testarCPF("11111111111", "CPF já cadastrado!");
    }

    void testarCPF(String cpf, String respostaEsperada) throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO("aaa", "Teste@gmail.com", cpf, localDate);

        mockMvc.perform(
                post("/pessoas").contentType("application/json;charset=UTF-8").content(objectMapper.writeValueAsString(pessoaDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cpf").value(respostaEsperada))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}