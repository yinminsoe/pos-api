package com.ym.projects.apis.posapi;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;


import java.time.LocalDateTime;
import java.util.Date;

public class BaseTestCase {
    protected final Long ID = 1L;
    protected final Long ID2 = 2L;
    protected static final String USER ="YIN MIN";
    protected static final LocalDateTime CURRENT_DATE =LocalDateTime.now();
    protected static final String UOM = "PCS";

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }
}
