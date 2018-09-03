package com.sd.lib.selection.config;

import android.view.View;

import com.sd.lib.selection.properties.FViewProperties;
import com.sd.lib.selection.properties.ViewProperties;

class SimpleViewConfig extends BaseSelectionConfig<ViewProperties> implements ViewSelectionConfig
{
    public SimpleViewConfig(View view)
    {
        super(view);
    }

    @Override
    protected ViewProperties newProperties()
    {
        return FViewProperties.ofView();
    }
}
