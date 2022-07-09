package com.shahenpc.common.utils.string;

public class StringHelper {
    /**
     * 当数字超过3位数1000的时候，自动加逗号 (,)
     * @param view
     * @return
     */
    public static String afterTextChanged(String view) {
        String s = null;
        try {
            s = String.format("%,d", Long.parseLong(view));
        } catch (NumberFormatException e) {
            return view;
        }
        return s;
    }
}
