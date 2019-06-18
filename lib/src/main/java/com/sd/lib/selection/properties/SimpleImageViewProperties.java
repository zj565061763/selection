package com.sd.lib.selection.properties;

import android.view.View;
import android.widget.ImageView;

import com.sd.lib.selection.invoker.imageview.ImageResourceInvoker;
import com.sd.lib.selection.invoker.imageview.ImageScaleTypeInvoker;

class SimpleImageViewProperties extends SimpleViewProperties implements ImageViewProperties
{
    private Integer mImageResource;
    private ImageView.ScaleType mScaleType;

    @Override
    public ImageViewProperties setImageResId(Integer value)
    {
        setImageResource(value);
        return this;
    }

    @Override
    public ImageViewProperties setImageResource(Integer value)
    {
        mImageResource = value;
        return this;
    }

    @Override
    public ImageViewProperties setScaleType(ImageView.ScaleType value)
    {
        mScaleType = value;
        return this;
    }

    @Override
    public ImageViewProperties clear()
    {
        super.clear();
        mImageResource = null;
        mScaleType = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        super.invoke(view);

        if (view != null)
        {
            new ImageResourceInvoker().invoke(view, mImageResource);
            new ImageScaleTypeInvoker().invoke(view, mScaleType);
        }
    }
}
