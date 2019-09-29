package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Author;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "authors")
@RequestMapping("/api/v1/authors")
public class AuthorController extends BaseController<Author> {
}