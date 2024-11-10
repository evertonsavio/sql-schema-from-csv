package dev.evertonsavio.moviesservice.controllers;

import dev.evertonsavio.moviesservice.repositories.ProducerRepository;
import dev.evertonsavio.moviesservice.services.ProducerService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
		@Sql(value = "classpath:empty/reset.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(value = "classpath:init/init.sql", executionPhase = BEFORE_TEST_METHOD)
})
class ProducersControllerTest
{

	@Autowired
	private ProducerRepository producerRepository;


	@Autowired
	private MockMvc mockMvc;


	@Test
	void shouldGetProducersAwardsInterval() throws Exception {
		this.mockMvc.perform(get("/v1/producers"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$.min", hasSize(3)))
				.andExpect(jsonPath("$.max", hasSize(3)))
				.andExpect(jsonPath("$.min[0].producer").value("Allan Carr"))
				.andExpect(jsonPath("$.min[0].interval").value(4))
				.andExpect(jsonPath("$.min[0].previousWin").value(1980))
				.andExpect(jsonPath("$.min[0].followingWin").value(1984))
				.andExpect(jsonPath("$.max[0].producer").value("Allan Carr"))
				.andExpect(jsonPath("$.max[0].interval").value(12))
				.andExpect(jsonPath("$.max[0].previousWin").value(1984))
				.andExpect(jsonPath("$.max[0].followingWin").value(1996))
				.andExpect(jsonPath("$.min[1].producer").value("Bill Gerber"))
				.andExpect(jsonPath("$.min[1].interval").value(2))
				.andExpect(jsonPath("$.min[1].previousWin").value(2016))
				.andExpect(jsonPath("$.min[1].followingWin").value(2018))
				.andExpect(jsonPath("$.max[1].producer").value("Bill Gerber"))
				.andExpect(jsonPath("$.max[1].interval").value(7))
				.andExpect(jsonPath("$.max[1].previousWin").value(2009))
				.andExpect(jsonPath("$.max[1].followingWin").value(2016))
				.andExpect(jsonPath("$.min[2].producer").value("Bo Derek"))
				.andExpect(jsonPath("$.min[2].interval").value(6))
				.andExpect(jsonPath("$.min[2].previousWin").value(1984))
				.andExpect(jsonPath("$.min[2].followingWin").value(1990))
				.andExpect(jsonPath("$.max[2].producer").value("Bo Derek"))
				.andExpect(jsonPath("$.max[2].interval").value(6))
				.andExpect(jsonPath("$.max[2].previousWin").value(1984))
				.andExpect(jsonPath("$.max[2].followingWin").value(1990));
	}

}
