
public class DeadCharacterException extends Exception {

    private Character c;

    public DeadCharacterException(Character c) {
        this.c = c;
    }

    public String getMessage() {
        if (c instanceof Sorcerer) {
            return "The sorcerer " + c.getName() + " is dead.";
        } else if (c instanceof Monster) {
            return "The monster " + c.getName() + " is dead.";
        } else if (c instanceof Templar) {
            return "The templar " + c.getName() + " is dead.";
        }
        return "";
    }
}
