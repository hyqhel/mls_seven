package com.digiwes.common.util;

public class CommonUtils {


    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        String retStr = jsonForMatStr.toString();

        while (-1 != retStr.indexOf("\t\t\n")) {
            retStr = retStr.replace("\t\t\n", "\t\n");
        }
        retStr = retStr.replace("\t\n", "");
        return retStr;

    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    /**
     * check parameter is null
     */
    public static boolean checkParamIsNull(Object obj) {
        if (null == obj) {
            return true;
        }
        return false;
    }

    public static void checkParamIsNull(String paramName, Object paramValue) throws IllegalArgumentException {
        if (null == paramValue || "".equals(paramValue.toString())) {
            throw new IllegalArgumentException("Parameter [" + paramName + "] must be not null. ");
        }
    }
}
