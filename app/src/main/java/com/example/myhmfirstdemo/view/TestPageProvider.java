package com.example.myhmfirstdemo.view;

import ohos.agp.colors.RgbColor;
import ohos.agp.components.*;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.webengine.WebView;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;
import ohos.app.Context;

import java.util.List;

public class TestPageProvider extends PageSliderProvider {
    // 数据源，每个页面对应list中的一项
    private final List<DataItem> list;
    private final Context context;

    public TestPageProvider(Context context, List<DataItem> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        final DataItem data = list.get(i);
        Object result = null;
        if (data.type == 0) {
            Text label = new Text(null);
            label.setTextAlignment(TextAlignment.CENTER);
            label.setLayoutConfig(
                    new StackLayout.LayoutConfig(
                            ComponentContainer.LayoutConfig.MATCH_PARENT,
                            ComponentContainer.LayoutConfig.MATCH_PARENT
                    ));
            label.setText(data.mText);
            label.setTextColor(Color.BLACK);
            label.setTextSize(50);
            ShapeElement element = new ShapeElement();
            element.setRgbColor(RgbColor.fromArgbInt(Color.getIntColor("#AFEEEE")));
            label.setBackground(element);
            componentContainer.addComponent(label);
            result = label;
        } else {
//            DirectionalLayout dLayout = new DirectionalLayout(context);
//            dLayout.setLayoutConfig(new ComponentContainer.LayoutConfig(
//                    ComponentContainer.LayoutConfig.MATCH_PARENT,
//                    ComponentContainer.LayoutConfig.MATCH_PARENT
//            ));
            ohos.agp.components.webengine.WebView webView = new ohos.agp.components.webengine.WebView(context);
            webView.setWidth(ComponentContainer.LayoutConfig.MATCH_PARENT);
            webView.setHeight(ComponentContainer.LayoutConfig.MATCH_PARENT);
            webView.getWebConfig().setJavaScriptPermit(true);  // 如果网页需要使用JavaScript，增加此行；如何使用JavaScript下文有详细介绍
            final String url = "https://www.baidu.com"; // EXAMPLE_URL由开发者自定义
            webView.load(url);
//            dLayout.addComponent(webView);
            componentContainer.addComponent(webView);
            result = webView;
        }
        return result;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return true;
    }

    //数据实体类
    public static class DataItem {
        String mText;
        int type;

        public DataItem(String txt, int type) {
            mText = txt;
            this.type = type;
        }
    }
}