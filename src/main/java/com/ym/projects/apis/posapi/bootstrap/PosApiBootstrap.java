package com.ym.projects.apis.posapi.bootstrap;


import com.ym.projects.apis.posapi.model.Location;
import com.ym.projects.apis.posapi.model.Warehouse;
import com.ym.projects.apis.posapi.services.WarehouseService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class PosApiBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private static final Long ID_1 = 1L;
    private static final String WH_DESC_1 = "WAREHOUSE 1 DESCRIPTION";
    private static final String LOC_DESC_1 = "LOCATION 1 DESCRIPTION";

    private final WarehouseService warehouseService;
    public PosApiBootstrap(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
    private void intializeWhLocation(){
        Location location=Location.builder().id(ID_1).name(LOC_DESC_1).build();
        Warehouse warehouse = Warehouse.builder().id(ID_1).name(WH_DESC_1).location(location).build();
        location.setWarehouse(warehouse);
        warehouseService.saveAndUpdateWarehouse(warehouse);

    }
}
