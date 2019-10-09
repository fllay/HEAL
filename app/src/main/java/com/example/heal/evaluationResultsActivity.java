package com.example.heal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;

public class evaluationResultsActivity extends AppCompatActivity {

    HalfGauge diabetesGauge;
    HalfGauge fatGauge;
    HalfGauge htGauge;
    TextView dbRisk;
    TextView fatRisk;
    TextView htRisk;
    TextView htSugestion;

    public static final String mypreference = "mypref";
    //Family dicease
    public static final String s_familyDiabtes = "familyDiabtes";
    public static final String s_familyGastationalDiabetes = "familyGastationalDiabetes";
    public static final String s_familyHighBloodPressure = "familyHighBloodPressure";
    public static final String s_familyCoronaryAryeryDicease = "familyCoronaryAryeryDicease";
    public static final String s_familyCardiacArrhythmias = "familyCardiacArrhythmias";
    public static final String s_familyHighCholesterol = "familyHighCholesterol";
    public static final String s_familyGout = "familyGout";
    public static final String s_familyPolycysticOvarianSyndrome = "familyPolycysticOvarianSyndrome";
    public static final String s_familyDeliveredOverweightBaby = "familyDeliveredOverweightBaby";
    public static final String s_familyBloodSugarProblemDuringDietry = "familyBloodSugarProblemDuringDietry";
    //Self dicease
    public static final String s_selfDiabtes = "selfDiabtes";
    public static final String s_selfGastationalDiabetes = "selfGastationalDiabetes";
    public static final String s_selfHighBloodPressure = "selfHighBloodPressure";
    public static final String s_selfCoronaryAryeryDicease = "selfCoronaryAryeryDicease";
    public static final String s_selfCardiacArrhythmias = "selfCardiacArrhythmias";
    public static final String s_selfHighCholesterol = "selfHighCholesterol";
    public static final String s_selfGout = "selfGout";
    public static final String s_selfPolycysticOvarianSyndrome = "selfPolycysticOvarianSyndrome";
    public static final String s_selfDeliveredOverweightBaby = "selfDeliveredOverweightBaby";
    public static final String s_selfBloodSugarProblemDuringDietry = "selfBloodSugarProblemDuringDietry";
    //Blood test
    public static final String s_bloodUpper = "bloodUpper";
    public static final String s_bloodLower = "bloodLower";
    public static final String s_serumLipidProfile = "serumLipidProfile";
    public static final String s_choresterol = "choresterol";
    public static final String s_LDL = "LDL";
    public static final String s_HDL = "HDL";
    public static final String s_TG = "TG";
    public static final String s_fastingBloodGlucose = "fastingBloodGlucose";
    public static final String s_uricAcid = "uricAcid";
    //Basic info
    public static final String Sex = "Sex";
    public static final String Age = "Age";
    public static final String DOB = "DOB";
    public static final String Height = "Height";
    public static final String Weight = "Weight";
    public static final String Waist = "Waist";

