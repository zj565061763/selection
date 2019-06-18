package com.sd.lib.selection.invoker.textview;

import android.widget.TextView;

public class TextMaxLinesInvoker extends TextViewInvoker<Integer>
{
    @Override
    protected void invokeImpl(TextView view, Integer value)
    {
        if (value == null)
            return;

        view.setMaxLines(value);
    }
}
