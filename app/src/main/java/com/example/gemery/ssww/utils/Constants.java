package com.example.gemery.ssww.utils;

/**
 * Created by gemery on 2018/4/9.
 */

public class Constants {
    /*   post请求必填项   订单单号 填写  s_oea  s_oeb
       {
 "oeaList": [
   {
     "id": "integer,ID",
      s_oea00:"string",
      s_oea_code:"string",
     "s_oea01": "123"

   }
 ],
 "oebList": [
   {
     "s_oeb01": "123",
      s_oeb03:"string"
     }
 ],
 "flage": "1"
}
        */

    public final static String BASE_URL = "http://www.baidu.com";

    public final static String  IMA_GET_LIST_URL = "http://192.168.1.251:8091/api/imaData/getimaList";
    public final static String IMA_POST_JSON = "{\n" +
            "  \"ima\": {\n" +
            "    \"id\": \"2112\",\n" +
            "    \n" +
            "   },\n" +
            "pageSize:\"1\",\n" +
            "pageIndex:\"1\"\n" +
            "}";
   public final static String EDIT_ORDER_URL ="http://192.168.1.251:8091/api/Order/standardOrderExq";
   public final static String EDIT_POST_JSON = "{\n" +
           " \"oeaList\": [\n" +
           "   {\n" +
           "     \"id\": \"integer,ID\",\n" +
           "      s_oea00:\"string\",\n" +
           "      s_oea_code:\"string\",\n" +
           "     \"s_oea01\": \"123\"\n" +
           "\n" +
           "   }\n" +
           " ],\n" +
           " \"oebList\": [\n" +
           "   {\n" +
           "     \"s_oeb01\": \"123\",\n" +
           "      s_oeb03:\"string\"\n" +
           "     }\n" +
           " ],\n" +
           " \"flage\": \"1\"\n" +
           "}";


}
