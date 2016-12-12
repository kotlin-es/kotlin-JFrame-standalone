package utils.map

import java.util.*

/**
 * Created by vicboma on 12/12/16.
 */
public fun <K, V> Map<K, V>.mergeReduce(other: Map<K, V>, reduce: (V, V) -> V = { a, b -> b }): Map<K, V> {
    val result = LinkedHashMap<K, V>(this.size + other.size)
    result.putAll(this)
    for(entry in other.entries) {
        val existing = result[entry.key]

        if (existing == null) {
            result.put(entry.key, entry.value)
        }
        else {
            result.put(entry.key, reduce(entry.value, existing))
        }
    }

    return result
}