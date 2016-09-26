package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.security.MessageDigest;
import java.util.Locale;

public class eu
{
    private static String a = "";
    private static String b = "me.weyye.amapdemo";
    private static String c = "";
    private static String d = "a2d9036406c8a2889dfdabd8d29d17fb";
    private static String e = "72:3C:3C:8C:16:95:E4:20:DD:23:B2:C2:67:C5:67:40:4B:B3:91:D1:me.weyye.amapdemo";

    public static String a(Context paramContext)
    {
        try
        {
            return g(paramContext);
        }
        catch (Throwable localThrowable)
        {
            localThrowable.printStackTrace();
        }
        return d;
    }

    public static String b(Context paramContext)
    {
        PackageManager localPackageManager = null;
        ApplicationInfo localApplicationInfo = null;
        try
        {
            if (!"".equals(a)) {
                return a;
            }
            localPackageManager = paramContext.getPackageManager();
            localApplicationInfo = localPackageManager.getApplicationInfo(paramContext
                    .getPackageName(), 0);

            a = (String)localPackageManager.getApplicationLabel(localApplicationInfo);
        }
        catch (Throwable localThrowable)
        {
            fh.a(localThrowable, "AppInfo", "getApplicationName");
        }
        return a;
    }

    public static String c(Context paramContext)
    {
        try
        {
            if ((b != null) && (!"".equals(b))) {
                return b;
            }
            b = paramContext.getApplicationContext().getPackageName();
        }
        catch (Throwable localThrowable)
        {
            fh.a(localThrowable, "AppInfo", "getPackageName");
        }
        return b;
    }

    public static String d(Context paramContext)
    {
        PackageInfo localPackageInfo = null;
        try
        {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager localPackageManager = paramContext.getPackageManager();
            localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);

            c = localPackageInfo.versionName;
        }
        catch (Throwable localThrowable)
        {
            fh.a(localThrowable, "AppInfo", "getApplicationVersion");
        }
        return c == null ? "" : c;
    }

    public static String e(Context paramContext)
    {
        try
        {
            if ((e != null) && (!"".equals(e))) {
                return e;
            }
            PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext
                    .getPackageName(), 64);

            byte[] arrayOfByte1 = localPackageInfo.signatures[0].toByteArray();
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
            byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
            StringBuffer localStringBuffer = new StringBuffer();
            for (int i = 0; i < arrayOfByte2.length; i++)
            {
                String str = Integer.toHexString(0xFF & arrayOfByte2[i]).toUpperCase(Locale.US);
                if (str.length() == 1) {
                    localStringBuffer.append("0");
                }
                localStringBuffer.append(str);
                localStringBuffer.append(":");
            }
            localStringBuffer.append(localPackageInfo.packageName);
            e = localStringBuffer.toString();
            return e;
        }
        catch (Throwable localThrowable)
        {
            fh.a(localThrowable, "AppInfo", "getSHA1AndPackage");
        }
        return e;
    }

    static void a(String paramString)
    {
        d = paramString;
    }

    public static String f(Context paramContext)
    {
        try
        {
            return g(paramContext);
        }
        catch (Throwable localThrowable)
        {
            fh.a(localThrowable, "AppInfo", "getKey");
        }
        return d;
    }

    private static String g(Context paramContext)
            throws PackageManager.NameNotFoundException
    {
        if ((d == null) || (d.equals("")))
        {
            ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
            if ((localApplicationInfo == null) || (localApplicationInfo.metaData == null)) {
                return d;
            }
            d = localApplicationInfo.metaData.getString("com.amap.api.v2.apikey");
            if (d == null) {
                d = "";
            }
        }
        return d;
    }
}
