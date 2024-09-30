package com.stardevllc.registry.functions;

@FunctionalInterface
public interface UnregisterListener<K extends Comparable<K>, V> {
    void onUnregister(K key, V value);
}
