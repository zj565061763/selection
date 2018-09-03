package com.sd.lib.selection.config;

import com.sd.lib.selection.properties.ViewProperties;

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