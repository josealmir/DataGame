package com.app.datagame;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int [] diceeArray = {
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textViewPlayerName = findViewById(R.id.txtPlayerName);
        Intent intent = getIntent();
        String  fullName = "Olá ";
        textViewPlayerName.setText(fullName.concat(intent.getStringExtra("PlayerName")).concat(" !"));

        ImageView imageViewLeft = findViewById(R.id.imgLeft);
        ImageView imageViewRight = findViewById(R.id.imgRight);

        Button buttonRoll = findViewById(R.id.btnRoll);
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int diceRight = getNumber();
                imageViewRight.setImageResource(diceeArray[diceRight]);

                int diceLeft = getNumber();
                imageViewLeft.setImageResource(diceeArray[diceLeft]);

                String message = "Total: " + (diceRight + diceLeft + 2);

                Toast.makeText(GameActivity.this, message , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getNumber() {
        return new  Random().nextInt(6);
    }
}