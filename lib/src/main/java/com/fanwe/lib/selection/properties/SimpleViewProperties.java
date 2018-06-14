/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.selection.properties;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.fanwe.lib.selection.invoker.AlphaInvoker;
import com.fanwe.lib.selection.invoker.BackgroundDrawableInvoker;
import com.fanwe.lib.selection.invoker.HeightInvoker;
import com.fanwe.lib.selection.invoker.VisibilityInvoker;
import com.fanwe.lib.selection.invoker.WidthInvoker;

class SimpleViewProperties implements ViewProperties
{
    private Float mAlpha;
    private Drawable mBackgroundDrawable;
    private Integer mVisibility;
    private Integer mWidth;
    private Integer mHeight;

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
    public ViewProperties clear()
    {
        mAlpha = null;
        mBackgroundDrawable = null;
        mVisibility = null;
        mWidth = null;
        mHeight = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        if (view != null)
        {
            new AlphaInvoker().invoke(view, mAlpha);
            new BackgroundDrawableInvoker().invoke(view, mBackgroundDrawable);
            new VisibilityInvoker().invoke(view, mVisibility);
            new WidthInvoker().invoke(view, mWidth);
            new HeightInvoker().invoke(view, mHeight);
        }
    }
}
