package Behavioral.Command;

public class CommandDemo {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light livingRoomLight = new Light();
        remote.setCommand(new LightOnCommand(livingRoomLight));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(livingRoomLight));
        remote.pressButton();
    }
}
