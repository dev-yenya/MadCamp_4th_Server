package com.change.exchange.controller;

import java.nio.charset.Charset;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.change.exchange.mapper.PostMapper;
import com.change.exchange.model.*;

@RestController
@RequestMapping("/posting")
@CrossOrigin("*")

public class PostController {
    
    Message message = new Message();
    private PostMapper mapper;

    public PostController(PostMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<Message> getPostList(){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        System.out.println(mapper.getPostList().toString());
        
        message.setStatus(StatusEnum.OK);
        message.setMessage("전체 포스팅 불러오기 성공");
        message.setData(mapper.getPostList());
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @GetMapping("/things")
    public ResponseEntity<Message> getThingsPostList(){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        System.out.println(mapper.getThingsPostList().toString());
        
        message.setStatus(StatusEnum.OK);
        message.setMessage("Things 포스팅 불러오기 성공");
        message.setData(mapper.getThingsPostList());
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Message> getPeoplePostList(){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        System.out.println(mapper.getPeoplePostList().toString());
        
        message.setStatus(StatusEnum.OK);
        message.setMessage("People 포스팅 불러오기 성공");
        message.setData(mapper.getPeoplePostList());
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @PostMapping("/{uid}")
    public ResponseEntity<Message> postPosting(@PathVariable("uid") String uid, @RequestBody ReqPost req){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        
        int id = mapper.insertPost(req.title, uid, req.context, req.category, req.imgUrl);
        message.setStatus(StatusEnum.OK);
        message.setMessage("포스팅 게시 성공");
        message.setData(mapper.getPost(id));
        System.out.println(mapper.getPost(id));
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Message> updatePosting(@PathVariable("id") String id, @RequestBody ReqPost req){
    //     HttpHeaders  headers = new HttpHeaders();
    //     headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    
    //     message.setStatus(StatusEnum.OK);
    //     message.setMessage("포스팅 업데이트 성공");
    //     // message.setData(mapper.getPost(id));
    //     // System.out.println(mapper.getPost(id));
    //     return new ResponseEntity<>(message, headers, HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deletePosting(@PathVariable("id") String id){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        
        mapper.deletePost(id);

        // int id = mapper.insertPost(req.title, uid, req.context, req.category, req.imgUrl);
        message.setStatus(StatusEnum.OK);
        message.setMessage("포스팅 삭제 성공");
        // message.setData(mapper.getPost(id));
        // System.out.println(mapper.getPost(id));
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }


}
