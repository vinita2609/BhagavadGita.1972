package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("vedic_scriptures/content?book_id=2")
    Call<List<BookContent>> getAllBooks(@Query("chapter_id") String chapter_id);

    @GET("vedic_scriptures/chapter_list?book_id=2")
    Call<List<ChapterTitle>> getAllChapters();



    @GET("/v1/bhagavat_gita/content")
    Call<List<BookContent>> getAllChapter(
            @Query("book_id") Integer bookId,
            @Query("chapter_id") Integer chapterId
    );
}