package com.sd.lib.selection.invoker;

import android.view.View;
import android.widget.TextView;

public class TextColorInvoker implements PropertyInvoker<Integer>
{
    @Override
    public void invoke(View view, Integer value)
    {
        if (value == null)
            return;
        if (!(view instanceof TextView))
            throw new IllegalArgumentException("ofView must be instance of TextView");

        final TextView textView = (TextView) view;
        textView.setTextColor(value);
    }
}
