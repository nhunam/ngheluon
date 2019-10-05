package saola.com.ngheluon.service.impl;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Category;
import saola.com.ngheluon.service.CategoryService;

import java.util.UUID;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, UUID> implements CategoryService {
}
