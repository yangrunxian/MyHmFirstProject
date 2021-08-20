package com.example.myhmfirstdemo.slice;

import com.example.myhmfirstdemo.ResourceTable;
import com.example.myhmfirstdemo.utils.ElementUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.utils.Color;
import ohos.agp.window.service.WindowManager;
import ohos.app.dispatcher.task.TaskPriority;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaunchAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
//        WindowManager.getInstance().getTopWindow().get().setStatusBarColor(Color.BLUE.getValue()); // 设置状态栏颜色
//        getWindow().addFlags(WindowManager.LayoutConfig.MARK_TRANSLUCENT_NAVIGATION);
//        getWindow().addFlags(WindowManager.LayoutConfig.MARK_FULL_SCREEN);//隐藏状态栏
//        getWindow().addFlags(WindowManager.LayoutConfig.MARK_TRANSLUCENT_STATUS);//沉浸式状态栏
//        WindowManager.getInstance().getTopWindow().get().setStatusBarVisibility(2);   //设置状态栏显示
//        WindowManager.getInstance().getTopWindow().get().setStatusBarColor();    //状态栏颜色
        setUIContent(ResourceTable.Layout_ability_launch);

    }


    @Override
    protected void onActive() {
        super.onActive();
        getGlobalTaskDispatcher(TaskPriority.DEFAULT)
                .asyncDispatch(
                        () -> {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                Logger.getLogger(ElementUtil.class.getName()).log(Level.SEVERE, e.getMessage());
                            }
                            // SendEvent whether login success or fail
                            jump2MainAbility();
                        });
    }



    private void jump2LoginAbility() {
        Intent intent = new Intent();
        // 通过Intent中的OperationBuilder类构造operation对象，指定设备标识（空串表示当前设备）、应用包名、Ability名称
        Operation operation = new Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("com.example.myhmfirstdemo")
                .withAbilityName("com.example.myhmfirstdemo.LoginAbility")
                .build();
        // 把operation设置到intent中
        intent.setOperation(operation);
        startAbility(intent);
    }
    private void jump2MainAbility() {
        Intent intent = new Intent();
        // 通过Intent中的OperationBuilder类构造operation对象，指定设备标识（空串表示当前设备）、应用包名、Ability名称
        Operation operation = new Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("com.example.myhmfirstdemo")
                .withAbilityName("com.example.myhmfirstdemo.MainAbility")
                .build();
        // 把operation设置到intent中
        intent.setOperation(operation);
        startAbility(intent);
    }
}
