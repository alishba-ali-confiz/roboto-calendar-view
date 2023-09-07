/*
 * Copyright (C) 2016 Marco Hernaiz Cao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marcohc.robotocalendarview.sample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.marcohc.robotocalendarview.RobotoCalendarView;
import com.marcohc.robotocalendarview.RobotoCalendarView.RobotoCalendarListener;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity implements RobotoCalendarListener {

    private RobotoCalendarView robotoCalendarView;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Gets the calendar from the view
        robotoCalendarView = findViewById(R.id.robotoCalendarPicker);
        Button markDayButton = findViewById(R.id.markDayButton);
        Button clearSelectedDayButton = findViewById(R.id.clearSelectedDayButton);

        int year = 2023;
        int month = Calendar.SEPTEMBER; // Calendar.MONTH is 0-based, so August is 7
        int day = 5;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        Date date = calendar.getTime();
//        Log.i("TAGG","Date:  "+date);
//        robotoCalendarView.markCircleImage2(date);

//        markDayButton.setOnClickListener(view -> {
//            Calendar calendar = Calendar.getInstance();
//            Random random = new Random(System.currentTimeMillis());
//            int style = random.nextInt(2);
//            int daySelected = random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            calendar.set(Calendar.DAY_OF_MONTH, daySelected);
//
//            switch (style) {
//                case 0:
//                    robotoCalendarView.markCircleImage1(calendar.getTime());
//                    break;
//                case 1:
//                    robotoCalendarView.markCircleImage2(calendar.getTime());
//                    break;
//                default:
//                    break;
//            }
//        });

        clearSelectedDayButton.setOnClickListener(v -> robotoCalendarView.clearSelectedDay());

        // Set listener, in this case, the same activity
        robotoCalendarView.setRobotoCalendarListener(this);

        robotoCalendarView.setShortWeekDays(false);

        robotoCalendarView.showDateTitle(true);

       robotoCalendarView.setDate(new Date());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onDayClick(Date date) {
        Toast.makeText(this, "onDayClick: " + date, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDayLongClick(Date date) {
        Toast.makeText(this, "onDayLongClick: " + date, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRightButtonClick() {
        Toast.makeText(this, "onRightButtonClick!", Toast.LENGTH_SHORT).show();
        robotoCalendarView.invalidate();
    }

    @Override
    public void onLeftButtonClick() {
        Toast.makeText(this, "onLeftButtonClick!", Toast.LENGTH_SHORT).show();
        robotoCalendarView.invalidate();
    }

}