    public static final String s_selfLHV = "selfLHV";
    public static final String s_selfProteinuria = "selfProteinuria";
    public static final String s_selfAtherosclerotic = "selfAtherosclerotic";
    public static final String s_selfRetinapathy = "selfRetinapathy";
    public static final String s_selfPVD = "selfPVD";
    public static final String s_selfCKD1 = "selfCKD1";
    public static final String s_selfCKD2 = "selfCKD2";
    public static final String s_selfCKD3 = "selfCKD3";
    public static final String s_selfCKD4 = "selfCKD4";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_results);

        diabetesGauge = findViewById(R.id.results_diabetes);
        dbRisk = findViewById(R.id.results_diabetes_risk);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        float h = sharedpreferences.getFloat(Height, 1)/100;
        float BMI = sharedpreferences.getFloat(Weight, 0)/(h*h);

        //Diabetes
        Range range0 = new Range();
        range0.setColor(Color.parseColor("#E3C5F1"));
        range0.setFrom(0.0);
        range0.setTo(3.0);

        Range range1 = new Range();
        range1.setColor(Color.parseColor("#9CFF33"));
        range1.setFrom(0.0);
        range1.setTo(3.0);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#FFF033"));
        range2.setFrom(3.0);
        range2.setTo(6.0);

        Range range3 = new Range();
        range3.setColor(Color.parseColor("#FFA533"));
        range3.setFrom(6.0);
        range3.setTo(8.0);

        Range range4 = new Range();
        range4.setColor(Color.parseColor("#FF5733"));
        range4.setFrom(8.0);
        range4.setTo(10.0);
        //add color ranges to gauge
        diabetesGauge.addRange(range1);
        diabetesGauge.addRange(range2);
        diabetesGauge.addRange(range3);
        diabetesGauge.addRange(range4);



        //set min max and current value
        diabetesGauge.setMinValue(0.0);
        diabetesGauge.setMaxValue(10.0);
        int dbR = calDiabetes();
        diabetesGauge.setValue(dbR);
        //calDiabetes();

        float age = sharedpreferences.getInt(Age, 10);
        Boolean diabetesScreening = false;
        if(age < 35){
            if(sharedpreferences.getFloat(s_fastingBloodGlucose, 0) == 0){
                if(BMI > 25 && sharedpreferences.getBoolean(s_familyDiabtes, false)){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getFloat(s_TG, 0) >= 250 || sharedpreferences.getFloat(s_HDL, 1000) < 35){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getBoolean(s_selfHighBloodPressure, false)){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getBoolean(s_selfCoronaryAryeryDicease, false)){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getBoolean(s_selfPolycysticOvarianSyndrome, false)){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getBoolean(s_selfDeliveredOverweightBaby, false) || sharedpreferences.getBoolean(s_selfGastationalDiabetes, false)){
                    diabetesScreening = true;
                }

                if(sharedpreferences.getFloat(s_fastingBloodGlucose, 100) > 110 || sharedpreferences.getFloat(s_fastingBloodGlucose, 100) < 126){
                    diabetesScreening = true;
                }



            }
        } else {
            diabetesScreening = false;
        }

        String sc = "";
        if(diabetesScreening){
            sc = " ตรวจคัดกรองเบาหวาน";
        }

        if(dbR <= 2 ){
            dbRisk.setText("เสี่ยงเป็นเบาหวานต่ำ" + sc);
        } else  if(dbR >= 3 && dbR <= 5){
            dbRisk.setText("เสี่ยงเป็นเบาหวานปานกลาง" + sc);
        } else  if(dbR >= 6 && dbR <= 8 ){
            dbRisk.setText("เสี่ยงเป็นเบาหวานสูง" + sc);
        } else  if(dbR > 8 ){
            dbRisk.setText("เสี่ยงเป็นเบาหวานสูงมาก" + sc);
        }

        // Fat


        Range frange0 = new Range();
        frange0.setColor(Color.parseColor("#E3C5F1"));
        frange0.setFrom(0.0);
        frange0.setTo(18.5);

        Range frange1 = new Range();
        frange1.setColor(Color.parseColor("#9CFF33"));
        frange1.setFrom(18.5);
        frange1.setTo(22.9);

        Range frange2 = new Range();
        frange2.setColor(Color.parseColor("#FFF033"));
        frange2.setFrom(23);
        frange2.setTo(24.9);

        Range frange3 = new Range();
        frange3.setColor(Color.parseColor("#FFA533"));
        frange3.setFrom(25.0);
        frange3.setTo(29.9);

        Range frange4 = new Range();
        frange4.setColor(Color.parseColor("#FF5733"));
        frange4.setFrom(30);
        frange4.setTo(40.0);

        fatRisk = findViewById(R.id.results_fat_text);
        fatGauge = findViewById(R.id.results_fat);
        fatGauge.addRange(frange0);
        fatGauge.addRange(frange1);
        fatGauge.addRange(frange2);
        fatGauge.addRange(frange3);
        fatGauge.addRange(frange4);
        fatGauge.setMinValue(0.0);
        fatGauge.setMaxValue(40.0);


        fatGauge.setValue(BMI);
        String sex = sharedpreferences.getString(Sex,"Male");
        String tbell = "";
        if(sex.equals("Male")){
            if(sharedpreferences.getFloat(Waist, 80) > 90) {
                tbell = "อ้วนลงพุง";
            }
        } else {
            if(sharedpreferences.getFloat(Waist, 80) > 80) {
                tbell = "อ้วนลงพุง";
            }
        }


        if( BMI <=18.5) {
            fatRisk.setText("น้ำหนักตัวต่ำ " + tbell);
        }else if (BMI >18.5 && BMI <= 22.9) {
            fatRisk.setText("น้ำหนักตัวปกติ " + tbell);
        }else if (BMI > 22.9 && BMI <= 24.9) {
            fatRisk.setText("น้ำหนักตัวเกิน " + tbell);
        }else if (BMI > 24.9 && BMI < 29.9) {
            fatRisk.setText("อ้วนระดับ 1 " + tbell);
        } else {
            fatRisk.setText("อ้วนระดับ 2 " + tbell);
        }




        Range hrange0 = new Range();
        hrange0.setColor(Color.parseColor("#C5F1D8"));
        hrange0.setFrom(0.0);
        hrange0.setTo(1);

        Range hrange1 = new Range();
        hrange1.setColor(Color.parseColor("#48D361"));
        hrange1.setFrom(1);
        hrange1.setTo(2);

        Range hrange2 = new Range();
        hrange2.setColor(Color.parseColor("#F2EE63"));
        hrange2.setFrom(2);
        hrange2.setTo(3);

        Range hrange3 = new Range();
        hrange3.setColor(Color.parseColor("#F99550"));
        hrange3.setFrom(3);
        hrange3.setTo(4);

        Range hrange4 = new Range();
        hrange4.setColor(Color.parseColor("#FD3D34"));
        hrange4.setFrom(4);
        hrange4.setTo(5);

        Range hrange5 = new Range();
        hrange5.setColor(Color.parseColor("#7C0904"));
        hrange5.setFrom(5);
        hrange5.setTo(6);

        htRisk = findViewById(R.id.results_ht_text);
        htSugestion = findViewById(R.id.results_ht_sugestion);
        htGauge = findViewById(R.id.results_ht);
        htGauge.addRange(hrange0);
        htGauge.addRange(hrange1);
        htGauge.addRange(hrange2);
        htGauge.addRange(hrange3);
        htGauge.addRange(hrange4);
        htGauge.addRange(hrange5);
        htGauge.setMinValue(0.0);
        htGauge.setMaxValue(6.0);

        float bloodPh =  sharedpreferences.getFloat(s_bloodUpper, 120);
        float bloodPl =  sharedpreferences.getFloat(s_bloodLower, 80);
        float totalChoresterol =  sharedpreferences.getFloat(s_choresterol, 120);
        float LDL_C =  sharedpreferences.getFloat(s_LDL, 80);
        float TG = sharedpreferences.getFloat(s_TG, 100);
        float HDL_C = sharedpreferences.getFloat(s_HDL, 100);
        float FPG = sharedpreferences.getFloat(s_fastingBloodGlucose, 100);
        float waist = sharedpreferences.getFloat(Waist, 90);
        Log.i("INFO", String.valueOf(bloodPh));
        Log.i("INFO", String.valueOf(bloodPl));
        double htl = 0;
        if(bloodPh < 120 || bloodPl < 80){
            htl = 0.5;
            htRisk.setText("เหมาะสม");
        }

        if ( (bloodPh >= 120 && bloodPh < 130) || (bloodPl >= 80 && bloodPl < 85)){
            htl = 1.5;
            htRisk.setText("ปกติ");
        }

        if ( (bloodPh >= 130 && bloodPh < 140) || (bloodPl >= 85 && bloodPl < 90)){
            htl = 2.5;
            htRisk.setText("สูงปกติ");
        }

        if ( (bloodPh >= 140 && bloodPh < 160) || (bloodPl >= 90 && bloodPl < 100)){
            htl = 3.5;
            htRisk.setText("ความดันโลหิตสูงระดับ 1");
        }
        if ( (bloodPh >= 160 && bloodPh < 180) || (bloodPl >= 100 && bloodPl < 110)){
            htl = 4.5;
            htRisk.setText("ความดันโลหิตสูงระดับ 2");
        }

        if ( (bloodPh >= 180 ) || (bloodPl >= 110)){
            htl = 5.5;
            htRisk.setText("ความดันโลหิตสูงระดับ 3");
        }

        htGauge.setValue(htl);

        int riskFactor = 0;

        if(bloodPh - bloodPl > 60){
            riskFactor++;
        }
        int age1 = sharedpreferences.getInt(Age, 0);
        if(age1 > 55 && sex.equals("Male")){
            riskFactor++;
        }
        if(age1 > 65 && sex.equals("Female")){
            riskFactor++;
        }

        if(totalChoresterol > 200 && LDL_C > 130){
            riskFactor++;
        }
        if(sex.equals("Male")){
            if(TG > 150 || HDL_C < 40 ){
                riskFactor++;
            }
        } else {
            if(TG > 150 || HDL_C < 50 ){
                riskFactor++;
            }
        }

        if(FPG > 100 && FPG < 125){
            riskFactor++;
        }

        if(sharedpreferences.getBoolean(s_familyCoronaryAryeryDicease, false)){
            riskFactor++;
        }


        if(sex.equals("Male")){
            if(waist > 90){
                riskFactor++;
            }
        } else {
            if(waist > 80 ){
                riskFactor++;
            }
        }

        Boolean TOD = sharedpreferences.getBoolean(s_selfAtherosclerotic, false);
        Boolean CKD = sharedpreferences.getBoolean(s_selfCKD3, false);
        Boolean Db = sharedpreferences.getBoolean(s_selfDiabtes, false);
        Boolean CVD = sharedpreferences.getBoolean(s_selfCoronaryAryeryDicease, false);
        Boolean CKD4 = sharedpreferences.getBoolean(s_selfCKD4, false);

        double HT_segestion = 0;
        String ht_s = "ไม่ต้องรักษา";
        //  0 - white 1 = green  1.5 yellow-green 2 = yellow 2.5 yellow-orange 3 = orange 3.5 = orange-red 4 = red
        if ((TOD && Db) || CKD4 || CVD){
            Log.i("INFO", "Row 5");
            HT_segestion = 4;
            if(htl == 2.5) {
                ht_s = "ปรับพฤติกรรม ไม่ต้องให้ยา";
            } else {
                ht_s = "ปรับพฤติกรรม ให้ยาทันที";
            }
        } else if( TOD || CKD || Db){
            Log.i("INFO", "Row 4");
            if(htl == 2.5){
                HT_segestion = 2.5;
                ht_s = "ปรับพฤติกรรม ไม่ต้องให้ยา";
            }  else if(htl == 3.5){
                HT_segestion = 3;
                ht_s = "ปรับพฤติกรรม ให้ยาทันที";
            } else if(htl == 4.5){
                HT_segestion = 3;
                ht_s = "ปรับพฤติกรรม ให้ยาทันที";
            } else if(htl == 5.5){
                HT_segestion = 3.5;
                ht_s = "ปรับพฤติกรรม ให้ยาทันที";
            }
            Log.i("INFO", ht_s);
        } else {
            Log.i("INFO", "Risk factors");
            if(riskFactor == 0) {
                if(htl == 2.5){
                    HT_segestion = 0;
                    ht_s = "ไม่ต้องรักษา";
                }  else if(htl == 3.5){
                    HT_segestion = 1;
                    ht_s = "ปรับพฤติกรรม 2-4 เดือน หาก BP >140/90 ให้ยา";
                } else if(htl == 4.5){
                    HT_segestion = 2;
                    ht_s = "ปรับพฤติกรรม 2-4 เดือน หาก BP >140/90 ให้ยา";
                } else if(htl == 5.5){
                    HT_segestion = 3;
                    ht_s = "ปรับพฤติกรรม ให้ยาทันที";
                }
            } else if(riskFactor <= 2 && riskFactor >= 1) {
                if(htl == 2.5){
                    HT_segestion = 1;
                    ht_s = "ปรับพฤติกรรม ไม่ต้องให้ยา";
                }  else if(htl == 3.5){
                    HT_segestion = 2;
                    ht_s = "ปรับพฤติกรรม 2-4 เดือน หาก BP >140/90 ให้ยา";
                } else if(htl == 4.5){
                    HT_segestion = 2.5;
                    ht_s = "ปรับพฤติกรรม 2-4 เดือน หาก BP >140/90 ให้ยา";
                } else if(htl == 5.5){
                    HT_segestion = 3;
                    ht_s = "ปรับพฤติกรรม ให้ยาทันที";
                }
            } else if(riskFactor >= 3) {
                if(htl == 2.5){
                    HT_segestion = 1.5;
                    ht_s = "ปรับพฤติกรรม ไม่ต้องให้ยา";
                }  else if(htl == 3.5){
                    HT_segestion = 2.5;
                    ht_s = "ปรับพฤติกรรม ให้ยาทันที";
                } else if(htl == 4.5){
                    HT_segestion = 3;
                    ht_s = "ปรับพฤติกรรม ให้ยาทันที";
                } else if(htl == 5.5){
                    HT_segestion = 3;
                    ht_s = "ปรับพฤติกรรม ให้ยาทันที";
                }
            }
        }


        htSugestion.setText(ht_s);
        if(ht_s.equals("ไม่ต้องรักษา")) {
            htSugestion.setTextColor(Color.parseColor("#000000"));
            htSugestion.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else if(HT_segestion == 1) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#009900"));
        } else if(HT_segestion == 1.5) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#ccff99"));
        } else if(HT_segestion == 2) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#FFFF00"));
        } else if(HT_segestion == 2.5) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#FFCC66"));
        }else if(HT_segestion == 3.0) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#FF6600"));
        }
        else if(HT_segestion == 3.5) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#FF3300"));
        } else if(HT_segestion == 4.0) {
            htSugestion.setTextColor(Color.parseColor("#FFFFFF"));
            htSugestion.setBackgroundColor(Color.parseColor("#cc0000"));
        }



    }


    private int calDiabetes(){

        int age1 = sharedpreferences.getInt(Age, 0);
        int score = 0;
        if(age1 < 34) {

        } else if(age1 >=34 && age1 <= 39){
            score = 0;
        } else if(age1 >= 40 && age1 <= 44){
            score = 0;
        } else if(age1 >= 45 && age1 <= 49){
            score = score + 1;

        } else if(age1 >= 50){
            score = score + 2;
        }

        String sex = sharedpreferences.getString(Sex,"Male");

        if(sex.equals("Male")){
            score = score + 2;
        }

        float h = sharedpreferences.getFloat(Height, 1)/100;
        float BMI = sharedpreferences.getFloat(Weight, 0)/(h*h);

        Log.i("INFO", String.valueOf(BMI));

        if(BMI < 23){
            score = score + 0;
        }else if(BMI >=23 && BMI <=27.9) {
            score = score + 3;
        } else  if(BMI >= 27.5 ) {
            score = score + 3;
        }

        float ww = sharedpreferences.getFloat(Waist, 60);
        if(sex.equals("Male")){
            if( ww < 90) {
                score = score + 0;
            } else {
                score = score + 2;
            }
        } else {
            if( ww < 80) {
                score = score + 0;
            } else {
                score = score + 2;
            }
        }

        if(sharedpreferences.getBoolean(s_selfHighBloodPressure, false)){
            score = score + 2;
        }

        if(sharedpreferences.getBoolean(s_familyHighBloodPressure, false)){
            score = score + 4;
        }


        Log.i("INFO", String.valueOf(score));


        return score;
    }
}
