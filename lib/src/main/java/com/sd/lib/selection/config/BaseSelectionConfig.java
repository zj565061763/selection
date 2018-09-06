package com.sd.lib.selection.config;

import android.view.View;

import com.sd.lib.selection.properties.ViewProperties;
import com.sd.lib.viewupdater.ViewUpdater;
import com.sd.lib.viewupdater.impl.OnPreDrawUpdater;

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
                    updateViewIfNeed();
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
    public SelectionConfig setConfig(PropertiesConfig<T> configer)
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
        final View view = getView();
        if (view != null)
        {
            view.setSelected(selected);
            updateView(selected, view);
        }
        return this;
    }

    private void updateViewIfNeed()
    {
        final View view = getView();
        if (view == null)
            return;

        final boolean selected = view.isSelected();
        if (mSelected == selected)
            return;

        view.post(new Runnable()
        {
            @Override
            public void run()
            {
                updateView(selected, view);
            }
        });
    }

    private void updateView(boolean selected, View view)
    {
        if (view == null)
            return;

        mSelected = selected;

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

    private final class UpdateRunnable implements Runnable
    {
        private final boolean nSelected;

        public UpdateRunnable(boolean selected)
        {
            nSelected = selected;
        }

        @Override
        public void run()
        {
            updateView(nSelected, getView());
        }
    }

    private void synchronizeSelected()
    {
        final View view = getView();
        mSelected = view == null ? false : view.isSelected();
    }
}
