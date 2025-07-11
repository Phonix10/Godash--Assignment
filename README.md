# Godash--Assignment
# Promotion Engine – Checkout System

A modular **Promotion Engine** built in Java for applying various pricing rules during checkout. Designed using **clean OOP principles**, TDD, and **extensible interfaces** to allow future promotion types.

---
## Features

- Add items to cart (SKU, quantity, unit price)
- Apply fixed-price bundle promotions (e.g., 3 A’s for ₹130)
- Apply combo promotions (e.g., C + D for ₹30)
- Designed to support future rules like % discounts
- Input validation (null SKUs, invalid quantities)
- Full test suite using JUnit5
- Modular design using Strategy Pattern

---

## Getting Started

### ✅ Requirements:
- Java 17+
- Gradle (or use included wrapper)

### Run Application:

```bash
./gradlew build
./gradlew run
```

### Run Test case:

```bash
./gradlew test
```


