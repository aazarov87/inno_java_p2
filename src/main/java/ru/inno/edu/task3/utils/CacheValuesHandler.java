package ru.inno.edu.task3.utils;

import java.util.*;

public class CacheValuesHandler {

    List<Object> listKeys = new ArrayList<>();

    public CacheValuesHandler(List<Object> listKeys) {
        this.listKeys = listKeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheValuesHandler)) return false;
        CacheValuesHandler that = (CacheValuesHandler) o;
        return Objects.equals(listKeys, that.listKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listKeys);
    }
}
