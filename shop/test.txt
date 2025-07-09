> mvn clean compile 

Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.zkrallah.zshop:zshop >----------------------
[INFO] Building zshop 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ zshop ---
[INFO] Deleting /mnt/hdd/java_projects/fawry/zshop/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ zshop ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /mnt/hdd/java_projects/fawry/zshop/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ zshop ---
[INFO] Recompiling the module because of changed source code.
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 18 source files with javac [debug target 1.8] to target/classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO] Annotation processing is enabled because one or more processors were found
  on the class path. A future release of javac may disable annotation processing
  unless at least one processor is specified by name (-processor), or a search
  path is specified (--processor-path, --processor-module-path), or annotation
  processing is enabled explicitly (-proc:only, -proc:full).
  Use -Xlint:-options to suppress this message.
  Use -proc:none to disable annotation processing.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.729 s
[INFO] Finished at: 2025-07-04T23:16:22+03:00
[INFO] ------------------------------------------------------------------------


> java -classpath target/classes com.zkrallah.zshop.App        
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Insufficient amount in inventory!
Product Expired!
Insufficient amount in inventory!

Items in cart now:
CartItem [product=Product [name=Vodafone 100EGP, price=100.0, quantity=10], count=6]
CartItem [product=Product [name=Oreo, price=5.0, quantity=30], count=7]

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 635.00
Shipping fee : 55
Paid amount  : 690.00
Balance left : 310.00
-----------------------------------

# EDGE CASE -> NO BALANCE
> java -classpath target/classes com.zkrallah.zshop.App                                                             
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Product Expired!

Items in cart now:
CartItem [product=Product [name=Vodafone 100EGP, price=100.0, quantity=10], count=2]
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=5]
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=6]
CartItem [product=Product [name=Vodafone 100EGP, price=100.0, quantity=10], count=7]
Insufficient balance to complete the transaction!
Total balance: 1000.0
paidAmount: 1499.0

# EDGE CASE -> EMPTY CART
> java -classpath target/classes com.zkrallah.zshop.App                                                            
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Product Expired!
Insufficient amount in inventory!
Insufficient amount in inventory!
Insufficient amount in inventory!
Insufficient amount in inventory!

Items in cart now:
Empty cart!


# SHIPPING ONE ITEM
> java -classpath target/classes com.zkrallah.zshop.App                                                            
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Product Expired!

Items in cart now:
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=7]
CartItem [product=Product [name=Digestive, price=4.5, quantity=20], count=6]
CartItem [product=Product [name=Cheddar, price=15.3, quantity=5], count=1]
CartItem [product=Product [name=Digestive, price=4.5, quantity=20], count=4]

Shipping the following items:
name: Cheddar, weight: 0.50

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 410.30
Shipping fee : 55
Paid amount  : 465.30
Balance left : 534.70
-----------------------------------


> java -classpath target/classes com.zkrallah.zshop.App                                                             
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Product Expired!
Insufficient amount in inventory!
Product Expired!

Items in cart now:
CartItem [product=Product [name=Oreo, price=5.0, quantity=30], count=4]
CartItem [product=Product [name=Vodafone 100EGP, price=100.0, quantity=10], count=6]

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 620.00
Shipping fee : 23
Paid amount  : 643.00
Balance left : 357.00
-----------------------------------

# SHIPPING THREE ITEMS
> java -classpath target/classes com.zkrallah.zshop.App                                                             
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Insufficient amount in inventory!
Insufficient amount in inventory!

Items in cart now:
CartItem [product=Product [name=Mozzarella, price=18.0, quantity=3], count=3]
CartItem [product=Product [name=Vodafone 100EGP, price=100.0, quantity=10], count=6]
CartItem [product=Product [name=Digestive, price=4.5, quantity=20], count=4]

Shipping the following items:
name: Mozzarella, weight: 0.60
name: Mozzarella, weight: 0.60
name: Mozzarella, weight: 0.60

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 672.00
Shipping fee : 59
Paid amount  : 731.00
Balance left : 269.00
-----------------------------------

> java -classpath target/classes com.zkrallah.zshop.App                                                             
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
Insufficient amount in inventory!
Product Expired!

Items in cart now:
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=2]
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=1]
CartItem [product=Product [name=Etisalat 50EGP, price=50.0, quantity=20], count=1]

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 200.00
Shipping fee : 17
Paid amount  : 217.00
Balance left : 783.00
-----------------------------------
