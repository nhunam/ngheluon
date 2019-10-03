package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.CategoryBook;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "categorybooks")
@RequestMapping("/api/v1/categorybooks")
public class CategoryBookController extends BaseController<CategoryBook, Integer> {
}