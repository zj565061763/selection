package com.sd.lib.selection.invoker.textview;

import android.util.TypedValue;
import android.widget.TextView;

public class TextSizeInvoker extends TextViewInvoker<Integer>
{
    @Override
    protected void invokeImpl(TextView view, Integer value)
    {
        if (value == null)
            return;

        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, value);
    }
}
