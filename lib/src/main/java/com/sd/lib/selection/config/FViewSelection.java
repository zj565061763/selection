package com.sd.lib.selection.config;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.WeakHashMap;

public final class FViewSelection
{
    private static final Map<View, SelectionConfig> MAP_CONFIG = new WeakHashMap<>();

    private FViewSelection()
    {
    }

    public static ViewSelectionConfig ofView(View view)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof ViewSelectionConfig))
        {
            config = new SimpleViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        return (ViewSelectionConfig) config;
    }

    public static TextViewSelectionConfig ofTextView(TextView view)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof TextViewSelectionConfig))
        {
            config = new SimpleTextViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        return (TextViewSelectionConfig) config;
    }

    public static ImageViewSelectionConfig ofImageView(ImageView view)
    {
        if (view == null)
            return null;

        SelectionConfig config = MAP_CONFIG.get(view);
        if (!(config instanceof ImageViewSelectionConfig))
        {
            config = new SimpleImageViewConfig(view);
            MAP_CONFIG.put(view, config);
        }
        return (ImageViewSelectionConfig) config;
    }

    public static void remove(View view)
    {
        final SelectionConfig config = MAP_CONFIG.remove(view);
        if (config != null)
            config.setAutoMode(false);
    }
}
