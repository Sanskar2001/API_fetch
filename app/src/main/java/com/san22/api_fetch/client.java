package com.san22.api_fetch;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class client {

      public static API getService(){
         Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
         Retrofit retrofit= new Retrofit.Builder().baseUrl("https://www.finnovationz.com").addConverterFactory(GsonConverterFactory.create(gson)).build();
         API myapi=retrofit.create(API.class);
         return myapi;
     }
}
