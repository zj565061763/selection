package com.sd.lib.selection.invoker.textview;

import android.widget.TextView;

public class TextGravityInvoker extends TextViewInvoker<Integer>
{
    @Override
    protected void invokeImpl(TextView view, Integer value)
    {
        if (value == null)
            return;

        view.setGravity(value);
    }
}
