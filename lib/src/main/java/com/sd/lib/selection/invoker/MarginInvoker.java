package com.sd.lib.selection.invoker;

import android.view.View;
import android.view.ViewGroup;

public class MarginInvoker implements PropertyInvoker<Integer[]>
{
    @Override
    public void invoke(View view, Integer[] value)
    {
        final ViewGroup.LayoutParams p = view.getLayoutParams();
        if (!(p instanceof ViewGroup.MarginLayoutParams))
            return;

        if (value == null)
            return;

        if (value.length != 4)
            throw new IllegalArgumentException("value lenght must be 4");

        final ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) p;

        final int left = value[0] != null ? value[0] : params.leftMargin;
        final int top = value[1] != null ? value[1] : params.topMargin;
        final int right = value[2] != null ? value[2] : params.rightMargin;
        final int bottom = value[3] != null ? value[3] : params.bottomMargin;

        if (left != params.leftMargin
                || top != params.topMargin
                || right != params.rightMargin
                || bottom != params.bottomMargin)
        {
            params.leftMargin = left;
            params.topMargin = top;
            params.rightMargin = right;
            params.bottomMargin = bottom;

            view.setLayoutParams(params);
        }
    }
}
