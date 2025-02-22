package com.example.week04;

import org.junit.Test;
import static org.junit.Assert.*;

public class Week04HomeworkTest {

    @Test
    public void testLRUCache1() {
        LRUCache1<Integer, String> cache = new LRUCache1<>(3);

        // 添加元素
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        assertEquals(3, cache.size());
        assertEquals("one", cache.get(1));
        assertEquals("two", cache.get(2));
        assertEquals("three", cache.get(3));

        // 访问元素1，使它变为最近使用
        cache.get(1);
        assertEquals("one", cache.get(1));

        // 添加第四个元素，触发LRU移除
        cache.put(4, "four");
        assertEquals(3, cache.size());
        assertNull(cache.get(2)); // 元素2被移除
        assertEquals("one", cache.get(1));
        assertEquals("three", cache.get(3));
        assertEquals("four", cache.get(4));

        // 再次访问元素3，使它变为最近使用
        cache.get(3);
        assertEquals("three", cache.get(3));

        // 添加第五个元素，触发LRU移除
        cache.put(5, "five");
        assertEquals(3, cache.size());
        assertNull(cache.get(1)); // 元素1被移除
        assertEquals("three", cache.get(3));
        assertEquals("four", cache.get(4));
        assertEquals("five", cache.get(5));
    }

    @Test
    public void testLRUCache2() {
        LRUCache2<Integer, String> cache = new LRUCache2<>(3);

        // 添加元素
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        assertEquals(3, cache.size());
        assertEquals("one", cache.get(1));
        assertEquals("two", cache.get(2));
        assertEquals("three", cache.get(3));

        // 访问元素1，使它变为最近使用
        cache.get(1);
        assertEquals("one", cache.get(1));

        // 添加第四个元素，触发LRU移除
        cache.put(4, "four");
        assertEquals(3, cache.size());
        assertNull(cache.get(2)); // 元素2被移除
        assertEquals("one", cache.get(1));
        assertEquals("three", cache.get(3));
        assertEquals("four", cache.get(4));

        // 再次访问元素3，使它变为最近使用
        cache.get(3);
        assertEquals("three", cache.get(3));

        // 添加第五个元素，触发LRU移除
        cache.put(5, "five");
        assertEquals(3, cache.size());
        assertNull(cache.get(1)); // 元素1被移除
        assertEquals("three", cache.get(3));
        assertEquals("four", cache.get(4));
        assertEquals("five", cache.get(5));
    }
}