package com.sd.lib.selection.properties;

import android.widget.ImageView;

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

    /**
     * 设置图片缩放类型
     *
     * @param value
     * @return
     */
    ImageViewProperties setScaleType(ImageView.ScaleType value);

    @Override
    ImageViewProperties clear();
}
