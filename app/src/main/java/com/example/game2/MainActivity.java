package com.example.game2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game2.controlador.Controlador;
import com.example.game2.modelo.Modelo;
import com.example.game2.vista.vista;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, vista {
    Button btn_1,btn_2;
    ImageView bloque;
    TextView txtMsg;
    Controlador controlador;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modelo modelo = new Modelo();
        this.controlador = new Controlador(this,modelo);
        initViews();
        listeners();
        handler = new Handler(Looper.getMainLooper());

    }

    private void listeners() {
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initViews() {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        bloque = findViewById(R.id.bloque);
        txtMsg = findViewById(R.id.msg);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (controlador.isOnRace()){
            switch (id) {
                case R.id.btn_1:
                    controlador.player1Accion();
                    break;
                case R.id.btn_2:
                    controlador.player2Accion();
                    break;
            }
        }

    }

    @Override
    public void showMsg(String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(!txtMsg.isShown()){
                    txtMsg.setVisibility(View.VISIBLE);
                }

                txtMsg.setText(msg);

                ObjectAnimator sX = ObjectAnimator.ofFloat(txtMsg, "scaleX", 0.5f, 1.0f);
                ObjectAnimator sY = ObjectAnimator.ofFloat(txtMsg, "scaleX", 0.5f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(sY,sX);
                animatorSet.start();

            }
        });
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void hideMsg() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);
    }
}