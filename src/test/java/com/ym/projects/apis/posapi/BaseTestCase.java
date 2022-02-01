package com.ym.projects.apis.posapi;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;


import java.util.Date;

public class BaseTestCase {
    protected final Long ID = 1L;
    protected static final String USER ="YIN MIN";
    protected static final Date CURRENT_DATE =new Date();
    protected static final String UOM = "PCS";

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }
}
