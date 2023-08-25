package org.matthenry87.noautowiredemo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MyService myService;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(new MyController(myService))
                .setMessageConverters(new MappingJackson2HttpMessageConverter(new ObjectMapper()))
                .build();
    }

    @Test
    void works() throws Exception {
        // Arrange
        var hashMap = new HashMap<String, Object>();
        hashMap.put("foo", "bar");

        when(myService.getMap()).thenReturn(hashMap);

        // Act
        mockMvc.perform(get("/")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"foo\":\"bar\"}"));

        // Assert
        verify(myService).getMap();

        verifyNoMoreInteractions(myService);
    }

}