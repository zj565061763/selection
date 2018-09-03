package com.sd.lib.selection.config;

import android.widget.ImageView;

import com.sd.lib.selection.properties.FViewProperties;
import com.sd.lib.selection.properties.ImageViewProperties;

class SimpleImageViewConfig extends BaseSelectionConfig<ImageViewProperties> implements ImageViewSelectionConfig
{
    public SimpleImageViewConfig(ImageView view)
    {
        super(view);
    }

    @Override
    protected ImageViewProperties newProperties()
    {
        return FViewProperties.ofImageView();
    }
}
