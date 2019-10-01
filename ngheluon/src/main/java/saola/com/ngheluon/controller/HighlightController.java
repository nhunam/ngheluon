package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Highlight;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "highlights")
@RequestMapping("/api/v1/highlights")
public class HighlightController extends BaseController<Highlight> {
}