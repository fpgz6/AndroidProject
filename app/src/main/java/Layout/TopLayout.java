package Layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import  com.example.androidproject.R;


/**
 * Created by MECHREVO on 2018/4/26.
 */

public class TopLayout extends LinearLayout {
    public TopLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top,this);
    }
}
