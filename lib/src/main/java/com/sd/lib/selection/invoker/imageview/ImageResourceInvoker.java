package com.sd.lib.selection.invoker.imageview;

import android.widget.ImageView;

public class ImageResourceInvoker extends ImageViewInvoker<Integer>
{
    @Override
    protected void invokeImpl(ImageView view, Integer value)
    {
        if (value == null)
            return;

        view.setImageResource(value);
    }
}
