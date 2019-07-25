package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Pakeage;
import com.oocl.packagebooking.repository.PakeageRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {
    @Autowired
    private PakeageRepository pakeageRepository;

    @Autowired
    private MockMvc mvc;
//    @Test
//    public void should_get_hello_world_when_getHelloWorld() {
//        // GIVEN
//        PakeageController helloWorldController = new PakeageController();
//
//        // WHEN
//        String helloWorld = helloWorldController.getHelloWorld();
//
//        // THEN
//        Assertions.assertEquals("Hello world", helloWorld);
//    }
    @Before
    public void deleteAll() {
       pakeageRepository.deleteAll();
    }

    @Test
    public void should_return_is_page_pakeage_when_search_pageage() {
        // GIVEN
        Pakeage pakeage=new Pakeage();
        pakeage.setRecipient("李四");
        pakeage.setPhoneNum("123456");
        pakeage.setWeight("5");
//
//        Pakeage pakeage1=new Pakeage();
//        pakeage.setRecipient("王五");
//        pakeage.setPhoneNum("12345");
//        pakeage.setWeight("3");
        pakeageRepository.saveAndFlush(pakeage);
//        pakeageRepository.saveAndFlush(pakeage1);

        //when
        String result= null;
        try {
            result = this.mvc.perform(get("/pakeages/")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        JSONArray jsonArray = new JSONArray(result);
        Assertions.assertEquals("5",jsonArray.getJSONObject(0).get("weight"));
//        Assertions.assertEquals("3",jsonArray.getJSONObject(1).get("weight"));

    }
}