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

    public static ViewSelectionConfig config(View view)
    {
        if (view == null)
            return null;

        final SelectionConfig config = MAP_CONFIG.get(view);
        if (config instanceof ViewSelectionConfig)
            return (ViewSelectionConfig) config;

        final SimpleViewConfig newConfig = new SimpleViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static TextViewSelectionConfig config(TextView view)
    {
        if (view == null)
            return null;

        final SelectionConfig config = MAP_CONFIG.get(view);
        if (config instanceof TextViewSelectionConfig)
            return (TextViewSelectionConfig) config;

        final SimpleTextViewConfig newConfig = new SimpleTextViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static ImageViewSelectionConfig config(ImageView view)
    {
        if (view == null)
            return null;

        final SelectionConfig config = MAP_CONFIG.get(view);
        if (config instanceof ImageViewSelectionConfig)
            return (ImageViewSelectionConfig) config;

        final SimpleImageViewConfig newConfig = new SimpleImageViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static void removeConfig(View view)
    {
        final SelectionConfig config = MAP_CONFIG.remove(view);
        if (config != null)
            config.setAutoMode(false);
    }
}
