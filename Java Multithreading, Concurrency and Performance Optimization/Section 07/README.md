# Chapter 07 - Advanced Locking.

Advanced Locking.

# What I learned.

# ReentrantLock Part 01 – tryLock and interruptible Lock.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

1. We will be introducing new type of lock!

<div align="center">
    <img src="What_We_Will_Learn_Next_Is_Advanced_Locks.PNG" width="700" alt="Threads multithreading."/>
</div>

1. We will be looking at `ReetrantLock`!

<div align="center">
    <img src="ReetrantLock_Lock.PNG"  alt="Java threads." width="600"/>
</div>

1. Concept is the same as with the locking with the object!
    - Requires **explicit** locking and unlocking! 

<div align="center">
    <img src="ReetrantLock_Old_And_New_Way.PNG"  alt="Java threads." width="600"/>
</div>

1. **Left** is how we would normally lock the **Object()**!
2. **Right** how we would lock with the **ReetantLock()**!
    - `2.1`, with this we would need to **explicitly** `.lock()` and `unlock()` the object!

<div align="center">
    <img src="ReetrantLock_Disadvantage.PNG"  alt="Java threads." width="600"/>
</div>

1. After we used to lock shared object, we may **forget** to unlock it!

<div align="center">
    <img src="ReetrantLock_Disadvantage_Second_Point.PNG"  alt="Java threads." width="600"/>
</div>

1. If **exception** inside business logic, we may never get to call `.unblock()`!

<div align="center">
    <img src="ReetrantLock_Disadvantage_Second_Point_Solution.PNG"  alt="Java threads." width="600"/>
</div>

1. To fix that, we just need to use `try-catch` block!

<div align="center">
    <img src="Methods_For_ReetrantLock.PNG"  alt="Java threads." width="600"/>
</div>

- This comes very handy, when testing production code!

<div align="center">
    <img src="ReetrantLock_Why.PNG"  alt="Java threads." width="600"/>
</div>

<br>

<div align="center">
    <img src="ReetrantLock_Why_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. We can enforce **fairness** for the `ReentrantLock`!

<div align="center">
    <img src="ReentantLock_Fairness.gif"  alt="Java threads." width="600"/>
</div>

1. If there are **many threads** wanting to get **lock** on the one object!
    - There can be situation where **one thread gets lock multiple times**, where other **threads** are going to be starved!
        - In such situations, we would need to consider **fairness flag!** 

<div align="center">
    <img src="FairnessFlag.PNG"  alt="Java threads." width="600"/>
</div>

1. Using **fairness flag**, when you need it!
    - It may cause reduce throughput!

<div align="center">
    <img src="What_We_Will_Learn_Next_LockInterruptibly.PNG"  alt="Java threads." width="600"/>
</div>

1. Feature of **ReenterantLock** is `.lockInterruptibly()`.

<div align="center">
    <img src="LockInterruptibly_Motivation.PNG"  alt="Java threads." width="600"/>
</div>

1. Generally: When the **thread** is acquiring the `.lock()`, while another **thread** is currently holding lock. The caller **thread** usually gets **suspended** until the lock is released!
2. In this case calling `.interrupt()` does not help!

<div align="center">
    <img src="LockInterruptibly_Locking.PNG"  alt="Java threads." width="600"/>
</div>

1. With locking with the `.lockInterruptibly()` we are **forced** to implement the `try catch`!

<div align="center">
    <img src="LockInterruptibly_Locking_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. If we want to **stop thread** waiting for the **lock**, we can call the `.interrupt()` on the suspended **thread** and resume the `catch` block for it!
    - We could shut down tread gracefully!

<div align="center">
    <img src="LockInterruptibly_Use_Cases.PNG"  alt="Java threads." width="600"/>
</div>

1. We could use this for **Watchog** functionality.
2. When our app would exit, we could implement gracefully exit!

<div align="center">
    <img src="ReetrantLock_TryLock.PNG"  alt="Java threads." width="600"/>
</div>

1. We will go thought `.tryLock()`.

<div align="center">
    <img src="ReetrantLock_Why_To_Use.PNG"  alt="Java threads." width="600"/>
</div>

1. `.tryLock()` is trying to get the lock.

<div align="center">
    <img src="Scenario_01.PNG"  alt="Java threads." width="600"/>
