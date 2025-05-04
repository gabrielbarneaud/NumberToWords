package com.example.numbertowords;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/convert")
public class NumberToWordsController {

    @GetMapping
    public ResponseEntity<String> convert(@RequestParam int number) {
        String result = NumberToWordsConverter.convert(number);
        return ResponseEntity.ok(result);
    }
}
