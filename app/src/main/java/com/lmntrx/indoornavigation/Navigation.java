package com.lmntrx.indoornavigation;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

public class Navigation extends AppCompatActivity {

    PointF from_PointF=new PointF(800f,400f);
    PointF to_PointF=new PointF(300f, 400f);
    PointF original_to_PointF,original_from_PointF;
    PointF floor1_Stairs1;
    PointF floor2_Stairs1;
    PointF floor3_Stairs1;

    public View thisview;

    public static int chooseroute=-1 , fromlocation=0,tolocation=0;
    public static int from_floor=1,to_floor=1;

    public static int fabControl=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // X,Y Coordinates of stairs
        floor1_Stairs1 = new PointF(1460f, 1600f);
        floor2_Stairs1 = new PointF(1460f, 1600f);
        floor3_Stairs1 = new PointF(1600f, 1900f);


        // Start from these data
        from_floor = 1;
        to_floor = 1;

        // function to show/hide fab
        fabDisplay();

        // background map setting
        final PinView imageView = (PinView) findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);
        imageView.setImage(ImageSource.resource(R.drawable.map1));

        // choose 2 default x,y coordinates and display 2 pins at 2 default locations. Initialising Pins
        chooseroute = 0;
        //setPin assigns pins to corresponding locations
        imageView.setPin(from_PointF, to_PointF, chooseroute);


    }


// This function is called whenever From button is clicked
    public void from_popup(View view) {
        thisview=view;



        final Button toFloorBTN=(Button)findViewById(R.id.ToFloorBTN);
        final Button toBTN= (Button) findViewById(R.id.ToDropDownBTN);



        final PinView imageView = (PinView) findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_from = (Button) findViewById(R.id.FromDropDownBTN);

        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this, anchor_from);


