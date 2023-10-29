package com.example.apifetchget;

public class Post {
   private String id , userId , title , description;

   public Post( String id , String name, String title ,String description) {
      this.id=id;
      this.userId=name;
      this.title=title;
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getName() {
      return userId;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }


   public void setName(String name) {
      this.userId = name;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Post(){

   }
}
