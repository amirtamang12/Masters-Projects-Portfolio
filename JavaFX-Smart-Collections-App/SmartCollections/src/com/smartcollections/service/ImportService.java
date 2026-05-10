package com.smartcollections.service;

import com.smartcollections.model.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ImportService - scans folders recursively and builds Item objects.
 */
public class ImportService {

    public static List<Item> importFolder(File folder, List<String> existingPaths) {
        List<Item> items = new ArrayList<>();
        scanFolder(folder, items, existingPaths);
        return items;
    }

    // Recursively scan subfolders
    private static void scanFolder(File folder, List<Item> items, List<String> existingPaths) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                scanFolder(file, items, existingPaths);
            } else if (file.isFile()) {
                String path = file.getAbsolutePath();
                if (!existingPaths.contains(path)) {
                    items.add(new Item(file.getName(), detectCategory(file.getName()), generateTags(file.getName()), 3, path));
                }
            }
        }
    }

    // Detect category based on file extension
    private static String detectCategory(String name) {
        name = name.toLowerCase();
        if (name.endsWith(".pdf")) return "PDF";
        if (name.endsWith(".mp3") || name.endsWith(".wav")) return "AUDIO";
        if (name.endsWith(".mp4") || name.endsWith(".avi")) return "VIDEO";
        if (name.endsWith(".java") || name.endsWith(".py") || name.endsWith(".txt")) return "SNIPPET";
        return "NOTE";
    }

    // Generate tags from filename
    private static String generateTags(String name) {
        return name.replaceAll("[^a-zA-Z0-9]", ",").toLowerCase();
    }
}
