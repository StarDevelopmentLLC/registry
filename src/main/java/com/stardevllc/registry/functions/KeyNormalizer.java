package com.stardevllc.registry.functions;

import java.util.function.Function;

public interface KeyNormalizer<K extends Comparable<K>> extends Function<K, K> {
}
