package com.stardevllc.registry.functions;

import java.util.function.Function;

public interface KeyRetriever<V, K extends Comparable<K>> extends Function<V, K>  {
}
