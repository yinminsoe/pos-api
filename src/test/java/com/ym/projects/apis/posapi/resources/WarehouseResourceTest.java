package com.ym.projects.apis.posapi.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.projects.apis.posapi.entity.Company;
import com.ym.projects.apis.posapi.entity.Country;
import com.ym.projects.apis.posapi.entity.Tax;
import com.ym.projects.apis.posapi.entity.Warehouse;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*@ExtendWith(SpringExtension.class)
*//*@SpringBootTest
*//*
@WebMvcTest
@AutoConfigureMockMvc*/
class WarehouseResourceTest extends BaseResourceTest {
    private Warehouse warehouse;
    private String warehouseJson;
    private final String WH_DESC = "WAREHOUSE 1";
    private final String WH_DESC_2 = "WAREHOUSE 2";
    private Company company;

    @MockBean
    private WarehouseService warehouseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    WarehouseResource warehouseResource;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        company = Company.builder().id(ID).name("YMS YGN COMPANY").countryName(Country.MYANMAR).tax(Tax.builder().taxCode("MYR").taxPercentage(5).build()).build();
        warehouse = Warehouse.builder().id(ID).name(WH_DESC).company(company).build();
        warehouseJson=objectMapper.writeValueAsString(warehouse);
    }

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {

    }


    @Test
    void getAllWarehouse() throws Exception {

    /*    mockMvc.perform(MockMvcRequestBuilders.post("/warehouse")
                .content(warehouseJson)
                .contentType(JSON_UTF_8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(JSON_UTF_8));*/
    }

    @Test
    void getWarehouseById() {
    }

    @Test
    void saveWarehouse() {
    }

    @Test
    void saveOrUpdateWarehouse() {
    }

    @Test
    void deleteWarehouseById() {
    }
}