package com.sd.lib.selection.invoker.imageview;

import android.widget.ImageView;

public class ImageScaleTypeInvoker extends ImageViewInvoker<ImageView.ScaleType>
{
    @Override
    protected void invokeImpl(ImageView view, ImageView.ScaleType value)
    {
        if (value == null)
            return;

        view.setScaleType(value);
    }
}
