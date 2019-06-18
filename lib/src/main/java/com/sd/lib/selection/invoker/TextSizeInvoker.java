package com.sd.lib.selection.invoker;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class TextSizeInvoker implements PropertyInvoker<Integer>
{
    @Override
    public void invoke(View view, Integer value)
    {
        if (!(view instanceof TextView))
            throw new IllegalArgumentException("view must be instance of TextView");

        if (value == null)
            return;

        final TextView textView = (TextView) view;
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, value);
    }
}
