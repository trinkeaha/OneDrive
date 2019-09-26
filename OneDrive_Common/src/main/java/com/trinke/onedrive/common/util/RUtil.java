package com.trinke.onedrive.common.util;



import com.trinke.onedrive.common.menum.Renum;
import com.trinke.onedrive.common.vo.R;

public class RUtil {

    public static <T> R setOK(String msg, T obj) {
        R<T> r = new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static <T> R setOK(String msg) {
        R<T> r = new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static <T> R setOK() {
        R<T> r = new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg("OK");
        r.setData(null);
        return r;
    }

    public static <T> R setERROR(String msg){
        R<T> r=new R<>();
        r.setCode(Renum.ERROR.getCode());
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static <T> R setERROR(){
        R<T> r=new R<>();
        r.setCode(Renum.ERROR.getCode());
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }

    public static <T> R setR(boolean issuccess, String msg) {
        return issuccess?setOK(msg):setERROR(msg);

    }


}
