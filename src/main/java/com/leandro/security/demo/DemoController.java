package com.leandro.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
    @GetMapping("/Just/autheticated")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Hello from a just autheticated endpoint");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?>  sayHelloAdmin() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/noauth")
    public ResponseEntity<?>  sayHelloNoAuth() {
        return ResponseEntity.ok("Hello from not a secured endpoint");
    }

}
