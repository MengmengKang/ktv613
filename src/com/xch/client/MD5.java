package com.xch.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
    private String str1;

    private String str2;

    public void set(final String inputstr)
    {
        str1 = inputstr;
        calcMD5();
    }

    public String get()
    {
        return str2;
    }

    public MD5(final String str)
    {
        str1 = str;
        calcMD5();
    }

    public MD5()
    {
    }

    public void calcMD5()
    {
        try
        {
            final MessageDigest message = MessageDigest.getInstance("MD5");
            message.update(str1.getBytes());
            byte[] b = new byte[16];
            b = message.digest();
            String digestHexStr = "";
            for (int i = 0; i < 16; i++)
            {
                digestHexStr += byteHEX(b[i]);
            }
            str2 = digestHexStr;
        }
        catch (final NoSuchAlgorithmException e2)
        {
            e2.printStackTrace();
        }
    }

    public static String byteHEX(final byte ib)
    {
        final char[] Digit =
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                'E', 'F' };
        final char[] ob = new char[2];
        ob[0] = Digit[ib >>> 4 & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        final String s = new String(ob);
        return s;
    }
}
