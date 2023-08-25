package org.matthenry87.noautowiredemo.api;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public
class MyService {

    Map<String, Object> getMap() {

        var hashMap = new HashMap<String, Object>();
        hashMap.put("foo", "bar");

        return hashMap;
    }

}
