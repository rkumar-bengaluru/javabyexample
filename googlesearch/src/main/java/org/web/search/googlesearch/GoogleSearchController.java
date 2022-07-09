package org.web.search.googlesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleSearchController {

    private CompletableFuture<String> fetchWeb(String query) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(100));
            }catch(Exception e) {}
            return "Web Result";
        });
    }

    private CompletableFuture<String> fetchImage(String query) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(100));
            }catch(Exception e) {}
            return "Image Result";
        });
    }

    private CompletableFuture<String> fetchVideo(String query) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(100));
            }catch(Exception e) {}
            return "Video Result";
        });
    }

    @RequestMapping("/search/{query}")
    public List<String> search(@PathVariable String query) {
        List<String> all = new ArrayList<>();
        try {
            all.add(fetchWeb(query).get(80, TimeUnit.MILLISECONDS));
        }catch(Exception e) {}
        try {
            all.add(fetchImage(query).get(80, TimeUnit.MILLISECONDS));
        }catch(Exception e) {}
        try {
            all.add(fetchVideo(query).get(80, TimeUnit.MILLISECONDS));
        }catch(Exception e) {}
        return all;
    }
}
