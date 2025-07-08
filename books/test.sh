  books    master ⇡3 !4 ?10  mvn clean compile                                                                           ✔ 
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< com.zkrallah.zbooks:zbooks >---------------------
[INFO] Building zbooks 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ zbooks ---
[INFO] Deleting /mnt/hdd/java_projects/zshop/books/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ zbooks ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /mnt/hdd/java_projects/zshop/books/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ zbooks ---
[INFO] Recompiling the module because of changed source code.
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 13 source files with javac [debug target 1.8] to target/classes
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
[INFO] Total time:  1.722 s
[INFO] Finished at: 2025-07-08T20:44:29+03:00
[INFO] ------------------------------------------------------------------------

  books    master ⇡3 !4 ?10  java -classpath target/classes com.zkrallah.zbooks.App                               ✔  3s  
Picked up JAVA_TOOL_OPTIONS: -javaagent:/home/zkrallah/.local/share/java/lombok.jar
--------------CUSTOMER ONE TURN-----------------
Book already exists in inventory.

Books in inventory before removing outdated books: 
Book [title=DDIA, isbn=ISBN-101, author=Martin Kleppmann]
Book [title=NeoVim, isbn=ISBN-103, author=Zkrallah]
Book [title=Grokking Concurrency, isbn=ISBN-102, author=Kiril Bobrov]
Book [title=Old Book, isbn=ISBN-999, author=Vintage Author]
Removing outdated book: Book [title=Old Book, isbn=ISBN-999, author=Vintage Author]

Books in inventory after removing outdated books: 
Book [title=DDIA, isbn=ISBN-101, author=Martin Kleppmann]
Book [title=NeoVim, isbn=ISBN-103, author=Zkrallah]
Book [title=Grokking Concurrency, isbn=ISBN-102, author=Kiril Bobrov]

Books in inventory before removing: 
Book [title=DDIA, isbn=ISBN-101, author=Martin Kleppmann]
Book [title=NeoVim, isbn=ISBN-103, author=Zkrallah]
Book [title=Grokking Concurrency, isbn=ISBN-102, author=Kiril Bobrov]

Books in inventory after removing: 
Book [title=DDIA, isbn=ISBN-101, author=Martin Kleppmann]
Book [title=Grokking Concurrency, isbn=ISBN-102, author=Kiril Bobrov]

Buying paper book:
Shipping 2 copyies of "DDIA" to address: Egypt, Cairo
Remaining ISBN-101 book stock now: 3
-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 110.00
Shipping fee : 16
Paid amount  : 126.00
Balance left : 74.00
-----------------------------------

Buying ebook:
Sending "Grokking Concurrency" book with file type: PDF to email: zkrallah@example.com

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 45.00
Shipping fee : 0
Paid amount  : 45.00
Balance left : 29.00
-----------------------------------

Buying too many paper books:
Insufficient balance to complete the transaction!
Total balance: 29.0
paidAmount: 1168.0

Buying when balance is low:
Insufficient balance to complete the transaction!
Total balance: 29.0
paidAmount: 45.0
--------------CUSTOMER TWO TURN-----------------

Buying all remaining paper books:
Shipping 3 copyies of "DDIA" to address: Egypt, Cairo
Remaining ISBN-101 book stock now: 0
-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 165.00
Shipping fee : 93
Paid amount  : 258.00
Balance left : 742.00
-----------------------------------

Buying after stock is 0:
Not enough copies in stock.

Buying ebook:
Sending "Grokking Concurrency" book with file type: PDF to email: zkrallah@example.com

-------- CHECK‑OUT SUMMARY --------
Sub‑total    : 45.00
Shipping fee : 0
Paid amount  : 45.00
Balance left : 697.00
-----------------------------------

Buying removed demo book:
Book is not available in inventory!

