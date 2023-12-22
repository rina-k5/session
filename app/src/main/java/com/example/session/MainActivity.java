package com.example.session;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText edName, edPassword;
Button btnReg;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);

        edPassword = findViewById(R.id.edName);

        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        dbHelper = new DBHelper(this);//подключение к базе

// Получение значений из EditText
        String login = edName.getText().toString();
        String password = edPassword.getText().toString();

// Добавление данных в базу данных
        boolean isDataAdded = dbHelper.addLoginData(login, password);

        if (isDataAdded) {
            Toast.makeText(this, "Данные успешно сохранены в базу данных", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ошибка при сохранении данных", Toast.LENGTH_SHORT).show();
        }


    }
}

