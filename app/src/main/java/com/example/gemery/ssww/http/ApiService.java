package com.example.gemery.ssww.http;



import com.example.gemery.ssww.bean.ParaseData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by gemery on 2018/4/7.
 */

public interface ApiService {
    @GET("/apiv3/post/getPostInCate?cateid=0&p=1")
    Observable<ParaseData> getMoviceList();
}
