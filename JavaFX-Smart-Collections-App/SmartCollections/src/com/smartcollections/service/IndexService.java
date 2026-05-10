package com.smartcollections.service;

import com.smartcollections.model.Item;

import java.util.*;

/**
 * IndexService - builds keyword and tag indices for fast search and ranking.
 */
public class IndexService {

    private final Map<String, Set<String>> mainIndex = new HashMap<>();
    private final Map<String, Set<String>> keywordToItems = new HashMap<>();
    private final Map<String, Integer> tagFrequency = new HashMap<>();
    private final Map<String, Item> itemRegistry = new HashMap<>();

    public void indexMetadata(List<Item> items) {
        for (Item item : items) {
            String itemId = item.getPathOrUrl();
            itemRegistry.put(itemId, item);

            for (String word : item.getTitle().toLowerCase().split("\\W+")) {
                if (!word.isEmpty()) {
                    keywordToItems.computeIfAbsent(word, k -> new HashSet<>()).add(itemId);
                }
            }

            for (String tag : item.getTags().toLowerCase().split(",")) {
                tag = tag.trim();
                if (!tag.isEmpty()) {
                    tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
                }
            }
        }
    }

    public void buildMainIndex(List<Item> items) {
        for (Item item : items) {
            String itemId = item.getPathOrUrl();
            itemRegistry.put(itemId, item);

            for (String word : item.getTitle().toLowerCase().split("\\W+")) {
                if (!word.isEmpty()) {
                    mainIndex.computeIfAbsent(word, k -> new HashSet<>()).add(itemId);
                }
            }
        }
    }

    public List<Item> search(String keyword) {
        keyword = keyword.toLowerCase();
        Set<String> paths = keywordToItems.getOrDefault(keyword, Set.of());
        List<Item> results = new ArrayList<>();

        for (String path : paths) {
            Item item = itemRegistry.get(path);
            if (item != null) results.add(item);
        }

        return results;
    }

    public Map<String, Set<String>> getKeywordToItems() { return keywordToItems; }
    public Map<String, Integer> getTagFrequency() { return tagFrequency; }
    public Map<String, Set<String>> getMainIndex() { return mainIndex; }
}
