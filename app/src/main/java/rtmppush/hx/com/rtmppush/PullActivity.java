package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import com.example.Freedom.UserSession;
import com.example.androidproject.R;

/**
 * Created by MECHREVO on 2018/4/26.
 */

public class PullActivity extends Fragment {
    private static final String TAG = "MainActivity";
    private String path;
    //private HashMap<String, String> options;
    private VideoView mVideoView;
    private View view;
    private Activity activity;
    private TextView textView;

    // session 相关
    private UserSession usersession;
    private String id;


    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_two,container,false);

        Log.d("Right","onCreateView");

        usersession = (UserSession) view.getContext().getApplicationContext();
        id = usersession.getUsername();
if(!id.equals("T001")){id="S001";}
        mVideoView = (VideoView) view.findViewById(R.id.vitamio_videoView);
        path = "rtmp://45.76.205.111:1935/live/"+id;
        Log.d("Right",path);

       // mVideoView.setVideoPath(path);


        mVideoView.setVideoPath(path);

        mVideoView.setMediaController(new MediaController(activity));
        mVideoView.requestFocus();
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });

        Log.d("Right","finish");
        return view;
    }


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        Log.d("Right","onCreate");

        activity=getActivity();

        if (!LibsChecker.checkVitamioLibs(activity)){
        return;
        }


    }



    public void onPause() {
        super.onPause();
    }

}

