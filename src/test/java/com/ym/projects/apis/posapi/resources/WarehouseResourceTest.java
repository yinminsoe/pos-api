package com.ym.projects.apis.posapi.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.projects.apis.posapi.dto.WarehouseDto;
import com.ym.projects.apis.posapi.repositories.WarehouseRepository;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class WarehouseResourceTest extends BaseResourceTest{
    private final List<WarehouseDto> warehouseDtosList = new ArrayList<>();
    private  WarehouseDto warehouseDto;
    private WarehouseDto warehouseDto2;
    private WarehouseDto warehouseNew;
    private final String WH_DESC = "WAREHOUSE 1";
    private final String WH_DESC2 = "WAREHOUSE 2";
    private final String WH_DESC3 = "WAREHOUSE 3";

    private final static String BASE_URL ="/warehouse";
    private final static String URL_W_ID ="/warehouse/{id}";
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        warehouseDto = WarehouseDto.builder().id(ID).companyId(ID).name(WH_DESC).createDate(CURRENT_DATE).createBy(USER).build();
        warehouseDto2 = WarehouseDto.builder().id(ID2).companyId(ID).name(WH_DESC2).createDate(CURRENT_DATE).createBy(USER).build();
        warehouseNew=WarehouseDto.builder().companyId(ID)
                .name(WH_DESC3).createDate(CURRENT_DATE).createBy(USER).build();
        warehouseDtosList.add(warehouseDto);
        warehouseDtosList.add(warehouseDto2);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAllWarehouses() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print())
               .andExpect(jsonPath("$.warehouses").exists())
               .andExpect(jsonPath("$.warehouses[*].name").isNotEmpty());
    }

    @Test
    void getWarehouseById() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.get(URL_W_ID, ID).accept(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andDo(MockMvcResultHandlers.print())
                 .andExpect(jsonPath("$.name").isNotEmpty());
    }

    @Test
    void saveWarehouse() throws Exception {
       mockMvc.perform(post(BASE_URL)
               .contentType(MediaType.APPLICATION_JSON).content(asJsonString(warehouseNew))
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andDo(MockMvcResultHandlers.print())
               .andExpect(header().exists("Location"))
               .andExpect(jsonPath("$.id").isNotEmpty());

    }

    @Test
    void saveOrUpdateWarehouse() throws Exception {
        String name = "Warehouse 2 updated";
        warehouseDto2.setName(name);
        mockMvc.perform(MockMvcRequestBuilders.put(URL_W_ID, ID2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(warehouseDto2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.name").value(name.toUpperCase(Locale.ROOT)));
    }

    @Test
    @DirtiesContext
    void deleteWarehouseById() throws Exception {
        mockMvc.perform(delete(URL_W_ID, 3L))
                .andExpect(status().isAccepted());
    }


    private String asJsonString(Object obj){
        try{
            return objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }

    }
}