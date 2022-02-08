package com.ym.projects.apis.posapi.resources;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

public abstract class BaseResourceTest {
    public static final String BASE_DOMAIN="pos-app";
    public static final MediaType JSON_UTF_8 = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"));
    protected final Long ID = 1L;
    protected final Long ID2 = 2L;
    protected static final String USER ="YIN MIN";
    protected static final LocalDateTime CURRENT_DATE =LocalDateTime.now();
    protected static final String UOM = "PCS";
}
