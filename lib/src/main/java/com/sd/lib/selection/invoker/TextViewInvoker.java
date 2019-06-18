package com.sd.lib.selection.invoker;

import android.view.View;
import android.widget.TextView;

public abstract class TextViewInvoker<T> implements PropertyInvoker<T>
{
    @Override
    public void invoke(View view, T value)
    {
        if (!(view instanceof TextView))
            throw new IllegalArgumentException("view must be instance of TextView");
        invokeImpl((TextView) view, value);
    }

    protected abstract void invokeImpl(TextView view, T value);
}
