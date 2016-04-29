package com.lmntrx.indoornavigation;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView indoorTXT= (TextView) findViewById(R.id.indoorTXT);
        final TextView vjcTXT= (TextView) findViewById(R.id.vjcTXT);

        final Button b1= (Button) findViewById(R.id.NavigationBTN);
        final Button b2= (Button) findViewById(R.id.GalleryBTN);
        final Button b3= (Button) findViewById(R.id.AboutBTN);

        final Button b4= (Button) findViewById(R.id.ExitBTN);
        final Button b5= (Button) findViewById(R.id.EmergencyBTN);

        indoorTXT.setTranslationY(300);
        vjcTXT.setTranslationY(300);


        // Animation code
        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(2000);




        // animation code handler
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                indoorTXT.animate().translationYBy(-400).setDuration(1500);
                vjcTXT.animate().translationYBy(-400).setDuration(1500);








            }
        }, 2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                indoorTXT.setBackgroundColor(98020101);
                vjcTXT.setBackgroundColor(98020101);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
                b4.setVisibility(View.VISIBLE);
                b5.setVisibility(View.VISIBLE);
                b1.setAnimation(fadeIn);
                b2.setAnimation(fadeIn);
                b3.setAnimation(fadeIn);
                b4.setAnimation(fadeIn);
                b5.setAnimation(fadeIn);


            }
        }, 2600);




    }

    public void enterNavigation(View view) {
        Intent intent = new Intent(this, Navigation.class);
        startActivity(intent);
    }

    public void enterGallery(View view) {
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }

    public void enterAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void exit(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void enterEmergency(View view) {

        Intent intent = new Intent(this, EmergencyExits.class);
        startActivity(intent);
    }
}
