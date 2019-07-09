package com.bawei.wuxinzhong20190709.view.xlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * <p>文件描述：自定义的GridView<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class XlistView extends GridView {
    public XlistView(Context context) {
        super(context);
    }

    public XlistView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XlistView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
