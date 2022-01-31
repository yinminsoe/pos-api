package com.ym.projects.apis.posapi;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTestCase {
    protected final Long ID = 1L;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }
}
