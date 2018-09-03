package com.sd.lib.selection.config;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sd.lib.selection.properties.ImageViewProperties;
import com.sd.lib.selection.properties.TextViewProperties;
import com.sd.lib.selection.properties.ViewProperties;

import java.util.Map;
import java.util.WeakHashMap;

public final class FViewSelection
{
    private static final Map<View, SelectionConfig> MAP_CONFIG = new WeakHashMap<>();

    private FViewSelection()
    {
    }

    public static ViewSelectionConfig configView(View view, PropertiesConfiger<ViewProperties> configer)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof ViewSelectionConfig))
        {
            config = new SimpleViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        config.setConfiger(configer);
        return (ViewSelectionConfig) config;
    }

    public static TextViewSelectionConfig configTextView(TextView view, PropertiesConfiger<TextViewProperties> configer)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof TextViewSelectionConfig))
        {
            config = new SimpleTextViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        config.setConfiger(configer);
        return (TextViewSelectionConfig) config;
    }

    public static ImageViewSelectionConfig configImageView(ImageView view, PropertiesConfiger<ImageViewProperties> configer)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof ImageViewSelectionConfig))
        {
            config = new SimpleImageViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        config.setConfiger(configer);
        return (ImageViewSelectionConfig) config;
    }

    public static void removeConfig(View view)
    {
        final SelectionConfig config = MAP_CONFIG.remove(view);
        if (config != null)
            config.setAutoMode(false);
    }
}
