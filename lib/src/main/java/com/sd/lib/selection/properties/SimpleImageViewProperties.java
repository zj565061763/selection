package com.sd.lib.selection.properties;

import android.view.View;

import com.sd.lib.selection.invoker.imageview.ImageResourceInvoker;

class SimpleImageViewProperties extends SimpleViewProperties implements ImageViewProperties
{
    private Integer mImageResource;

    @Override
    public ImageViewProperties setImageResId(Integer value)
    {
        mImageResource = value;
        return this;
    }

    @Override
    public ImageViewProperties clear()
    {
        super.clear();
        mImageResource = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        super.invoke(view);

        if (view != null)
            new ImageResourceInvoker().invoke(view, mImageResource);
    }
}
