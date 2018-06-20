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

import com.fanwe.lib.selection.properties.ImageViewProperties;
import com.fanwe.lib.selection.properties.TextViewProperties;
import com.fanwe.lib.selection.properties.ViewProperties;

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
