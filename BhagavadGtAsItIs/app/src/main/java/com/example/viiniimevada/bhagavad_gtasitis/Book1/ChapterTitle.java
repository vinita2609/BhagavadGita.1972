package com.example.viiniimevada.bhagavad_gtasitis.Book1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterTitle {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;

        public String getId() { return id; }

        public void setId(String id) { this.id = id; }

        public String getTitle() {
            return title; }

        public void setTitle(String title) { this.title = title; }
}

