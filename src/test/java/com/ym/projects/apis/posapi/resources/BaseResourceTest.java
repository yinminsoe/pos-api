package com.ym.projects.apis.posapi.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.projects.apis.posapi.PosApiApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={ PosApiApplication.class })
public abstract class BaseResourceTest {
    public static final String BASE_DOMAIN="pos-app";
    public static final MediaType JSON_UTF_8 = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"));
    protected final Long ID = 1L;
    protected final Long ID2 = 2L;
    protected static final String USER ="YIN MIN";
    protected static final LocalDateTime CURRENT_DATE =LocalDateTime.now();
    protected static final String UOM = "PCS";

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected ObjectMapper objectMapper;


    protected String asJsonString(Object obj){
        try{
            return objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }

    }
}