// whenever an item in from popup menu is clicked set From_PointF to that location.
            if (from_floor == 1) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_1_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {

                                toBTN.setText("TO");
                                toFloorBTN.setText("-");

                                switch (which) {

                                    case R.id.floor1_langLab:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Language Lab");


                                        //these are coordinates of language lab . similarly do for all nodes.
                                        from_PointF = new PointF(280f, 1021f);



                                        break;
                                    case R.id.floor1_ecStaffRoom:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("EC Staff Room");
                                        from_PointF = new PointF(500f, 1020f);




                                        break;
                                    case R.id.floor1_ptcSeminarHall:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("PTC Hall");
                                        from_PointF = new PointF(1000f, 1020f);




                                        break;
                                    case R.id.floor1_placementTraining:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Placement Training Center");
                                        from_PointF = new PointF(1800f, 1020f);



                                        break;

                                    case R.id.floor1_placementStaffRoom:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Placement Staff Room");
                                        from_PointF = new PointF(1700f, 1500f);


                                        break;

                                    case R.id.floor1_studentCouncil:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Student Council");
                                        from_PointF = new PointF(1900f, 1600f);



                                        break;

                                    case R.id.floor1_gdRoom:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("GD Room");
                                        from_PointF = new PointF(2100f, 1600f);




                                        break;

                                }

                                // draw pins at chosen location.
                                chooseroute=0;
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                            }
                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();
            } else if (from_floor == 2) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_2_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {

                                toBTN.setText("TO");
                                toFloorBTN.setText("-");
                                switch (which) {

                                    case R.id.floor2_vicePrincy:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Vice Principal");
                                        from_PointF = new PointF(3550f, 700f);



                                        break;

                                    case R.id.floor2_scienceDept:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Science and Humanities Dept");
                                        from_PointF = new PointF(3150f, 700f);

                                        break;

                                    case R.id.floor2_csStaffRoom:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CS Staff Room");
                                        from_PointF = new PointF(3000f, 1200f);
                                        original_from_PointF=from_PointF;



                                        break;

                                    case R.id.floor2_ecStaffRoom1:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("EC Staff Room 1");
                                        from_PointF = new PointF(450f, 950f);

                                        break;

                                    case R.id.floor2_ecStaffRoom2:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("EC Staff Room 2");
                                        from_PointF = new PointF(1900f, 1550f);

                                        break;

                                    case R.id.floor2_s8eca:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S8 ECA");
                                        from_PointF = new PointF(1700f, 950f);

                                        break;

                                    case R.id.floor2_s8ecb:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S8 EC B");
                                        from_PointF = new PointF(2150f, 950f);

                                        break;

                                    case R.id.floor2_s6eca:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S6 ECA");
                                        from_PointF = new PointF(950f, 950f);

                                        break;

                                    case R.id.floor2_s6ecb:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S6 EC B");
                                        from_PointF = new PointF(1250f, 950f);

                                        break;

                                    case R.id.floor2_s4csb:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S4 CSB");
                                        from_PointF = new PointF(2800f, 1200f);

                                        break;

                                    case R.id.floor2_ktu:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("KTU Exam Control Room");
                                        from_PointF = new PointF(3230f, 1200f);

                                        break;

                                    case R.id.floor2_mg:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("MG Exam Control Room");
                                        from_PointF = new PointF(3550f, 1200f);

                                        break;
                                }
                                chooseroute=0;
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                            }


                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();

            }
            // 3 separate ifs because 3 floors
            else if (from_floor == 3) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {

                                toBTN.setText("TO");
                                toFloorBTN.setText("-");
                                switch (which) {

                                    case R.id.floor3_csHOD:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CS HOD");

                                        from_PointF = new PointF(2425f, 260f);

                                        break;

                                    case R.id.floor3_meHOD:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Mech HOD");
                                        from_PointF = new PointF(3000f, 1620);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;


                                        break;


                                    case R.id.floor3_ccc:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CCC");
                                        from_PointF = new PointF(1650f, 1421f);

                                        break;

                                    case R.id.floor3_csLibrary:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CS Library");
                                        from_PointF = new PointF(2900f, 700f);

                                        break;

                                    case R.id.floor3_s8csa:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S8 CSA");
                                        from_PointF = new PointF(950f, 1415f);

                                        break;

                                    case R.id.floor3_s8csb:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S8 CSB");
                                        from_PointF = new PointF(1250f, 1415f);

                                        break;

                                    case R.id.floor3_s6csa:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S6 CSA");
                                        from_PointF = new PointF(250f, 1415f);

                                        break;

                                    case R.id.floor3_s6csb:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S6 CSB");
                                        from_PointF = new PointF(550f, 1415f);


                                        break;

                                    case R.id.floor3_s4csa:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S4 CSA");
                                        from_PointF = new PointF(2800f, 1620f);

                                        break;

                                    case R.id.floor3_s4mea:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S4 ME A");
                                        from_PointF = new PointF(3550f, 1620f);
                                        break;

                                    case R.id.floor3_s4meb:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("S4 ME B");
                                        from_PointF = new PointF(3230f, 1620f);

                                        break;

                                    case R.id.floor3_seminarHall1:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Seminar Hall 1");
                                        from_PointF = new PointF(2650f, 260f);

                                        break;

                                    case R.id.floor3_seminarHall2:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Seminar Hall 2");
                                        from_PointF = new PointF(3200f, 260f);

                                        break;


                                    case R.id.floor3_csStaffRoom1:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CS Staff Room 1");
                                        from_PointF = new PointF(1800f, 2075f);

                                        break;

                                    case R.id.floor3_csStaffRoom2:

                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("CS Staff Room 2");
                                        from_PointF = new PointF(2620f, 800f);

                                        break;

                                    case R.id.floor3_meStaffRoom:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("ME Staff Room");
                                        from_PointF = new PointF(3200f, 1100f);

                                        break;

                                    case R.id.floor3_serverRoom:
                                        fromlocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_from.setText("Server Room");
                                        from_PointF = new PointF(2250f, 1420f);

                                        break;

                                }

                                chooseroute=0;
                                imageView.setPin(from_PointF, to_PointF, chooseroute);
                            }
                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();


            }




        }

    // This function is called whenever To button is clicked
    public void to_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_to = (Button) findViewById(R.id.ToDropDownBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);


        // similar to from button. but here assign  to_PointF  = whichever option clicked

            if (to_floor == 1) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_1_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {



                                switch (which) {

                                    case R.id.floor1_langLab:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Language Lab");
                                        to_PointF = new PointF(280f, 1021f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            // a correct path is drawn only when to button is clicked.
                                            // function to choose the correct route to show path
                                            calculateInitialRoute();

                                        }

                                        // sets pins and also draws the path
                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;
                                    case R.id.floor1_ecStaffRoom:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("EC Staff Room");
                                        to_PointF = new PointF(500f, 1020f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;
                                    case R.id.floor1_ptcSeminarHall:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("PTC Hall");
                                        to_PointF = new PointF(1000f, 1020f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;
                                    case R.id.floor1_placementTraining:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Placement Training Center");
                                        to_PointF = new PointF(1800f, 1020f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor1_placementStaffRoom:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Placement Staff Room");
                                        to_PointF = new PointF(1700f, 1500f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor1_studentCouncil:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Student Council");
                                        to_PointF = new PointF(1900f, 1600f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor1_gdRoom:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("GD Room");
                                        to_PointF = new PointF(2100f, 1600f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                }
                            }
                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();
            } else if (to_floor == 2) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_2_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {



                                switch (which) {

                                    case R.id.floor2_vicePrincy:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Vice Principal");
                                        to_PointF = new PointF(3550f, 700f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_scienceDept:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Science and Humanities Dept");
                                        to_PointF = new PointF(3150f, 700f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_csStaffRoom:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CS Staff Room");
                                        to_PointF = new PointF(3000f, 1200f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_ecStaffRoom1:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("EC Staff Room 1");
                                        to_PointF = new PointF(450f, 950f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_ecStaffRoom2:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("EC Staff Room 2");
                                        to_PointF = new PointF(1900f, 1550f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_s8eca:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S8 ECA");
                                        to_PointF = new PointF(1700f, 950f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_s8ecb:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S8 EC B");
                                        to_PointF = new PointF(2150f, 950f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_s6eca:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S6 ECA");
                                        to_PointF = new PointF(950f, 950f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_s6ecb:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S6 EC B");
                                        to_PointF = new PointF(1250f, 950f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_s4csb:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S4 CSB");
                                        to_PointF = new PointF(2800f, 1200f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_ktu:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("KTU Exam Control Room");
                                        to_PointF = new PointF(3230f, 1200f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor2_mg:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("MG Exam Control Room");
                                        to_PointF = new PointF(3550f, 1200f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;
                                }
                            }
                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();
            } else if (to_floor == 3) {
                droppyMenu = droppyBuilder.fromMenu(R.menu.floor_3_locations)
                        .triggerOnAnchorClick(false)
                        .setOnClick(new DroppyClickCallbackInterface() {
                            @Override
                            public void call(View v, int which) {



                                switch (which) {

                                    case R.id.floor3_csHOD:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CS HOD");
                                        to_PointF = new PointF(2425f, 260f);
                                       // /*/

                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                     //   /*/

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_meHOD:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Mech HOD");
                                        to_PointF = new PointF(3000f, 1620);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();

                                        }

                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;


                                    case R.id.floor3_ccc:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CCC");
                                        to_PointF = new PointF(1650f, 1421f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_csLibrary:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CS Library");
                                        to_PointF = new PointF(2900f, 700f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }



                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s8csa:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S8 CSA");
                                        to_PointF = new PointF(950f, 1415f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s8csb:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S8 CSB");
                                        to_PointF = new PointF(1250f, 1415f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s6csa:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S6 CSA");
                                        to_PointF = new PointF(250f, 1415f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s6csb:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S6 CSB");
                                        to_PointF = new PointF(550f, 1415f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s4csa:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S4 CSA");
                                        to_PointF = new PointF(2800f, 1620f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s4mea:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S4 ME A");
                                        to_PointF = new PointF(3550f, 1620f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_s4meb:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("S4 ME B");
                                        to_PointF = new PointF(3230f, 1620f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;

                                            calculateInitialRoute();

                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_seminarHall1:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Seminar Hall 1");
                                        to_PointF = new PointF(2650f, 260f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_seminarHall2:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Seminar Hall 2");
                                        to_PointF = new PointF(3200f, 260f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;


                                    case R.id.floor3_csStaffRoom1:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CS Staff Room 1");
                                        to_PointF = new PointF(1800f, 2075f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_csStaffRoom2:

                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("CS Staff Room 2");
                                        to_PointF = new PointF(2620f, 800f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_meStaffRoom:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("ME Staff Room");
                                        to_PointF = new PointF(3200f, 1100f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                    case R.id.floor3_serverRoom:
                                        tolocation = which;
                                        chooseroute = fromlocation * 100 + tolocation;
                                        anchor_to.setText("Server Room");
                                        to_PointF = new PointF(2250f, 1420f);
                                        original_from_PointF=from_PointF;
                                        original_to_PointF=to_PointF;

                                        if(from_floor!=to_floor && fabControl==0)
                                        {
                                            from_PointF = original_from_PointF;

                                            if (from_floor==1)
                                                to_PointF=floor1_Stairs1;
                                            else if(from_floor==2)
                                                to_PointF=floor2_Stairs1;
                                            else if(from_floor==3)
                                                to_PointF=floor3_Stairs1;


                                            calculateInitialRoute();
                                        }


                                        imageView.setPin(from_PointF, to_PointF, chooseroute);
                                        break;

                                }
                            }
                        })
                        .setPopupAnimation(new DroppyFadeInAnimation())
                        .setXOffset(-6)
                        .setYOffset(5)
                        .build();
                droppyMenu.show();
            }
        }


    // this function is called whenever from floor button is clicked
    public void from_floor_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);

        final Button toFloorBTN=(Button)findViewById(R.id.ToFloorBTN);
        final Button toBTN= (Button) findViewById(R.id.ToDropDownBTN);
        final Button fromBTN = (Button) findViewById(R.id.FromDropDownBTN);




        final Button anchor_to = (Button) findViewById(R.id.FromFloorBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);
        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {

                        fromBTN.setText("FROM");
                        toBTN.setText("TO");
                        toFloorBTN.setText("-");

                        switch (which)
                        {
                            case R.id.floor1 :
                                Navigation.from_floor=1;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map1));
                                anchor_to.setText("1");
                                break;
                            case R.id.floor2 :
                                Navigation.from_floor=2;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map2));
                                anchor_to.setText("2");
                                break;
                            case R.id.floor3 :
                                Navigation.from_floor=3;
                                fabDisplay();
                                imageView.setImage(ImageSource.resource(R.drawable.map3));
                                anchor_to.setText("3");
                                break;

                        }

                    }
                })


                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(-6)
                .setYOffset(5)
                .build();
        droppyMenu.show();
    }

    // this function is called whenever to floor button is clicked
    public void to_floor_popup(View view) {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        final Button anchor_to = (Button) findViewById(R.id.ToFloorBTN);
        DroppyMenuPopup droppyMenu;
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this,anchor_to);
        droppyMenu = droppyBuilder.fromMenu(R.menu.floor_menu)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int which) {
                        switch (which)
                        {
                            case R.id.floor1 :
                                Navigation.to_floor=1;
                                fabDisplay();
                                anchor_to.setText("1");
                                break;
                            case R.id.floor2 :
                                Navigation.to_floor=2;
                                fabDisplay();
                                anchor_to.setText("2");
                                break;
                            case R.id.floor3 :
                                Navigation.to_floor=3;
                                fabDisplay();
                                anchor_to.setText("3");
                                break;

                        }

                    }
                })


                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(-6)
                .setYOffset(5)
                .build();
        droppyMenu.show();
    }

    // function to determine fab hide/show
    public void fabDisplay()  {
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        if (Navigation.from_floor==Navigation.to_floor)
        {
            floatingActionButton.hide();
            PinView.fabCounter=0;
        }

        else {
            floatingActionButton.show();
            PinView.fabCounter=0;
        }

    }

    // this function is executed whenever user presses fab button
    public void chooseNextFloor(View view) {
        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
        imageView.setZoomEnabled(false);

        Button fromBTN= (Button) findViewById(R.id.FromDropDownBTN);
        Button toBTN= (Button) findViewById(R.id.ToDropDownBTN);
        Button fromFloorBTN= (Button) findViewById(R.id.FromFloorBTN);
        Button toFloorBTN= (Button) findViewById(R.id.ToFloorBTN);

        if(fabControl==0)
        {
            if(Navigation.to_floor==1)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map1));
                fabControl=1;
                fromBTN.setEnabled(false);
                toBTN.setEnabled(false);
                fromFloorBTN.setEnabled(false);
                toFloorBTN.setEnabled(false);

            }

            else if(Navigation.to_floor==2)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map2));
                fabControl=1;
                fromBTN.setEnabled(false);
                toBTN.setEnabled(false);
                fromFloorBTN.setEnabled(false);
                toFloorBTN.setEnabled(false);
            }

            else if(Navigation.to_floor==3)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map3));
                fabControl=1;
                fromBTN.setEnabled(false);
                toBTN.setEnabled(false);
                fromFloorBTN.setEnabled(false);
                toFloorBTN.setEnabled(false);
            }

        }


        else
        {
            if(Navigation.from_floor==1)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map1));
                fabControl=0;
                fromBTN.setEnabled(true);
                toBTN.setEnabled(true);
                fromFloorBTN.setEnabled(true);
                toFloorBTN.setEnabled(true);
            }

            else if(Navigation.from_floor==2)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map2));
                fabControl=0;
                fromBTN.setEnabled(true);
                toBTN.setEnabled(true);
                fromFloorBTN.setEnabled(true);
                toFloorBTN.setEnabled(true);
            }

            else if(Navigation.from_floor==3)
            {
                imageView.setImage(ImageSource.resource(R.drawable.map3));
                fabControl=0;
                fromBTN.setEnabled(true);
                toBTN.setEnabled(true);
                fromFloorBTN.setEnabled(true);
                toFloorBTN.setEnabled(true);
            }


        }

        redrawOnFabClick();



    }

    // 2nd part of chooseNextFloor. also executed whenever user presses fab button
    public void redrawOnFabClick() {

        final PinView imageView = (PinView)findViewById(R.id.navigationScaleIMGVIEW);

        if(from_floor!=to_floor && fabControl==0)
        {
            from_PointF = original_from_PointF;

            if (from_floor==1)
                to_PointF=floor1_Stairs1;
            else if(from_floor==2)
                to_PointF=floor2_Stairs1;
            else if(from_floor==3)
                to_PointF=floor3_Stairs1;


            calculateInitialRoute();
            imageView.setPin(from_PointF, to_PointF, chooseroute);



        }

        else if(from_floor!=to_floor && fabControl==1) { // CALLED FIRST
            if (to_floor == 1)
                from_PointF = floor1_Stairs1;
            else if (to_floor == 2)
                from_PointF = floor2_Stairs1;
            else if (to_floor == 3)
                from_PointF = floor3_Stairs1;

            to_PointF = original_to_PointF;


            calculateFinalRoute();

            imageView.setPin(from_PointF, to_PointF, chooseroute);




        }



    }

    // function to calculate chooseRoute
    void calculateInitialRoute() {
        switch (fromlocation)
        {
            case R.id.floor1_langLab:

                chooseroute=101;
                break;

            case R.id.floor1_ecStaffRoom:
                chooseroute=102;
                break;
            case R.id.floor1_ptcSeminarHall:
                chooseroute=103;
                break;
            case R.id.floor1_placementTraining:
                chooseroute=104;
                break;
            case R.id.floor1_placementStaffRoom:
                chooseroute=105;
                break;
            case R.id.floor1_studentCouncil:
                chooseroute=106;
                break;
            case R.id.floor1_gdRoom:
                chooseroute=107;
                break;

            case R.id.floor2_vicePrincy:
                chooseroute=201;
                break;

            case R.id.floor2_scienceDept:
                chooseroute=202;
                break;

            case R.id.floor2_csStaffRoom:
                chooseroute=203;
                break;
            case R.id.floor2_ecStaffRoom1:
                chooseroute=204;
                break;
            case R.id.floor2_ecStaffRoom2:
                chooseroute=205;
                break;
            case R.id.floor2_s8eca:
                chooseroute=206;
                break;
            case R.id.floor2_s8ecb:
                chooseroute=207;
                break;
            case R.id.floor2_s6eca:
                chooseroute=208;
                break;
            case R.id.floor2_s6ecb:
                chooseroute=209;
                break;
            case R.id.floor2_s4csb:
                chooseroute=210;
                break;
            case R.id.floor2_ktu:
                chooseroute=211;
                break;
            case R.id.floor2_mg:
                chooseroute=212;
                break;

            case R.id.floor3_csHOD:
                chooseroute=301;
                break;

            case R.id.floor3_meHOD:
                chooseroute=302;
                break;

            case R.id.floor3_ccc:
                chooseroute=303;
                break;

            case R.id.floor3_csLibrary:
                chooseroute=304;
                break;

            case R.id.floor3_s8csa:
                chooseroute=305;
                break;

            case R.id.floor3_s8csb:
                chooseroute=306;
                break;

            case R.id.floor3_s6csa:
                chooseroute=307;
                break;

            case R.id.floor3_s6csb:
                chooseroute=308;
                break;

            case R.id.floor3_s4csa:
                chooseroute=309;
                break;

            case R.id.floor3_s4mea:
                chooseroute=310;
                break;

            case R.id.floor3_s4meb:
                chooseroute=311;
                break;

            case R.id.floor3_seminarHall1:
                chooseroute=312;
                break;

            case R.id.floor3_seminarHall2:
                chooseroute=313;
                break;

            case R.id.floor3_csStaffRoom1:
                chooseroute=314;
                break;

            case R.id.floor3_csStaffRoom2:
                chooseroute=315;
                break;

            case R.id.floor3_meStaffRoom:
                chooseroute=316;
                break;

            case R.id.floor3_serverRoom:
                chooseroute=317;
                break;




        }


    }

    // function to calculate route when fab button is clicked
    void calculateFinalRoute() {
        switch (tolocation) {
            case R.id.floor1_langLab:
                chooseroute = -101;
                break;

            case R.id.floor1_ecStaffRoom:
                chooseroute = -102;
                break;
            case R.id.floor1_ptcSeminarHall:
                chooseroute = -103;
                break;
            case R.id.floor1_placementTraining:
                chooseroute = -104;
                break;
            case R.id.floor1_placementStaffRoom:
                chooseroute = -105;
                break;
            case R.id.floor1_studentCouncil:
                chooseroute = -106;
                break;
            case R.id.floor1_gdRoom:
                chooseroute = -107;
                break;

            case R.id.floor2_vicePrincy:
                chooseroute = -201;
                break;

            case R.id.floor2_scienceDept:
                chooseroute = -202;
                break;

            case R.id.floor2_csStaffRoom:
                chooseroute = -203;
                break;
            case R.id.floor2_ecStaffRoom1:
                chooseroute = -204;
                break;
            case R.id.floor2_ecStaffRoom2:
                chooseroute = -205;
                break;
            case R.id.floor2_s8eca:
                chooseroute = -206;
                break;
            case R.id.floor2_s8ecb:
                chooseroute = -207;
                break;
            case R.id.floor2_s6eca:
                chooseroute = -208;
                break;
            case R.id.floor2_s6ecb:
                chooseroute = -209;
                break;
            case R.id.floor2_s4csb:
                chooseroute = -210;
                break;
            case R.id.floor2_ktu:
                chooseroute = -211;
                break;
            case R.id.floor2_mg:
                chooseroute = -212;
                break;

            case R.id.floor3_csHOD:
                chooseroute = -301;
                break;

            case R.id.floor3_meHOD:
                chooseroute = -302;
                break;

            case R.id.floor3_ccc:
                chooseroute = -303;
                break;

            case R.id.floor3_csLibrary:
                chooseroute = -304;
                break;

            case R.id.floor3_s8csa:
                chooseroute = -305;
                break;

            case R.id.floor3_s8csb:
                chooseroute = -306;
                break;

            case R.id.floor3_s6csa:
                chooseroute = -307;
                break;

            case R.id.floor3_s6csb:
                chooseroute = -308;
                break;

            case R.id.floor3_s4csa:
                chooseroute = -309;
                break;

            case R.id.floor3_s4mea:
                chooseroute = -310;
                break;

            case R.id.floor3_s4meb:
                chooseroute = -311;
                break;

            case R.id.floor3_seminarHall1:
                chooseroute = -312;
                break;

            case R.id.floor3_seminarHall2:
                chooseroute = -313;
                break;

            case R.id.floor3_csStaffRoom1:
                chooseroute = -314;
                break;

            case R.id.floor3_csStaffRoom2:
                chooseroute = -315;
                break;

            case R.id.floor3_meStaffRoom:
                chooseroute = -316;
                break;

            case R.id.floor3_serverRoom:
                chooseroute = -317;
                break;

        }
    }
}
