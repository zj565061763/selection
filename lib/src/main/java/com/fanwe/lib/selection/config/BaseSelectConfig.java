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
package com.fanwe.lib.selection.config;

import android.view.View;
import android.view.ViewTreeObserver;

import com.fanwe.lib.selection.properties.ViewProperties;

import java.lang.ref.WeakReference;

abstract class BaseSelectConfig<T extends ViewProperties> implements SelectConfig<T>
{
    private final WeakReference<View> mView;

    private T mPropertiesNormal;
    private T mPropertiesSelected;
    private boolean mSelected;

    private boolean mAutoMode;
    private final InternalOnPreDrawListener mOnPreDrawListener = new InternalOnPreDrawListener();
    private final InternalOnAttachStateChangeListener mOnAttachStateChangeListener = new InternalOnAttachStateChangeListener();

    public BaseSelectConfig(View view)
    {
        if (view == null)
            throw new NullPointerException("view is null");

        mView = new WeakReference<>(view);
        setAutoMode(true);
    }

    private View getView()
    {
        return mView == null ? null : mView.get();
    }

    @Override
    public SelectConfig setAutoMode(boolean autoMode)
    {
        mAutoMode = autoMode;

        mOnPreDrawListener.register(autoMode);
        mOnAttachStateChangeListener.register(autoMode);
        return this;
    }

    @Override
    public SelectConfig init(PropertiesIniter<T> initer)
    {
        if (mPropertiesNormal == null)
            mPropertiesNormal = newProperties();

        if (mPropertiesSelected == null)
            mPropertiesSelected = newProperties();

        initer.init(mPropertiesNormal, mPropertiesSelected);
        return this;
    }

    protected abstract T newProperties();

    @Override
    public SelectConfig clear()
    {
        mPropertiesNormal = null;
        mPropertiesSelected = null;
        return this;
    }

    @Override
    public SelectConfig setSelected(boolean selected)
    {
        updateViewState(selected, getView());
        return this;
    }

    private void updateViewState(boolean selected, View view)
    {
        if (view == null)
            return;

        if (selected)
        {
            if (mPropertiesSelected != null)
                mPropertiesSelected.invoke(view);
        } else
        {
            if (mPropertiesNormal != null)
                mPropertiesNormal.invoke(view);
        }
    }

    private void updateStateIfNeed()
    {
        final View view = getView();
        if (view == null)
            return;

        final boolean selected = view.isSelected();
        if (mSelected != selected)
        {
            mSelected = selected;
            view.post(new Runnable()
            {
                @Override
                public void run()
                {
                    updateViewState(selected, view);
                }
            });
        }
    }

    private final class InternalOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener
    {
        public void register(boolean register)
        {
            final View view = getView();
            if (view == null)
                return;

            final ViewTreeObserver observer = view.getViewTreeObserver();
            if (observer.isAlive())
            {
                observer.removeOnPreDrawListener(this);

                if (register)
                {
                    observer.addOnPreDrawListener(this);
                    updateStateIfNeed();
                }
            }
        }

        @Override
        public boolean onPreDraw()
        {
            updateStateIfNeed();
            return true;
        }
    }

    private final class InternalOnAttachStateChangeListener implements View.OnAttachStateChangeListener
    {
        public void register(boolean register)
        {
            final View view = getView();
            if (view == null)
                return;

            view.removeOnAttachStateChangeListener(this);

            if (register)
                view.addOnAttachStateChangeListener(this);
        }

        @Override
        public void onViewAttachedToWindow(View v)
        {
            if (mAutoMode)
                mOnPreDrawListener.register(true);
        }

        @Override
        public void onViewDetachedFromWindow(View v)
        {
            mOnPreDrawListener.register(false);
        }
    }
}
