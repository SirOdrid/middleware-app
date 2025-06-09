package com.tfg.backend.api.controllers.External;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@RestController
@RequestMapping("/proxy")
public class ImageProxyController {

    @GetMapping
    public ResponseEntity<byte[]> proxyImage(@RequestParam String url) {
        try {
            if (!url.startsWith("https://cf.geekdo-images.com/")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            URI uri = URI.create(url);
            URL imageUrl = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();

            String contentType = connection.getContentType();
            byte[] imageBytes = connection.getInputStream().readAllBytes();
            connection.getInputStream().close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setCacheControl(CacheControl.noCache());
            headers.add("Access-Control-Allow-Origin", "*");

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el proxy.".getBytes());
        }
    }
}
