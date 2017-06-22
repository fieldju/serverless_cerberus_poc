package com.fieldju.cerberus;

import org.junit.Before;
import org.junit.Test;

public class IamPrincipalAuthHandlerIntegrationTest {

    private IamPrincipalAuthHandler handler;

    @Before
    public void before() {
        handler = new IamPrincipalAuthHandler();
    }

    @Test
    public void run_handle() {
        handler.handle();
    }
}
