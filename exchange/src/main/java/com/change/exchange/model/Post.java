package com.change.exchange.model;

public class Post {
    private String id;
    private String title;
    private String uid;
    private String postDate;
    private String context;
    private String category;
    private String imgUrl;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getUid(){
        return uid;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getPostDate(){
        return postDate;
    }

    public void setPostDate(String postDate){
        this.postDate = postDate;
    }

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
    public String toString(){
        return "{id : "+id+", title : "+title+", uid : "+uid+", postDate : "+postDate+", context : "+context+", category : "+category+", ImgUrl : "+imgUrl+"}";
    }

}
