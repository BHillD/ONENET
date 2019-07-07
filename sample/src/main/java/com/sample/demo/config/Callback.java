package com.sample.demo.config;

import okhttp3.Call;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.logging.Logger;

/**
 * date: 2019/7/1
 * description: OKHTTP Callbcak接口实现类
 */

public class Callback implements okhttp3.Callback {

    private static Logger logger = Logger.getLogger("callback");

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        logger.info(response.body().string());
    }
}
