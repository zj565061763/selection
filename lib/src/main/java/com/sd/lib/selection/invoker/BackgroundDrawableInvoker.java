package com.sd.lib.selection.invoker;

import android.graphics.drawable.Drawable;
import android.view.View;

public class BackgroundDrawableInvoker implements PropertyInvoker<Drawable>
{
    @Override
    public void invoke(View view, Drawable value)
    {
        if (value == null)
            return;

        final int left = view.getPaddingLeft();
        final int top = view.getPaddingTop();
        final int right = view.getPaddingRight();
        final int bottom = view.getPaddingBottom();

        view.setBackgroundDrawable(value);
        view.setPadding(left, top, right, bottom);
    }
}
