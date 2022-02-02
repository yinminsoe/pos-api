package com.ym.projects.apis.posapi.bootstrap;


import com.ym.projects.apis.posapi.model.Location;
import com.ym.projects.apis.posapi.model.Warehouse;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PosApiBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private static final Long ID_1 = 1L;
    private static final String WH_DESC_1 = "SOUTH DAGON WAREHOUSE YANGON";
    private static final String LOC_DESC_1 = "SOUTH DAGON NO(2) MARKET YANGON";
    protected static final String USER ="YIN MIN";
    protected static final Date CURRENT_DATE =new Date();



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }

}
