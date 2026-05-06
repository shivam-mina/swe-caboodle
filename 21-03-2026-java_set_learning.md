# 🧠 Java Sets — Today's Learning

## 🔹 Set Fundamentals
- Stores **unique elements** only, order doesn't matter
- Use for: removing duplicates, comparisons, set operations
- Convert List → Set: `new HashSet<>(list)` (auto-removes duplicates)

---

## 🔁 Set Operations

| Operation | Method | Used in |
|---|---|---|
| Union (all) | `set.addAll(other)` | `allCards()` |
| Intersection (common) | `set.retainAll(other)` | `commonCards()` |
| Difference (distinct) | `set.removeAll(other)` | `canTrade()` |

---

## ⚖️ Comparison vs Modification

| Method | Purpose | Modifies? |
|---|---|---|
| `containsAll()` | check subset | ❌ |
| `retainAll()` | intersection | ✅ |

---

## 🧩 Problem-Solving Patterns

**Copy before modifying** — avoids mutating original data
```java
new HashSet<>(original)
```

**Trade logic** — both sides must have unique elements
```java
!myDistinct.isEmpty() && !theirDistinct.isEmpty()
```

**Intersect multiple sets**
```java
Set<String> common = new HashSet<>(firstSet);
for (...) { common.retainAll(...); }
```

---

## 🔁 Loop Control
- `break` → exits loop
- `continue` → skips current iteration (does NOT exit outer loop)

---

## ⚠️ Common Mistakes Fixed

```java
contain = collection.contains(card);   // ❌ overwrites
contain = contain && collection.contains(card);  // ✅ accumulates
```
- `continue` won't exit outer loop — use `break` or a label
- Naming: `common` vs `all` matters for readability

---

## ✨ Code Quality
- Prefer `addAll()` / `retainAll()` / `removeAll()` over manual loops
- Start loops from index 1 to skip reprocessing the first element
- Each method should do **one job**

---

## 🧠 Mental Models
- **Think in sets**: union / intersection / difference — not "loop through everything"
- **Data immutability**: don't modify inputs; create copies when transforming
