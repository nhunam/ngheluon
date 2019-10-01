package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Category;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "categories")
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController<Category> {
}