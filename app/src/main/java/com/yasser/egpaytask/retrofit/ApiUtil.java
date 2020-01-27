package com.yasser.egpaytask.retrofit;

public class ApiUtil {

    private ApiUtil() {}

    public static final String BASE_URL = "http://101.amrbdr.com";

    public static APIInterface getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIInterface.class);
    }
}
