package com.demo.reponsitories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.Dtos.Output.CategoryOutput;
import com.demo.models.Category;

@Repository
public interface CategoryReponsitory extends CrudRepository<Category, Integer>{
	@Query("select new com.demo.Dtos.Output.CategoryOutput(id,category.id, category.name, name, isDelete ) from Category")
	public List<CategoryOutput> getListCategory();
	@Query("select new com.demo.Dtos.Output.CategoryOutput(id, category.id, category.name, name, isDelete ) from Category")
	public List<CategoryOutput> findAllCategory();
}
