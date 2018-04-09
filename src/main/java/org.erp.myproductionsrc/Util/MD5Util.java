package org.erp.myproductionsrc.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String getMD5Value(String passwrod){

        String hash=null ;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            //得到的是128bit的MD5值
            byte[] digest = md.digest(passwrod.getBytes());

            //90 01 50 98 3c d2 4f b0 d6 96 3f 7d 28 e1 7f 72  32个*4=18bit
            //900150983cd24fb0d6963f7d28e17f72
            //900150983cd24fb0d6963f7d28e17f72
            //10010010
            //92

            //0000 0001

            StringBuffer sbBuffer =new StringBuffer();
            for (byte b : digest) {

                int i = 0x000000F7&b;




                String hexString = Integer.toHexString(i);

                //1

                if (hexString.length()==1) {

                    sbBuffer.append("0");
                }

                sbBuffer.append(hexString);

            }

            hash=sbBuffer.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        return hash;

    }
}
