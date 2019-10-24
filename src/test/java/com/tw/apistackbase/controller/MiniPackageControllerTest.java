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

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

        ResultActions result = mvc.perform(post("/api/packages")
                .contentType(APPLICATION_JSON)
                .content(mapToJson(miniPackage)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.receiver").value("Alpha"));
    }

    @Test
    void getAllMiniPackages_should_return_list_of_all_minipackages_and_status_code_200() throws Exception {
        MiniPackage miniPackage1 = new MiniPackage();
        miniPackage1.setReceiver("Alpha");
        MiniPackage miniPackage2 = new MiniPackage();
        miniPackage2.setReceiver("Bravo");
        when(miniPackageService.getAllMiniPackages()).thenReturn(asList(miniPackage1, miniPackage2));

        ResultActions result = mvc.perform(get("/api/packages"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]receiver").value("Alpha"))
                .andExpect(jsonPath("$.[1]receiver").value("Bravo"));
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
