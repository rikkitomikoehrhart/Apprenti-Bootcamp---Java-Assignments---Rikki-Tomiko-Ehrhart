This is a functional locker management system that demonstrates understanding of basic Java concepts. Well done overall! You've had some experiences with various languages and such, so a lot of this feedback is to "java-fy" you.

**OVERALL:  Revision Requested**

Minor Tweaks:

* Too much spacing! Try to limit empty lines to 1 between class members.

* **Inconsistent Naming**: `getPinNumber()` should be `getPin()` since the field is called `pin` (locker.java)

* `setIsOpen()` is confusing - it toggles rather than sets. You can name it `toggleOpen()` for this case.

  ```java
  // Names that a Java developer would use:
  public String getPin() { return this.pin; }
  public boolean isOpen() { return this.isOpen; }
  public void toggleOpen() { this.isOpen = !this.isOpen; }
  public void setOpen(boolean open) { this.isOpen = open; }
  ```

* There looks like there's a bug in the locker service:
  ```java
  public Locker assignLocker() {
      int index = getNextAvailableLockerIndex();
  
      lockers[index] = new Locker(index);
  
      return lockers[index];
  }
  ```

  The `getNextAvailableLockerIndex()` returns -1 if there are no lockers available, but `assignLocker()` doesn't handle that case.
  Double check that your lockers 1-based numbers are being properly converted to indexes only when necessary.

* **Feature Envy**: You shouldn't be calling back to other classes, pass necessary objects as parameters to methods.

  ```java
  // Directly accessing Main.locker, Main.ls, Main.appUtils from Actions
  public static void rentALocker() {
      Result result = Result.canRentLocker();
      if (result.success) {
          Main.locker = Main.ls.assignLocker();
          Main.appUtils.displayLockerAndPin(Main.locker);
  
          clearLockerVariable();
      } else {
          Main.appUtils.displayMessage(result.message);
      }
  }
  
  // instead do this:
  public static void rentLocker(LockerService ls, AppUtils utils) {
      
  }
  ```

  This is also happening in AppUtils.
  When you do this, it makes the code very difficult to maintain because the classes are **tightly coupled**, which means changes in one class will likely ripple through to the others.

* There's a bit of overuse of static. I like that you're trying to be efficient, but it looks like you were forcing it, which caused the feature envy.

* Remove obvious comments like `// GETS` and `// SETS`