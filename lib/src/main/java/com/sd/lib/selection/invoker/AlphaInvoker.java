package com.sd.lib.selection.invoker;

import android.view.View;

public class AlphaInvoker implements PropertyInvoker<Float>
{
    @Override
    public void invoke(View view, Float value)
    {
        if (value == null)
            return;

        view.setAlpha(value);
    }
}
