package com.yogi;

import com.yogi.model.BaseDao;
import com.yogi.model.ItemArray;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiServices {
    //    http://open.api.ebay.com/shopping?callname=FindPopularItems&responseencoding=JSON&appid=FandyGot-ec13-4906-b11c-94d9e36684ee&siteid=0&QueryKeywords=dog&version=713
    @GET("shopping")
    Observable<BaseDao<ItemArray>> getData(@Query("callname") String callname,
                                           @Query("responseencoding") String responseencoding,
                                           @Query("appid") String appid,
                                           @Query("siteid") int siteid,
                                           @Query("QueryKeywords") String querykeyword,
                                           @Query("version") String version);

}
