package com.sd.lib.selection.config;

import android.view.View;

import com.sd.lib.selection.properties.ViewProperties;

abstract class BaseSelectionConfig<T extends ViewProperties> implements SelectionConfig<T>
{
    private T mPropertiesNormal;
    private T mPropertiesSelected;
    private boolean mSelected;

    public BaseSelectionConfig(View view)
    {
        if (view == null)
            throw new NullPointerException("view is null");

        mViewListener.setView(view);
        setAutoMode(true);
        updateView(view);
    }

    private View getView()
    {
        return mViewListener.getView();
    }

    private final FViewListener<View> mViewListener = new FViewListener<View>()
    {
        @Override
        protected void onUpdate(View view)
        {
            updateViewIfNeed();
        }
    };

    @Override
    public SelectionConfig setAutoMode(boolean autoMode)
    {
        if (autoMode)
            mViewListener.start();
        else
            mViewListener.stop();
        return this;
    }

    @Override
    public SelectionConfig setConfig(PropertiesConfig<T> config)
    {
        if (config != null)
        {
            if (mPropertiesNormal == null)
                mPropertiesNormal = newProperties();

            if (mPropertiesSelected == null)
                mPropertiesSelected = newProperties();

            config.config(mPropertiesNormal, mPropertiesSelected);
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
            updateView(view);
        }
        return this;
    }

    private void updateViewIfNeed()
    {
        final View view = getView();
        if (view == null)
            return;

        if (mSelected != view.isSelected())
            view.post(mUpdateRunnable);
    }

    private final Runnable mUpdateRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            updateView(getView());
        }
    };

    private void updateView(View view)
    {
        if (view == null)
            return;

        mSelected = view.isSelected();

        if (mSelected)
        {
            if (mPropertiesSelected != null)
                mPropertiesSelected.invoke(view);
        } else
        {
            if (mPropertiesNormal != null)
                mPropertiesNormal.invoke(view);
        }
    }
}
