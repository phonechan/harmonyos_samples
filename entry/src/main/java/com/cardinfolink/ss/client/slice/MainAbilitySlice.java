package com.cardinfolink.ss.client.slice;

import com.cardinfolink.ss.client.ResourceTable;
import com.cardinfolink.ss.client.model.ItemMain;
import com.cardinfolink.ss.client.provider.MainItemProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {

    private List<ItemMain> data;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        initData();
        initView();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void initData() {
        /**
         * Ability
         * 线程
         * UI
         * 媒体
         * 安全
         * AI
         * 网络与连接
         * 设备管理
         * 数据管理
         * 日志管理
         */
        data = new ArrayList<>();
        data.add(new ItemMain("Ability"));
        data.add(new ItemMain("线程"));
        data.add(new ItemMain("UI"));
        data.add(new ItemMain("媒体"));
        data.add(new ItemMain("安全"));
        data.add(new ItemMain("网络与连接"));
        data.add(new ItemMain("设备管理"));
        data.add(new ItemMain("数据管理"));
        data.add(new ItemMain("日志管理"));
    }

    private void initView() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        MainItemProvider mainItemProvider = new MainItemProvider(data, this);
        listContainer.setItemProvider(mainItemProvider);
        listContainer.setReboundEffectParams(40, 0.6f, 20);

        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                ItemMain item = (ItemMain) listContainer.getItemProvider().getItem(i);
                new ToastDialog(getContext())
                        .setText("clicked:" + item.getName())
                        // Toast显示在界面中间
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            }
        });
    }
}
