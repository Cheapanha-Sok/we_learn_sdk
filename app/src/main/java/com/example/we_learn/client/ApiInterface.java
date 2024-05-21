package com.example.we_learn.client;

import ApiResponse.PDFResponse;
import ApiResponse.ScholarshipResponse;
import ApiResponse.ScienceSubjectResponse;
import ApiResponse.SocialSciencesSubjectResponse;
import ApiResponse.YearsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/api/type/1")
    Call<ScienceSubjectResponse> getCategoriesScience();

    @GET("/api/type/2")
    Call<SocialSciencesSubjectResponse> getCategoriesSocialSciences();

    @GET("/api/users")
    Call<ScholarshipResponse> getScholarship();

    @GET("/api/examDate")
    Call<YearsResponse> getYear();

    @GET("/api/pdf/{examdate_id}/{category_id}")
    Call<PDFResponse> getPDF(@Path("examdate_id") int examdateId, @Path("category_id") int categoryId);

}

