package com.sd.lib.selection.properties;

import android.graphics.Typeface;
import android.view.View;

import com.sd.lib.selection.invoker.textview.TextColorInvoker;
import com.sd.lib.selection.invoker.textview.TextGravityInvoker;
import com.sd.lib.selection.invoker.textview.TextMaxLinesInvoker;
import com.sd.lib.selection.invoker.textview.TextSizeInvoker;
import com.sd.lib.selection.invoker.textview.TextTypefaceInvoker;

class SimpleTextViewProperties extends SimpleViewProperties implements TextViewProperties
{
    private Integer mTextColor;
    private Integer mTextSize;
    private Integer mGravity;
    private Integer mMaxLines;
    private Typeface mTypeface;

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
    public TextViewProperties setGravity(Integer value)
    {
        mGravity = value;
        return this;
    }

    public TextViewProperties setMaxLines(Integer value)
    {
        mMaxLines = value;
        return this;
    }

    @Override
    public TextViewProperties setTypeface(Typeface value)
    {
        mTypeface = value;
        return this;
    }

    @Override
    public TextViewProperties clear()
    {
        super.clear();
        mTextColor = null;
        mTextSize = null;
        mGravity = null;
        mMaxLines = null;
        mTypeface = null;
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
            new TextGravityInvoker().invoke(view, mGravity);
            new TextMaxLinesInvoker().invoke(view, mMaxLines);
            new TextTypefaceInvoker().invoke(view, mTypeface);
        }
    }
}
