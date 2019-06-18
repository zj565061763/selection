package com.sd.lib.selection.properties;

import android.view.View;

import com.sd.lib.selection.invoker.textview.TextColorInvoker;
import com.sd.lib.selection.invoker.textview.TextSizeInvoker;

class SimpleTextViewProperties extends SimpleViewProperties implements TextViewProperties
{
    private Integer mTextColor;
    private Integer mTextSize;

    @Override
    public TextViewProperties setTextColor(Integer value)
    {
        mTextColor = value;
        return this;
    }

    @Override
    public TextViewProperties setTextSize(Integer value)
    {
        mTextSize = value;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        super.invoke(view);

        if (view != null)
        {
            new TextColorInvoker().invoke(view, mTextColor);
            new TextSizeInvoker().invoke(view, mTextSize);
        }
    }

    @Override
    public TextViewProperties clear()
    {
        super.clear();
        mTextColor = null;
        mTextSize = null;
        return this;
    }
}
