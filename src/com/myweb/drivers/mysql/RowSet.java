package com.myweb.drivers.mysql;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.HashMap;

public class RowSet {
    /**
     * 字段列表
     */
    protected ArrayList<String> fields = new ArrayList<String>();
    /**
     * 参数列表
     */
    protected ArrayList<Object> values = new ArrayList<Object>();


    /**
     * 参数列表
     */
    protected HashMap<String, Object> sets = new HashMap<String, Object>();


    /**
     * 添加字符
     *
     * @param fieldName
     * @param fieldValue
     */
    public void addString(String fieldName, String fieldValue) {
        if(null!=fieldName && null!=fieldValue) {
            fields.add('`' + fieldName + '`');
            values.add('"' + fieldValue + '"');
        }
    }

    /**
     * 添加数值
     *
     * @param fieldName
     * @param fieldValue
     */
    public void addNumber(String fieldName, Number fieldValue) {
        if(null!=fieldName && null!=fieldValue) {
            fields.add('`' + fieldName + '`');
            values.add(String.valueOf(fieldValue));
        }
    }

    /**
     * 获取字段，逗号分隔
     *
     * @return
     */
    public String getFields() {
        return StringUtils.join(fields, ",");
    }

    /**
     * 获取参数，逗号分隔
     *
     * @return
     */
    public String getValues() {
        return StringUtils.join(values, ",");
    }

    /**
     * 要update的字段以及字段值，逗号拼接起来返回
     *
     * @return
     */
    public String getSets(){
        StringBuilder str = new StringBuilder();
        String fieldValStr = "";
        if(null != sets){
            for(String key:sets.keySet()) {
                str.append("`" + key + "`='" + sets.get(key) + "',");
            }
            fieldValStr = str.substring(0,str.length()-1);
        }
        return fieldValStr;
    }

    /**
     *  给map集合赋值
     *
     * @return
     */
    public void addSet(String name, Object value){
        if(null != name && null != value){
            sets.put(name, value);
        }
    }
}