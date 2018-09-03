package com.sd.lib.selection.properties;

import android.view.View;

import com.sd.lib.selection.invoker.ImageResIdInvoker;

class SimpleImageViewProperties extends SimpleViewProperties implements ImageViewProperties
{
    private Integer mImageResId;

    @Override
    public ImageViewProperties setImageResId(Integer value)
    {
        mImageResId = value;
        return this;
    }

    @Override
    public ImageViewProperties clear()
    {
        super.clear();
        mImageResId = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        super.invoke(view);

        if (view != null)
            new ImageResIdInvoker().invoke(view, mImageResId);
    }
}
