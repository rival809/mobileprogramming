package com.example.projectmobileprogramming;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
    public static String setFormatTemperature(double temperature){
        DecimalFormat decimalFormat = new DecimalFormat(".#");
        String suffix = "\u00B0";
        double celcius = temperature-273.15;
        return String.valueOf(decimalFormat.format(celcius)) + suffix + "C";
    }

    public static String getDayName(long dateInMilis){

        Calendar myDate = Calendar.getInstance();
        myDate.setTimeInMillis(dateInMilis*1000);

        Date date = new Date();
        Calendar myCurrentDate = Calendar.getInstance();
        myCurrentDate.setTime(date);
        int julianDay = myDate.get(Calendar.DAY_OF_MONTH);
        int currentJulianDay = myCurrentDate.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy HH:mm", new Locale("id","ID"));
        if (julianDay == currentJulianDay){
            return "Sekarang" + ", "+df.format(myDate.getTime());
        } else if (julianDay == currentJulianDay + 1 ){
            return "Besok" + ", "+df.format(myDate.getTime());
        } else {
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm", new Locale("id","ID"));
            return dayFormat.format(myDate.getTime());
        }
    }

    public static int getArtResourceForWeatherCondition(int weatherId) {
        Log.d("TAG", "getArtResourceForWeatherCondition: "+weatherId);
        if (weatherId >= 200 && weatherId <= 232) {
            return R.drawable.art_storm;
        } else if (weatherId >= 300 && weatherId <= 321) {
            return R.drawable.art_light_rain;
        } else if (weatherId >= 500 && weatherId <= 504) {
            return R.drawable.art_rain;
        } else if (weatherId == 511) {
            return R.drawable.art_snow;
        } else if (weatherId >= 520 && weatherId <= 531) {
            return R.drawable.art_rain;
        } else if (weatherId >= 600 && weatherId <= 622) {
            return R.drawable.art_snow;
        } else if (weatherId >= 701 && weatherId <= 761) {
            return R.drawable.art_fog;
        } else if (weatherId == 761 || weatherId == 781) {
            return R.drawable.art_storm;
        } else if (weatherId == 800) {
            return R.drawable.art_clear;
        } else if (weatherId == 801) {
            return R.drawable.art_light_clouds;
        } else if (weatherId >= 802 && weatherId <= 804) {
            return R.drawable.art_clouds;
        }

        return R.drawable.ic_logo;
    }
}
