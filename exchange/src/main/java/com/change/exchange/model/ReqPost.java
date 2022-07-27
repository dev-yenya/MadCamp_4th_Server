package com.change.exchange.model;

public class ReqPost {
    public String title;
    public String context;
    public String category;
    public String imgUrl;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContext(){
        return context;
    }

    public void setContext(String context){
        this.context = context;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getImgUrl(){
        return imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

}
