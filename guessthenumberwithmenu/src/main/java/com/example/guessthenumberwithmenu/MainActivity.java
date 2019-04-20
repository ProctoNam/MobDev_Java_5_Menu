package com.example.guessthenumberwithmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int r = new Random().nextInt(100 / 1);
    int level = 1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

    }

    public void onClick(View view) {
        try{
            int value = Integer.parseInt(etInput.getText().toString());
            if (value > 100*level || value < 0)
            {
                throw new InstantiationException();
            }
            if (value > r)
            {
                tvInfo.setText(getResources().getString(R.string.ahead)+" (Ответ)" +r);
            }
            else if (value < r)
            {
                tvInfo.setText(getResources().getString(R.string.behind)+" (Ответ)" +r);
            }
            else if (value == r)
            {
                tvInfo.setText(getResources().getString(R.string.hit)+" (Ответ)" +r);
            }
        }
        catch(InstantiationException e)
        {
            tvInfo.setText("Введенное число не должно быть выше "+ 100*level +" и не должно быть менее 0!");
        }
        catch(Exception e){
            tvInfo.setText(getResources().getString(R.string.error)+r);
        }
        //tvInfo.setText(getResources().getString(R.string.ahead)+r);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();


        switch (item.getItemId()) {
            case R.id.menu_lvl:
                level++;
                r = new Random().nextInt(100*level / 1);
                if (level > 3)
                {
                    level = 1;
                    r = new Random().nextInt(100*level / 1);
                }
                return true;
            case R.id.menu_new:
                r = new Random().nextInt(100*level / 1);
                return true;
            case R.id.menu_exit:
                System.exit(0);}
        // Выведем в TextView информацию о нажатом пункте меню

        return super.onOptionsItemSelected(item);
    }

}

