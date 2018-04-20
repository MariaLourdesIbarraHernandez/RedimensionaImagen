package com.example.fundacionc.redimensionaimagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView imagen;
SeekBar seekBar;
private  int iWidth =65;
private int iHeight = 52;
float density;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;

        imagen = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {

                float ancho = (Progress + iWidth) + density / 160;
                float alto = (Progress + iHeight) + density / 160;

                imagen.getLayoutParams().height =(int)alto;
                imagen.getLayoutParams().width =(int)ancho;
                imagen.requestLayout();

                if(Progress==0)
                    Toast.makeText(getApplicationContext(),"ESTOY AL PRINCIPIO",Toast.LENGTH_LONG).show();
                else if(Progress==100)
                    Toast.makeText(getApplicationContext(),"ESTOY AL FINAL :)",Toast.LENGTH_LONG).show();
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
}
