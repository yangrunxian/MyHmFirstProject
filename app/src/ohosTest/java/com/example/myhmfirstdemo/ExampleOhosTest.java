package com.example.myhmfirstdemo;

import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.net.NetManager;
import ohos.sysappcomponents.settings.SystemSettings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleOhosTest {
    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.example.myhmfirstdemo", actualBundleName);
    }
}