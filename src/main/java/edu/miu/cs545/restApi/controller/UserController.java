package edu.miu.cs545.restApi.controller;

import edu.miu.cs545.restApi.aspect.annotation.ExecutionTime;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.User;
import edu.miu.cs545.restApi.domain.dto.PostDto;
import edu.miu.cs545.restApi.domain.dto.UserDto;
import edu.miu.cs545.restApi.service.PostService;
import edu.miu.cs545.restApi.service.UserService;
import edu.miu.cs545.restApi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @ExecutionTime // aop annotation execution time calc
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    @GetMapping("/test/{id}")
    public User getUserByIdTest(@PathVariable Long id){
        return userService.getUserByIdTest(id);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
         UserDto newUser = userService.save(userDto);
         return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}/posts")
    public List<PostDto> getPosts(@PathVariable("id") Long id){
        return userService.getUserPosts(id);
    }

    @PostMapping("/{id}/posts")
    public void addPost(@PathVariable("id") Long id, @RequestBody List<Post> post){
        userService.addPost(id,post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @GetMapping("/posts")
    public List<UserDto> getUserMoreThanPosts(@RequestParam int post ){
        return userService.getUserMoreThanPosts(post);
    }

    //this can be done on getAll method
    @GetMapping("/title")
    public List<User> getUserFilteredPostTitle(@RequestParam(value = "filter", required = false) String title){
        return userService.getUserFilteredPostTitle(title);
    }

    //Test aop after exception
    @GetMapping("/exception")
    public void throwExceptionTest() throws Exception {
        throw new Exception();
    }


}
