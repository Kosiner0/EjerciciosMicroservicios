package com.curso.inicio;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.curso.model.Cliente;
import com.curso.services.cliente.ClienteService;


@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClienteService service;
	
	
		@BeforeEach
		public void setup() {
			Cliente cliente = new Cliente("Juan", "Perez");
			when(service.getClienteById(1)).thenReturn(cliente);
			//when(service.listAllClients()).thenReturn(Arrays.asList(cliente));
			
		}
	
	
	@Test
	public void createClienteWithPathVariableTest() throws Exception {
		doNothing().when(service).createClient(any(Cliente.class));
		
		mockMvc.perform(post("/clientes/Pepito/Grillo"))
				.andExpect(status().isOk());
		
	}
	
	
	@Test
	public void updateClienteByIdTest() throws Exception {
		doNothing().when(service).updateClienteById(1, "Pepito", "Grillo");
		
		mockMvc.perform(put("/clientes/1/Pepito/Grillo"))
				.andExpect(status().isOk());
		
	}
	
	
	@Test
	public void deleteClienteByIdTest() throws Exception {
		doNothing().when(service).deleteClienteById(1);
		
		mockMvc.perform(delete("/clientes/1"))
				.andExpect(status().isOk());
		
	}
	
	
	@Test
	public void createClienteTest() throws Exception {
		doNothing().when(service).createClient(any(Cliente.class));
		
		mockMvc.perform(post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Juan\", \"apellido\":\"Perez\"}"))
				.andExpect(status().isOk());
		
	}
	
	
	@Test
	public void getListTodosLosClientesTest() throws Exception {
		mockMvc.perform(get("/clientes"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nombre", is("Juan")))
				.andExpect(jsonPath("$[0].apellido", is("Perez")));
		
	}
	
	
	@Test
	public void getClienteByIdTest() throws Exception {
		
		mockMvc.perform(delete("/clientes/1"))
				.andExpect(status().isOk())
				//.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.nombre", is("Juan")))
				.andExpect(jsonPath("$.apellido", is("Perez")));
		
	}
	
	
}
