package com.yangle.tag;

/**
 * Created by yangle on 2017/10/13.
 */
import com.yangle.util.EhcacheUtils;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GlobalTag extends SimpleTagSupport {
    private String key;
    private String defaultValue;
    public static Map map=new HashMap();
static {
    map.put("a","帅");
    map.put("b","不帅");
    map.put("c","漂亮");
    map.put("d","丑人");
}
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void doTag() throws JspException, IOException {

    Object value= EhcacheUtils.getValue(key)==null?defaultValue:EhcacheUtils.getValue(key);
        getJspContext().setAttribute(key,value);

    }
}