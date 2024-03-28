package com.example;
/**
 * Clase Association que representa una asociación entre una clave y un valor.
 *
 * @param <K> Tipo de datos de la clave que debe ser comparable.
 * @param <V> Tipo de datos del valor asociado.
 */

public class  Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //Obtiene la clave de la asociación.
    public K getKey() {
        return key;
    }

    //Obtiene el valor asociado a la clave
    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    //Compara esta asociación con otra basándose en las claves.
    @Override
    public int compareTo(Association<K, V> o) {
        return this.key.compareTo(o.getKey());
    }

}
