package com.stardevllc.registry;

import com.stardevllc.registry.functions.*;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class StringRegistry<V> extends Registry<String, V> {
    public StringRegistry(Map<String, V> initialObjects, KeyNormalizer<String> keyNormalizer, KeyRetriever<V, String> keyRetriever, KeyGenerator<V, String> keyGenerator, KeySetter<String, V> keySetter) {
        super(initialObjects, keyNormalizer, keyRetriever, keyGenerator, keySetter);
    }

    public StringRegistry() {
    }

    @Override
    public SortedMap<String, V> subMap(String k1, String k2) {
        return new StringRegistry<>(this.objects.subMap(k1, k2), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }

    @Override
    public SortedMap<String, V> headMap(String k1) {
        return new StringRegistry<>(this.objects.headMap(k1), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }

    @Override
    public SortedMap<String, V> tailMap(String k1) {
        return new StringRegistry<>(this.objects.tailMap(k1), this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);
    }

    public static class Builder<V> extends Registry.Builder<String, V> {
        @Override
        public Builder<V> initialObjects(TreeMap<String, V> objects) {
            return (Builder<V>) super.initialObjects(objects);
        }

        @Override
        public  Builder<V> keyNormalizer(KeyNormalizer<String> keyNormalizer) {
            return (Builder<V>) super.keyNormalizer(keyNormalizer);
        }

        @Override
        public  Builder<V> keyRetriever(KeyRetriever<V, String> keyRetriever) {
            return (Builder<V>) super.keyRetriever(keyRetriever);
        }

        @Override
        public  Builder<V> keyGenerator(KeyGenerator<V, String> keyGenerator) {
            return (Builder<V>) super.keyGenerator(keyGenerator);
        }

        @Override
        public Builder<V> keySetter(KeySetter<String, V> keySetter) {
            return (Builder<V>) super.keySetter(keySetter);
        }

        @Override
        public Builder<V> addRegisterListener(RegisterListener<String, V> listener) {
            return (Builder<V>) super.addRegisterListener(listener);
        }

        @Override
        public Builder<V> addUnregisterListener(UnregisterListener<String, V> listener) {
            return (Builder<V>) super.addUnregisterListener(listener);
        }

        @Override
        public StringRegistry<V> build() {
            StringRegistry<V> registry = new StringRegistry<>(this.objects, this.keyNormalizer, this.keyRetriever, this.keyGenerator, this.keySetter);

            registerListeners.forEach(registry::addRegisterListener);
            unregisterListeners.forEach(registry::addUnregisterListener);
            
            return registry;
        }
    }
}