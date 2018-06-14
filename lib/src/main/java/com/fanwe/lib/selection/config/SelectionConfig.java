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

import com.fanwe.lib.selection.properties.ViewProperties;

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
     * 初始化配置参数
     *
     * @param initer
     * @return
     */
    SelectionConfig init(PropertiesIniter<T> initer);

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

    interface PropertiesIniter<T extends ViewProperties>
    {
        /**
         * 配置选中和非选中状态的参数
         *
         * @param normal
         * @param selected
         */
        void init(T normal, T selected);
    }
}
