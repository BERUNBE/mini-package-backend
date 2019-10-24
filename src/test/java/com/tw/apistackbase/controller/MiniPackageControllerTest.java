package com.tw.apistackbase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.service.MiniPackageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MiniPackageController.class)
public class MiniPackageControllerTest {

    @MockBean
    private MiniPackageService miniPackageService;

    @Autowired
    private MockMvc mvc;

    @Test
    void createMiniPackage_should_return_created_package_and_status_code_201() throws Exception {
        MiniPackage miniPackage = new MiniPackage();
        miniPackage.setReceiver("Alpha");
        when(miniPackageService.createMiniPackage(any())).thenReturn(miniPackage);

        ResultActions result = mvc.perform(post("/packages")
                .contentType(APPLICATION_JSON)
                .content(mapToJson(miniPackage)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.receiver").value("Alpha"));
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
