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

public class ComponentsAbilitySlice extends AbilitySlice {

    private List<ItemMain> data;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_components);
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
         *
         DirectionalLayout
         DependentLayout
         StackLayout
         TableLayout

         Text
         Button
         TextField
         Image
         TabList和Tab
         Picker
         DatePicker
         TimePicker
         Switch
         RadioButton
         RadioContainer
         Checkbox
         ProgressBar
         RoundProgressBar
         ToastDialog
         ScrollView
         ListContainer
         */
        data = new ArrayList<>();
        data.add(new ItemMain("DirectionalLayout"));
        data.add(new ItemMain("DependentLayout"));
        data.add(new ItemMain("StackLayout"));
        data.add(new ItemMain("TableLayout"));
        data.add(new ItemMain("Text"));
        data.add(new ItemMain("Button"));
        data.add(new ItemMain("TextField"));
        data.add(new ItemMain("Image"));
        data.add(new ItemMain("TabList和Tab"));
        data.add(new ItemMain("Picker"));
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
