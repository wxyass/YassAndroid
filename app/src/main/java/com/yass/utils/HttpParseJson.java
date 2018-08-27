package com.yass.utils;

import android.util.Log;

import com.yass.core.utils.dbtutil.CheckUtil;
import com.yass.core.utils.dbtutil.GZIP;
import com.yass.core.utils.dbtutil.JsonUtil;
import com.yass.core.utils.dbtutil.PropertiesUtil;
import com.yass.main.ConstValues;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
import cn.com.benyoyo.manage.Struct.RequestStructBean;
import cn.com.benyoyo.manage.Struct.ResponseStructBean;

/**
 * Created by yangwenmin on 2017/12/7.
 */

public class HttpParseJson {

    public static final String TAG = "HttpParseJson";

    /**
     * 压缩请求json
     *
     * @param reqObj
     * @return
     */
    public static String parseRequestJson(RequestStructBean reqObj){
        String jsonZip = "";

        try {
            // 不压缩
            // jsonZip = JsonUtil.toJson(reqObj);

            // 先压缩,在BASE64加密
            jsonZip = new BASE64Encoder().encode(GZIP.compress(JsonUtil.toJson(reqObj)).getBytes("UTF-8"));

        } catch (Exception e1) {
            //Log.e(TAG, "压缩上传数据JSON失败", e1);
        }
        return jsonZip;
    }

    /**
     * 解压、解析网络请求返回结果
     *
     * 返回结果 用新的解压方式解压(161127)
     *
     * 除了同步请求 解压其他的异步请求(2018/02/23) 原名parseRes(String resContent)
     *
     * @param resContent    网络请求返回结果
     * @return
     */
    public static ResponseStructBean parseRes(String resContent) {
        //      //配合朱志凯测试给他提取json语句进行压力测试
        //      FileUtil.writeTxt(JsonUtil.toJson(resContent),FileUtil.getSDPath()+"/ceshi.txt");
        ResponseStructBean resObj = new ResponseStructBean();
        //判断字符串是否为空或者null
        if (!CheckUtil.isBlankOrNull(resContent)) {


            String json;
            try {
                //json = GZIP.uncompress2(base.decodeBuffer(resContent));

                // 先BASE64解密,再解压
                json =GZIP.unCompress(new String(new BASE64Decoder().decodeBuffer(resContent), "UTF-8"));

                resObj = JsonUtil.parseJson(json, ResponseStructBean.class);
                // 促使内存释放
                json = null;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            resObj = new ResponseStructBean();
            resObj.getResHead().setStatus(ConstValues.ERROR);
            resObj.getResBody().setContent(
                    PropertiesUtil.getProperties("msg_err_netfail"));
        }
        return resObj;
    }

}
