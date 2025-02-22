package com.example.week04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存算法(基于LinkedHashMap)
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * 当容量超出时，移除最久没有访问的元素（队列头部元素）
     * <p>
     * 该方法会在往队列里放置元素时被调用
     *
     * @param eldest The least recently inserted entry in the map, or if
     *           this is an access-ordered map, the least recently accessed
     *           entry.  This is the entry that will be removed it this
     *           method returns <tt>true</tt>.  If the map was empty prior
     *           to the <tt>put</tt> or <tt>putAll</tt> invocation resulting
     *           in this invocation, this will be the entry that was just
     *           inserted; in other words, if the map contains a single
     *           entry, the eldest entry is also the newest.
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}