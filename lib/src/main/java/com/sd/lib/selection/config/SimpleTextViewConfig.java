package com.sd.lib.selection.config;

import android.widget.TextView;

import com.sd.lib.selection.properties.FViewProperties;
import com.sd.lib.selection.properties.TextViewProperties;

class SimpleTextViewConfig extends BaseSelectionConfig<TextViewProperties> implements TextViewSelectionConfig
{
    public SimpleTextViewConfig(TextView view)
    {
        super(view);
    }

    @Override
    protected TextViewProperties newProperties()
    {
        return FViewProperties.ofTextView();
    }
}
