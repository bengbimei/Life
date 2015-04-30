package utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by aaa on 15-4-30.
 */
public class NewListView extends ListView{
    public NewListView(Context context) {
        super(context);
    }

    public NewListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childHeight = getMeasuredHeight() - (getListPaddingTop() + getListPaddingBottom() +  getVerticalFadingEdgeLength() * 2);
        int fullHeight = getListPaddingTop() + getListPaddingBottom() + childHeight*(getCount());
        setMeasuredDimension(getMeasuredWidth(), fullHeight);
    }
}
