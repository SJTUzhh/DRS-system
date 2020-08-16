package com.loumeng.Bluetooth;
import java.io.DataOutputStream;
import java.io.IOException;

public class Root {

    private static boolean haveRoot = false;
    private static DataOutputStream outputStream;

    public static boolean IsRoot() {
        if (haveRoot == true)
            return true;
        if (ExceCommond("echo test") != -1) {
            haveRoot = true;
            return haveRoot;
        }
        haveRoot = false;
        return haveRoot;
    }

    public static int ExceCommond(String paramString) {
        int i = -1;
        try {
            Process process1 = Runtime.getRuntime().exec("su");
            outputStream = new DataOutputStream(process1.getOutputStream());
            outputStream.writeBytes(paramString + "\n");
            outputStream.flush();
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            process1.waitFor();
            int j = process1.exitValue();
            i = j;
            return i;
        } catch (Exception exception) {
            exception.printStackTrace();
            return i;
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
        }
    }
}
