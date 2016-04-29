package com.lmntrx.indoornavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");

        Element Mazhar = new Element();
        Mazhar.setTitle("Mazhar Ansari");

        Element Kiran = new Element();
        Kiran.setTitle("Kiran Tomy");

        Element Anstin = new Element();
        Anstin.setTitle("Anstin Babu");

        Element Diljose = new Element();
        Diljose.setTitle("Diljose Paul");


        String desc="Indoor Navigation App for C Block of Viswajyothi College Of Engineering And Technology.";




        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(desc)
                .setImage(R.mipmap.ic_launcher)
                .addItem(versionElement)
                .addGroup("Contributors")
                .addItem(Mazhar)
                .addItem(Kiran)
                .addItem(Anstin)
                .addItem(Diljose)
                .create();

        setContentView(aboutPage);




    }
}
