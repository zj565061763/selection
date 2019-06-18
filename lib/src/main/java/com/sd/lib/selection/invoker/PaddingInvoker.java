package com.sd.lib.selection.invoker;

import android.view.View;

public class PaddingInvoker implements PropertyInvoker<Integer[]>
{
    @Override
    public void invoke(View view, Integer[] value)
    {
        if (value == null)
            return;

        if (value.length != 4)
            throw new IllegalArgumentException("value lenght must be 4");

        final int left = value[0] != null ? value[0] : view.getPaddingLeft();
        final int top = value[1] != null ? value[1] : view.getPaddingTop();
        final int right = value[2] != null ? value[2] : view.getPaddingRight();
        final int bottom = value[3] != null ? value[3] : view.getPaddingBottom();

        if (view.getPaddingLeft() != left
                || view.getPaddingTop() != top
                || view.getPaddingRight() != right
                || view.getPaddingBottom() != bottom)
        {
            view.setPadding(left, top, right, bottom);
        }
    }
}
