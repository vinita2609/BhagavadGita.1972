package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookContent {

    @SerializedName("chapter_title")
    @Expose
    private String chapterTitle;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("chapter_id")
    @Expose
    private String chapterId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sanskrit")
    @Expose
    private String sanskrit;
    @SerializedName("english")
    @Expose
    private String english;
    @SerializedName("word_by_word_meaning")
    @Expose
    private String wordByWordMeaning;
    @SerializedName("translation")
    @Expose
    private String translation;
    @SerializedName("purpose")
    @Expose
    private String purpose;

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSanskrit() {
        return sanskrit;
    }

    public void setSanskrit(String sanskrit) {
        this.sanskrit = sanskrit;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getWordByWordMeaning() {
        return wordByWordMeaning;
    }

    public void setWordByWordMeaning(String wordByWordMeaning) {
        this.wordByWordMeaning = wordByWordMeaning;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}

