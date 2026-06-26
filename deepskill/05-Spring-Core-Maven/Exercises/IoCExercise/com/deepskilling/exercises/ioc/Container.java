package com.deepskilling.exercises.ioc;

import java.util.HashMap;
import java.util.Map;

/*
 * Simple IoC container that mimics Spring's BeanFactory.
 * Owns bean creation and storage — clients ask the container for instances.
 */
public class Container {
    private final Map<String, Object> beans = new HashMap<>();

    public void registerBean(String name, Object instance) {
        beans.put(name, instance);
        System.out.println("[Container] Registered bean: " + name);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(String name, Class<T> type) {
        Object bean = beans.get(name);
        if (bean == null) {
            throw new RuntimeException("No bean found for name: " + name);
        }
        System.out.println("[Container] Retrieved bean: " + name);
        return (T) bean;
    }

    public boolean containsBean(String name) {
        return beans.containsKey(name);
    }
}