</div>

1. Locking scenario for both flows are similar in locking the!

<div align="center">
    <img src="Scenario_02.PNG"  alt="Java threads." width="600"/>
</div>

1. If `.lock()` has object locked, the **tread** is suspended till its `.unlocked()`!
2. The **rest flow** is **resumed**, when the lock is unlocked.

<div align="center">
    <img src="Scenario_02_With_TryLock.PNG"  alt="Java threads." width="600"/>
</div>

1. Check is happened if the object is locked.
2. If It's locked, we can do something else!
    - We can come back later to acquire lock again!

<div align="center">
    <img src="TryLock_User_Cases.PNG"  alt="Java threads." width="600"/>
</div>

1. Suspending on the tread on a `.lock()` in real time application is unacceptable! Examples:
    - Video/Image processing
    - High Speed/Low latency trading system!
    - User Interface applications!
- These will lead application to be **unresponsible**!

<div align="center">
    <img src="Summary.PNG"  alt="Java threads." width="600"/>
</div>

# ReentrantLock Part 02 – User Interface Application Example.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

1. We will try `ReetrantLock` in real application!

<div align="center">
    <img src="ReetrantLock_TryLock_With_Real_Application.PNG"  alt="Java threads." width="600"/>
</div>

1. How and when to use `.tryLock()` in real application!

<div align="center">
    <img src="Dashboards.PNG"  alt="Java threads." width="600"/>
</div>

1. There are two dashboards!

<div align="center">
    <img src="JavaFx_Plan.PNG"  alt="Java threads." width="600"/>
</div>

1. **Thread 1**: UI application for mouse inputs!
2. **Thread 2**: Network call to assets and make update prices!
3. This is updated to the **shared resource**!

- We are having `PricesContainer.java` for containing the prices!

````Java
public static class PricesContainer {
        private Lock lockObject = new ReentrantLock();

        private double bitcoinPrice;
        private double etherPrice;
        private double litecoinPrice;
        private double bitcoinCashPrice;
        private double ripplePrice;

        public Lock getLockObject() {
            return lockObject;
        }
        public double getBitcoinPrice() {
            return bitcoinPrice;
        }
        public void setBitcoinPrice(double bitcoinPrice) {
            this.bitcoinPrice = bitcoinPrice;
        }
        public double getEtherPrice() {
            return etherPrice;
        }
        public void setEtherPrice(double etherPrice) {
            this.etherPrice = etherPrice;
        }
        public double getLitecoinPrice() {
            return litecoinPrice;
        }
        public void setLitecoinPrice(double litecoinPrice) {
            this.litecoinPrice = litecoinPrice;
        }
        public double getBitcoinCashPrice() {
            return bitcoinCashPrice;
        }
        public void setBitcoinCashPrice(double bitcoinCashPrice) {
            this.bitcoinCashPrice = bitcoinCashPrice;
        }
        public double getRipplePrice() {
            return ripplePrice;
        }
        public void setRipplePrice(double ripplePrice) {
            this.ripplePrice = ripplePrice;
        }
    }
````

- Worker class called `PriceUpdater` for updating the variables!

````Java
public static class PriceUpdater extends Thread {
        private PricesContainer pricesContainer;
        private Random random = new Random();

        public PriceUpdater(PricesContainer pricesContainer) {
            this.pricesContainer = pricesContainer;
        }

