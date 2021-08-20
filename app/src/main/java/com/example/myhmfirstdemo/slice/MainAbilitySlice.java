package com.example.myhmfirstdemo.slice;

import com.example.myhmfirstdemo.ResourceTable;
import com.example.myhmfirstdemo.view.TestPageProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.PageSlider;
import ohos.agp.components.TabList;

import java.util.ArrayList;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_main);
        initPageSlider();
    }

    private void initPageSlider() {
        PageSlider pageSlider = (PageSlider) findComponentById(ResourceTable.Id_page_slider);
        pageSlider.setProvider(new TestPageProvider(getAbility(),getData()));
        pageSlider.setSlidingPossible(false);
        TabList tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        TabList.Tab tab = tabList.new Tab(getContext());
        tab.setText("Image");
        tabList.addTab(tab);
    }

    private ArrayList<TestPageProvider.DataItem> getData() {
        ArrayList<TestPageProvider.DataItem> dataItems = new ArrayList<>();
        dataItems.add(new TestPageProvider.DataItem("Page A", 0));
        dataItems.add(new TestPageProvider.DataItem("Page B", 1));
        dataItems.add(new TestPageProvider.DataItem("Page C", 0));
        dataItems.add(new TestPageProvider.DataItem("Page D", 1));
        return dataItems;
    }
}
