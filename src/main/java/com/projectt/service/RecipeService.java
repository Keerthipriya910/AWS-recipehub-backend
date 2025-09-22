package com.projectt.service;

import java.util.*;

import com.projectt.repo.RecipeRepo;
import com.projectt.entity.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service

public class RecipeService {

    @Autowired
    RecipeRepo repo2;
    
    public String insertRecipe(Recipe recipe) {
    repo2.save(recipe);
    return "Recipe Inserted";
  }

  public List<Recipe> retrieveRecipe() {
    return repo2.findAll();
  }

  public String updateRecipe(Recipe recipe) {
    Recipe p2 = repo2.findById(recipe.getrid()).get();
    if(p2 != null) {
      repo2.delete(p2);
    }
    repo2.save(recipe);
    return "Recipe Updated";
  }

  public String deleteRecipe(int rid) {
    repo2.deleteById(rid);
    return "Recipe Deleted";
  }


}