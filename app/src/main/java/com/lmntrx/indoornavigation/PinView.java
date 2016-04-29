package com.lmntrx.indoornavigation;

/**
 * Created by ACJLionsRoar on 4/14/16.
 */

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;



public class PinView extends SubsamplingScaleImageView {

    Paint paint = new Paint();

    public static boolean fabClicked=false;
    public static int fabCounter=0;

    private int chooseRouteInMap;
    private int choose;

    private PointF sPin,sPin2;
    private Bitmap pin,pin2;

    public PinView(Context context) {
        this(context, null);
        // SETS COLOR OF LINE DRAWN TO BLACK
        paint.setColor(Color.BLACK);
    }

    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        // SETS COLOR OF LINE DRAWN TO BLACK
        paint.setColor(Color.BLACK);
        initialise();
    }

    // sets Pin according to locations already set in navigation
    public void setPin(PointF sPin,PointF sPin2,int chooseRoute) {
        this.sPin = sPin;
        this.sPin2 = sPin2;
        this.chooseRouteInMap=chooseRoute;
        initialise();
        invalidate(); // calls ondraw()


    }





        // convert x,y coordinates to ondraw coordinates
    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin);
        float w = (density/420f) * pin.getWidth();
        float h = (density/420f) * pin.getHeight();
        pin = Bitmap.createScaledBitmap(pin, (int)w, (int)h, true);

        pin2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin2);
        float w2 = (density/420f) * pin2.getWidth();
        float h2 = (density/420f) * pin2.getHeight();
        pin2 = Bitmap.createScaledBitmap(pin2, (int)w2, (int)h2, true);




    }

    // onDraw function is called when invalidate() is called.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        // calculates vX and vY based on sPin and sPin2. sPin = fromPoint_F  and sPin2 = to_PointF ( corresponding)
        if (sPin != null && pin != null) {
            // SETS 1st PIN in map
            PointF vPin = sourceToViewCoord(sPin);
            PointF vPin2 = sourceToViewCoord(sPin2);
            float vX = vPin.x - (pin.getWidth()/2);
            float vY = vPin.y - pin.getHeight();
            //drawBitmap is the function to actually place the pin on map. locations vX and vY are calculated based on from_PointF and toPointF set in navigation
            canvas.drawBitmap(pin, vX, vY, paint);

            // SETS 2nd Pin in map
            float vX2 = vPin2.x - (pin2.getWidth()/2);
            float vY2 = vPin2.y - pin2.getHeight();
            canvas.drawBitmap(pin2, vX2, vY2, paint);

            // SETS WIDTH OF LINE
            paint.setStrokeWidth(50);


            // This entire switch case draws all the routes as per user choices in navigation
            switch(chooseRouteInMap)
            {

                // ---------------------------------DEFAULT VALUES----------------------------------------------------

                case 0: break;

                // ----------------STAIRCASE VALUES. POSITIVE VALUES ARE . Destination =Staircases----------------

                // -------------STAIRCASE VALUES.NEGATIVE VALUES ARE. Starting Point =Staircases-----------------


                case 101:
                    canvas.drawLine(vX+30, vY+220, vX+530, vY+220, paint);



                    break;

                case -101:
                    canvas.drawLine(vX2+30, vY2+220, vX2+530, vY2+220, paint);

                    break;

                case 102:
                    canvas.drawLine(vX+30, vY+220, vX+470, vY+220, paint);



                    break;

                case -102:
                    canvas.drawLine(vX2+30, vY2+220, vX2+470, vY2+220, paint);

                    break;

                case 103:
                    canvas.drawLine(vX+110, vY+220, vX+220, vY+220, paint);

                    break;

                case -103:
                    canvas.drawLine(vX2+110, vY2+220, vX2+220, vY2+220, paint);

                    break;

                case 104:
                    canvas.drawLine(vX+50, vY+220, vX-120, vY+220, paint);
                    break;

                case -104:
                    canvas.drawLine(vX2+50, vY2+220, vX2-120, vY2+220, paint);

                    break;

                case 105:

                    canvas.drawLine(vX+50, vY+20, vX-100, vY+20, paint);

                    break;

                case -105:

                canvas.drawLine(vX2+50, vY2+20, vX2-100, vY2+20, paint);

                    break;

                case 106:
                    canvas.drawLine(vX+60, vY-20, vX-140, vY-20, paint);

                    break;

                case -106:

                canvas.drawLine(vX2+60, vY2-20, vX2-140, vY2-20, paint);

                    break;

                case 107:
                    canvas.drawLine(vX+60, vY-20, vX-220, vY-20, paint);

                    break;

                case -107:
                    canvas.drawLine(vX2+60, vY2-20, vX2-220, vY2-20, paint);

                    break;


                    // new code
                case 201:

                    canvas.drawLine(vX-480, vY+240, vX+80, vY+240, paint);
                    canvas.drawLine(vX-460, vY+220, vX-460, vY+380, paint);
                    canvas.drawLine(vX-850, vY+370, vX-435, vY+370, paint);


                    break;

                case -201:
                    canvas.drawLine(vX2-480, vY2+240, vX2+80, vY2+240, paint);
                    canvas.drawLine(vX2-460, vY2+220, vX2-460, vY2+380, paint);
                    canvas.drawLine(vX2-850, vY2+370, vX2-435, vY2+370, paint);

                    break;

              

                  

                case 202:

                    canvas.drawLine(vX-280, vY+245, vX+80, vY+245, paint);
                    canvas.drawLine(vX-290, vY+220, vX-290, vY+380, paint);
                    canvas.drawLine(vX-700, vY+370, vX-265, vY+370, paint);

                    break;

                case -202:
                    canvas.drawLine(vX2-280, vY2+245, vX2+80, vY2+245, paint);
                    canvas.drawLine(vX2-290, vY2+220, vX2-290, vY2+380, paint);
                    canvas.drawLine(vX2-700, vY2+370, vX2-265, vY2+370, paint);

                    break;

               

                case 203:

                    canvas.drawLine(vX-245, vY+25, vX+80, vY+25, paint);
                    canvas.drawLine(vX-220, vY+25, vX-220, vY+175, paint);
                    canvas.drawLine(vX-600, vY+170, vX-200, vY+170, paint);

                    break;

                case -203:


                    canvas.drawLine(vX2-245, vY2+25, vX2+80, vY2+25, paint);
                    canvas.drawLine(vX2-220, vY2+25, vX2-220, vY2+175, paint);
                    canvas.drawLine(vX2-600, vY2+170, vX2-200, vY2+170, paint);

                    break;

               

                case 204:
                    canvas.drawLine(vX, vY+250, vX+450, vY+250, paint);

                    break;

                case -204:
                    canvas.drawLine(vX2, vY2+250, vX2+450, vY2+250, paint);

                    break;

               

                case 205:
                    canvas.drawLine(vX+50, vY-20, vX-100, vY-20, paint);

                    break;

                case -205:
                    canvas.drawLine(vX2+50, vY2-20, vX2-100, vY2-20, paint);

                    break;

              

                case 206:
                    canvas.drawLine(vX+50, vY+250, vX-100, vY+250, paint);

                    break;

                case -206:

                    canvas.drawLine(vX2+50, vY2+250, vX2-100, vY2+250, paint);
                    break;

              

                case 207:
                    canvas.drawLine(vX+50, vY+250, vX-250, vY+250, paint);

                    break;

                case -207:
                    canvas.drawLine(vX2+50, vY2+250, vX2-250, vY2+250, paint);
                    break;

               
                case 208:

                    canvas.drawLine(vX, vY+250, vX+270, vY+250, paint);

                    break;

                case -208:
                    canvas.drawLine(vX2, vY2+250, vX2+270, vY2+250, paint);

                    break;

                

                case 209:

                    canvas.drawLine(vX, vY+250, vX+150, vY+250, paint);

                    break;

                case -209:
                    canvas.drawLine(vX2, vY2+250, vX2+150, vY2+250, paint);

                    break;

               


                case 210:
                    canvas.drawLine(vX-245+80, vY+25, vX+80, vY+25, paint);
                    canvas.drawLine(vX-220+80, vY+25, vX-220+80, vY+175, paint);
                    canvas.drawLine(vX-600+80, vY+170, vX-200+80, vY+170, paint);

                    break;

                case -210:
                    canvas.drawLine(vX2-245+80, vY2+25, vX2+80, vY2+25, paint);
                    canvas.drawLine(vX2-220+80, vY2+25, vX2-220+80, vY2+175, paint);
                    canvas.drawLine(vX2-600+80, vY2+170, vX2-200+80, vY2+170, paint);


                    break;

                
                case 211:

                    canvas.drawLine(vX-245-100, vY+25, vX+80, vY+25, paint);
                    canvas.drawLine(vX-220-100, vY+25, vX-220-100, vY+175, paint);
                    canvas.drawLine(vX-600-100, vY+170, vX-200-100, vY+170, paint);
                    break;

                case -211:
                    canvas.drawLine(vX2-245-100, vY2+25, vX2+80, vY2+25, paint);
                    canvas.drawLine(vX2-220-100, vY2+25, vX2-220-100, vY2+175, paint);
                    canvas.drawLine(vX2-600-100, vY2+170, vX2-200-100, vY2+170, paint);

                    break;

               

                case 212:

                    canvas.drawLine(vX-245-250, vY+25, vX+80, vY+25, paint);
                    canvas.drawLine(vX-220-250, vY+25, vX-220-250, vY+175, paint);
                    canvas.drawLine(vX-600-250, vY+170, vX-200-250, vY+170, paint);
                    break;

                case -212:
                    canvas.drawLine(vX2-245-250, vY2+25, vX2+80, vY2+25, paint);
                    canvas.drawLine(vX2-220-250, vY2+25, vX2-220-250, vY2+175, paint);
                    canvas.drawLine(vX2-600-250, vY2+170, vX2-200-250, vY2+170, paint);

                    break;


                case 301:

                    canvas.drawLine(vX+20, vY+130, vX+20, vY+700, paint);
                    canvas.drawLine(vX+45, vY+700, vX-320, vY+700, paint);

                    break;

                case -301:

                    canvas.drawLine(vX2+20, vY2+130, vX2+20, vY2+700, paint);
                    canvas.drawLine(vX2+45, vY2+700, vX2-320, vY2+700, paint);

                    break;

               

                case 302:

                    canvas.drawLine(vX-310+90, vY+225-220, vX+50, vY+225-220, paint);
                    canvas.drawLine(vX-310+90, vY+200-220, vX-310+90, vY+400-220, paint);
                    canvas.drawLine(vX-650+90, vY+375-220, vX-310+90, vY+375-220, paint);

                    break;

                case -302:
                    canvas.drawLine(vX2-310+90, vY2+225-220, vX2+50, vY2+225-220, paint);
                    canvas.drawLine(vX2-310+90, vY2+200-220, vX2-310+90, vY2+400-220, paint);
                    canvas.drawLine(vX2-650+90, vY2+375-220, vX2-310+90, vY2+375-220, paint);


                    break;

                

                case 303:
                    canvas.drawLine(vX+50, vY+230, vX-50, vY+230, paint);

                    break;

                case -303:
                    canvas.drawLine(vX2+50, vY2+230, vX2-50, vY2+230, paint);

                    break;

               

                case 304:
                    canvas.drawLine(vX-90-235+135, vY+155-180, vX+50, vY+155-180, paint);
                    canvas.drawLine(vX+20-100-235+135, vY+130-180, vX+20-100-235+135, vY+700-180, paint);
                    canvas.drawLine(vX+45-100-235+135, vY+700-180, vX-320-100-235+135, vY+700-180, paint);

                    break;

                case -304:
                    canvas.drawLine(vX2-90-235+135, vY2+155-180, vX2+50, vY2+155-180, paint);
                    canvas.drawLine(vX2+20-100-235+135, vY2+130-180, vX2+20-100-235+135, vY2+700-180, paint);
                    canvas.drawLine(vX2+45-100-235+135, vY2+700-180, vX2-320-100-235+135, vY2+700-180, paint);


                    break;

               

                case 305:
                    canvas.drawLine(vX-20, vY+230, vX+300, vY+230, paint);

                    break;

                case -305:
                    canvas.drawLine(vX2-20, vY2+230, vX2+300, vY2+230, paint);

                    break;

               

                case 306:
                    canvas.drawLine(vX-20, vY+230, vX+150, vY+230, paint);

                    break;

                case -306:
                    canvas.drawLine(vX2-20, vY2+230, vX2+150, vY2+230, paint);

                    break;

                

                case 307:
                    canvas.drawLine(vX-20, vY+230, vX+620, vY+230, paint);

                    break;

                case -307:
                    canvas.drawLine(vX2-20, vY2+230, vX2+620, vY2+230, paint);
                    break;

               

                case 308:
                    canvas.drawLine(vX-20, vY+230, vX+500, vY+230, paint);

                    break;

                case -308:
                    canvas.drawLine(vX2-20, vY2+230, vX2+500, vY2+230, paint);

                    break;

                
                case 309:

                    canvas.drawLine(vX-310+170, vY+225-220, vX+50, vY+225-220, paint);
                    canvas.drawLine(vX-310+170, vY+200-220, vX-310+170, vY+400-220, paint);
                    canvas.drawLine(vX-650+170, vY+375-220, vX-310+170, vY+375-220, paint);

                    break;

                case -309:
                    canvas.drawLine(vX2-310+170, vY2+225-220, vX2+50, vY2+225-220, paint);
                    canvas.drawLine(vX2-310+170, vY2+200-220, vX2-310+170, vY2+400-220, paint);
                    canvas.drawLine(vX2-650+170, vY2+375-220, vX2-310+170, vY2+375-220, paint);


                    break;


                case 310:

                    canvas.drawLine(vX-310-150, vY+225-220, vX+50, vY+225-220, paint);
                    canvas.drawLine(vX-310-150, vY+200-220, vX-310-150, vY+400-220, paint);
                    canvas.drawLine(vX-650-150, vY+375-220, vX-310-150, vY+375-220, paint);

                    break;



                case -310:
                    canvas.drawLine(vX2-310-150, vY2+225-220, vX2+50, vY2+225-220, paint);
                    canvas.drawLine(vX2-310-150, vY2+200-220, vX2-310-150, vY2+400-220, paint);
                    canvas.drawLine(vX2-650-150, vY2+375-220, vX2-310-150, vY2+375-220, paint);


                    break;

               


                case 311:

                    canvas.drawLine(vX-310-20, vY+225-220, vX+50, vY+225-220, paint);
                    canvas.drawLine(vX-310-20, vY+200-220, vX-310-20, vY+400-220, paint);
                    canvas.drawLine(vX-650-20, vY+375-220, vX-310-20, vY+375-220, paint);

                    break;

                case -311:
                    canvas.drawLine(vX2-310-20, vY2+225-220, vX2+50, vY2+225-220, paint);
                    canvas.drawLine(vX2-310-20, vY2+200-220, vX2-310-20, vY2+400-220, paint);
                    canvas.drawLine(vX2-650-20, vY2+375-220, vX2-310-20, vY2+375-220, paint);


                    break;

                

                case 312:
                    canvas.drawLine(vX-90, vY+155, vX+50, vY+155, paint);
                    canvas.drawLine(vX+20-100, vY+130, vX+20-100, vY+700, paint);
                    canvas.drawLine(vX+45-100, vY+700, vX-320-100, vY+700, paint);

                    break;

                case -312:
                    canvas.drawLine(vX2-90, vY2+155, vX2+50, vY2+155, paint);
                    canvas.drawLine(vX2+20-100, vY2+130, vX2+20-100, vY2+700, paint);
                    canvas.drawLine(vX2+45-100, vY2+700, vX2-320-100, vY2+700, paint);

                    break;

               
                case 313:
                    canvas.drawLine(vX-90-235, vY+155, vX+50, vY+155, paint);
                    canvas.drawLine(vX+20-100-235, vY+130, vX+20-100-235, vY+700, paint);
                    canvas.drawLine(vX+45-100-235, vY+700, vX-320-100-235, vY+700, paint);

                    break;

                case -313:
                    canvas.drawLine(vX2-90-235, vY2+155, vX2+50, vY2+155, paint);
                    canvas.drawLine(vX2+20-100-235, vY2+130, vX2+20-100-235, vY2+700, paint);
                    canvas.drawLine(vX2+45-100-235, vY2+700, vX2-320-100-235, vY2+700, paint);


                    break;

               
                case 314:
                    canvas.drawLine(vX+50, vY-50, vX-50, vY-50, paint);


                    break;

                case -314:
                    canvas.drawLine(vX2+50, vY2-50, vX2-50, vY2-50, paint);
                    break;

                


                case 315:
                    canvas.drawLine(vX-90-235+135+120, vY+155-180-35, vX+50, vY+155-180-35, paint);
                    canvas.drawLine(vX+20-100-235+135+120, vY+130-180-35, vX+20-100-235+135+120, vY+700-180-35, paint);
                    canvas.drawLine(vX+45-100-235+135+120, vY+700-180-35, vX-320-100-235+135+120, vY+700-180-35, paint);

                    break;

                case -315:
                    canvas.drawLine(vX2-90-235+135+120, vY2+155-180-35, vX2+50, vY2+155-180-35, paint);
                    canvas.drawLine(vX2+20-100-235+135+120, vY2+130-180-35, vX2+20-100-235+135+120, vY2+700-180-35, paint);
                    canvas.drawLine(vX2+45-100-235+135+120, vY2+700-180-35, vX2-320-100-235+135+120, vY2+700-180-35, paint);


                    break;

               

                case 316:
                    canvas.drawLine(vX-310, vY+225, vX+50, vY+225, paint);
                    canvas.drawLine(vX-310, vY+200, vX-310, vY+400, paint);
                    canvas.drawLine(vX-650, vY+375, vX-310, vY+375, paint);

                    break;

                case -316:
                    canvas.drawLine(vX2-310, vY2+225, vX2+50, vY2+225, paint);
                    canvas.drawLine(vX2-310, vY2+200, vX2-310, vY2+400, paint);
                    canvas.drawLine(vX2-650, vY2+375, vX2-310, vY2+375, paint);

                    break;

                
                case 317:
                    canvas.drawLine(vX+50, vY+230, vX-250, vY+230, paint);


                    break;

                case -317:
                    canvas.drawLine(vX2+50, vY2+230, vX2-250, vY2+230, paint);

                    break;




                //----------------------------------------- Floor 1 ---------------------------------------------------

                 //1. Language Lab - EC Staff Room

                case (R.id.floor1_langLab*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX+10, vY+220, vX+130, vY+220, paint);


                    break;


                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+130, vY2+220, paint);

                    break;



                //2. Language Lab - PTC Hall

                case (R.id.floor1_langLab*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX+10, vY+220, vX+400, vY+220, paint);

                    break;


                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+400, vY2+220, paint);


                    break;





                //3. Language Lab - Training Center

                case (R.id.floor1_langLab*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX+10, vY+220, vX+670, vY+220, paint);


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+670, vY2+220, paint);

                    break;




                //4. Language Lab -Staff Room

                case (R.id.floor1_langLab*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX+10, vY+220, vX+620, vY+220, paint);

                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+620, vY2+220, paint);


                    break;





                //5. Language Lab -Council

                case (R.id.floor1_langLab*100)+R.id.floor1_studentCouncil:
                    canvas.drawLine(vX+10, vY+220, vX+700, vY+220, paint);


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+700, vY2+220, paint);


                    break;



                //6. Language Lab - GD

                case (R.id.floor1_langLab*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+10, vY+220, vX+800, vY+220, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_langLab:
                    canvas.drawLine(vX2+10, vY2+220, vX2+800, vY2+220, paint);


                    break;




                //7. EC Staff Room - PTC Hall

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX+20, vY+220, vX+250, vY+220, paint);


                    break;


                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX2+20, vY2+220, vX2+250, vY2+220, paint);


                    break;




                //8. EC Staff Room - Training Center

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX+20, vY+220, vX+620, vY+220, paint);


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX2+20, vY2+220, vX2+620, vY2+220, paint);


                    break;



                //9. EC Staff Room -Staff Room

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX+20, vY+220, vX+550, vY+220, paint);


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX2+20, vY2+220, vX2+550, vY2+220, paint);


                    break;

                //10. EC Staff Room -Council

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_studentCouncil:
                    canvas.drawLine(vX+20, vY+220, vX+650, vY+220, paint);


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX2+20, vY2+220, vX2+650, vY2+220, paint);


                    break;



                //11. EC Staff Room - GD

                case (R.id.floor1_ecStaffRoom*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+20, vY+220, vX+750, vY+220, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_ecStaffRoom:
                    canvas.drawLine(vX2+20, vY2+220, vX2+750, vY2+220, paint);


                    break;





                //12. PTC Hall- Training Center

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX+20, vY+220, vX+370, vY+220, paint);


                    break;


                case (R.id.floor1_placementTraining*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX2+100, vY2+220, vX2+370, vY2+220, paint);


                    break;



                //13. PTC Hall -Staff Room

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX+20, vY+220, vX+350, vY+220, paint);


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX2+20, vY2+220, vX2+350, vY2+220, paint);


                    break;



                //14. PTC Hall -Council

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_studentCouncil:
                    canvas.drawLine(vX+20, vY+220, vX+400, vY+220, paint);


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX2+20, vY2+220, vX2+400, vY2+220, paint);


                    break;



                //15. PTC Hall - GD

                case (R.id.floor1_ptcSeminarHall*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+20, vY+220, vX+500, vY+220, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_ptcSeminarHall:
                    canvas.drawLine(vX2+20, vY2+220, vX2+500, vY2+220, paint);


                    break;


                //16. Training Center-Staff Room

                case (R.id.floor1_placementTraining*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX+20, vY+220, vX+70, vY+220, paint);


                    break;


                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX2+20, vY2+220, vX2+70, vY2+220, paint);


                    break;


                //17. Training Center -Council
                case (R.id.floor1_placementTraining*100)+R.id.floor1_studentCouncil:

                    canvas.drawLine(vX+10, vY+220, vX+70, vY+220, paint);

                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX2+10, vY2+220, vX2+70, vY2+220, paint);


                    break;




                //18. Training Center - GD

                case (R.id.floor1_placementTraining*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+10, vY+220, vX+130, vY+220, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_placementTraining:
                    canvas.drawLine(vX2+10, vY2+220, vX2+130, vY2+220, paint);


                    break;





                //19. Staff Room -Council

                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_studentCouncil:
                    canvas.drawLine(vX+1, vY+20, vX+90, vY+20, paint);


                    break;


                case (R.id.floor1_studentCouncil*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX2+1, vY2+20, vX2+90, vY2+20, paint);


                    break;





                //20. Staff Room- GD

                case (R.id.floor1_placementStaffRoom*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+1, vY+20, vX+90, vY+20, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_placementStaffRoom:
                    canvas.drawLine(vX2+1, vY2+20, vX2+90, vY2+20, paint);


                    break;



                //21. Council- GD

                case (R.id.floor1_studentCouncil*100)+R.id.floor1_gdRoom:
                    canvas.drawLine(vX+1, vY-10, vX+90, vY-10, paint);


                    break;


                case (R.id.floor1_gdRoom*100)+R.id.floor1_studentCouncil:

                    canvas.drawLine(vX2+1, vY2-10, vX2+90, vY2-10, paint);

                    break;





                //----------------------------------------- Floor 2 ---------------------------------------------------

               // 1.       Vice Principal - S&H dept.


                case (R.id.floor2_vicePrincy*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX+20, vY+220, vX-90, vY+220, paint);

                    break;


                case (R.id.floor2_scienceDept*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+20, vY2+220, vX2-90, vY2+220, paint);


                    break;


               // 2.       Vice Principal - CS Staff Room

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX+20, vY+220, vX-190, vY+220, paint);

                    break;


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_vicePrincy:

                    canvas.drawLine(vX2+20, vY2+220, vX2-190, vY2+220, paint);

                    break;




               // 3.       Vice Principal - EC staff Room 1

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX+30, vY+220, vX-460, vY+220, paint);
                    canvas.drawLine(vX-460, vY+195, vX-460, vY+390, paint);
                    canvas.drawLine(vX-460, vY+365, vX-1250, vY+365, paint);

                    break;


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+30, vY2+220, vX2-460, vY2+220, paint);
                    canvas.drawLine(vX2-460, vY2+195, vX2-460, vY2+390, paint);
                    canvas.drawLine(vX2-460, vY2+365, vX2-1250, vY2+365, paint);


                    break;



               // 4.       Vice Principal - S8 ECA

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX+30, vY+220, vX-460, vY+220, paint);
                    canvas.drawLine(vX-460, vY+195, vX-460, vY+390, paint);
                    canvas.drawLine(vX-460, vY+365, vX-760, vY+365, paint);

                    break;


                case (R.id.floor2_s8eca*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+30, vY2+220, vX2-460, vY2+220, paint);
                    canvas.drawLine(vX2-460, vY2+195, vX2-460, vY2+390, paint);
                    canvas.drawLine(vX2-460, vY2+365, vX2-760, vY2+365, paint);


                    break;





               // 5.       Vice Principal - S8 ECB

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX+30, vY+220, vX-460, vY+220, paint);
                    canvas.drawLine(vX-460, vY+195, vX-460, vY+390, paint);
                    canvas.drawLine(vX-460, vY+365, vX-600, vY+365, paint);

                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+30, vY2+220, vX2-460, vY2+220, paint);
                    canvas.drawLine(vX2-460, vY2+195, vX2-460, vY2+390, paint);
                    canvas.drawLine(vX2-460, vY2+365, vX2-600, vY2+365, paint);


                    break;




               // 6.       Vice Principal - S6 ECA

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX+30, vY+220, vX-460, vY+220, paint);
                    canvas.drawLine(vX-460, vY+195, vX-460, vY+390, paint);
                    canvas.drawLine(vX-460, vY+365, vX-1050, vY+365, paint);

                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+30, vY2+220, vX2-460, vY2+220, paint);
                    canvas.drawLine(vX2-460, vY2+195, vX2-460, vY2+390, paint);
                    canvas.drawLine(vX2-460, vY2+365, vX2-1050, vY2+365, paint);

                    break;




               // 7.       Vice Principal - S6 ECB

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+30, vY+220, vX-460, vY+220, paint);
                    canvas.drawLine(vX-460, vY+195, vX-460, vY+390, paint);
                    canvas.drawLine(vX-460, vY+365, vX-970, vY+365, paint);

                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+30, vY2+220, vX2-460, vY2+220, paint);
                    canvas.drawLine(vX2-460, vY2+195, vX2-460, vY2+390, paint);
                    canvas.drawLine(vX2-460, vY2+365, vX2-970, vY2+365, paint);

                    break;





               // 8.       Vice Principal - S4 CSB

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+20, vY+220, vX-320, vY+220, paint);


                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+20, vY2+220, vX2-320, vY2+220, paint);


                    break;




               // 9.       Vice Principal - KTU Exam Control Room

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+20, vY+220, vX-125, vY+220, paint);


                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+20, vY2+220, vX2-125, vY2+220, paint);


                    break;



               // 10.   Vice Principal - MG Exam Control Room

                case (R.id.floor2_vicePrincy*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+20, vY+220, vX-10, vY+220, paint);

                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX2+20, vY2+220, vX2-10, vY2+220, paint);

                    break;



               // 11.   S&H dept. -  CS Staff Room

                case (R.id.floor2_scienceDept*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX+20, vY+220, vX-20, vY+220, paint);


                    break;


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+20, vY2+220, vX2-20, vY2+220, paint);


                    break;




               // 12.   S&H dept. -  EC staff Room

                case (R.id.floor2_scienceDept*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX+20, vY+220, vX-300, vY+220, paint);
                    canvas.drawLine(vX-300, vY+195, vX-300, vY+360, paint);
                    canvas.drawLine(vX-275, vY+365, vX-1100, vY+365, paint);


                    break;


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+20, vY2+220, vX2-300, vY2+220, paint);
                    canvas.drawLine(vX2-300, vY2+195, vX2-300, vY2+360, paint);
                    canvas.drawLine(vX2-275, vY2+365, vX2-1100, vY2+365, paint);

                    break;


               // 13.   S&H dept. -  S8 ECA

                case (R.id.floor2_scienceDept*100)+R.id.floor2_s8eca:

                    canvas.drawLine(vX+20, vY+220, vX-300, vY+220, paint);
                    canvas.drawLine(vX-300, vY+195, vX-300, vY+360, paint);
                    canvas.drawLine(vX-275, vY+365, vX-600, vY+365, paint);
                    break;


                case (R.id.floor2_s8eca*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+20, vY2+220, vX2-300, vY2+220, paint);
                    canvas.drawLine(vX2-300, vY2+195, vX2-300, vY2+360, paint);
                    canvas.drawLine(vX2-275, vY2+365, vX2-600, vY2+365, paint);

                    break;




               // 14.   S&H dept. -  S8 ECB

                case (R.id.floor2_scienceDept*100)+R.id.floor2_s8ecb:

                    canvas.drawLine(vX+20, vY+220, vX-300, vY+220, paint);
                    canvas.drawLine(vX-300, vY+195, vX-300, vY+360, paint);
                    canvas.drawLine(vX-275, vY+365, vX-400, vY+365, paint);

                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_scienceDept:

                    canvas.drawLine(vX2+20, vY2+220, vX2-300, vY2+220, paint);
                    canvas.drawLine(vX2-300, vY2+195, vX2-300, vY2+360, paint);
                    canvas.drawLine(vX2-275, vY2+365, vX2-400, vY2+365, paint);

                    break;




               // 15.   S&H dept. -  S6 ECA

                case (R.id.floor2_scienceDept*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX+20, vY+220, vX-300, vY+220, paint);
                    canvas.drawLine(vX-300, vY+195, vX-300, vY+360, paint);
                    canvas.drawLine(vX-275, vY+365, vX-900, vY+365, paint);


                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_scienceDept:

                    canvas.drawLine(vX2+20, vY2+220, vX2-300, vY2+220, paint);
                    canvas.drawLine(vX2-300, vY2+195, vX2-300, vY2+360, paint);
                    canvas.drawLine(vX2-275, vY2+365, vX2-900, vY2+365, paint);

                    break;





               // 16.   S&H dept. -  S6 ECB

                case (R.id.floor2_scienceDept*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+20, vY+220, vX-300, vY+220, paint);
                    canvas.drawLine(vX-300, vY+195, vX-300, vY+360, paint);
                    canvas.drawLine(vX-275, vY+365, vX-800, vY+365, paint);

                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+20, vY2+220, vX2-300, vY2+220, paint);
                    canvas.drawLine(vX2-300, vY2+195, vX2-300, vY2+360, paint);
                    canvas.drawLine(vX2-275, vY2+365, vX2-800, vY2+365, paint);

                    break;


               // 17.   S&H dept. -  S4 CSB

                case (R.id.floor2_scienceDept*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+20, vY+220, vX-100, vY+220, paint);


                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+20, vY2+220, vX2-100, vY2+220, paint);

                    break;





                //18.   S&H dept. -  KTU Exam Control Room

                case (R.id.floor2_scienceDept*100)+R.id.floor2_ktu:


                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_scienceDept:


                    break;



               // 19.   S&H dept. -  MG Exam Control Room

                case (R.id.floor2_scienceDept*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY+220, vX+180, vY+220, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_scienceDept:
                    canvas.drawLine(vX2+10, vY2+220, vX2+180, vY2+220, paint);


                    break;




               // 20.   CS Staff Room - EC staff Room


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_ecStaffRoom1:

                    canvas.drawLine(vX+20, vY+10, vX-230, vY+10, paint);
                    canvas.drawLine(vX-235, vY-15, vX-235, vY+150, paint);
                    canvas.drawLine(vX-210, vY+160, vX-1000, vY+160, paint);
                    break;


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_csStaffRoom:

                    canvas.drawLine(vX2+20, vY2+10, vX2-230, vY2+10, paint);
                    canvas.drawLine(vX2-235, vY2-15, vX2-235, vY2+150, paint);
                    canvas.drawLine(vX2-210, vY2+160, vX2-1000, vY2+160, paint);
                    break;



               // 21.   CS Staff Room - S8 ECA


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX+20, vY+10, vX-230, vY+10, paint);
                    canvas.drawLine(vX-235, vY-15, vX-235, vY+150, paint);
                    canvas.drawLine(vX-210, vY+160, vX-470, vY+160, paint);


                    break;


                case (R.id.floor2_s8eca*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX2+20, vY2+10, vX2-230, vY2+10, paint);
                    canvas.drawLine(vX2-235, vY2-15, vX2-235, vY2+150, paint);
                    canvas.drawLine(vX2-210, vY2+160, vX2-470, vY2+160, paint);
                    break;




               // 22.   CS Staff Room - S8 ECB

                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX+20, vY+10, vX-230, vY+10, paint);
                    canvas.drawLine(vX-235, vY-15, vX-235, vY+150, paint);
                    canvas.drawLine(vX-210, vY+160, vX-350, vY+160, paint);


                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX2+20, vY2+10, vX2-230, vY2+10, paint);
                    canvas.drawLine(vX2-235, vY2-15, vX2-235, vY2+150, paint);
                    canvas.drawLine(vX2-210, vY2+160, vX2-350, vY2+160, paint);

                    break;




                //23.   CS Staff Room - S6 ECA


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_s6eca:

                    canvas.drawLine(vX+20, vY+10, vX-230, vY+10, paint);
                    canvas.drawLine(vX-235, vY-15, vX-235, vY+150, paint);
                    canvas.drawLine(vX-210, vY+160, vX-800, vY+160, paint);


                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX2+20, vY2+10, vX2-230, vY2+10, paint);
                    canvas.drawLine(vX2-235, vY2-15, vX2-235, vY2+150, paint);
                    canvas.drawLine(vX2-210, vY2+160, vX2-800, vY2+160, paint);

                    break;




                //24.   CS Staff Room - S6 ECB


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+20, vY+10, vX-230, vY+10, paint);
                    canvas.drawLine(vX-235, vY-15, vX-235, vY+150, paint);
                    canvas.drawLine(vX-210, vY+160, vX-700, vY+160, paint);

                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_csStaffRoom:

                    canvas.drawLine(vX2+20, vY2+10, vX2-230, vY2+10, paint);
                    canvas.drawLine(vX2-235, vY2-15, vX2-235, vY2+150, paint);
                    canvas.drawLine(vX2-210, vY2+160, vX2-700, vY2+160, paint);
                    break;




                //25.   CS Staff Room - S4 CSB


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+20, vY+10, vX-60, vY+10, paint);

                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_csStaffRoom:

                    canvas.drawLine(vX2+20, vY2+10, vX2-60, vY2+10, paint);
                    break;




                //26.   CS Staff Room - KTU Exam Control Room


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+20, vY+10, vX+150, vY+10, paint);


                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_csStaffRoom:

                    canvas.drawLine(vX2+20, vY2+10, vX2+150, vY2+10, paint);

                    break;



                //27.   CS Staff Room - MG Exam Control Room


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+20, vY+10, vX+300, vY+10, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX2+20, vY2+10, vX2+300, vY2+10, paint);


                    break;



                //28.   EC staff Room 1 - S8 ECA


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX+10, vY+250, vX+610, vY+250, paint);


                    break;


                case (R.id.floor2_s8eca*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+610, vY2+250, paint);

                    break;




                //29.   EC staff Room 1 - S8 ECB


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX+10, vY+250, vX+720, vY+250, paint);


                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+720, vY2+250, paint);


                    break;



                //30.   EC staff Room 1 - S6 ECA

                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX+10, vY+250, vX+280, vY+250, paint);


                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+280, vY2+250, paint);

                    break;



                //31.   EC staff Room 1- S6 ECB

                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+10, vY+250, vX+380, vY+250, paint);


                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+380, vY2+250, paint);


                    break;





                //32.   EC staff Room 1- S4 CSB

                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+10, vY+250, vX+880, vY+250, paint);
                    canvas.drawLine(vX+855, vY+250, vX+855, vY+130, paint);
                    canvas.drawLine(vX+830, vY+130, vX+1000, vY+130, paint);



                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+880, vY2+250, paint);
                    canvas.drawLine(vX2+855, vY2+250, vX2+855, vY2+130, paint);
                    canvas.drawLine(vX2+830, vY2+130, vX2+1000, vY2+130, paint);

                    break;



                //33.   EC staff Room 1- KTU Exam Control Room

                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY+250, vX+880, vY+250, paint);
                    canvas.drawLine(vX+855, vY+250, vX+855, vY+130, paint);
                    canvas.drawLine(vX+830, vY+130, vX+1200, vY+130, paint);

                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+880, vY2+250, paint);
                    canvas.drawLine(vX2+855, vY2+250, vX2+855, vY2+130, paint);
                    canvas.drawLine(vX2+830, vY2+130, vX2+1200, vY2+130, paint);

                    break;



                //34.   EC staff Room 1- MG Exam Control Room


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY+250, vX+880, vY+250, paint);
                    canvas.drawLine(vX+855, vY+250, vX+855, vY+130, paint);
                    canvas.drawLine(vX+830, vY+130, vX+1350, vY+130, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX2+10, vY2+250, vX2+880, vY2+250, paint);
                    canvas.drawLine(vX2+855, vY2+250, vX2+855, vY2+130, paint);
                    canvas.drawLine(vX2+830, vY2+130, vX2+1350, vY2+130, paint);


                    break;


                //35.   S8 ECA - S8 ECB

                case (R.id.floor2_s8eca*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX2-130, vY2+250, vX2+50, vY2+250, paint);


                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+200, vY2+250, paint);


                    break;




                //36.   S8 ECA - S6 ECA

                case (R.id.floor2_s8eca*100)+R.id.floor2_s6eca:

                    canvas.drawLine(vX+10, vY+250, vX-300, vY+250, paint);

                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2-300, vY2+250, paint);


                    break;


                //37.   S8 ECA - S6 ECB

                case (R.id.floor2_s8eca*100)+R.id.floor2_s6ecb:

                    canvas.drawLine(vX+10, vY+250, vX-190, vY+250, paint);

                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2-190, vY2+250, paint);


                    break;




                //38.   S8 ECA - S4 CSB

                case (R.id.floor2_s8eca*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+10, vY+250, vX+340, vY+250, paint);
                    canvas.drawLine(vX+320, vY+270, vX+320, vY+140, paint);
                    canvas.drawLine(vX+295, vY+140, vX+510, vY+140, paint);

                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+340, vY2+250, paint);
                    canvas.drawLine(vX2+320, vY2+270, vX2+320, vY2+140, paint);
                    canvas.drawLine(vX2+295, vY2+140, vX2+510, vY2+140, paint);

                    break;






                //39.   S8 ECA - KTU Exam Control Room


                case (R.id.floor2_s8eca*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY+250, vX+340, vY+250, paint);
                    canvas.drawLine(vX+320, vY+270, vX+320, vY+140, paint);
                    canvas.drawLine(vX+295, vY+140, vX+700, vY+140, paint);

                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_s8eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+340, vY2+250, paint);
                    canvas.drawLine(vX2+320, vY2+270, vX2+320, vY2+140, paint);
                    canvas.drawLine(vX2+295, vY2+140, vX2+700, vY2+140, paint);


                    break;



                //40.   S8 ECA - MG Exam Control Room

                case (R.id.floor2_s8eca*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY+250, vX+340, vY+250, paint);
                    canvas.drawLine(vX+320, vY+270, vX+320, vY+140, paint);
                    canvas.drawLine(vX+295, vY+140, vX+850, vY+140, paint);

                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_s8eca:

                    canvas.drawLine(vX2+10, vY2+250, vX2+340, vY2+250, paint);
                    canvas.drawLine(vX2+320, vY2+270, vX2+320, vY2+140, paint);
                    canvas.drawLine(vX2+295, vY2+140, vX2+850, vY2+140, paint);
                    break;



                //41.   S8 ECB - S6 ECA

                case (R.id.floor2_s8ecb*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX+10, vY+250, vX-450, vY+250, paint);


                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_s8ecb:

                    canvas.drawLine(vX2+10, vY2+250, vX2-450, vY2+250, paint);

                    break;




                //42.   S8 ECB - S6 ECB
                case (R.id.floor2_s8ecb*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+10, vY+250, vX-330, vY+250, paint);


                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX2+10, vY2+250, vX2-330, vY2+250, paint);


                    break;






                //43.   S8 ECB - S4 CSB

                case (R.id.floor2_s8ecb*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+10, vY+250, vX+160, vY+250, paint);
                    canvas.drawLine(vX+140, vY+270, vX+140, vY+140, paint);
                    canvas.drawLine(vX+115, vY+140, vX+320, vY+140, paint);


                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_s8ecb:

                    canvas.drawLine(vX2+10, vY2+250, vX2+160, vY2+250, paint);
                    canvas.drawLine(vX2+140, vY2+270, vX2+140, vY2+140, paint);
                    canvas.drawLine(vX2+115, vY2+140, vX2+320, vY2+140, paint);
                    break;




                //44.   S8 ECB - KTU Exam Control Room

                case (R.id.floor2_s8ecb*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY+250, vX+160, vY+250, paint);
                    canvas.drawLine(vX+140, vY+270, vX+140, vY+140, paint);
                    canvas.drawLine(vX+115, vY+140, vX+520, vY+140, paint);



                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_s8ecb:


                    canvas.drawLine(vX2+10, vY2+250, vX2+160, vY2+250, paint);
                    canvas.drawLine(vX2+140, vY2+270, vX2+140, vY2+140, paint);
                    canvas.drawLine(vX2+115, vY2+140, vX2+520, vY2+140, paint);
                    break;




                //45.   S8 ECB - MG Exam Control Room


                case (R.id.floor2_s8ecb*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY+250, vX+160, vY+250, paint);
                    canvas.drawLine(vX+140, vY+270, vX+140, vY+140, paint);
                    canvas.drawLine(vX+115, vY+140, vX+650, vY+140, paint);

                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_s8ecb:

                    canvas.drawLine(vX2+10, vY2+250, vX2+160, vY2+250, paint);
                    canvas.drawLine(vX2+140, vY2+270, vX2+140, vY2+140, paint);
                    canvas.drawLine(vX2+115, vY2+140, vX2+650, vY2+140, paint);
                    break;



                //46.   S6 ECA - S6 ECB


                case (R.id.floor2_s6eca*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+10, vY+250, vX+150, vY+250, paint);


                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+150, vY2+250, paint);


                    break;



                //47.   S6 ECA - S4 CSB


                case (R.id.floor2_s6eca*100)+R.id.floor2_s4csb:

                    canvas.drawLine(vX+10, vY+250, vX+660, vY+250, paint);
                    canvas.drawLine(vX+640, vY+270, vX+640, vY+140, paint);
                    canvas.drawLine(vX+615, vY+140, vX+820, vY+140, paint);
                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_s6eca:

                    canvas.drawLine(vX2+10, vY2+250, vX2+660, vY2+250, paint);
                    canvas.drawLine(vX2+640, vY2+270, vX2+640, vY2+140, paint);
                    canvas.drawLine(vX2+615, vY2+140, vX2+820, vY2+140, paint);

                    break;




                //48.   S6 ECA - KTU Exam Control Room

                case (R.id.floor2_s6eca*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY+250, vX+660, vY+250, paint);
                    canvas.drawLine(vX+640, vY+270, vX+640, vY+140, paint);
                    canvas.drawLine(vX+615, vY+140, vX+1000, vY+140, paint);

                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+660, vY2+250, paint);
                    canvas.drawLine(vX2+640, vY2+270, vX2+640, vY2+140, paint);
                    canvas.drawLine(vX2+615, vY2+140, vX2+1000, vY2+140, paint);

                    break;


                //49.   S6 ECA - MG Exam Control Room

                case (R.id.floor2_s6eca*100)+R.id.floor2_mg:

                    canvas.drawLine(vX+10, vY+250, vX+660, vY+250, paint);
                    canvas.drawLine(vX+640, vY+270, vX+640, vY+140, paint);
                    canvas.drawLine(vX+615, vY+140, vX+1150, vY+140, paint);
                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX2+10, vY2+250, vX2+660, vY2+250, paint);
                    canvas.drawLine(vX2+640, vY2+270, vX2+640, vY2+140, paint);
                    canvas.drawLine(vX2+615, vY2+140, vX2+1150, vY2+140, paint);

                    break;



               // 50.   S6 ECB - S4 CSB

                case (R.id.floor2_s6ecb*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX+10, vY+250, vX+530, vY+250, paint);
                    canvas.drawLine(vX+510, vY+270, vX+510, vY+140, paint);
                    canvas.drawLine(vX+485, vY+140, vX+685, vY+140, paint);

                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX2+10, vY2+250, vX2+530, vY2+250, paint);
                    canvas.drawLine(vX2+510, vY2+270, vX2+510, vY2+140, paint);
                    canvas.drawLine(vX2+485, vY2+140, vX2+685, vY2+140, paint);

                    break;


               // 51.   S6 ECB - KTU Exam Control Room
                case (R.id.floor2_s6ecb*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY+250, vX+530, vY+250, paint);
                    canvas.drawLine(vX+510, vY+270, vX+510, vY+140, paint);
                    canvas.drawLine(vX+485, vY+140, vX+855, vY+140, paint);

                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_s6ecb:

                    canvas.drawLine(vX2+10, vY2+250, vX2+530, vY2+250, paint);
                    canvas.drawLine(vX2+510, vY2+270, vX2+510, vY2+140, paint);
                    canvas.drawLine(vX2+485, vY2+140, vX2+855, vY2+140, paint);
                    break;



                //52.   S6 ECB - MG Exam Control Room

                case (R.id.floor2_s6ecb*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY+250, vX+530, vY+250, paint);
                    canvas.drawLine(vX+510, vY+270, vX+510, vY+140, paint);
                    canvas.drawLine(vX+485, vY+140, vX+1000, vY+140, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX2+10, vY2+250, vX2+530, vY2+250, paint);
                    canvas.drawLine(vX2+510, vY2+270, vX2+510, vY2+140, paint);
                    canvas.drawLine(vX2+485, vY2+140, vX2+1000, vY2+140, paint);

                    break;


                //53.   S4 CSB - KTU Exam Control Room
                case (R.id.floor2_s4csb*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+0, vY+10, vX+180, vY+10, paint);


                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX2+0, vY2+10, vX2+180, vY2+10, paint);


                    break;



                //54.   S4 CSB - MG Exam Control Room

                case (R.id.floor2_s4csb*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+0, vY+10, vX+330, vY+10, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_s4csb:
                    canvas.drawLine(vX2+0, vY2+10, vX2+330, vY2+10, paint);

                    break;



                //55.   KTU Exam Control Room -  MG Exam Control Room

                case (R.id.floor2_ktu*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+0, vY+10, vX+150, vY+10, paint);


                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX2+0, vY2+10, vX2+150, vY2+10, paint);


                    break;


                //68.  EC Staff Room 2 - Vice Principal

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_vicePrincy:
                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+720, vY-117, paint);

                    break;


                case (R.id.floor2_vicePrincy*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+720, vY2-117, paint);

                    break;



                //69. EC Staff Room 2 - Science and Humanities Dept


                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_scienceDept:

                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+560, vY-117, paint);

                    break;


                case (R.id.floor2_scienceDept*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+560, vY2-117, paint);

                    break;


                //70. EC Staff Room 2 - CS Staff Room

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_csStaffRoom:
                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+500, vY-117, paint);


                    break;


                case (R.id.floor2_csStaffRoom*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+500, vY2-117, paint);

                    break;



                //71. EC Staff Room 2 - Ec staff Room 1

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_ecStaffRoom1:
                    canvas.drawLine(vX+10, vY-0, vX-520, vY+0, paint);


                    break;


                case (R.id.floor2_ecStaffRoom1*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2-520, vY2+0, paint);


                    break;


                //72. EC Staff Room 2 - S8 ECA

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_s8eca:

                    canvas.drawLine(vX+10, vY-0, vX-50, vY+0, paint);

                    break;


                case (R.id.floor2_s8eca*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2-50, vY2+0, paint);


                    break;



                //73. EC Staff Room 2 - S8 ECB

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_s8ecb:
                    canvas.drawLine(vX+10, vY-0, vX+80, vY+0, paint);


                    break;


                case (R.id.floor2_s8ecb*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+80, vY2+0, paint);


                    break;


                //74. EC Staff Room 2 - S6 ECA

                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_s6eca:
                    canvas.drawLine(vX+10, vY-0, vX-350, vY+0, paint);


                    break;


                case (R.id.floor2_s6eca*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2-350, vY2+0, paint);


                    break;



                //75. EC Staff Room 2 - S6 ECB


                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_s6ecb:
                    canvas.drawLine(vX+10, vY-0, vX-250, vY+0, paint);


                    break;


                case (R.id.floor2_s6ecb*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2-250, vY2+0, paint);


                    break;



                //76. EC Staff Room 2 - S4 CSB



                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_s4csb:

                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+420, vY-117, paint);
                    break;


                case (R.id.floor2_s4csb*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+420, vY2-117, paint);

                    break;

                //77. EC Staff Room 2 - KTU


                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_ktu:
                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+590, vY-117, paint);
                    break;


                case (R.id.floor2_ktu*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+590, vY2-117, paint);

                    break;


                //78. EC Staff Room 2 - MG


                case (R.id.floor2_ecStaffRoom2*100)+R.id.floor2_mg:
                    canvas.drawLine(vX+10, vY-0, vX+270, vY+0, paint);
                    canvas.drawLine(vX+250, vY+20, vX+250, vY-110, paint);
                    canvas.drawLine(vX+225, vY+-117, vX+740, vY-117, paint);

                    break;


                case (R.id.floor2_mg*100)+R.id.floor2_ecStaffRoom2:
                    canvas.drawLine(vX2+10, vY2-0, vX2+270, vY2+0, paint);
                    canvas.drawLine(vX2+250, vY2+20, vX2+250, vY2-110, paint);
                    canvas.drawLine(vX2+225, vY2+-117, vX2+740, vY2-117, paint);

                    break;



                //----------------------------------------- Floor 3 ---------------------------------------------------

                // 1.       CS HOD - MECH HOD


                case (R.id.floor3_csHOD*100)+R.id.floor3_meHOD:

                    canvas.drawLine(vX+25, vY+120, vX+25, vY+590, paint);
                    canvas.drawLine(vX, vY+590, vX+265, vY+590, paint);
                    break;

                case (R.id.floor3_meHOD*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+590, paint);
                    canvas.drawLine(vX2, vY2+590, vX2+265, vY2+590, paint);


                    break;





                // 2.       CS HOD - CCC


                // CCC TO HOD AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    //canvas.drawLine(vX+320, vY-320, vX+530, vY-320, paint);

                    break;

                case (R.id.floor3_csHOD*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    //canvas.drawLine(vX2+320, vY2-320, vX2+530, vY2-320, paint);
                    break;



                // 3.       CS HOD - CS LIB

                case (R.id.floor3_csHOD*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX+25, vY+180, vX+225, vY+180, paint);


                    break;

                case (R.id.floor3_csLibrary*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+180, vX2+225, vY2+180, paint);

                    break;






                // 4.       CS HOD - S8 CSA

                case (R.id.floor3_csHOD*100)+R.id.floor3_s8csa:

                    canvas.drawLine(vX+25, vY+120, vX+25, vY+710, paint);
                    canvas.drawLine(vX+50,vY+710,vX-600,vY+710,paint);
                    break;

                case (R.id.floor3_s8csa*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+710, paint);
                    canvas.drawLine(vX2+50,vY2+710,vX2-600,vY2+710,paint);


                    break;









                // 5.       CS HOD - S8 CSB

                case (R.id.floor3_csHOD*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+710, paint);
                    canvas.drawLine(vX+50,vY+710,vX-475,vY+710,paint);

                    break;

                case (R.id.floor3_s8csb*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+710, paint);
                    canvas.drawLine(vX2+50,vY2+710,vX2-475,vY2+710,paint);

                    break;












                // 6.       CS HOD - S6 CSA


                case (R.id.floor3_csHOD*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+710, paint);
                    canvas.drawLine(vX+50,vY+710,vX-890,vY+710,paint);

                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+710, paint);
                    canvas.drawLine(vX2+50,vY2+710,vX2-890,vY2+710,paint);

                    break;












                // 7.       CS HOD - S6 CSB
                case (R.id.floor3_csHOD*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+710, paint);
                    canvas.drawLine(vX+50,vY+710,vX-760,vY+710,paint);

                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+710, paint);
                    canvas.drawLine(vX2+50,vY2+710,vX2-760,vY2+710,paint);

                    break;













                // 8.       CS HOD - S4 CSA
                case (R.id.floor3_csHOD*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+590, paint);
                    canvas.drawLine(vX, vY+590, vX+175, vY+590, paint);

                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+590, paint);
                    canvas.drawLine(vX2, vY2+590, vX2+175, vY2+590, paint);

                    break;











                // 9.       CS HOD - S4 ME A
                case (R.id.floor3_csHOD*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+590, paint);
                    canvas.drawLine(vX, vY+590, vX+500, vY+590, paint);


                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+590, paint);
                    canvas.drawLine(vX2, vY2+590, vX2+500, vY2+590, paint);


                    break;











                // 10.   CS HOD - S4 ME B

                case (R.id.floor3_csHOD*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+590, paint);
                    canvas.drawLine(vX, vY+590, vX+350, vY+590, paint);


                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+590, paint);
                    canvas.drawLine(vX2, vY2+590, vX2+350, vY2+590, paint);


                    break;












                // 11.   CS HOD - SEMINAR HALL 1
                case (R.id.floor3_csHOD*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX+25, vY+180, vX+265, vY+180, paint);


                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+180, vX2+265, vY2+180, paint);

                    break;










                // 12.   CS HOD -  SEMINAR HALL 2
                case (R.id.floor3_csHOD*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX+25, vY+180, vX+360, vY+180, paint);


                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+180, vX2+360, vY2+180, paint);


                    break;











                // 13.   CS HOD -  CS STAFF ROOM 1

                // HOD TO STAFFROOM_1 AND BACK
                case (R.id.floor3_csHOD*100)+R.id.floor3_csStaffRoom1:


                    canvas.drawLine(vX+20, vY+180, vX+20, vY+730, paint);
                    canvas.drawLine(vX+20, vY+705, vX-260, vY+705, paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX2+20, vY2+180, vX2+20, vY2+730, paint);
                    canvas.drawLine(vX2+20, vY2+705, vX2-260, vY2+705, paint);
                    break;







                // 14.   CS HOD - CS STAFF ROOM 2



                // HOD TO STAFFROOM_2 AND BACK
                case (R.id.floor3_csHOD*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+20, vY+180, vX+140, vY+180, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_csHOD:

                    canvas.drawLine(vX2+20, vY2+180, vX2+140, vY2+180, paint);
                    break;


                ///15.   CS HOD - MECH STAFFROOM
                case (R.id.floor3_csHOD*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+590, paint);
                    canvas.drawLine(vX, vY+590, vX+500, vY+590, paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+590, paint);
                    canvas.drawLine(vX2, vY2+590, vX2+500, vY2+590, paint);
                    break;









                //16.   CS HOD - SERVER ROOM  

                case (R.id.floor3_csHOD*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX+25, vY+120, vX+25, vY+710, paint);
                    canvas.drawLine(vX+50,vY+710,vX-45,vY+710,paint);
                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_csHOD:
                    canvas.drawLine(vX2+25, vY2+120, vX2+25, vY2+710, paint);
                    canvas.drawLine(vX2+50,vY2+710,vX2-45,vY2+710,paint);
                    break;



                // 17.   MECH HOD - CCC

                case (R.id.floor3_meHOD*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX,vY,vX-225,vY,paint);
                    canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                    canvas.drawLine(vX-200,vY+135,vX-575,vY+135,paint);

                    break;

                case (R.id.floor3_ccc*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                    canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                    canvas.drawLine(vX2-200,vY2+135,vX2-575,vY2+135,paint);
                    break;







                // 18.   MECH HOD - CS LIB
                case (R.id.floor3_meHOD*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX,vY,vX-225,vY,paint);
                    canvas.drawLine(vX-225,vY+25,vX-225,vY-430,paint);
                    canvas.drawLine(vX-225,vY-405,vX+10,vY-405,paint);

                    break;

                case (R.id.floor3_csLibrary*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                    canvas.drawLine(vX2-225,vY2+25,vX2-225,vY2-430,paint);
                    canvas.drawLine(vX2-225,vY2-405,vX2+10,vY2-405,paint);
                    break;












                // 19.   MECH HOD - S8 CSA


                case (R.id.floor3_meHOD*100)+R.id.floor3_s8csa:
                     canvas.drawLine(vX,vY,vX-225,vY,paint);
                     canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                     canvas.drawLine(vX-200,vY+135,vX-845,vY+135,paint);
                     break;

                case (R.id.floor3_s8csa*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                     canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                     canvas.drawLine(vX2-200,vY2+135,vX2-845,vY2+135,paint);
                     break;











                // 20.   MECH HOD - S8 CSB
                case (R.id.floor3_meHOD*100)+R.id.floor3_s8csb:
                     canvas.drawLine(vX,vY,vX-225,vY,paint);
                     canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                     canvas.drawLine(vX-200,vY+135,vX-725,vY+135,paint);
                     break;

                case (R.id.floor3_s8csb*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                    canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                    canvas.drawLine(vX2-200,vY2+135,vX2-725,vY2+135,paint);













                // 21.   MECH HOD - S6 CSA

                case (R.id.floor3_meHOD*100)+R.id.floor3_s6csa:
                   canvas.drawLine(vX,vY,vX-225,vY,paint);
                   canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                   canvas.drawLine(vX-200,vY+135,vX-1100,vY+135,paint);
                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);

                    canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);

                    canvas.drawLine(vX2-200,vY2+135,vX2-1100,vY2+135,paint);
                    break;













                // 22.   MECH HOD - S6 CSB

                case (R.id.floor3_meHOD*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX,vY,vX-225,vY,paint);
                    canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                    canvas.drawLine(vX-200,vY+135,vX-1010,vY+135,paint);

                     break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                     canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                     canvas.drawLine(vX2-200,vY2+135,vX2-1010,vY2+135,paint);
                     break;












                // 23.   MECH HOD - S4 CSA
                case (R.id.floor3_meHOD*100)+R.id.floor3_s4csa:
                     canvas.drawLine(vX,vY,vX-25,vY,paint);

                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2-25,vY2,paint);


                    break;













                // 24.   MECH HOD - S4 ME A

                case (R.id.floor3_meHOD*100)+R.id.floor3_s4mea:
                     canvas.drawLine(vX,vY,vX+245,vY,paint);

                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2+245,vY2,paint);

                    break;










                // 25.   MECH HOD - S4 ME B

                case (R.id.floor3_meHOD*100)+R.id.floor3_s4meb:
                     canvas.drawLine(vX,vY,vX+145,vY,paint);

                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2+145,vY2,paint);

                    break;











                // 26.   MECH HOD - SEMINAR HALL 1

                case (R.id.floor3_meHOD*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX,vY,vX-225,vY,paint);
                    canvas.drawLine(vX-225,vY+25,vX-225,vY-430,paint);
                    canvas.drawLine(vX-225,vY-405,vX+15,vY-405,paint);
                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                    canvas.drawLine(vX2-225,vY2+25,vX2-225,vY2-430,paint);
                    canvas.drawLine(vX2-225,vY2-405,vX2+15,vY2-405,paint);
                    break;











                // 27.   MECH HOD - SEMINAR HALL 2

                case (R.id.floor3_meHOD*100)+R.id.floor3_seminarHall2:
                     canvas.drawLine(vX,vY,vX-225,vY,paint);
                     canvas.drawLine(vX-225,vY+25,vX-225,vY-430,paint);
                    canvas.drawLine(vX-225,vY-405,vX+145,vY-405,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_meHOD:
                     canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                     canvas.drawLine(vX2-225,vY2+25,vX2-225,vY2-430,paint);
                    canvas.drawLine(vX2-225,vY2-405,vX2+145,vY2-405,paint);
                    break;











                // 28.   MECH HOD - CS STAFF ROOM 1
                case (R.id.floor3_meHOD*100)+R.id.floor3_csStaffRoom1:
                     canvas.drawLine(vX,vY,vX-225,vY,paint);
                     canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                    canvas.drawLine(vX-200,vY+135,vX-300,vY+135,paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_meHOD:
                      canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                      canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                    canvas.drawLine(vX2-200,vY2+135,vX2-300,vY2+135,paint);
                    break;












                //29.   MECH HOD - CS STAFF ROOM 2
                case (R.id.floor3_meHOD*100)+R.id.floor3_csStaffRoom2:
                     canvas.drawLine(vX,vY,vX-225,vY,paint);
                     canvas.drawLine(vX-225,vY+25,vX-225,vY-430,paint);
                    canvas.drawLine(vX-225,vY-405,vX-120,vY-405,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_meHOD:
                    canvas.drawLine(vX2,vY,vX2-225,vY2,paint);
                    canvas.drawLine(vX2-225,vY2+25,vX2-225,vY2-430,paint);
                    canvas.drawLine(vX2-225,vY2-405,vX2-120,vY2-405,paint);
                    break;














                ///30.   MECH HOD - MECH STAFFROOM
                case (R.id.floor3_meHOD*100)+R.id.floor3_meStaffRoom:
                     canvas.drawLine(vX,vY,vX+275,vY,paint);

                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_meHOD:
                      canvas.drawLine(vX2,vY2,vX2+275,vY2,paint);

                    break;













                // 31.   MECH HOD - SERVER ROOM 

                case (R.id.floor3_meHOD*100)+R.id.floor3_serverRoom:
                      canvas.drawLine(vX,vY,vX-225,vY,paint);
                      canvas.drawLine(vX-225,vY-25,vX-225,vY+135,paint);
                    canvas.drawLine(vX-200,vY+135,vX-300,vY+135,paint);
                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_meHOD:
                      canvas.drawLine(vX2,vY2,vX2-225,vY2,paint);
                      canvas.drawLine(vX2-225,vY2-25,vX2-225,vY2+135,paint);
                    canvas.drawLine(vX2-200,vY2+135,vX2-300,vY2+135,paint);
                    break;











                //32.   CCC - CS LIB
                case (R.id.floor3_ccc*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                    canvas.drawLine(vX+350,vY+255,vX+350,vY-345,paint);
                    canvas.drawLine(vX+350,vY-320,vX+565,vY-320,paint);


                    break;

                case (R.id.floor3_csLibrary*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                    canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2-345,paint);
                    canvas.drawLine(vX2+350,vY2-320,vX2+565,vY2-320,paint);
                    break;













                //33.   CCC - S8 CSA
                case (R.id.floor3_ccc*100)+R.id.floor3_s8csa:
                     canvas.drawLine(vX,vY+230,vX-250,vY+230,paint);

                    break;

                case (R.id.floor3_s8csa*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX2,vY2+230,vX2-250,vY2+230,paint);


                    break;













                //34.   CCC - S8 CSB

                case (R.id.floor3_ccc*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX,vY+230,vX-140,vY+230,paint);

                    break;

                case (R.id.floor3_s8csb*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX2,vY2+230,vX2-140,vY2+230,paint);


                    break;











                //35.   CCC - S6 CSA

                case (R.id.floor3_ccc*100)+R.id.floor3_s6csa:
                     canvas.drawLine(vX,vY+230,vX-580,vY+230,paint);

                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_ccc:
                     canvas.drawLine(vX2,vY2+230,vX2-580,vY2+230,paint);

                    break;












                //36.   CCC - S6 CSB

                case (R.id.floor3_ccc*100)+R.id.floor3_s6csb:
                      canvas.drawLine(vX,vY+230,vX-410,vY+230,paint);

                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_ccc:
                      canvas.drawLine(vX2,vY2+230,vX2-410,vY2+230,paint);

                    break;












                //37.   CCC - S4 CSA
                case (R.id.floor3_ccc*100)+R.id.floor3_s4csa:
                      canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                      canvas.drawLine(vX+350,vY+255,vX+350,vY+60,paint);
                      canvas.drawLine(vX+350,vY+85,vX+550,vY+85,paint);
                      break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_ccc:
                      canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                      canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2+60,paint);
                    canvas.drawLine(vX2+350,vY2+85,vX2+550,vY2+85,paint);
                    break;











                //38.   CCC - S4 ME A
                case (R.id.floor3_ccc*100)+R.id.floor3_s4mea:
                     canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                     canvas.drawLine(vX+350,vY+255,vX+350,vY+60,paint);
                     canvas.drawLine(vX+350,vY+85,vX+850,vY+85,paint);
                     break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_ccc:
                        canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                        canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2+60,paint);
                      canvas.drawLine(vX2+350,vY2+85,vX2+850,vY2+85,paint);
                    break;













                //39.   CCC - S4 ME B

                case (R.id.floor3_ccc*100)+R.id.floor3_s4meb:
                     canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                     canvas.drawLine(vX+350,vY+255,vX+350,vY+60,paint);
                     canvas.drawLine(vX+350,vY+85,vX+700,vY+85,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_ccc:
                         canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                         canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2+60,paint);
                       canvas.drawLine(vX2+350,vY2+85,vX2+700,vY2+85,paint);
                    break;











                //40.   CCC - SEMINAR HALL 1
                case (R.id.floor3_ccc*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                    canvas.drawLine(vX+350,vY+255,vX+350,vY-345,paint);
                    canvas.drawLine(vX+350,vY-320,vX+575,vY-320,paint);
                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                    canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2-345,paint);
                    canvas.drawLine(vX2+350,vY2-320,vX2+575,vY2-320,paint);
                    break;














                //41.   CCC - SEMINAR HALL 2
                case (R.id.floor3_ccc*100)+R.id.floor3_seminarHall2:
                     canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                     canvas.drawLine(vX+350,vY+255,vX+350,vY-345,paint);
                     canvas.drawLine(vX+350,vY-320,vX+705,vY-320,paint);
                     break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX2,vY2+230,vX2+350,vY2+230,paint);
                    canvas.drawLine(vX2+350,vY2+255,vX2+350,vY2-345,paint);
                    canvas.drawLine(vX2+350,vY2-320,vX2+705,vY2-320,paint);
                    break;













                //42.   CCC - CS STAFF ROOM 1

                // CCC TO STAFFROOM_1 AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX+20, vY+220, vX+100, vY+220, paint);
                    canvas.drawLine(vX+100, vY+195, vX+100, vY+275, paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+20, vY2+220, vX2+100, vY2+220, paint);
                    canvas.drawLine(vX2+100, vY2+195, vX2+100, vY2+275, paint);
                    break;


                //43.   CCC - CS STAFF ROOM 2

                // CCC TO STAFFROOM_2 AND BACK
                case (R.id.floor3_ccc*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+50, vY+220, vX+370, vY+220, paint);
                    canvas.drawLine(vX+345, vY+220, vX+345, vY-320, paint);
                    canvas.drawLine(vX+320, vY-320, vX+440, vY-320, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_ccc:

                    canvas.drawLine(vX2+50, vY2+220, vX2+370, vY2+220, paint);
                    canvas.drawLine(vX2+345, vY2+220, vX2+345, vY2-320, paint);
                    canvas.drawLine(vX2+320, vY2-320, vX2+440, vY2-320, paint);
                    break;


                //44.   CCC - MECH STAFFROOM
                case (R.id.floor3_ccc*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                    canvas.drawLine(vX+350,vY+255,vX+350,vY+60,paint);
                    canvas.drawLine(vX+350,vY+85,vX+850,vY+85,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_ccc:
                    canvas.drawLine(vX,vY+230,vX+350,vY+230,paint);
                    canvas.drawLine(vX+350,vY+255,vX+350,vY+60,paint);
                    canvas.drawLine(vX+350,vY+85,vX+850,vY+85,paint);
                    break;












                //45.   CCC - SERVER ROOM  
                case (R.id.floor3_ccc*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX,vY+230,vX+300,vY+230,paint);

                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_ccc:
                      canvas.drawLine(vX,vY+230,vX+300,vY+230,paint);

                    break;












                ///46.   CS LIB - S8 CSA
                case (R.id.floor3_csLibrary*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-750,vY+530,paint);


                    break;

                case (R.id.floor3_s8csa*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                    canvas.drawLine(vX2-180,vY2+530,vX2-750,vY2+530,paint);
                    break;














                //47.   CS LIB - S8 CSB
                case (R.id.floor3_csLibrary*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-650,vY+530,paint);
                    break;

                case (R.id.floor3_s8csb*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                    canvas.drawLine(vX2-180,vY2+530,vX2-650,vY2+530,paint);
                    break;















                ///48.   CS LIB - S6 CSA

                case (R.id.floor3_csLibrary*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-1050,vY+530,paint);
                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                    canvas.drawLine(vX2-180,vY2+530,vX2-1050,vY2+530,paint);
                    break;














                //49.   CS LIB - S6 CSB

                case (R.id.floor3_csLibrary*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-950,vY+530,paint);
                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_csLibrary:
                     canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                     canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                     canvas.drawLine(vX2-180,vY2+530,vX2-950,vY2+530,paint);
                    break;
















                // 50.   CS LIB - S4 CSA

                case (R.id.floor3_csLibrary*100)+R.id.floor3_s4csa:
                     canvas.drawLine(vX,vY,vX-205,vY,paint);
                     canvas.drawLine(vX-180,vY,vX-180,vY+400,paint);
                     canvas.drawLine(vX-205,vY+400,vX,vY+400,paint);
                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX2-180,vY2+400,paint);
                    canvas.drawLine(vX2-205,vY2+400,vX2,vY2+400,paint);
                    break;















                //51.   CS LIB - S4 ME A
                case (R.id.floor3_csLibrary*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+400,paint);
                    canvas.drawLine(vX-205,vY+400,vX+320,vY+400,paint);
                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX2-180,vY2+400,paint);
                    canvas.drawLine(vX2-205,vY2+400,vX2+320,vY2+400,paint);
                    break;



















                //52.   CS LIB - S4 ME B

                case (R.id.floor3_csLibrary*100)+R.id.floor3_s4meb:
                      canvas.drawLine(vX,vY,vX-205,vY,paint);
                      canvas.drawLine(vX-180,vY,vX-180,vY+400,paint);
                    canvas.drawLine(vX-205,vY+400,vX+200,vY+400,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX2-180,vY2+400,paint);
                    canvas.drawLine(vX2-205,vY2+400,vX2+200,vY2+400,paint);
                    break;
















                //53.   CS LIB - SEMINAR HALL 1

                case (R.id.floor3_csLibrary*100)+R.id.floor3_seminarHall1:
                      canvas.drawLine(vX+40,vY,vX+60,vY,paint);

                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_csLibrary:
                           canvas.drawLine(vX2+40,vY2,vX2+60,vY2,paint);

                    break;















                // 54.   CS LIB - SEMINAR HALL 2

                case (R.id.floor3_csLibrary*100)+R.id.floor3_seminarHall2:

                          canvas.drawLine(vX+40,vY,vX+180,vY,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_csLibrary:
                           canvas.drawLine(vX2+40,vY2,vX2+180,vY2,paint);

                    break;


















                // 55.   CS LIB - CS STAFF ROOM 1
                case (R.id.floor3_csLibrary*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-250,vY+530,paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                    canvas.drawLine(vX2-180,vY2+530,vX2-250,vY2+530,paint);
                    break;

















                // 56.   CS LIB - CS STAFF ROOM 2
                case (R.id.floor3_csLibrary*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX,vY,vX-40,vY,paint);


                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_csLibrary:


                    break;












                //57.   CS LIB - MECH STAFFROOM
                case (R.id.floor3_csLibrary*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+400,paint);
                    canvas.drawLine(vX-205,vY+400,vX+320,vY+400,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX2-180,vY2+400,paint);
                    canvas.drawLine(vX2-205,vY2+400,vX2+320,vY2+400,paint);
                    break;













                //58.   CS LIB - SERVER ROOM  
                case (R.id.floor3_csLibrary*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX,vY,vX-205,vY,paint);
                    canvas.drawLine(vX-180,vY,vX-180,vY+555,paint);
                    canvas.drawLine(vX-180,vY+530,vX-210,vY+530,paint);
                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_csLibrary:
                    canvas.drawLine(vX2,vY2,vX2-205,vY2,paint);
                    canvas.drawLine(vX2-180,vY2,vX-180,vY2+555,paint);
                    canvas.drawLine(vX2-180,vY2+530,vX2-210,vY2+530,paint);
                    break;



















                //59.   S8 CSA - S8 CSB
                case (R.id.floor3_s8csa*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX+50,vY+220,vX+180,vY+220,paint);


                    break;

                case (R.id.floor3_s8csb*100)+R.id.floor3_s8csa:
                        canvas.drawLine(vX2+50,vY2+220,vX2+180,vY2+220,paint);

                    break;













                //60.   S8 CSA - S6 CSA

                case (R.id.floor3_s8csa*100)+R.id.floor3_s6csa:
                         canvas.drawLine(vX+50,vY+220,vX-225,vY+220,paint);
                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+225,vY2+220,paint);


                    break;



















                //61.   S8 CSA - S6 CSB
                case (R.id.floor3_s8csa*100)+R.id.floor3_s6csb:
                          canvas.drawLine(vX+50,vY+220,vX-155,vY+220,paint);

                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+220,vY2+220,paint);


                    break;















                //62.   S8 CSA - S4 CSA
                case (R.id.floor3_s8csa*100)+R.id.floor3_s4csa:
                     canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                     canvas.drawLine(vX+645,vY+220,vX+645,vY+110,paint);
                     canvas.drawLine(vX+620,vY+110,vX+785,vY+110,paint);

                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2+110,paint);
                    canvas.drawLine(vX2+620,vY2+110,vX2+785,vY2+110,paint);
                    break;















                //63.   S8 CSA - S4 ME A

                case (R.id.floor3_s8csa*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY+110,paint);
                    canvas.drawLine(vX+620,vY+110,vX+1130,vY+110,paint);
                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2+110,paint);
                    canvas.drawLine(vX2+620,vY2+110,vX2+1130,vY2+110,paint);
                    break;













                //64.   S8 CSA - S4 ME B
                case (R.id.floor3_s8csa*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY+110,paint);
                    canvas.drawLine(vX+620,vY+110,vX+990,vY+110,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2+110,paint);
                    canvas.drawLine(vX2+620,vY2+110,vX2+1030,vY2+110,paint);
                    break;













                //65.   S8 CSA - SEMINAR HALL 1
                case (R.id.floor3_s8csa*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY-330,paint);
                    canvas.drawLine(vX+620,vY-330,vX+875,vY-330,paint);

                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2-330,paint);
                    canvas.drawLine(vX2+620,vY2-330,vX2+875,vY2-330,paint);
                    break;















                //66.   S8 CSA - SEMINAR HALL 2
                case (R.id.floor3_s8csa*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY-330,paint);
                    canvas.drawLine(vX+620,vY-330,vX+975,vY-330,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2-330,paint);
                    canvas.drawLine(vX2+620,vY2-330,vX2+975,vY2-330,paint);

                    break;














                //67.   S8 CSA - CS STAFF ROOM 1
                case (R.id.floor3_s8csa*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX+50,vY+220,vX+590,vY+220,paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+590,vY2+220,paint);


                    break;












                //68.   S8 CSA - CS STAFF ROOM 2

                case (R.id.floor3_s8csa*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY-330,paint);
                    canvas.drawLine(vX+620,vY-330,vX+735,vY-330,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2-330,paint);
                    canvas.drawLine(vX2+620,vY2-330,vX2+735,vY2-330,paint);
                    break;













                //69.   S8 CSA - MECH STAFFROOM

                case (R.id.floor3_s8csa*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX+50,vY+220,vX+670,vY+220,paint);
                    canvas.drawLine(vX+645,vY+220,vX+645,vY+110,paint);
                    canvas.drawLine(vX+620,vY+110,vX+1130,vY+110,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+670,vY2+220,paint);
                    canvas.drawLine(vX2+645,vY2+220,vX2+645,vY2+110,paint);
                    canvas.drawLine(vX2+620,vY2+110,vX2+1130,vY2+110,paint);
                    break;










                //70.   S8 CSA - SERVER ROOM  

                case (R.id.floor3_s8csa*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX+50,vY+220,vX+590,vY+220,paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s8csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+590,vY2+220,paint);


                    break;












                ///71.   S8 CSB- S6 CSA
                case (R.id.floor3_s8csb*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX+50,vY+220,vX-340,vY+220,paint);


                    break;

                case (R.id.floor3_s6csa*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2-340,vY2+220,paint);


                    break;













                //72.   S8 CSB- S6 CSB

                case (R.id.floor3_s8csb*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX+50,vY+220,vX-240,vY+220,paint);


                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2-240,vY2+220,paint);


                    break;











                //73.   S8 CSB- S4 CSA


                case (R.id.floor3_s8csb*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY+85,paint);
                    canvas.drawLine(vX+530,vY+110,vX+700,vY+110,paint);



                case (R.id.floor3_s4csa*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2+85,paint);
                    canvas.drawLine(vX2+530,vY2+110,vX2+700,vY2+110,paint);
                    break;








                //74.   S8 CSB- S4 ME A


                case (R.id.floor3_s8csb*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY+85,paint);
                    canvas.drawLine(vX+530,vY+110,vX+1000,vY+110,paint);
                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2+85,paint);
                    canvas.drawLine(vX2+530,vY2+110,vX2+1000,vY2+110,paint);
                    break;










                //75.   S8 CSB- S4 ME B

                case (R.id.floor3_s8csb*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY+85,paint);
                    canvas.drawLine(vX+530,vY+110,vX+900,vY+110,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2+85,paint);
                    canvas.drawLine(vX2+530,vY2+110,vX2+900,vY2+110,paint);
                    break;













                //76.   S8 CSB- SEMINAR HALL 1

                case (R.id.floor3_s8csb*100)+R.id.floor3_seminarHall1:
                     canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                     canvas.drawLine(vX+525,vY+245,vX+525,vY-320,paint);
                     canvas.drawLine(vX+500,vY-320,vX+625,vY-320,paint);

                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2-320,paint);
                    canvas.drawLine(vX2+500,vY2-320,vX2+625,vY2-320,paint);
                    break;














                //77.   S8 CSB- SEMINAR HALL 2

                case (R.id.floor3_s8csb*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY-320,paint);
                    canvas.drawLine(vX+500,vY-320,vX+850,vY-320,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2-320,paint);
                    canvas.drawLine(vX2+500,vY2-320,vX2+850,vY2-320,paint);
                    break;











                //78.   S8 CSB- CS STAFF ROOM 1

                case (R.id.floor3_s8csb*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX+50,vY+220,vX+450,vY+220,paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+450,vY2+220,paint);


                    break;












                //79.   S8 CSB- CS STAFF ROOM 2


                case (R.id.floor3_s8csb*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY-320,paint);
                    canvas.drawLine(vX+500,vY-320,vX+575,vY-320,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2-320,paint);
                    canvas.drawLine(vX2+500,vY2-320,vX2+575,vY2-320,paint);
                    break;













                //80.   S8 CSB- MECH STAFFROOM

                case (R.id.floor3_s8csb*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX+50,vY+220,vX+520,vY+220,paint);
                    canvas.drawLine(vX+525,vY+245,vX+525,vY+85,paint);
                    canvas.drawLine(vX+530,vY+110,vX+1000,vY+110,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+520,vY2+220,paint);
                    canvas.drawLine(vX2+525,vY2+245,vX2+525,vY2+85,paint);
                    canvas.drawLine(vX2+530,vY2+110,vX2+1000,vY2+110,paint);

                    break;














                //81.   S8 CSB- SERVER ROOM  


                case (R.id.floor3_s8csb*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX2+50,vY2+220,vX2+420,vY2+220,paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s8csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+420,vY2+220,paint);


                    break;












                //82.   S6 CSA- S6 CSB


                case (R.id.floor3_s6csa*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX+50,vY+220,vX+220,vY+220,paint);


                    break;

                case (R.id.floor3_s6csb*100)+R.id.floor3_s6csa:
                     canvas.drawLine(vX2+50,vY2+220,vX2+220,vY2+220,paint);


                    break;













                //83.   S6 CSA- S4 CSA
                case (R.id.floor3_s6csa*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY+85,paint);
                    canvas.drawLine(vX+945,vY+110,vX+1140,vY+110,paint);
                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2+85,paint);
                    canvas.drawLine(vX2+945,vY2+110,vX2+1140,vY2+110,paint);
                    break;














                //84.   S6 CSA- S4 ME A
                case (R.id.floor3_s6csa*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY+85,paint);
                    canvas.drawLine(vX+945,vY+110,vX+1440,vY+110,paint);
                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2+85,paint);
                    canvas.drawLine(vX2+945,vY2+110,vX2+1440,vY2+110,paint);
                    break;
















                //85.   S6 CSA- S4 ME B
                case (R.id.floor3_s6csa*100)+R.id.floor3_s4meb:
                     canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                     canvas.drawLine(vX+930,vY+245,vX+930,vY+85,paint);
                     canvas.drawLine(vX+945,vY+110,vX+1330,vY+110,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2+85,paint);
                    canvas.drawLine(vX2+945,vY2+110,vX2+1330,vY2+110,paint);
                    break;














                //86.   S6 CSA- SEMINAR HALL 1
                case (R.id.floor3_s6csa*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY-350,paint);
                    canvas.drawLine(vX+925,vY-325,vX+1190,vY-325,paint);

                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2-350,paint);
                    canvas.drawLine(vX2+925,vY2-325,vX2+1190,vY2-325,paint);
                    break;














                //87.   S6 CSA- SEMINAR HALL 2
                case (R.id.floor3_s6csa*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY-350,paint);
                    canvas.drawLine(vX+925,vY-325,vX+1320,vY-325,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s6csa:
                   canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                   canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2-350,paint);
                   canvas.drawLine(vX2+925,vY2-325,vX2+1320,vY2-325,paint);
                    break;



















                //88.   S6 CSA- CS STAFF ROOM 1
                case (R.id.floor3_s6csa*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);


                    break;












                //89.   S6 CSA- CS STAFF ROOM 2
                case (R.id.floor3_s6csa*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY-350,paint);
                    canvas.drawLine(vX+925,vY-325,vX+1060,vY-325,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2-350,paint);
                    canvas.drawLine(vX2+925,vY2-325,vX2+1060,vY2-325,paint);
                    break;
















                //90.   S6 CSA- MECH STAFFROOM
                case (R.id.floor3_s6csa*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX+50,vY+220,vX+920,vY+220,paint);
                    canvas.drawLine(vX+930,vY+245,vX+930,vY+85,paint);
                    canvas.drawLine(vX+945,vY+110,vX+1440,vY+110,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s6csa:
                    canvas.drawLine(vX2+50,vY2+220,vX2+920,vY2+220,paint);
                    canvas.drawLine(vX2+930,vY2+245,vX2+930,vY2+85,paint);
                    canvas.drawLine(vX2+945,vY2+110,vX2+1440,vY2+110,paint);
                    break;













                //91.   S6 CSA- SERVER ROOM  
                case (R.id.floor3_s6csa*100)+R.id.floor3_serverRoom:
                     canvas.drawLine(vX+50,vY+220,vX+870,vY+220,paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s6csa:
                     canvas.drawLine(vX2+50,vY2+220,vX2+870,vY2+220,paint);


                    break;
















                //92.   S6 CSB- S4 CSA
                case (R.id.floor3_s6csb*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY+85,paint);
                    canvas.drawLine(vX+835,vY+110,vX+990,vY+110,paint);
                    break;

                case (R.id.floor3_s4csa*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2+85,paint);
                    canvas.drawLine(vX2+835,vY2+110,vX2+990,vY2+110,paint);
                    break;















                //93.   S6 CSB- S4 ME A

                case (R.id.floor3_s6csb*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY+85,paint);
                    canvas.drawLine(vX+835,vY+110,vX+1300,vY+110,paint);
                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2+85,paint);
                    canvas.drawLine(vX2+835,vY2+110,vX2+1300,vY2+110,paint);
                    break;












                //94.   S6 CSB- S4 ME B

                case (R.id.floor3_s6csb*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY+85,paint);
                    canvas.drawLine(vX+835,vY+110,vX+1210,vY+110,paint);
                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2+85,paint);
                    canvas.drawLine(vX2+835,vY2+110,vX2+1210,vY2+110,paint);
                    break;













                //95.   S6 CSB- SEMINAR HALL 1


                case (R.id.floor3_s6csb*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY-350,paint);
                    canvas.drawLine(vX+835,vY-325,vX+1060,vY-325,paint);
                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2-350,paint);
                    canvas.drawLine(vX2+925,vY2-325,vX2+1060,vY2-325,paint);
                    break;













                //96.   S6 CSB- SEMINAR HALL 2


                case (R.id.floor3_s6csb*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY-350,paint);
                    canvas.drawLine(vX+835,vY-325,vX+1260,vY-325,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2-350,paint);
                    canvas.drawLine(vX2+925,vY2-325,vX2+1260,vY2-325,paint);
                    break;














                //97.   S6 CSB- CS STAFF ROOM 1

                case (R.id.floor3_s6csb*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX+50,vY+220,vX+720,vY+220,paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+720,vY2+220,paint);


                    break;















                ///98.   S6 CSB- CS STAFF ROOM 2


                case (R.id.floor3_s6csb*100)+R.id.floor3_csStaffRoom2:
                     canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                     canvas.drawLine(vX+815,vY+245,vX+815,vY-350,paint);
                     canvas.drawLine(vX+835,vY-325,vX+930,vY-325,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2-350,paint);
                    canvas.drawLine(vX2+925,vY2-325,vX2+930,vY2-325,paint);
                    break;















                //99.   S6 CSB- MECH STAFFROOM


                case (R.id.floor3_s6csb*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX+50,vY+220,vX+820,vY+220,paint);
                    canvas.drawLine(vX+815,vY+245,vX+815,vY+85,paint);
                    canvas.drawLine(vX+835,vY+110,vX+1300,vY+110,paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+820,vY2+220,paint);
                    canvas.drawLine(vX2+815,vY2+245,vX2+815,vY2+85,paint);
                    canvas.drawLine(vX2+835,vY2+110,vX2+1300,vY2+110,paint);
                    break;














                //100.S6 CSB- SERVER ROOM  

                case (R.id.floor3_s6csb*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX+50,vY+220,vX+750,vY+220,paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s6csb:
                    canvas.drawLine(vX2+50,vY2+220,vX2+750,vY2+220,paint);


                    break;


















                //101.S4 CSA- S4 ME A

                case (R.id.floor3_s4csa*100)+R.id.floor3_s4mea:
                     canvas.drawLine(vX+50,vY,vX+325,vY,paint);



                    break;

                case (R.id.floor3_s4mea*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2+50,vY2,vX2+325,vY2,paint);


                    break;










                //102.S4 CSA- S4 ME B
                case (R.id.floor3_s4csa*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX+50,vY,vX+325-75,vY,paint);


                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2+50,vY2,vX2+325-75,vY2,paint);


                    break;















                //103.S4 CSA- SEMINAR HALL 1

                case (R.id.floor3_s4csa*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX,vY,vX-150,vY,paint);
                    canvas.drawLine(vX-120,vY+10,vX-120,vY-430,paint);
                    canvas.drawLine(vX-120,vY-405,vX+100,vY-405,paint);


                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2,vY2,vX2-150,vY2,paint);
                    canvas.drawLine(vX2-120,vY2+10,vX2-120,vY2-430,paint);
                    canvas.drawLine(vX2-120,vY2-405,vX2+100,vY2-405,paint);
                    break;













                //104.S4 CSA- SEMINAR HALL 2

                case (R.id.floor3_s4csa*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX,vY,vX-150,vY,paint);
                    canvas.drawLine(vX-120,vY+10,vX-120,vY-430,paint);
                    canvas.drawLine(vX-120,vY-405,vX+200,vY-405,paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2,vY2,vX2-150,vY2,paint);
                    canvas.drawLine(vX2-120,vY2+10,vX2-120,vY2-430,paint);
                    canvas.drawLine(vX2-120,vY2-405,vX2+200,vY2-405,paint);
                    break;














                //105.S4 CSA- CS STAFF ROOM 1

                case (R.id.floor3_s4csa*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX,vY,vX-150,vY,paint);
                    canvas.drawLine(vX-135,vY-25,vX-135,vY+160,paint);
                     canvas.drawLine(vX-120,vY+135,vX-200,vY+135,paint);



                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2,vY2,vX2-150,vY2,paint);
                    canvas.drawLine(vX2-135,vY2-25,vX2-135,vY2+160,paint);
                     canvas.drawLine(vX2-120,vY2+135,vX2-200,vY2+135,paint);
                    break;

















                //106.S4 CSA- CS STAFF ROOM 2
                case (R.id.floor3_s4csa*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX,vY,vX-150,vY,paint);
                    canvas.drawLine(vX-120,vY+10,vX-120,vY-430,paint);
                    canvas.drawLine(vX-120,vY-405,vX-50,vY-405,paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2,vY2,vX2-150,vY2,paint);
                    canvas.drawLine(vX2-130,vY2+10,vX2-130,vY2-430,paint);
                    canvas.drawLine(vX2-120,vY2-405,vX2-50,vY2-405,paint);
                    break;













                //107.S4 CSA- MECH STAFFROOM

                case (R.id.floor3_s4csa*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX,vY,vX+380,vY,paint);


                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s4csa:
                           canvas.drawLine(vX2,vY2,vX2+380,vY2,paint);

                    break;













                //108.S4 CSA- SERVER ROOM  

                case (R.id.floor3_s4csa*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX,vY,vX-150,vY,paint);
                    canvas.drawLine(vX-135,vY-25,vX-135,vY+160,paint);
                     canvas.drawLine(vX-120,vY+135,vX-200,vY+135,paint);
                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s4csa:
                    canvas.drawLine(vX2,vY2,vX2-150,vY2,paint);
                    canvas.drawLine(vX2-135,vY2-25,vX2-135,vY2+160,paint);
                     canvas.drawLine(vX2-120,vY2+135,vX2-200,vY2+135,paint);
                    break;













                //109.S4 ME A- S4 ME B
                case (R.id.floor3_s4mea*100)+R.id.floor3_s4meb:
                    canvas.drawLine(vX,vY,vX-100,vY,paint);


                    break;

                case (R.id.floor3_s4meb*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX2,vY2,vX2-100,vY2,paint);


                    break;













                //110.S4 ME A- SEMINAR HALL 1
                case (R.id.floor3_s4mea*100)+R.id.floor3_seminarHall1:


                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s4mea:


                    break;












                //111.S4 ME A- SEMINAR HALL 2
                case (R.id.floor3_s4mea*100)+R.id.floor3_seminarHall2:

                    canvas.drawLine(vX,vY,vX-450,vY,paint);
                    canvas.drawLine(vX-450,vY,vX-450,vY-400,paint);
                    canvas.drawLine(vX-450,vY-400,vX-100,vY-400,paint);

                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s4mea:

                    canvas.drawLine(vX2,vY2,vX2-450,vY2,paint);
                    canvas.drawLine(vX2-450,vY2,vX2-450,vY2-400,paint);
                    canvas.drawLine(vX2-450,vY2-400,vX2-100,vY2-400,paint);

                    break;
















                //112.S4 ME A- CS STAFF ROOM 1
                case (R.id.floor3_s4mea*100)+R.id.floor3_csStaffRoom1:


                    canvas.drawLine(vX,vY,vX-450,vY,paint);
                    canvas.drawLine(vX-450,vY,vX-450,vY+150,paint);
                    canvas.drawLine(vX-450,vY+150,vX-700,vY+150,paint);

                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s4mea:



                    canvas.drawLine(vX2,vY2,vX2-450,vY2,paint);
                    canvas.drawLine(vX2-450,vY2,vX2-450,vY2+150,paint);
                    canvas.drawLine(vX2-450,vY2+150,vX2-700,vY2+150,paint);
                    break;














                //113.S4 ME A- CS STAFF ROOM 2

                case (R.id.floor3_s4mea*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX,vY,vX-450,vY,paint);
                    canvas.drawLine(vX-450,vY,vX-450,vY-250,paint);


                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s4mea:

                    canvas.drawLine(vX2,vY2,vX2-450,vY2,paint);
                    canvas.drawLine(vX2-450,vY2,vX2-450,vY2-250,paint);

                    break;















                //114.S4 ME A- MECH STAFFROOM
                case (R.id.floor3_s4mea*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX,vY,vX-100,vY,paint);

                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s4mea:
                    canvas.drawLine(vX2,vY2,vX2-100,vY2,paint);

                    break;



















                //115.S4 ME A- SERVER ROOM  

                case (R.id.floor3_s4mea*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX,vY,vX-500,vY,paint);

                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s4mea:

                    canvas.drawLine(vX2,vY2,vX2-500,vY2,paint);

                    break;














                //116.S4 ME B- SEMINAR HALL 1
                case (R.id.floor3_s4meb*100)+R.id.floor3_seminarHall1:

                    canvas.drawLine(vX-330, vY+5, vX+50, vY+5, paint);
                    canvas.drawLine(vX-330, vY+25, vX-330, vY-450, paint);
                    canvas.drawLine(vX-330, vY-425, vX-180, vY-425, paint);
                    break;

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-330, vY2+5, vX2+50, vY2+5, paint);
                    canvas.drawLine(vX2-330, vY2+25, vX2-330, vY2-450, paint);
                    canvas.drawLine(vX2-330, vY2-425, vX2-180, vY2-425, paint);

                    break;

















                //117.S4 ME B- SEMINAR HALL 2
                case (R.id.floor3_s4meb*100)+R.id.floor3_seminarHall2:

                    canvas.drawLine(vX-330, vY+5, vX+50, vY+5, paint);
                    canvas.drawLine(vX-330, vY+25, vX-330, vY-450, paint);
                    canvas.drawLine(vX-330, vY-425, vX+50, vY-425, paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-330, vY2+5, vX2+50, vY2+5, paint);
                    canvas.drawLine(vX2-330, vY2+25, vX2-330, vY2-450, paint);
                    canvas.drawLine(vX2-330, vY2-425, vX2+50, vY2-425, paint);
                    break;





















                //118.S4 ME B- CS STAFF ROOM 1


                case (R.id.floor3_s4meb*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX-330, vY+5, vX+50, vY+5, paint);
                    canvas.drawLine(vX-310, vY+5, vX-310, vY+150, paint);
                    canvas.drawLine(vX-300, vY+150, vX-470, vY+150, paint);
                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-330, vY2+5, vX2+50, vY2+5, paint);
                    canvas.drawLine(vX2-310, vY2+5, vX2-310, vY2+150, paint);
                    canvas.drawLine(vX2-300, vY2+150, vX2-470, vY2+150, paint);
                    break;














                //119.S4 ME B- CS STAFF ROOM 2

                case (R.id.floor3_s4meb*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX-330, vY+5, vX+50, vY+5, paint);
                    canvas.drawLine(vX-330, vY+25, vX-330, vY-450, paint);
                    canvas.drawLine(vX-330, vY-425, vX-180, vY-425, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-330, vY2+5, vX2+50, vY2+5, paint);
                    canvas.drawLine(vX2-330, vY2+25, vX2-330, vY2-450, paint);
                    canvas.drawLine(vX2-330, vY2-425, vX2-180, vY2-425, paint);
                    break;


















                //120.S4 ME B- MECH STAFFROOM
                case (R.id.floor3_s4meb*100)+R.id.floor3_meStaffRoom:

                    canvas.drawLine(vX-50, vY+5, vX+50, vY+5, paint);

                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-50, vY2+5, vX2+50, vY2+5, paint);
                    break;


















                //121.S4 ME B- SERVER ROOM  

                case (R.id.floor3_s4meb*100)+R.id.floor3_serverRoom:

                    canvas.drawLine(vX-310-20, vY+225-220, vX+50, vY+225-220, paint);
                    canvas.drawLine(vX-310-20, vY+200-220, vX-310-20, vY+400-220, paint);
                    canvas.drawLine(vX-650-20+250, vY+375-220, vX-310-20, vY+375-220, paint);



                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_s4meb:

                    canvas.drawLine(vX2-310-20, vY2+225-220, vX2+50, vY2+225-220, paint);
                    canvas.drawLine(vX2-310-20, vY2+200-220, vX2-310-20, vY2+400-220, paint);
                    canvas.drawLine(vX2-650-20+250, vY2+375-220, vX2-310-20, vY2+375-220, paint);



                    break;

















                //122.SEMINAR HALL 1- SEMINAR HALL 2
                case (R.id.floor3_seminarHall1*100)+R.id.floor3_seminarHall2:

                    canvas.drawLine(vX-50, vY+175, vX+300, vY+175, paint);
                    break;

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_seminarHall1:

                    canvas.drawLine(vX2-50, vY2+175, vX2+300, vY2+175, paint);
                    break;















                //123.SEMINAR HALL 1- CS STAFF ROOM 1
                case (R.id.floor3_seminarHall1*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX+50, vY+175, vX-100, vY+175, paint);
                    canvas.drawLine(vX-75, vY+175, vX-80, vY+750, paint);
                    canvas.drawLine(vX-75, vY+725, vX-400, vY+725, paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_seminarHall1:

                    canvas.drawLine(vX2+50, vY2+175, vX2-100, vY2+175, paint);
                    canvas.drawLine(vX2-75, vY2+175, vX2-80, vY2+750, paint);
                    canvas.drawLine(vX2-75, vY2+725, vX2-400, vY2+725, paint);

                    break;
















                //124.SEMINAR HALL 1- CS STAFF ROOM 2

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX+50, vY+175, vX-50, vY+175, paint);

                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX2+50, vY2+175, vX2-50, vY2+175, paint);

                    break;















                //125.SEMINAR HALL 1- MECH STAFFROOM

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_meStaffRoom:

                    canvas.drawLine(vX+50, vY+175, vX-100, vY+175, paint);
                    canvas.drawLine(vX-75, vY+175, vX-80, vY+600, paint);
                    canvas.drawLine(vX-105, vY+600, vX+200, vY+600, paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_seminarHall1:
                    canvas.drawLine(vX2+50, vY2+175, vX2-100, vY2+175, paint);
                    canvas.drawLine(vX2-75, vY2+175, vX2-80, vY2+600, paint);
                    canvas.drawLine(vX2-105, vY2+600, vX2+200, vY2+600, paint);

                    break;















                //126.SEMINAR HALL 1- SERVER ROOM  

                case (R.id.floor3_seminarHall1*100)+R.id.floor3_serverRoom:

                    canvas.drawLine(vX+50, vY+175, vX-100, vY+175, paint);
                    canvas.drawLine(vX-75, vY+175, vX-80, vY+750, paint);
                    canvas.drawLine(vX-75, vY+725, vX-150, vY+725, paint);
                    break;
                case (R.id.floor3_serverRoom*100)+R.id.floor3_seminarHall1:

                    canvas.drawLine(vX2+50, vY2+175, vX2-100, vY2+175, paint);
                    canvas.drawLine(vX2-75, vY2+175, vX2-80, vY2+750, paint);
                    canvas.drawLine(vX2-75, vY2+725, vX2-150, vY2+725, paint);
                    break;



















                //127.SEMINAR HALL 2- CS STAFF ROOM 1
                case (R.id.floor3_seminarHall2*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX+300-225, vY+175, vX-100-225, vY+175, paint);
                    canvas.drawLine(vX-75-225, vY+175, vX-80-225, vY+750, paint);
                    canvas.drawLine(vX-75-225, vY+725, vX-400-225, vY+725, paint);


                    break;

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX2+300-225, vY2+175, vX2-100-225, vY2+175, paint);
                    canvas.drawLine(vX2-75-225, vY2+175, vX2-80-225, vY2+750, paint);
                    canvas.drawLine(vX2-75-225, vY2+725, vX2-400-225, vY2+725, paint);


                    break;


















                //128.SEMINAR HALL 2- CS STAFF ROOM 2

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+300-225, vY+175, vX-100-150, vY+175, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_seminarHall2:

                    canvas.drawLine(vX2+300-225, vY2+175, vX2-100-150, vY2+175, paint);
                    break;











                //129.SEMINAR HALL 2- MECH STAFFROOM
                case (R.id.floor3_seminarHall2*100)+R.id.floor3_meStaffRoom:

                    canvas.drawLine(vX+50-390, vY+175, vX+50, vY+175, paint);
                    canvas.drawLine(vX-75-240, vY+175, vX-80-240, vY+600, paint);
                    canvas.drawLine(vX-105-240, vY+600, vX+200-140, vY+600, paint);
                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_seminarHall2:
                    canvas.drawLine(vX2+50-390, vY2+175, vX2+50, vY2+175, paint);
                    canvas.drawLine(vX2-75-240, vY2+175, vX2-80-240, vY2+600, paint);
                    canvas.drawLine(vX2-105-240, vY2+600, vX2+200-140, vY2+600, paint);
                    break;


















                //130.SEMINAR HALL 2- SERVER ROOM  

                case (R.id.floor3_seminarHall2*100)+R.id.floor3_serverRoom:

                    canvas.drawLine(vX+50-390, vY+175, vX+50, vY+175, paint);
                    canvas.drawLine(vX-75-240, vY+175, vX-80-240, vY+750, paint);
                    canvas.drawLine(vX+50-420, vY+725, vX+50-390, vY+725, paint);
                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_seminarHall2:


                    canvas.drawLine(vX2+50-390, vY2+175, vX2+50, vY2+175, paint);
                    canvas.drawLine(vX2-75-240, vY2+175, vX2-80-240, vY2+750, paint);
                    canvas.drawLine(vX2+50-420, vY2+725, vX2+50-390, vY2+725, paint);
                    break;














                //131.CS STAFF ROOM 1- CS STAFF ROOM 2
                // STAFFROOM_1 To STAFFROOM_2 AND BACK
                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_csStaffRoom2:

                    canvas.drawLine(vX+20, vY-50, vX+300, vY-50, paint);
                    canvas.drawLine(vX+275, vY-50, vX+275, vY-600, paint);
                    canvas.drawLine(vX+250, vY-600, vX+400, vY-600, paint);
                    break;

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_csStaffRoom1:

                    canvas.drawLine(vX2+20, vY2-50, vX2+300, vY2-50, paint);
                    canvas.drawLine(vX2+275, vY2-50, vX2+275, vY2-600, paint);
                    canvas.drawLine(vX2+250, vY2-600, vX2+400, vY2-600, paint);
                    break;








                //132.CS STAFF ROOM 1- MECH STAFFROOM

                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_meStaffRoom:
                     canvas.drawLine(vX+20, vY-50, vX+300, vY-50, paint);
                     canvas.drawLine(vX+275, vY-50, vX+275, vY-200, paint);
                    canvas.drawLine(vX+275, vY-175, vX+700, vY-175, paint);


                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_csStaffRoom1:
                     canvas.drawLine(vX2+20, vY2-50, vX2+300, vY2-50, paint);
                     canvas.drawLine(vX2+275, vY2-50, vX2+275, vY2-200, paint);
                    canvas.drawLine(vX2+275, vY2-175, vX2+700, vY2-175, paint);
                    break;











                //133.CS STAFF ROOM 1- SERVER ROOM  
                case (R.id.floor3_csStaffRoom1*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX+20, vY-50, vX+40, vY-50, paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_csStaffRoom1:
                    canvas.drawLine(vX2+20, vY2-50, vX2+40, vY2-50, paint);


                    break;
















                // 134.CS STAFF ROOM 2- MECH STAFFROOM
                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_meStaffRoom:
                    canvas.drawLine(vX, vY-50, vX-80, vY-50, paint);
                    canvas.drawLine(vX-65, vY-50, vX-65, vY+350, paint);
                    canvas.drawLine(vX-80, vY+350, vX+450, vY+350, paint);


                    break;

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX2, vY2-50, vX2-80, vY2-50, paint);
                    canvas.drawLine(vX2-65, vY2-50, vX2-65, vY2+350, paint);
                    canvas.drawLine(vX2-80, vY2+350, vX2+450, vY2+350, paint);
                    break;















                //135.CS STAFF ROOM 2- SERVER ROOM  

                case (R.id.floor3_csStaffRoom2*100)+R.id.floor3_serverRoom:
                    canvas.drawLine(vX, vY-50, vX-90, vY-50, paint);
                    canvas.drawLine(vX-65, vY-50, vX-65, vY+500, paint);
                    canvas.drawLine(vX-45, vY+500, vX-115, vY+500, paint);


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_csStaffRoom2:
                    canvas.drawLine(vX2, vY2-50, vX2-90, vY2-50, paint);
                    canvas.drawLine(vX2-65, vY2-50, vX2-65, vY2+500, paint);
                    canvas.drawLine(vX2-45, vY2+500, vX2-115, vY2+500, paint);
                    break;














                //136.MECH STAFFROOM- SERVER ROOM 

                case (R.id.floor3_meStaffRoom*100)+R.id.floor3_serverRoom:
                     canvas.drawLine(vX+20, vY+250, vX-320, vY+250, paint) ;
                    canvas.drawLine(vX-320, vY+225, vX-320, vY+390, paint) ;
                    canvas.drawLine(vX-320, vY+380, vX-380, vY+380, paint) ;


                    break;

                case (R.id.floor3_serverRoom*100)+R.id.floor3_meStaffRoom:
                     canvas.drawLine(vX2+20, vY2+250, vX2-320, vY2+250, paint) ;
                    canvas.drawLine(vX2-320, vY2+225, vX2-320, vY2+390, paint) ;
                    canvas.drawLine(vX2-320, vY2+380, vX2-380, vY2+380, paint) ;
                    break;





                /// ------------------------------------------------------------------------------------------------------


            }


            //	drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

        }

    }





}