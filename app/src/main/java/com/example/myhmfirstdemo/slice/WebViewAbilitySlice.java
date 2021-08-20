package com.example.myhmfirstdemo.slice;

import com.example.myhmfirstdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.webengine.WebView;

public class WebViewAbilitySlice  extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_webview);
        WebView webView = (WebView) findComponentById(ResourceTable.Id_web_view);
        webView.getWebConfig().setJavaScriptPermit(true);  // 如果网页需要使用JavaScript，增加此行；如何使用JavaScript下文有详细介绍
        final String url = "https://www.baidu.com"; // EXAMPLE_URL由开发者自定义
        webView.load(url);
    }
}
