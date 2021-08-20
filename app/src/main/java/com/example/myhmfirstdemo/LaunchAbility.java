package com.example.myhmfirstdemo;

import com.example.myhmfirstdemo.slice.LaunchAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.global.systemres.ResourceTable;

public class LaunchAbility extends Ability {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(LaunchAbilitySlice.class.getName());
    }
}
