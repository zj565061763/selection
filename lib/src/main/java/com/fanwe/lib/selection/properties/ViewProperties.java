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
package com.fanwe.lib.selection.properties;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * view属性配置接口
 */
public interface ViewProperties
{
    /**
     * 设置透明度
     *
     * @param value
     * @return
     */
    ViewProperties setAlpha(Float value);

    /**
     * 设置背景
     *
     * @param value
     * @return
     */
    ViewProperties setBackgroundDrawable(Drawable value);

    /**
     * 设置背景
     *
     * @param color 颜色值
     * @return
     */
    ViewProperties setBackgroundColor(int color);

    /**
     * 设置可见状态
     *
     * @param value
     * @return
     */
    ViewProperties setVisibility(Integer value);

    /**
     * 设置宽度
     *
     * @param value
     * @return
     */
    ViewProperties setWidth(Integer value);

    /**
     * 设置高度
     *
     * @param value
     * @return
     */
    ViewProperties setHeight(Integer value);

    /**
     * 清空所有设置的属性值
     *
     * @return
     */
    ViewProperties clear();

    /**
     * 将当前属性配置应用到某个view
     *
     * @param view
     */
    void invoke(View view);
}