        @Override
        public void run() {
            while (true) {
                pricesContainer.getLockObject().lock();

                try {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    pricesContainer.setBitcoinPrice(random.nextInt(20000));
                    pricesContainer.setEtherPrice(random.nextInt(2000));
                    pricesContainer.setLitecoinPrice(random.nextInt(500));
                    pricesContainer.setBitcoinCashPrice(random.nextInt(5000));
                    pricesContainer.setRipplePrice(random.nextDouble());
                } finally {
                    pricesContainer.getLockObject().unlock();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
````

- Here we are ensuring consistent variable updates with the `ReentrantLock.lock()`!

<br>

- Next we will be making **JavaFX** UI thread.

````Java
public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cryptocurrency Prices");

        GridPane grid = createGrid();
        Map<String, Label> cryptoLabels = createCryptoPriceLabels();

        addLabelsToGrid(cryptoLabels, grid);

        double width = 300;
        double height = 250;

        StackPane root = new StackPane();

        Rectangle background = createBackgroundRectangleWithAnimation(width, height);

        root.getChildren().add(background);
        root.getChildren().add(grid);

        primaryStage.setScene(new Scene(root, width, height));

        PricesContainer pricesContainer = new PricesContainer();

        PriceUpdater priceUpdater = new PriceUpdater(pricesContainer);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pricesContainer.getLockObject().tryLock()) {
                    try {
                        Label bitcoinLabel = cryptoLabels.get("BTC");
                        bitcoinLabel.setText(String.valueOf(pricesContainer.getBitcoinPrice()));

                        Label etherLabel = cryptoLabels.get("ETH");
                        etherLabel.setText(String.valueOf(pricesContainer.getEtherPrice()));

                        Label litecoinLabel = cryptoLabels.get("LTC");
                        litecoinLabel.setText(String.valueOf(pricesContainer.getLitecoinPrice()));

                        Label bitcoinCashLabel = cryptoLabels.get("BCH");
                        bitcoinCashLabel.setText(String.valueOf(pricesContainer.getBitcoinCashPrice()));

                        Label rippleLabel = cryptoLabels.get("XRP");
                        rippleLabel.setText(String.valueOf(pricesContainer.getRipplePrice()));
                    } finally {
                        pricesContainer.getLockObject().unlock();
                    }
                }
            }
        };

        addWindowResizeListener(primaryStage, background);

        animationTimer.start();
        priceUpdater.start();
        primaryStage.show();
    }

    private void addWindowResizeListener(Stage stage, Rectangle background) {
        ChangeListener<Number> stageSizeListener = ((observable, oldValue, newValue) -> {
            background.setHeight(stage.getHeight());
            background.setWidth(stage.getWidth());
        });
        stage.widthProperty().addListener(stageSizeListener);
        stage.heightProperty().addListener(stageSizeListener);
    }

    private Map<String, Label> createCryptoPriceLabels() {
        Label bitcoinPrice = new Label("0");
        bitcoinPrice.setId("BTC");

        Label etherPrice = new Label("0");
        etherPrice.setId("ETH");

        Label liteCoinPrice = new Label("0");
        liteCoinPrice.setId("LTC");

        Label bitcoinCashPrice = new Label("0");
        bitcoinCashPrice.setId("BCH");

        Label ripplePrice = new Label("0");
        ripplePrice.setId("XRP");

        Map<String, Label> cryptoLabelsMap = new HashMap<>();
        cryptoLabelsMap.put("BTC", bitcoinPrice);
        cryptoLabelsMap.put("ETH", etherPrice);
        cryptoLabelsMap.put("LTC", liteCoinPrice);
        cryptoLabelsMap.put("BCH", bitcoinCashPrice);
        cryptoLabelsMap.put("XRP", ripplePrice);

        return cryptoLabelsMap;
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        return grid;
    }

    private void addLabelsToGrid(Map<String, Label> labels, GridPane grid) {
        int row = 0;
        for (Map.Entry<String, Label> entry : labels.entrySet()) {
            String cryptoName = entry.getKey();
            Label nameLabel = new Label(cryptoName);
            nameLabel.setTextFill(Color.BLUE);
            nameLabel.setOnMousePressed(event -> nameLabel.setTextFill(Color.RED));
            nameLabel.setOnMouseReleased((EventHandler) event -> nameLabel.setTextFill(Color.BLUE));

            grid.add(nameLabel, 0, row);
            grid.add(entry.getValue(), 1, row);

            row++;
        }
    }

    private Rectangle createBackgroundRectangleWithAnimation(double width, double height) {
        Rectangle backround = new Rectangle(width, height);
        FillTransition fillTransition = new FillTransition(Duration.millis(1000), backround, Color.LIGHTGREEN, Color.LIGHTBLUE);
        fillTransition.setCycleCount(Timeline.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        return backround;
    }
````

- It is important to update the **UI thread**!

````Java
AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pricesContainer.getLockObject().tryLock()) {
                    try {
                        Label bitcoinLabel = cryptoLabels.get("BTC");
                        bitcoinLabel.setText(String.valueOf(pricesContainer.getBitcoinPrice()));

                        Label etherLabel = cryptoLabels.get("ETH");
                        etherLabel.setText(String.valueOf(pricesContainer.getEtherPrice()));

                        Label litecoinLabel = cryptoLabels.get("LTC");
                        litecoinLabel.setText(String.valueOf(pricesContainer.getLitecoinPrice()));

                        Label bitcoinCashLabel = cryptoLabels.get("BCH");
                        bitcoinCashLabel.setText(String.valueOf(pricesContainer.getBitcoinCashPrice()));

                        Label rippleLabel = cryptoLabels.get("XRP");
                        rippleLabel.setText(String.valueOf(pricesContainer.getRipplePrice()));
                    } finally {
                        pricesContainer.getLockObject().unlock();
                    }
                }
            }
