package com.example.vialtoemployeeregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {

    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for(int i=1; i<10; i++){
            float value = (float)(i*10.0);

            BarEntry barEntry = new BarEntry(i, value);

            barEntries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "EmployeeDetails");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barDataSet.setDrawValues(false);

        barChart.setData(new BarData(barDataSet));

        barChart.animateY(5000);

        BarData barData = new BarData(barDataSet);

        barChart.getDescription().setText("Employee Chart");
        barChart.getDescription().setTextColor(Color.BLUE);
        
    }
}