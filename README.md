# About
管理android view的选中状态

# Gradle
`implementation 'com.fanwe.android:selection:1.0.0-beta1'`

# 简单demo
![](http://thumbsnap.com/i/jxj71QW0.gif?0614)

```java
public class MainActivity extends AppCompatActivity
{
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);
        mTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 切换选中状态
                mTextView.setSelected(!mTextView.isSelected());
            }
        });

        FViewSelection.config(mTextView).setConfiger(new SelectionConfig.PropertiesConfiger<TextViewProperties>()
        {
            @Override
            public void config(TextViewProperties normal, TextViewProperties selected)
            {
                // 配置正常状态的参数
                normal.setTextColor(Color.BLACK)
                        .setTextSize(40)
                        .setAlpha(0.5f);

                // 配置选中状态的参数
                selected.setTextColor(Color.RED)
                        .setTextSize(60)
                        .setAlpha(1.0f);
            }
        }).setSelected(false);
    }
}
```

# 目前支持的配置
* textColor
TextView字体颜色

* textSize  
TextView字体大小

* imageResId
ImageView资源图片

* background
View的背景

* alpha    
View的透明度

* width    
View的宽度

* height    
View的高度

* visibility
View的可见状态