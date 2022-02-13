package com.ym.projects.apis.posapi.resources;

import com.ym.projects.apis.posapi.dto.LocationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


class LocationResourceTest extends BaseResourceTest{
    private final List<LocationDto> locationDtosList = new ArrayList<>();
    private LocationDto locationDto, locationDto2, locationDtoNew;
    private final String LOC_DESC = "LOCATION DESC 1", LOC_DESC_2 = "LOCATION DESC 2", LOC_DESC_NEW = "LOCATION DESC NEW";
    private static final String BASE_URL = "/location";
    private static  final String URL_W_ID=BASE_URL+"/{id}";

    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        locationDto=LocationDto.builder().id(ID).name(LOC_DESC).warehouseId(ID).createBy(USER).createDate(CURRENT_DATE).build();
        locationDto2=LocationDto.builder().id(ID2).name(LOC_DESC_2).warehouseId(ID).createBy(USER).createDate(CURRENT_DATE).build();
        locationDtoNew=LocationDto.builder().name(LOC_DESC_NEW).warehouseId(ID).createBy(USER).createDate(CURRENT_DATE).build();
        locationDtosList.add(locationDto);
        locationDtosList.add(locationDto2);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAllLocation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.locations").exists())
                .andExpect(jsonPath("$.locations[*].name").isNotEmpty());

    }

    @Test
    void getLocationById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_W_ID, ID).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());
    }

    @Test
    void saveLocation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL).contentType(MediaType.APPLICATION_JSON).content(asJsonString(locationDtoNew)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    void updateLocation() throws Exception {
        String name = "Location 2 Updated";
        locationDto2.setName(name);
        mockMvc.perform(MockMvcRequestBuilders.put(URL_W_ID, ID).contentType(MediaType.APPLICATION_JSON).content(asJsonString(locationDto2)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name.toUpperCase(Locale.ROOT)));
    }

    @Test
    void deleteLocationById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(URL_W_ID, ID2))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}