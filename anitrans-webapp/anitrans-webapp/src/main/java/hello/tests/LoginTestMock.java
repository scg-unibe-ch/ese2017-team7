package hello.tests;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import hello.*;
import hello.controllers.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.containsString;
import org.springframework.test.web.servlet.*;



/*
 * Tests if the home page loads correctly.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class LoginTestMock {	
	@Autowired
	private MockMvc mockMvc;
	
	//Tests that the home.html page has the right content
	@Test
	public void loginShouldHaveTitl() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("Login")));
	}
	
	//Tests that logging in without username and password isn't possible
	@Test
	public void loginError() throws Exception {
		this.mockMvc.perform(post("/login")).andDo(print())
	               .andExpect(status().isForbidden());
	}
	
	//Tests that a logged in user will se the logout page
		@Test
		@WithMockUser(roles={"USER"})
		public void logoutTitle() throws Exception {
			this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("Logout")));
		}

}