````

- We are executing the `mvn clean javafx:run`

<div align="center">
    <img src="UI_Thread_Updating_The_Stocks.gif"  alt="Java threads." width="600"/>
</div>

1. We can see that the **thread** gets updated as in **one thread**!
    - This utilizing the `pricesContainer.getLockObject().tryLock()`!

<div align="center">
    <img src="UI_Thread_Updating_The_Stocks_Lock_Traditional.gif"  alt="Java threads." width="600"/>
</div>

1. We can see that the **thread** gets updated as in **one thread**!
    - This utilizing the `pricesContainer.getLockObject().lock();`!
        - We can see the **UI** is getting locked!

<div align="center">
    <img src="Summary_With_Lock.PNG"  alt="Java threads." width="600"/>
</div>

# Quiz 10: ReentrantLock.


<details>

<summary id="Question_01" open="true"> <b>Question 01.</b> </summary>

````Yaml
Question 01:
What is the potential danger with the current implementation?
````

- My answer:

<div align="center">
    <img src="Quiz 10/Q01.PNG" width="600"/>
</div>

1. We need to handle the **exception** somehow!

</details>

<details>

<summary id="Question_02" open="true"> <b>Question 02.</b> </summary>

````Yaml
Question 02:
Is this implementation safe?
````

- My answer:

<div align="center">
    <img src="Quiz 10/Q02.PNG" width="600"/>
</div>

1. We need to handle the return value!

</details>

# Reentrant Read-Write Lock & Database Implementation.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

1. We are advancing in advanced locks!

<div align="center">
    <img src="What_We_Will_Learn_Next_Is_ReetrantLockWriteLock.PNG"  alt="Java threads." width="600"/>
</div>

1. We will go thought the `ReetrantLockWriteLock` **two** locks in one!
    - Read lock!
    - Write lock!

<div align="center">
    <img src="ReetrantLockWriteLock_Why.PNG"  alt="Java threads." width="600"/>
</div>

1. Old way of handling he's locking!

<div align="center">
    <img src="ReetrantLockWriteLock_Why_Image.PNG"  alt="Java threads." width="600"/>
</div>

1. There is **much reader threads**.
2. There is one **writer** thread, which gets activated much less!

<div align="center">
    <img src="ReentrantReadWriteLock_Lock.PNG"  alt="Java threads." width="600"/>
</div>

1. We need **lock object** to protect from readers and the writers!

<div align="center">
    <img src="ReentrantReadWriteLock_Do_We_Need_Locks.gif"  alt="Java threads." width="600"/>
</div>

1. We don't want to restrict every **reader** thread, from reading **shared resource**!
2. This is **safe**, as long they are not modifying its state!

<div align="center">
    <img src="ReentrantReadWriteLock_Use_Case.PNG"  alt="Java threads." width="600"/>
</div>

1. In general, we don't need to separate the **read locks** and **write locks**!
    - If we keep the **critical sections** short and the **resource locks** as minimal!

<div align="center">
    <img src="ReentrantReadWriteLock_When_To_Use.PNG"  alt="Java threads." width="600"/>
</div>

1. When **reading operations** are **predominant**!
2. If, the read operations take time:
    - Read form many variables.
    - Read form complex data structure.

- We can separate the usage!

<div align="center">
    <img src="ReentrantReadWriteLock_How_To_Use.PNG"  alt="Java threads." width="600"/>
</div>

1. We can use **ReadLock** as separately!
1. Furthermore, we can use **WriteLock** as separately!

- The **reader lock** is allowing **multiple reader threads** to be access the lock!

