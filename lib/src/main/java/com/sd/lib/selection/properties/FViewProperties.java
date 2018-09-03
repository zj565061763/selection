package com.sd.lib.selection.properties;

public final class FViewProperties
{
    private FViewProperties()
    {
    }

    public static ViewProperties ofView()
    {
        return new SimpleViewProperties();
    }

    public static TextViewProperties ofTextView()
    {
        return new SimpleTextViewProperties();
    }

    public static ImageViewProperties ofImageView()
    {
        return new SimpleImageViewProperties();
    }
}
