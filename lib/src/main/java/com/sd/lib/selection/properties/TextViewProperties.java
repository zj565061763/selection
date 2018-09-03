package com.sd.lib.selection.properties;

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

    @Override
    TextViewProperties clear();
}
