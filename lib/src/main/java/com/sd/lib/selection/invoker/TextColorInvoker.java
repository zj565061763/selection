package com.sd.lib.selection.invoker;

import android.widget.TextView;

public class TextColorInvoker extends TextViewInvoker<Integer>
{
    @Override
    protected void invokeImpl(TextView view, Integer value)
    {
        if (value == null)
            return;

        view.setTextColor(value);
    }
}
