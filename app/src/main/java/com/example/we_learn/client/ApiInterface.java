package com.example.we_learn.client;

import ApiResponse.ScholarshipResponse;
import ApiResponse.ScienceSubjectResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api/users")
    Call<ScienceSubjectResponse> getScienceSubject();

    @GET("/api/users")
    Call<ScholarshipResponse> getScholarship();
}

