package com.cardinfolink.ss.client.provider;

import com.cardinfolink.ss.client.ResourceTable;
import com.cardinfolink.ss.client.model.ItemMain;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.List;

public class MainItemProvider extends RecycleItemProvider {

    private List<ItemMain> data;
    private AbilitySlice slice;

    public MainItemProvider(List<ItemMain> data, AbilitySlice slice) {
        this.data = data;
        this.slice = slice;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int pos, Component component, ComponentContainer componentContainer) {
        Component cpt = component;
        if (cpt == null) {
            cpt = LayoutScatter.getInstance(slice).parse(ResourceTable.Layout_item_main, null, false);
        }
        ItemMain itemMain = data.get(pos);
        Text text = (Text) cpt.findComponentById(ResourceTable.Id_item_index);
        text.setText(itemMain.getName());
        return cpt;
    }
}
