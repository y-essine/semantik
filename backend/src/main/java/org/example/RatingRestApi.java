package org.example;

import org.example.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/ratings")
public class RatingRestApi {
  @Autowired
  private RatingService ratingService;

  @GetMapping("/all")
  @ResponseStatus
  public ResponseEntity<?> all() {
    return ResponseEntity.ok(ratingService.getAll());
  }

  @GetMapping("/page/{pageId}")
  @ResponseStatus
  public ResponseEntity<?> page(@PathVariable String pageId) {
    return ResponseEntity.ok(ratingService.getByPageId(pageId));
  }

}
