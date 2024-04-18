package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculationRadiatorActivity extends AppCompatActivity {

    private static int COEFFICIENT = 41; //41 ватт на кубометр дает комфортную температуру примерно в 20 С даже в панельных многоэтажках
    private TextView output; // вывод результата
    private Button buttonBack, buttonNew; // кнопки возврата назад

    private int count = 0; // количество радиаторов
    private int costAll = 0; // стоимость радиатора

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_radiator);

        output = findViewById(R.id.output);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNew = findViewById(R.id.buttonBack);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            Radiator radiator = (Radiator) bundle.getSerializable(Radiator.class.getSimpleName());

            count = (((radiator.getSquare()) * radiator.getHeight())/1000 * COEFFICIENT)/radiator.getRadiatorPower();
            if ((float)(((radiator.getSquare()) * radiator.getHeight())/1000 * COEFFICIENT)%radiator.getRadiatorPower() > 0){
                count++;
            }

            costAll = count * radiator.getCost();

            output.setText("Для строительства нужно " + count + " радиаторов\nИх стоимость " + costAll + " монет");
        }

        buttonBack.setOnClickListener(listener);
        buttonNew.setOnClickListener(listener);
    }



    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = null; // объявление намерения

            // инициализация намерения
            switch (view.getId()) {
                case R.id.buttonBack:
                    intent = new Intent(getApplicationContext(), RadiatorActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // удаление всех активностей кроме той на которую происходит переход
                    break;
                case R.id.buttonNew:
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // перемещение нужной активности на вершину стека
                    break;
            }
            startActivity(intent); // запуск намерения
        }
    };
}