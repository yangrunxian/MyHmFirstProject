package com.example.myhmfirstdemo;

import com.example.myhmfirstdemo.slice.MainAbilitySlice;
import com.example.myhmfirstdemo.slice.WebViewAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
