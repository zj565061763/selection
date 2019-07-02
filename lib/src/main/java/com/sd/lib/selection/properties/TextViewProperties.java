package com.sd.lib.selection.properties;

import android.graphics.Typeface;

/**
 * TextView属性配置接口
 */
public interface TextViewProperties extends ViewProperties
{
    /**
     * 设置字体颜色
     *
     * @param value
     * @return
     */
    TextViewProperties setTextColor(Integer value);

    /**
     * 设置字体大小
     *
     * @param value
     * @return
     */
    TextViewProperties setTextSize(Integer value);

    /**
     * 设置文字重力属性
     *
     * @param value
     * @return
     */
    TextViewProperties setGravity(Integer value);

    /**
     * 设置文字最大行数
     *
     * @param value
     * @return
     */
    TextViewProperties setMaxLines(Integer value);

    /**
     * 设置字体<br>
     * {@link Typeface#defaultFromStyle(int)}<br>
     * {@link Typeface#BOLD}<br>
     * {@link Typeface#NORMAL}<br>
     *
     * @param value
     * @return
     */
    TextViewProperties setTypeface(Typeface value);

    @Override
    TextViewProperties clear();
}
