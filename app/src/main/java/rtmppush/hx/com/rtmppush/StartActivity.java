package rtmppush.hx.com.rtmppush;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import com.example.androidproject.R;


public class StartActivity extends Activity {
    public static final String RTMPURL_MESSAGE = "rtmppush.hx.com.rtmppush.rtmpurl";

    private Button _startRtmpPushButton = null;
    private EditText _rtmpUrlEditText = null;

    private View.OnClickListener _startRtmpPushOnClickedEvent = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent i = new Intent(StartActivity.this, MActivity.class);
            Intent intent = getIntent();
            String rtmpUrl="rtmp://45.76.205.111:1935/live/"+intent.getStringExtra("id");
           // String rtmpUrl = _rtmpUrlEditText.getText().toString();
          //  String rtmpUrl="rtmp://45.76.205.111:1935/live";
            i.putExtra(StartActivity.RTMPURL_MESSAGE, rtmpUrl);
            StartActivity.this.startActivity(i);
        }
    };

    private void InitUI(){
       // _rtmpUrlEditText = (EditText)findViewById(R.id.rtmpUrleditText);
        _startRtmpPushButton = (Button)findViewById(R.id.startRtmpButton);
        //_rtmpUrlEditText.setText("rtmp://45.76.205.111:1935/live");
        _startRtmpPushButton.setOnClickListener(_startRtmpPushOnClickedEvent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        InitUI();
    }
}
