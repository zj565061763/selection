package com.sd.lib.selection.properties;

/**
 * ImageView属性配置接口
 */
public interface ImageViewProperties extends ViewProperties
{
    /**
     * {@link #setImageResource(Integer)}
     */
    @Deprecated
    ImageViewProperties setImageResId(Integer value);

    /**
     * 设置图片资源
     *
     * @param value
     * @return
     */
    ImageViewProperties setImageResource(Integer value);

    @Override
    ImageViewProperties clear();
}
