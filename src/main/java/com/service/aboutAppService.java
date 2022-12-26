package com.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class aboutAppService {
    @Value("${app.name}")
    private String name;
    @Value("${app.version}")
    private String version;
    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
