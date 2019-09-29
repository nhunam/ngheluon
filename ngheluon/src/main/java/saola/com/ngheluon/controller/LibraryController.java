package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Library;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "libraries")
@RequestMapping("/api/v1/libraries")
public class LibraryController extends BaseController<Library> {
}