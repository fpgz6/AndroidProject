package Layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.androidproject.R;



/**
 * Created by MECHREVO on 2018/4/26.
 */

public class BottomLayout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom,container,false);
        return view;
    }

    /*private Button teacher;
    private Button course;
    private Button account;
    private MainActivity mainActivity;
    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom,this);
        init();
    }

    private void init() {
        course = findViewById(R.id.course);
        course.setOnClickListener(this);
        teacher = findViewById(R.id.teacher);
        teacher.setOnClickListener(this);
        account = findViewById(R.id.account);
        account.setOnClickListener(this);

        mainActivity = new MainActivity();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.teacher :
                Log.d("woaini","teacher");
                mainActivity.changeFragmentTeacher();
                break;
            case R.id.course:
                Log.d("woaini","course");
                mainActivity.changeFragmentCourse();
                break;
            case R.id.account:
                Log.d("woaini","account");
                mainActivity.changeFragmentAccount();
                break;
            default:break;
        }

    }*/
}
