package com.change.exchange.controller;

import java.nio.charset.Charset;
// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
// import javax.annotation.PostConstruct;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.change.exchange.mapper.UserProfileMapper;
import com.change.exchange.model.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserProfileController {

    Message message = new Message();

    private UserProfileMapper mapper;
    // private Map<String, UserProfile> userMap;
    public UserProfileController(UserProfileMapper mapper){
        this.mapper = mapper;
    }

    // ���� ���� ����
    @PutMapping("/{id}")
    public UserProfile posttUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("email") String email){
        mapper.updateUserProfile(id, name, email);
        System.out.println("���� ������ �߰��Ǿ����ϴ� : "+id);
        return mapper.getUserProfile(id);
    }
  
    
    // ���� ���� �ҷ�����
    // ���� ó��
    // ������ ã�� ������ ��(���� ����)

    @GetMapping("/{id}")
    public ResponseEntity<Message> getUserProfile(@PathVariable("id") String id){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        System.out.println(mapper.getUserProfile(id).toString());

        message.setStatus(StatusEnum.OK);
        message.setMessage("���� �ڵ�");
        message.setData(mapper.getUserProfile(id));

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    // ��ü ���� ���� �ҷ�����
    // ���� ����� ������� ��
    @GetMapping("/all")
    public ResponseEntity<Message> getUserProfileList(){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        System.out.println(mapper.getUserProfileList().toString());

        message.setStatus(StatusEnum.OK);
        message.setMessage("���� �ڵ�");
        message.setData(mapper.getUserProfileList());
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    // ȸ������
    @PostMapping("/{id}")
    public ResponseEntity<Message> putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("email") String email){
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        mapper.insertUserProfile(id, name, email);
        System.out.println("������ �߰��Ǿ����ϴ� : "+id);

        message.setStatus(StatusEnum.OK);
        message.setMessage("���� �ڵ�");
        message.setData(mapper.getUserProfile(id));
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }


    // ȸ�� Ż��
    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        if(mapper.getUserProfile(id)!=null){
            mapper.deleteUserProfile(id);
            System.out.println("������ Ż��Ǿ����ϴ� : "+id);
        }
        else {
            // ���� ���� Ż��
        }
    }
    
    
}





// package com.change.exchange.controller;

// // import java.util.ArrayList;
// // import java.util.HashMap;
// import java.util.List;
// // import java.util.Map;
// // import javax.annotation.PostConstruct;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.change.exchange.mapper.UserProfileMapper;
// import com.change.exchange.model.UserProfile;

// @RestController
// public class UserProfileController {

//     private UserProfileMapper mapper;
//     // private Map<String, UserProfile> userMap;
//     public UserProfileController(UserProfileMapper mapper){
//         this.mapper = mapper;
//     }

//     // @PostConstruct
//     // public void init(){
//     //     userMap = new HashMap<String, UserProfile>();
//     //     userMap.put("1", new UserProfile("1", "�ڿ���", "111-1111", "����� ������ ��ġ1��"));
//     //     userMap.put("2", new UserProfile("2", "�ڼ���", "111-1112", "����� ������ ��ġ2��"));
//     //     userMap.put("3", new UserProfile("3", "���ο�", "111-1113", "����� ������ ��ġ3��"));

//     // }
    
//     @GetMapping("user/{id}")
//     public UserProfile getUserProfile(@PathVariable("id") String id){
//         //return userMap.get(id);
//         return mapper.getUserProfile(id);
//     }

//     @GetMapping("user/all")
//     public List<UserProfile> getUserProfileList(){
//         //return new ArrayList<UserProfile>(userMap.values());
//         return mapper.getUserProfileList();
//     }

//     @PutMapping("/user/{id}")
//     public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("email") String email){
//         // UserProfile userProfile = new UserProfile(id, name, phone, address);
//         // userMap.put(id, userProfile);
//         mapper.insertUserProfile(id, name, email);
//     }

//     @PostMapping("user/{id}")
//     public void posttUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("email") String email){
//         // UserProfile userProfile = userMap.get(id);
//         // userProfile.setName(name);
//         // userProfile.setPhone(phone);
//         // userProfile.setAddress(address);
//         mapper.updateUserProfile(id, name, email);
//     }

//     @DeleteMapping("user/{id}")
//     public void deleteUserProfile(@PathVariable("id") String id){
//         // userMap.remove(id);
//         mapper.deleteUserProfile(id);
//     }
    
    
// }