<div align="center">
    <img src="ReentrantReadWriteLock_How_To_Use_ReaderLock.PNG"  alt="Java threads." width="600"/>
</div>

1. **ReadLock** is having **internal count**, how many threads are currently having the lock!

<div align="center">
    <img src="ReentrantReadWriteLock_How_To_Use_WritingLock.PNG"  alt="Java threads." width="600"/>
</div>

1. **Only one thread** can access the given **resource** when using the `ReentrantReadWriteLock`.
2. If, there is another **thread** one accessing the for writing, while its occupied. That **thread** will be **suspended**! 

<div align="center">
    <img src="ReentrantReadWriteLock_Are_Mutually_Exclusive.PNG"  alt="Java threads." width="600"/>
</div>

1. If, Thread is having the **writeLock**, **no other threads** can access the **readLock**! 

<div align="center">
    <img src="ReentrantReadWriteLock_Are_Mutually_Exclusive_Second.PNG"  alt="Java threads." width="600"/>
</div>

1. If there is `2.` **read locks** with threads that are still unfinished, the `writer.lock()` cannot be invoked by another thread!

- We will be exploring the with the **binary tree**!

<div align="center">
    <img src="Use_Case_For_The_ReentrantReadWriteLock.PNG"  alt="Java threads." width="600"/>
</div>

1. **Key** is the **price amount**!
2. **Value** is the **number of the items**!

- This will be resented using `private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();`!

- Add here the link to the binary tree!

- We will be implanting this to illustrate this! First one will be `getNumberOfItemsInPriceRange(int lowerBound, int upperBound)`!
    - This gives count of given **prize range**! **Upper** and **lower** range!
    ````Java
    public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
                //lock.lock();
                readLock.lock();
                try {
                    Integer fromKey = priceToCountMap.ceilingKey(lowerBound);

                    Integer toKey = priceToCountMap.floorKey(upperBound);

                    if (fromKey == null || toKey == null) {
                        return 0;
                    }

                    NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

                    int sum = 0;
                    for (int numberOfItemsForPrice : rangeOfPrices.values()) {
                        sum += numberOfItemsForPrice;
                    }

                    return sum;
                } finally {
                    readLock.unlock();
                    //lock.unlock();
                }
            }
    ````


- The individual pieces:
    - `priceToCountMap.ceilingKey(lowerBound);` 
        - Call will *"Gives me the next matching key at or above this value”*!
    - `priceToCountMap.floorKey(upperBound);`
        - Call will *Finds the greatest key in priceToCountMap that is less than or equal to upperBound*!
    - `NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);` 
        - Get **snapshot** of the given range!
    - We will be adding the `sum`.
    ````Java
    int sum = 0;
    for (int numberOfItemsForPrice : rangeOfPrices.values()) {
        sum += numberOfItemsForPrice;
    }
    return sum;
    ````

- We will be implanting this to illustrate this! First one will be `public void addItem(int price)`!
    - This for adds item that costs given prize!
    ````Java
            public void addItem(int price) {
                //lock.lock();
                writeLock.lock();
                try {
                    Integer numberOfItemsForPrice = priceToCountMap.get(price);
                    if (numberOfItemsForPrice == null) {
                        priceToCountMap.put(price, 1);
                    } else {
                        priceToCountMap.put(price, numberOfItemsForPrice + 1);
                    }

                } finally {
                    writeLock.unlock();
                    /// lock.unlock();
                }
            }
    ````

- We will be implanting this to illustrate this! First one will be `public void removeItem(int price)`!
    - This for adds item that costs given prize!
    ````Java
            public void removeItem(int price) {
                //lock.lock();
                writeLock.lock();
                try {
                    Integer numberOfItemsForPrice = priceToCountMap.get(price);
                    if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1) {
                        priceToCountMap.remove(price);
                    } else {
                        priceToCountMap.put(price, numberOfItemsForPrice - 1);
                    }
                } finally {
                    writeLock.unlock();
                    // lock.unlock();
                }
            }
    ````

# Resources.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>

# Quiz 11: Read-Write Locks.

# Coding Exercise 4: Product Reviews Service.

# Product Reviews Service – Solution.

<div align="center">
    <img src="Java_Multi_Threading.PNG"  alt="Java threads." width="600"/>
</div>
