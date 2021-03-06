package Calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidproject.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Entity.Reservation;
import util.JsonTool;
import util.WebService;

/**
 * Created by MECHREVO on 2018/4/30.
 */

public class NewCalendar extends LinearLayout {

    private ImageView btnPrev;
    private ImageView btnNext;
    private TextView  txtDate;
    private GridView  grid;
    private Calendar  curDate = Calendar.getInstance();
    private  String displayFormat;


    public NewCalendarListener listener;

    public NewCalendar(Context context) {
        super(context);
    }

    public NewCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initControl(context,attrs);
    }

    public NewCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initControl(context,attrs);
    }

    private void initControl(Context context, AttributeSet attrs){
        bindControl(context);
        bindControlEvent();


        TypedArray ta =getContext().obtainStyledAttributes(attrs,R.styleable.NewCalendar);


        try {
            String format = ta.getString(R.styleable.NewCalendar_dateFormat);
            displayFormat = format;
            if(displayFormat ==null){
                displayFormat = "MMM yyyy";
            }

        }finally {
            ta.recycle();
        }
        renderCalendar();

    }


    private void bindControl(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.calendar_view,this);

        btnPrev = (ImageView)findViewById(R.id.btnPrev);
        btnNext = (ImageView)findViewById(R.id.btnNext);
        txtDate = (TextView)findViewById(R.id.tetDate);
        grid = (GridView)findViewById(R.id.calendar_grid);

    }


    private void bindControlEvent() {
        btnPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                curDate.add(Calendar.MONTH,-1);
                renderCalendar();

            }
        });

        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                curDate.add(Calendar.MONTH,1);
                renderCalendar();
            }
        });
    }

    //渲染calendar
    private void renderCalendar(){
        SimpleDateFormat sdf = new SimpleDateFormat(displayFormat);
        txtDate.setText(sdf.format(curDate.getTime()));

        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) curDate.clone();

        calendar.set(Calendar.DAY_OF_MONTH,1);
        int prevDays = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH,-prevDays);

        int maxCellCount = 6*7;
        while(cells.size()<maxCellCount){
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        grid.setAdapter(new CalendarAdapter(getContext(),cells));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                if(listener == null){
                }else{
                    listener.onItemPress((Date) parent.getItemAtPosition(position));
                }
            }
        });
        /*grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                if(listener == null){
                    return false;
                }else{
                    listener.onItemPress((Date) parent.getItemAtPosition(position));
                    return  true;
                }

            }
        });*/

    }


    private class CalendarAdapter extends ArrayAdapter<Date>{

        private String info="";

        LayoutInflater inflater;

        ArrayList<Reservation> list;
        public CalendarAdapter(@NonNull Context context,ArrayList<Date> days) {
            super(context, R.layout.calendar_text_day,days);
            inflater = LayoutInflater.from(context);
            Thread thread=new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    info= WebService.executeHttpGetP1s("reservation.do", "get_list_by_sid" ,"S001");

                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*ArrayList<Reservation> */list= JsonTool.getAllReservation("s_lists",info);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Date date = getItem(position);

            if(convertView==null)
            {
                convertView = inflater.inflate(R.layout.calendar_text_day,parent,false);
            }

            int day = date.getDate();
            ((TextView)convertView).setText(String.valueOf(day));

            Date now = new Date();
            {



                Boolean isTheSameMonth = false;
                if(date.getMonth()  == now.getMonth())
                {
                    isTheSameMonth=true;
                }
                if(isTheSameMonth){
                    ((TextView)convertView).setTextColor(Color.parseColor("#000000"));

                }else{
                    ((TextView)convertView).setTextColor(Color.parseColor("#666666"));
                }



                for(int i = 0;i<list.size();i++){

                    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                    String str=sdf.format(date);
                    if(str.equals(list.get(i).getDate())){

                        ((TextView)convertView).setTextColor(Color.parseColor("#ff0000"));
                        ((Calendar_day_textView)convertView).isToday = true;
                    }
                }

                /*if(now.getDate() == date.getDate() && now.getMonth() == date.getMonth() && now.getYear() == date.getYear()){

                    ((TextView)convertView).setTextColor(Color.parseColor("#ff0000"));
                    ((Calendar_day_textView)convertView).isToday = true;
                }*/

            }
            return convertView;
        }
    }


    public interface NewCalendarListener{
        void onItemPress(Date day);
    }


}
