package com.sd.lib.selection.properties;

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
