package com.example.benchmark.utills;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.File;
import java.io.FileFilter;

import java.io.InputStream;
import java.util.regex.Pattern;


public class DeviceInfo {


    public static String getCPUName() {
        String[] cmd = { "/system/bin/cat", "/proc/cpuinfo" };
        String workdirectory = "/system/bin/";
        String result = "";
        try {
            ProcessBuilder builder = new ProcessBuilder(cmd);

            if (workdirectory != null)
                builder.directory(new File(workdirectory));
            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                result = result + new String(re);
            }
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        result = result.substring(result.indexOf("Hardware	:") + 11);
        result = result.substring(0, result.indexOf('\n'));


        return result;
    }


    public static String getManufacturer() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static String getModel() {
        return Build.MODEL.startsWith(getManufacturer()) ? Build.MODEL.replace(getManufacturer(), "") : Build.MODEL;
    }



    public static int getCPUNumbers(){
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                return Pattern.matches("cpu[0-9]", pathname.getName());
            }
        }

        try {
            File dir = new File("/sys/devices/system/cpu/");
            File[] files = dir.listFiles(new CpuFilter());
            if (files != null) {
                return files.length;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 1;
    }

    public static int[] getMetrics(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int[] size = new int[3];
        size[0] = outMetrics.widthPixels;
        size[1] = outMetrics.heightPixels;
        size[2] = outMetrics.densityDpi;

        return size;
    }


}


