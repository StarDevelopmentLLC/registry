package com.stardevllc.registry;

import com.stardevllc.registry.functions.*;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class IntegerRegistry<V> extends Registry<Integer, V> {
    public IntegerRegistry(Map<Integer, V> initialObjects, KeyNormalizer<Integer> keyNormalizer, KeyRetriever<V, Integer> keyRetriever, KeyGenerator<V, Integer> keyGenerator, KeySetter<Integer, V> keySetter) {
        super(initialObjects, keyNormalizer, keyRetriever, keyGenerator, keySetter);
    }

    public IntegerRegistry() {
    }

    @Override
    public SortedMap<Integer, V> subMap(Integer integer, Integer k1) {
        return new IntegerRegistry<>(this.objects.subMap(integer, k1), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }

    @Override
    public SortedMap<Integer, V> headMap(Integer integer) {
        return new IntegerRegistry<>(this.objects.headMap(integer), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }

    @Override
    public SortedMap<Integer, V> tailMap(Integer integer) {
        return new IntegerRegistry<>(this.objects.tailMap(integer), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }
    
    public static class Builder<V> extends Registry.Builder<Integer, V> {
        @Override
        public Builder<V> initialObjects(TreeMap<Integer, V> objects) {
            return (Builder<V>) super.initialObjects(objects);
        }

        @Override
        public  Builder<V> keyNormalizer(KeyNormalizer<Integer> keyNormalizer) {
            return (Builder<V>) super.keyNormalizer(keyNormalizer);
        }

        @Override
        public  Builder<V> keyRetriever(KeyRetriever<V, Integer> keyRetriever) {
            return (Builder<V>) super.keyRetriever(keyRetriever);
        }

        @Override
        public  Builder<V> keyGenerator(KeyGenerator<V, Integer> keyGenerator) {
            return (Builder<V>) super.keyGenerator(keyGenerator);
        }

        @Override
        public Builder<V> keySetter(KeySetter<Integer, V> keySetter) {
            return (Builder<V>) super.keySetter(keySetter);
        }
        
        @Override
        public Builder<V> addRegisterListener(RegisterListener<Integer, V> listener) {
            return (Builder<V>) super.addRegisterListener(listener);
        }

        @Override
        public Builder<V> addUnregisterListener(UnregisterListener<Integer, V> listener) {
            return (Builder<V>) super.addUnregisterListener(listener);
        }

        @Override
        public IntegerRegistry<V> build() {
            IntegerRegistry<V> registry = new IntegerRegistry<>(this.objects, this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
            
            registerListeners.forEach(registry::addRegisterListener);
            unregisterListeners.forEach(registry::addUnregisterListener);
            
            return registry;
        }
    }
}
