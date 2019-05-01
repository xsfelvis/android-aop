package com.xsfdev.aop;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author：xsf
 * @version: 2018/9/13
 * @Description:
 */
public class SharedPreferenceUtil {

    private static SharedPreferences mPreferences;
    private static Context mContext;

    public static void setContext(Context c) {
        mContext = c;
    }

    public static SharedPreferences getSharePreferences(Context context) {
        if (mPreferences == null) {
            synchronized (SharedPreferenceUtil.class) {
                if (mPreferences == null) {
                    mPreferences = context.getSharedPreferences("AOP_SP", context.MODE_PRIVATE);
                }
            }
        }
        return mPreferences;
    }


    public static boolean isLogin() {
        return getSharePreferences(mContext).getBoolean("isLogin", false);
    }

    public static void setLogin(Context context, boolean isLogin) {
        getSharePreferences(mContext).edit().putBoolean("isLogin", isLogin).commit();
    }

}
