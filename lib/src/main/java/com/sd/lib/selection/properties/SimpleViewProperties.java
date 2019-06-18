package com.sd.lib.selection.properties;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.sd.lib.selection.invoker.AlphaInvoker;
import com.sd.lib.selection.invoker.BackgroundDrawableInvoker;
import com.sd.lib.selection.invoker.HeightInvoker;
import com.sd.lib.selection.invoker.MarginInvoker;
import com.sd.lib.selection.invoker.PaddingInvoker;
import com.sd.lib.selection.invoker.VisibilityInvoker;
import com.sd.lib.selection.invoker.WidthInvoker;

class SimpleViewProperties implements ViewProperties
{
    private Float mAlpha;
    private Drawable mBackgroundDrawable;
    private Integer mVisibility;

    private Integer mWidth;
    private Integer mHeight;

    private Integer mPaddingLeft;
    private Integer mPaddingTop;
    private Integer mPaddingRight;
    private Integer mPaddingBottom;

    private Integer mMarginLeft;
    private Integer mMarginTop;
    private Integer mMarginRight;
    private Integer mMarginBottom;

    @Override
    public ViewProperties setAlpha(Float value)
    {
        mAlpha = value;
        return this;
    }

    @Override
    public ViewProperties setBackgroundDrawable(Drawable value)
    {
        mBackgroundDrawable = value;
        return this;
    }

    @Override
    public ViewProperties setBackgroundColor(int color)
    {
        setBackgroundDrawable(new ColorDrawable(color));
        return this;
    }

    @Override
    public ViewProperties setVisibility(Integer value)
    {
        mVisibility = value;
        return this;
    }

    @Override
    public ViewProperties setWidth(Integer value)
    {
        mWidth = value;
        return this;
    }

    @Override
    public ViewProperties setHeight(Integer value)
    {
        mHeight = value;
        return this;
    }

    @Override
    public ViewProperties setPaddingLeft(Integer value)
    {
        mPaddingLeft = value;
        return this;
    }

    @Override
    public ViewProperties setPaddingTop(Integer value)
    {
        mPaddingTop = value;
        return this;
    }

    @Override
    public ViewProperties setPaddingRight(Integer value)
    {
        mPaddingRight = value;
        return this;
    }

    @Override
    public ViewProperties setPaddingBottom(Integer value)
    {
        mPaddingBottom = value;
        return this;
    }

    @Override
    public ViewProperties setMarginLeft(Integer value)
    {
        mMarginLeft = value;
        return this;
    }

    @Override
    public ViewProperties setMarginTop(Integer value)
    {
        mMarginTop = value;
        return this;
    }

    @Override
    public ViewProperties setMarginRight(Integer value)
    {
        mMarginRight = value;
        return this;
    }

    @Override
    public ViewProperties setMarginBottom(Integer value)
    {
        mMarginBottom = value;
        return this;
    }

    @Override
    public ViewProperties clear()
    {
        mAlpha = null;
        mBackgroundDrawable = null;
        mVisibility = null;

        mWidth = null;
        mHeight = null;

        mPaddingLeft = null;
        mPaddingTop = null;
        mPaddingRight = null;
        mPaddingBottom = null;

        mMarginLeft = null;
        mMarginTop = null;
        mMarginRight = null;
        mMarginBottom = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        if (view != null)
        {
            new AlphaInvoker().invoke(view, mAlpha);
            new BackgroundDrawableInvoker().invoke(view, mBackgroundDrawable);
            new PaddingInvoker().invoke(view, new Integer[]{mPaddingLeft, mPaddingTop, mPaddingRight, mPaddingBottom});
            new MarginInvoker().invoke(view, new Integer[]{mMarginLeft, mMarginTop, mMarginRight, mMarginBottom});
            new WidthInvoker().invoke(view, mWidth);
            new HeightInvoker().invoke(view, mHeight);
            new VisibilityInvoker().invoke(view, mVisibility);
        }
    }
}
