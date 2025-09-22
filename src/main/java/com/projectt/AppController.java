package com.projectt;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectt.entity.*;
import com.projectt.service.*;

@RestController
@CrossOrigin
public class AppController {
  
  @Autowired
  UserService obj;
  
  Cryptography cryp = new Cryptography();
  
  @PostMapping("/register")
  public String fun2(@RequestBody User user) {
    user.setPassword(cryp.encryptData(user.getPassword()));
    return obj.insertUser(user);
  }
  
  @PostMapping("/login")
  public User fun3(@RequestBody User user) {
    return obj.retrieveUser(user);
  }
  
  @Autowired
  AdminService obj1;
  
  Cryptography cryp2 = new Cryptography();
  
  @PostMapping("/adminregister")
  public String func4(@RequestBody Admin admin) {
    admin.setPassword(cryp2.encryptData(admin.getPassword()));
    return obj1.insertAdmin(admin);
  }
  
  @PostMapping("/adminlogin")
  public Admin func5(@RequestBody Admin admin) {
    return obj1.retrieveAdmin(admin);
  }
  
  @Autowired 
  RecipeService obj2;
  
  @PostMapping("/insert")
  public String fun4(@RequestBody Recipe recipe) {
    System.out.println("insert function called");
    return obj2.insertRecipe(recipe);
  }
  
  @GetMapping("/recipe")
  public List<Recipe> fun5(){
    return obj2.retrieveRecipe();
  }
  
  @PutMapping("/update")
  public String fun6(@RequestBody Recipe recipe){
    System.out.println("update function called");
    return obj2.updateRecipe(recipe);
  }
  
  @DeleteMapping("/delete")
  public String fun7(@RequestParam("rid") int rid) {
    return obj2.deleteRecipe(rid);
  }
  
}