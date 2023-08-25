package org.matthenry87.noautowiredemo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping
    public Map<String, Object> get() {

        return myService.getMap();
    }

}
