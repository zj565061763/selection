package com.sd.lib.selection.invoker.imageview;

import android.view.View;
import android.widget.ImageView;

import com.sd.lib.selection.invoker.PropertyInvoker;

public abstract class ImageViewInvoker<T> implements PropertyInvoker<T>
{
    @Override
    public void invoke(View view, T value)
    {
        if (!(view instanceof ImageView))
            throw new IllegalArgumentException("view must be instance of ImageView");
        invokeImpl((ImageView) view, value);
    }

    protected abstract void invokeImpl(ImageView view, T value);
}
