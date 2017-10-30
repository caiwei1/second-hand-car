package com.secondhandcar.admin.utils;

import com.secondhandcar.core.utils.StringUtils;
import com.secondhandcar.core.utils.ToolUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/12.
 */
public class DictUtils {
    /**
     * 每个条目之间的分隔符
     */
    public static final String ITEM_SPLIT = ";";

    public static final String IMAGE_SPLIT = "@@";

    /**
     * 属性之间的分隔符
     */
    public static final String ATTR_SPLIT = ":";

    /**
     * 拼接字符串的id
     */
    public static final String MUTI_STR_ID = "ID";

    /**
     * 拼接字符串的key
     */
    public static final String MUTI_STR_KEY = "KEY";

    /**
     * 拼接字符串的value
     */
    public static final String MUTI_STR_VALUE = "VALUE";
    /**
     * 拼接字符串的第三个值
     */
    public static final String MUTI_STR_THREE = "THREE";

    /**
     * 解析一个组合字符串(例如:  "1:启用;2:禁用;3:冻结"  这样的字符串)
     *
     * @author xietao
     * @Date 2017/4/27 16:44
     */
    public static List<Map<String, String>> parseKeyValue(String mutiString) {
        if (ToolUtil.isEmpty(mutiString)) {
            return new ArrayList<>();
        } else {
            ArrayList<Map<String, String>> results = new ArrayList<>();
            String[] items = StringUtils.split(StringUtils.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(ATTR_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>();
                itemMap.put(MUTI_STR_KEY, attrs[0]);
                itemMap.put(MUTI_STR_VALUE, attrs[1]);
                results.add(itemMap);
            }
            return results;
        }
    }

    /**
     * 解析一个组合字符串(例如:  "1:启用:xxx;2:禁用:xxx;3:冻结:xxx"  这样的字符串)
     *
     * @author xietao
     * @Date 2017/4/27 16:44
     */
    public static List<Map<String, String>> parseKeyValueForThree(String mutiString) {
        if (ToolUtil.isEmpty(mutiString)) {
            return new ArrayList<>();
        } else {
            ArrayList<Map<String, String>> results = new ArrayList<>();
            String[] items = StringUtils.split(StringUtils.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(ATTR_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>();
                itemMap.put(MUTI_STR_KEY, attrs[0]);
                itemMap.put(MUTI_STR_VALUE, attrs[1]);
                itemMap.put(MUTI_STR_THREE, attrs[2]);
                results.add(itemMap);
            }
            return results;
        }
    }

    /**
     * 解析一个组合字符串(例如:  "1:启用:xxx;2:禁用:xxx;3:冻结:xxx"  这样的字符串)
     *
     * @author xietao
     * @Date 2017/4/27 16:44
     */
    public static List<Map<String, String>> parseKeyValueForImage(String mutiString) {
        if (ToolUtil.isEmpty(mutiString)) {
            return new ArrayList<>();
        } else {
            ArrayList<Map<String, String>> results = new ArrayList<>();
            String[] items = StringUtils.split(StringUtils.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(IMAGE_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>();
                itemMap.put(MUTI_STR_KEY, attrs[0]);
                itemMap.put("image", attrs[1]);
                itemMap.put(MUTI_STR_THREE, attrs[2]);
                results.add(itemMap);
            }
            return results;
        }
    }
}
