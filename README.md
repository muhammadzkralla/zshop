<h1 align="center"> ZSHOP </h1>

## IMPORTANT:

This project was initiated using `Maven` from the terminal using the following command:
```bash
mvn archetype:generate \                                                                     
  -DgroupId=com.zkrallah.zshop \
  -DartifactId=zshop \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

In order to run and test it, I also do this from the terminal using the following commands:
```bash
mvn clean compile
java -classpath target/classes com.zkrallah.zshop.App
```

 No IDEs Were Used.

 This entire project was built and managed without using any IDEs like IntelliJ IDEA, VS Code, Eclipse, or others. It was developed, run, and tested entirely within the terminal using [Neovim](https://neovim.io/) and **[nvim-jdtls](https://github.com/mfussenegger/nvim-jdtls)** LSP.

I didn’t have enough time to write proper unit tests, so I used randomized tests instead. Although it’s not the best approach, but it helped check that things work.

The random tests try to add 5 random products with random quantities from the inventory to the cart, and then checkout. See more in the [App.java](https://github.com/muhammadzkralla/zshop/blob/master/src/main/java/com/zkrallah/zshop/App.java) file.

Also note that Some trade-offs are discussed in the code comments.

See [tests.txt](https://github.com/muhammadzkralla/zshop/blob/master/tests.txt) for some samples.
