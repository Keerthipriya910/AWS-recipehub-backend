package com.projectt.repo;
import com.projectt.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

}