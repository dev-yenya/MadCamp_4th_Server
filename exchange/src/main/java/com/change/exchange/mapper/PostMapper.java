package com.change.exchange.mapper;
import org.apache.ibatis.annotations.*;
import com.change.exchange.model.Post;
import java.util.List;

@Mapper
public interface PostMapper {

    @Select ("select * from Post where id=#{id}")
    Post getPost(@Param("id") int id);

    @Select ("Select * from Post")
    List<Post> getPostList();

    @Select ("Select * from Post where category='things'")
    List<Post> getThingsPostList();

    @Select ("Select * from Post where category='people'")
    List<Post> getPeoplePostList();

    // @Select ("Select ")
    @Insert("insert into Post (title, uid, context, category, imgUrl) values(#{title}, #{uid}, #{context}, #{category}, #{imgUrl})")
    int insertPost(@Param("title") String title, @Param("uid") String uid, @Param("context") String context, @Param("category") String category, @Param("imgUrl") String imgUrl);

    @Update("update Post set #{title}, #{uid}, #{postDate}, #{context}, #{email}, #{category}, #{imgUrl} where id=#{id}")
    int updatePost(@Param("id") String id, @Param("title") String title, @Param("uid") String uid, @Param("context") String context, @Param("category") String category, @Param("imgUrl") String imgUrl);

    @Delete("delete from Post where id=#{id}")
    int deletePost(@Param("id") String id);
}
