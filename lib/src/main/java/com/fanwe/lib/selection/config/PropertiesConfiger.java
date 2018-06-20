package com.fanwe.lib.selection.config;

import com.fanwe.lib.selection.properties.ViewProperties;

public interface PropertiesConfiger<T extends ViewProperties>
{
    /**
     * 配置选中和非选中状态的参数
     *
     * @param normal
     * @param selected
     */
    void config(T normal, T selected);
}