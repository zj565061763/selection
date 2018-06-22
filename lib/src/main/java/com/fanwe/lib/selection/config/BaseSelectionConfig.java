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

import com.fanwe.lib.selection.properties.ViewProperties;
import com.fanwe.lib.viewupdater.ViewUpdater;
import com.fanwe.lib.viewupdater.impl.OnPreDrawUpdater;

abstract class BaseSelectionConfig<T extends ViewProperties> implements SelectionConfig<T>
{
    private T mPropertiesNormal;
    private T mPropertiesSelected;
    private boolean mSelected;

    private ViewUpdater mViewUpdater;

    public BaseSelectionConfig(View view)
    {
        if (view == null)
            throw new NullPointerException("view is null");

        getViewUpdater().setView(view);
        setAutoMode(true);
    }

    private ViewUpdater getViewUpdater()
    {
        if (mViewUpdater == null)
        {
            mViewUpdater = new OnPreDrawUpdater();
            mViewUpdater.setUpdatable(new ViewUpdater.Updatable()
            {
                @Override
                public void update()
                {
                    updateStateIfNeed();
                }
            });
        }
        return mViewUpdater;
    }

    private View getView()
    {
        return getViewUpdater().getView();
    }

    @Override
    public SelectionConfig setAutoMode(boolean autoMode)
    {
        if (autoMode)
            getViewUpdater().start();
        else
            getViewUpdater().stop();

        return this;
    }

    @Override
    public SelectionConfig setConfiger(PropertiesConfiger<T> configer)
    {
        if (configer != null)
        {
            if (mPropertiesNormal == null)
                mPropertiesNormal = newProperties();

            if (mPropertiesSelected == null)
                mPropertiesSelected = newProperties();

            configer.config(mPropertiesNormal, mPropertiesSelected);
        }
        return this;
    }

    protected abstract T newProperties();

    @Override
    public SelectionConfig clear()
    {
        mPropertiesNormal = null;
        mPropertiesSelected = null;
        return this;
    }

    @Override
    public SelectionConfig setSelected(boolean selected)
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
}
