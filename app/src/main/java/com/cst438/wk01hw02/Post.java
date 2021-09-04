package com.cst438.wk01hw02;

import com.google.gson.annotations.SerializedName;

/**
 *
 * <h2><b>Post Java Class</b></h2>
 * This java class contains the data model for a Post. A single Post would contain a title, userId,
 * id, and text. This class only needs getter methods.
 *
 * @author Eric Chavez Velez
 */

public class Post {

    private String title;
    private int userId;
    private int id;

    @SerializedName("body")
    private String text;

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
