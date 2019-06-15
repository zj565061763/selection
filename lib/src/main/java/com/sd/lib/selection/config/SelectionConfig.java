package com.sd.lib.selection.config;

import com.sd.lib.selection.properties.ViewProperties;

/**
 * View的状态参数配置
 */
public interface SelectionConfig<T extends ViewProperties>
{
    /**
     * 设置当view的选中状态变化的时候是否自动更新UI，默认true-自动更新
     *
     * @param autoMode
     * @return
     */
    SelectionConfig setAutoMode(boolean autoMode);

    /**
     * 配置状态参数
     *
     * @param config
     * @return
     */
    SelectionConfig setConfig(PropertiesConfig<T> config);

    /**
     * 清空配置
     *
     * @return
     */
    SelectionConfig clear();

    /**
     * 设置选中状态
     *
     * @param selected
     * @return
     */
    SelectionConfig setSelected(boolean selected);
}
