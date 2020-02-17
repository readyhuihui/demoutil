package com.example.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:lyh
 * @Description:json工具类
 * @Date:Created in 2020/2/17 10:02
 */
public class JsonUtil {


    /**
     * 格式化非标准的集合对象
     * @param str
     * @return
     */
    private static List<Map<String, Object>> paramStrToListMap(String str) {
        List<Map<String, Object>> listMapData = new ArrayList<Map<String, Object>>();
        str = str.replace("[", "").replace("]", "");
        String[] strs = str.split("},");
        for (int i = 0; i < strs.length; i++) {
            String strNow = strs[i];
            if(null !=strNow){
                strNow = strs[i].trim().replace("{", "").replace("}", "");
            }
            Map<String, Object> mapData = new HashMap<String, Object>();
            String [] strMaps =strNow.split(",");
            for(int j=0;j<strMaps.length;j++){
                String strMapData = strMaps[j];
                String[] strMapKeyAndValues = strMapData.split("=");
                String strKey = strMapKeyAndValues[0];
                String strValue = strMapKeyAndValues[1];
                if(null !=strKey){
                    strKey = strKey.trim();
                }
                if(null !=strValue){
                    strValue = strValue.trim();
                }
                mapData.put(strKey,strValue);
            }
            listMapData.add(mapData);
        }
        return listMapData;
    }
}
