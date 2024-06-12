package com.works.services;

import com.works.entities.Category;
import com.works.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final CategoryRepository categoryRepository;
    final CacheManager cacheManager;

    @Cacheable("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

}
