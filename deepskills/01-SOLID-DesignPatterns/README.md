# Module 1: SOLID Principles & Design Patterns

**Status:** ✅ Successful

---

## Structure

```
01-SOLID-DesignPatterns/
├── SOLID-Principles/
│   ├── SRP/OCP/LSP/ISP/DIP/   # Each principle → own package + demo
│   └── screenshots/
└── Design-Patterns/
    ├── Creational/   → Singleton, Factory, Builder
    ├── Structural/   → Adapter, Decorator, Proxy
    ├── Behavioral/   → Observer, Strategy, Command
    ├── Creational/screenshots/
    ├── Structural/screenshots/
    └── Behavioral/screenshots/
```

---

## SOLID Principles

| Principle | Meaning | Code |
|-----------|---------|------|
| **SRP** | One class = one responsibility | `Invoice.java` (data), `InvoicePrinter.java` (print), `InvoiceRepository.java` (DB) |
| **OCP** | Extend without modifying existing code | `PaymentMethod` base → `CreditCardPayment`, `UpiPayment` subclasses |
| **LSP** | Subtypes must replace base types safely | `Sparrow` extends `FlyingBird`, `Ostrich` extends `Bird` (no fly) |
| **ISP** | Many specific interfaces > one fat interface | `Workable` + `Eatable` → `HumanWorker` implements both, `RobotWorker` implements only `Workable` |
| **DIP** | Depend on abstractions, not concretions | `NotificationService` depends on `NotificationSender` interface, not `EmailSender` |

---

## Design Patterns

| Type | Pattern | What it does | Code |
|------|---------|-------------|------|
| **Creational** | Singleton | One instance globally | `DatabaseConnection.getInstance()` |
| | Factory | Creates objects without specifying class | `ShapeFactory.getShape("CIRCLE")` |
| | Builder | Step-by-step object construction | `new Computer.Builder().setCpu(...).build()` |
| **Structural** | Adapter | Makes incompatible interfaces work | `MediaAdapter` bridges `MediaPlayer` ↔ `AdvancedMediaPlayer` |
| | Decorator | Adds behavior dynamically | `new SugarDecorator(new MilkDecorator(new SimpleCoffee()))` |
| | Proxy | Controls access / lazy loading | `ProxyImage` loads real image only on first `display()` |
| **Behavioral** | Observer | One-to-many notification | `NewsChannel` notifies all subscribed `User` objects |
| | Strategy | Interchangeable algorithms | `ShoppingCart.checkout()` accepts any `PaymentStrategy` |
| | Command | Request as an object | `LightOnCommand`, `LightOffCommand` executed by `RemoteControl` |

---

## Run

```bash
# SOLID
cd SOLID-Principles
javac -sourcepath . -cp . SRP/SRPDemo.java && java -cp . SRP.SRPDemo
javac -sourcepath . -cp . OCP/OCPDemo.java && java -cp . OCP.OCPDemo
javac -sourcepath . -cp . LSP/LSPDemo.java && java -cp . LSP.LSPDemo
javac -sourcepath . -cp . ISP/ISPDemo.java && java -cp . ISP.ISPDemo
javac -sourcepath . -cp . DIP/DIPDemo.java && java -cp . DIP.DIPDemo

# Design Patterns
cd ../Design-Patterns
javac -sourcepath . -cp . Creational/Singleton/SingletonDemo.java && java -cp . Creational.Singleton.SingletonDemo
javac -sourcepath . -cp . Creational/Factory/FactoryDemo.java && java -cp . Creational.Factory.FactoryDemo
javac -sourcepath . -cp . Creational/Builder/BuilderDemo.java && java -cp . Creational.Builder.BuilderDemo
javac -sourcepath . -cp . Structural/Adapter/AdapterDemo.java && java -cp . Structural.Adapter.AdapterDemo
javac -sourcepath . -cp . Structural/Decorator/DecoratorDemo.java && java -cp . Structural.Decorator.DecoratorDemo
javac -sourcepath . -cp . Structural/Proxy/ProxyDemo.java && java -cp . Structural.Proxy.ProxyDemo
javac -sourcepath . -cp . Behavioral/Observer/ObserverDemo.java && java -cp . Behavioral.Observer.ObserverDemo
javac -sourcepath . -cp . Behavioral/Strategy/StrategyDemo.java && java -cp . Behavioral.Strategy.StrategyDemo
javac -sourcepath . -cp . Behavioral/Command/CommandDemo.java && java -cp . Behavioral.Command.CommandDemo
```
