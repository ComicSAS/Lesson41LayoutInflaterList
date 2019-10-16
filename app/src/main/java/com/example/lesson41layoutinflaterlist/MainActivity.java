package com.example.lesson41layoutinflaterlist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    String[] name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь"};
    String[] position = {"Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник"};
    int[] salary = {13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000};

    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = findViewById(R.id.linLayout);
        LayoutInflater layoutInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++) {
            Log.d("myLogs", "i = " + i);

            View item = layoutInflater.inflate(R.layout.item, linLayout, false);
            TextView tvName = item.findViewById(R.id.tvName);
            TextView tvPosition = item.findViewById(R.id.tvPosition);
            TextView tvSalary = item.findViewById(R.id.tvSalary);

            tvName.setText(name[i]);
            tvPosition.setText(position[i]);
            tvSalary.setText(String.valueOf(salary[i]));

            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linLayout.addView(item);
        }

    }
}
