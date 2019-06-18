package com.sd.lib.selection.invoker;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class LayoutGravityInvoker implements PropertyInvoker<Integer>
{
    @Override
    public void invoke(View view, Integer value)
    {
        if (value == null)
            return;

        final ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p == null)
            return;

        if (p instanceof FrameLayout.LayoutParams)
        {
            final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) p;
            if (params.gravity != value)
            {
                params.gravity = value;
                view.setLayoutParams(params);
            }
        } else if (p instanceof LinearLayout.LayoutParams)
        {
            final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) p;
            if (params.gravity != value)
            {
                params.gravity = value;
                view.setLayoutParams(params);
            }
        }
    }
}
