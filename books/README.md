<h1 align="center"> ZBOOKS </h1>

## IMPORTANT:

This project was initiated using `Maven` from the terminal using the following command:
```bash
mvn archetype:generate \                                                                        
  -DgroupId=com.zkrallah.zbooks \
  -DartifactId=zbooks \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

In order to run and test it, I also do this from the terminal using the following commands:
```bash
mvn clean compile
java -classpath target/classes com.zkrallah.zbooks.App
```


 No IDEs Were Used.

 This entire project was built and managed without using any IDEs like IntelliJ IDEA, VS Code, Eclipse, or others. It was developed, run, and tested entirely within the terminal using [Neovim](https://neovim.io/) and **[nvim-jdtls](https://github.com/mfussenegger/nvim-jdtls)** LSP.

I didn’t write formal unit tests due to time constraints. Instead, a procedural testing method is used in GeneralTest.java to simulate:
- Adding/removing books (with duplicate handling)
- Buying shippable and mailable books
- Failing transactions due to:
  - Out-of-stock items
  - Low customer balance
  - Attempting to buy non-purchasable books

- Removing outdated books based on expiration
- Confirming that quantity updates persist correctly

Also note that Some trade-offs are discussed in the code comments.

See the test entry point: [App.java](https://github.com/muhammadzkralla/zshop/blob/master/books/src/main/java/com/zkrallah/zbooks/App.java) file.

See [test.sh](https://github.com/muhammadzkralla/zshop/blob/master/books/test.sh) for some sample test cases.
