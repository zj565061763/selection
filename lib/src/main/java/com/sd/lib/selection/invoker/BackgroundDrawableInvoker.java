package com.sd.lib.selection.invoker;

import android.graphics.drawable.Drawable;
import android.view.View;

public class BackgroundDrawableInvoker implements PropertyInvoker<Drawable>
{
    @Override
    public void invoke(View view, Drawable value)
    {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        final int paddingBottom = view.getPaddingBottom();

        view.setBackgroundDrawable(value);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
