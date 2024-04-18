package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RadiatorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiator);

        square = findViewById(R.id.square);
        height = findViewById(R.id.height);
        radiatorPower = findViewById(R.id.radiatorPower);
        costRadiator = findViewById(R.id.costRadiator);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }

    private EditText square, height, radiatorPower;
    private EditText costRadiator;
    private Button button;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int squareInt = Integer.parseInt(square.getText().toString());
            int heightInt = Integer.parseInt(height.getText().toString());
            int radiatorPowerInt = Integer.parseInt(radiatorPower.getText().toString());
            int costRadiatorInt = Integer.parseInt(costRadiator.getText().toString());

            Radiator radiator = new Radiator(squareInt, heightInt, radiatorPowerInt, costRadiatorInt);

            Intent intent = new Intent(getApplicationContext(), com.msaggik.fifthlessonconstructioncalculator.CalculationRadiatorActivity.class); // создание объекта намерения
            intent.putExtra(Radiator.class.getSimpleName(), radiator); // вложение в намерение значения объекта wallpaper по ключу Wallpaper.class.getSimpleName()
            startActivity(intent); // запуск намерения
        }
    };
}
