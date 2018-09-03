package com.sd.lib.selection.invoker;

import android.view.View;

public interface PropertyInvoker<T>
{
    void invoke(View view, T value);
}
