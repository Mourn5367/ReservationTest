package kr.ac.kopo.reservationtest;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Chronometer chronometer;
    RadioGroup rg;
    RadioButton rbDate, rbTime;
    DatePicker calendarView;
    TimePicker timePicker;
    TextView textResult;
//    Button btnStart;
//    Button btnDone;

    int selectedYear, selectedMonth, selectedDay, selectedHour, seletedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        chronometer = findViewById(R.id.chrono);
        //btnStart = findViewById(R.id.btn_start);
        rg = findViewById(R.id.rg);
        rbDate = findViewById(R.id.rb_date);
        rbTime = findViewById(R.id.rb_time);
        calendarView = findViewById(R.id.calendar_id);
        timePicker = findViewById(R.id.timepicker_id);
        textResult = findViewById(R.id.text_result);
        //btnDone = findViewById(R.id.btn_done);

        rg.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        rbDate.setOnClickListener(rbClickListener);
        rbTime.setOnClickListener(rbClickListener);
        chronometer.setOnClickListener(chronoListener);
        textResult.setOnLongClickListener(textListener);
        //btnDone.setOnClickListener(btnClickListener);
        //btnStart.setOnClickListener(btnClickListener);

//        calendarView.setOnDateChangeListener(calendarChangeListener);
    }

    View.OnClickListener chronoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            //rg.setVisibility(View.VISIBLE);
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            chronometer.setTextColor(Color.RED);
            rg.setVisibility(View.VISIBLE);
        }
    };

    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v)
        {
            chronometer.stop();
            chronometer.setTextColor(Color.BLUE);
            rg.setVisibility(View.INVISIBLE);
            calendarView.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            selectedYear = calendarView.getYear();
            selectedMonth = calendarView.getMonth() + 1;
            selectedDay = calendarView.getDayOfMonth();
            selectedHour = timePicker.getHour();
            seletedMinute = timePicker.getMinute();
            textResult.setText(selectedYear+"년 "+ selectedMonth + "월 " + selectedDay +
                    "일 " + selectedHour + "시 " + seletedMinute +"분 예약완료됨");

            return true;
        }

    };

//    View.OnClickListener startBtnClickListener = new View.OnClickListener()
//    {
//        @Override
//        public void onClick(View v) {
//            Button eventBtn = (Button) v;
//            {
//                if (eventBtn == btnStart)
//                {
//                    rg.setVisibility(View.VISIBLE);
//                }
//            }
//        }
//    };

    View.OnClickListener rbClickListener = new View.OnClickListener() {
        @Override

        public void onClick(View v)
        {
            calendarView.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);

            RadioButton rbEvent = (RadioButton) v;
            if (rbEvent == rbDate)
            {
                calendarView.setVisibility(View.VISIBLE);
            }
            else if (rbEvent == rbTime)
            {
                timePicker.setVisibility(View.VISIBLE);
            }
        }
    };

//    View.OnClickListener btnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Button btnEvent = (Button) v;
//
//            if (btnEvent == btnStart)
//            {
//                rg.setVisibility(View.VISIBLE);
//                chronometer.setBase(SystemClock.elapsedRealtime());
//                chronometer.start();
//                chronometer.setTextColor(Color.RED);
//            }
//            else if (btnEvent == btnDone)
//            {
//                chronometer.stop();
//                chronometer.setTextColor(Color.BLUE);
//                rg.setVisibility(View.INVISIBLE);
//                selectedYear = calendarView.getYear();
//                selectedMonth = calendarView.getMonth() + 1;
//                selectedDay = calendarView.getDayOfMonth();
//                selectedHour = timePicker.getHour();
//                seletedMinute = timePicker.getMinute();
//                textResult.setText(selectedYear+"년 "+ selectedMonth + "월 " + selectedDay +
//                        "일 " + selectedHour + "시 " + seletedMinute +"분\n 예약완료됨");
//            }
//        }
//    };

//    CalendarView.OnDateChangeListener calendarChangeListener = new CalendarView.OnDateChangeListener() {
//        @Override
//        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
//        {
//            selectedYear = year;
//            selectedMonth = month + 1; // 0 이 1월이라
//            selectedDay = dayOfMonth;
//        }
//    };

}