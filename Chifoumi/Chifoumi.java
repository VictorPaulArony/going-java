public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
       switch(chifoumiAction) {
        case ROCK:
            return ChifoumiAction.SCISSOR;
        case PAPER:
            return ChifoumiAction.ROCK;
        case SCISSOR:
            return ChifoumiAction.PAPER;
        default:
            throw new IllegalArgumentException("Invalid Action" + chifoumiAction);
       }

    }

    public static void main(String[] args) {
        System.out.println("ROCK beats: " + getActionBeatenBy(ChifoumiAction.ROCK));     // SCISSOR
        System.out.println("PAPER beats: " + getActionBeatenBy(ChifoumiAction.PAPER));   // ROCK
        System.out.println("SCISSOR beats: " + getActionBeatenBy(ChifoumiAction.SCISSOR)); // PAPER

    }
}