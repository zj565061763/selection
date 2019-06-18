package com.sd.lib.selection.invoker;

import android.view.View;
import android.view.ViewGroup;

public class HeightInvoker implements PropertyInvoker<Integer>
{
    @Override
    public void invoke(View view, Integer value)
    {
        if (value == null)
            return;

        final ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null)
            return;

        if (params.height != value)
        {
            params.height = value;
            view.setLayoutParams(params);
        }
    }
}
