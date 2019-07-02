package com.sd.lib.selection.invoker.textview;

import android.graphics.Typeface;
import android.widget.TextView;

public class TextTypefaceInvoker extends TextViewInvoker<Typeface>
{
    @Override
    protected void invokeImpl(TextView view, Typeface value)
    {
        if (value == null)
            return;

        view.setTypeface(value);
    }
}
