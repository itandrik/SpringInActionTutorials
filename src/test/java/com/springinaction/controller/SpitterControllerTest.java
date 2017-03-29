package com.springinaction.controller;

import com.springinaction.Spitter;
import com.springinaction.data.SpitterRepository;
import com.springinaction.web.SpitterController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by 1 on 28.03.2017.
 */
public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController(null);
        MockMvc mock = standaloneSetup(controller).build();

        mock.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository repository = mock(SpitterRepository.class);

        Spitter unsaved = new Spitter("jbauer", "24hours",
                "Jack", "Bauer","someemail");
        Spitter saved = new Spitter(24L,"jbauer", "24hours",
                "Jack", "Bauer","someemail");

        when(repository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(repository,atLeastOnce()).save(unsaved);
    }
}
