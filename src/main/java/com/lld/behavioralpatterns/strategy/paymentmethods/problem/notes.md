# Notes: `PaymentProcessor`

---

## 1. Exception Handling (Checked vs. Unchecked Exceptions)

### Question
In [`PaymentProcessor.java`](PaymentProcessor.java#L23) line 23, we throw an `IllegalStateException`. Why is there no `throws` clause in `processPayment()` or the caller method ([`Demo.java`](Demo.java))?

```java
default -> throw new IllegalStateException("Unexpected value: " + type);
```

### Explanation
The reason is the difference between **Checked** and **Unchecked Exceptions** in Java.

#### `IllegalStateException` is an Unchecked Exception
* `IllegalStateException` extends `RuntimeException`.
* Any subclass of `RuntimeException` (and `Error`) is classified as an **unchecked exception**.

```
Throwable
 ├── Error (Unchecked)
 └── Exception
      ├── RuntimeException (Unchecked) ──► IllegalStateException, NullPointerException, IllegalArgumentException, etc.
      └── Other Exceptions (Checked)   ──► IOException, SQLException, ClassNotFoundException, etc.
```

#### Checked vs. Unchecked Exceptions Comparison

| Feature | Checked Exceptions (e.g., `IOException`) | Unchecked Exceptions (e.g., `IllegalStateException`) |
| :--- | :--- | :--- |
| **Inheritance** | Directly extends `Exception` (not `RuntimeException`) | Extends `RuntimeException` |
| **Compiler Requirement** | **Mandatory**: Must be handled via `try-catch` or declared via `throws`. | **Optional**: The compiler does not force `throws` declaration or `try-catch`. |
| **Method Signature** | Requires `throws <ExceptionName>` | No `throws` clause needed |
| **Calling Method** | Must also handle with `try-catch` or declare `throws` | Can call directly without handling or declaring `throws` |
| **Common Use Case** | Recoverable errors outside program control (e.g., network, file system). | Programming errors, invalid arguments, or illegal states. |

#### Key Takeaway
* Because `IllegalStateException` is an unchecked exception (`RuntimeException`), neither `processPayment(type, amount)` nor its caller `Demo.main(...)` needs to declare a `throws` clause.
* If a **checked exception** were thrown instead (e.g., `throw new Exception(...)`), both `processPayment` and `Demo.main` would be forced by the compiler to either declare `throws Exception` or enclose the call in a `try-catch` block.

---

## 2. Arrow Syntax (`->`) in Switch Statements vs. Lambda Expressions

### Question
In [`PaymentProcessor.java`](PaymentProcessor.java#L6-L23), are we using lambda expressions inside the `switch` statements?

### Explanation
**No**, that is **not** a lambda expression, even though it shares the same arrow token (`->`).

It is called the **Switch Arrow Rule Syntax** (part of **Enhanced Switch**, introduced in Java 14 via [JEP 361](https://openjdk.org/jeps/361)).

#### Comparison Table

| Feature | Enhanced Switch Arrow (`case ->`) | Lambda Expression (`(args) -> { ... }`) |
| :--- | :--- | :--- |
| **What it is** | A control flow construct / branch syntax for `switch`. | An anonymous implementation of a Functional Interface (e.g., `Runnable`, `Consumer`). |
| **Primary Purpose** | **Eliminates fall-through** (no need to write `break;` after each `case`). | Enables passing behavior/functions as data. |
| **Object Creation** | Does **not** create any object/function instance. | Creates an instance of a functional interface. |

#### Code Comparison

1. **Traditional `switch` (Requires `break` to avoid fall-through):**
   ```java
   switch (type) {
       case "credit_card":
           System.out.println("Paid using credit card");
           break; // mandatory, otherwise it falls through to the next case!
       default:
           throw new IllegalStateException("Unexpected: " + type);
   }
   ```

2. **Enhanced `switch` with Arrow Syntax (`->`):**
   ```java
   switch (type) {
       case "credit_card" -> {
           System.out.println("Paid using credit card");
           // No 'break' needed! Only this branch executes.
       }
       default -> throw new IllegalStateException("Unexpected: " + type);
   }
   ```
