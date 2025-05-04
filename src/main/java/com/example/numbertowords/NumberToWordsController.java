package com.example.numbertowords;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/convert")
public class NumberToWordsController {

    @GetMapping
    public ResponseEntity<String> convert(@RequestParam int number) {
        if (Math.abs(number) > 999_999_999) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Number too large. Please enter a number between -999999999 and 999999999.");
        }

        String result = NumberToWordsConverter.convert(number);
        return ResponseEntity.ok(result);
    }
}
