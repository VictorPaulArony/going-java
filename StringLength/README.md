**Java String Cheat Sheet** 

---

### **1. String Declaration and Initialization**
```java
String str = "Hello, World!";
String emptyStr = "";
String str2 = new String("Hello");
```

---

### **2. Common String Methods**

#### a. **Length of a String**
```java
int length = str.length();  // Returns the length of the string
```

#### b. **Accessing Characters**
```java
char c = str.charAt(0);  // Gets character at specified index (0-based index)
```

#### c. **String Concatenation**
```java
String concatenated = str + " How are you?";  // Using "+" operator
String concatenatedUsingStringBuilder = new StringBuilder(str).append(" How are you?").toString();  // Efficient for large strings
```

#### d. **Substring**
```java
String sub = str.substring(7);  // From index 7 to the end
String sub2 = str.substring(0, 5);  // From index 0 to index 5 (not inclusive)
```

#### e. **String Comparison**
```java
boolean isEqual = str.equals("Hello, World!");  // Case-sensitive comparison
boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello, world!");  // Case-insensitive comparison
```

#### f. **String Contains**
```java
boolean contains = str.contains("World");  // Checks if the string contains the substring
```

#### g. **String Replacement**
```java
String replaced = str.replace("World", "Java");  // Replace all occurrences of "World" with "Java"
```

#### h. **String Trim**
```java
String trimmed = str.trim();  // Removes leading and trailing spaces
```

#### i. **String Split**
```java
String[] parts = str.split(",");  // Splits the string by the comma delimiter
```

#### j. **String to Uppercase/Lowercase**
```java
String upper = str.toUpperCase();  // Converts to uppercase
String lower = str.toLowerCase();  // Converts to lowercase
```

#### k. **Check if String is Empty or Blank**
```java
boolean isEmpty = str.isEmpty();  // Checks if the string is empty (length == 0)
boolean isBlank = str.isBlank();  // Checks if the string is empty or contains only whitespace
```

#### l. **StartsWith / EndsWith**
```java
boolean starts = str.startsWith("Hello");  // Checks if string starts with "Hello"
boolean ends = str.endsWith("!");  // Checks if string ends with "!"
```

---

### **3. StringBuilder and StringBuffer**
`StringBuilder` and `StringBuffer` are mutable alternatives to `String` (which is immutable).

#### a. **StringBuilder Example**
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World!");  // Efficient way to append
sb.insert(5, ",");  // Insert comma at index 5
sb.reverse();  // Reverses the string
String result = sb.toString();  // Convert back to string
```

#### b. **StringBuffer**: Similar to `StringBuilder`, but synchronized (thread-safe).

---

### **4. String Formatting**
You can format strings in Java using `String.format()` or `System.out.printf()`.

```java
String formatted = String.format("The price is %.2f", 19.99);  // Formats the number to two decimal places
System.out.printf("Hello %s!", "Java");  // Prints formatted output
```

---

### **5. String Conversion**

#### a. **String to Integer**
```java
String numStr = "123";
int num = Integer.parseInt(numStr);  // Converts String to int
```

#### b. **Integer to String**
```java
int num = 123;
String numStr = Integer.toString(num);  // Converts int to String
```

#### c. **String to Double**
```java
String doubleStr = "3.14";
double pi = Double.parseDouble(doubleStr);  // Converts String to double
```

#### d. **Double to String**
```java
double pi = 3.14;
String piStr = Double.toString(pi);  // Converts double to String
```

---

### **6. String Pool and Interning**
Strings are cached in Java to save memory. The **String pool** stores string literals.

#### a. **Interning Strings**
```java
String str1 = "Hello";
String str2 = new String("Hello").intern();  // Interning explicitly
```

---

### **7. Regular Expressions (Regex) with Strings**

#### a. **Pattern Matching**
```java
String regex = "^[A-Za-z]+$";  // Only letters
boolean matches = str.matches(regex);  // Checks if the string matches the regex pattern
```

#### b. **Using `Pattern` and `Matcher`**
```java
Pattern pattern = Pattern.compile("\\d+");  // Match digits
Matcher matcher = pattern.matcher(str);
boolean found = matcher.find();  // Finds the first match
```

#### c. **Replacing with Regex**
```java
String replaced = str.replaceAll("\\d+", "#");  // Replaces digits with "#"
```

---

### **8. Special Characters in Strings**

#### a. **Escape Sequences**
```java
String s = "This is a \"quoted\" word.\nNew line.";
```
- `\n`: New line
- `\t`: Tab
- `\\`: Backslash
- `\'`: Single quote
- `\"`: Double quote

---

### **9. Common Performance Tips**

- **Use `StringBuilder` or `StringBuffer`** for repetitive string concatenation (e.g., in loops).
- **String comparison (`equals()`) is case-sensitive**; use `equalsIgnoreCase()` for case-insensitive comparison.
- **Avoid using `+` for string concatenation inside loops** — it creates many intermediate `String` objects. Use `StringBuilder` instead.

---

### **10. Common Errors and Pitfalls**

- **Null Pointer Exceptions**: Always check if the string is null before calling methods on it.
```java
if (str != null && str.equals("test")) {
    // safe to compare
}
```
- **Strings are immutable**: Operations like `.concat()` or `.replace()` don’t change the original string but return a new one.

---

Let me know if you need more specific examples or any further clarifications!