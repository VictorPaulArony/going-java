public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        switch (chifoumiAction) {
            case ROCK:
                return ChifoumiAction.SCISSOR;
            case PAPER:
                return ChifoumiAction.ROCK;
            default:
                return ChifoumiAction.PAPER;
        }
    }

    public static void main(String[] args) {
        System.out.println(Chifoumi.getActionBeatenBy(ChifoumiAction.ROCK));
        System.out.println(Chifoumi.getActionBeatenBy(ChifoumiAction.PAPER));
        System.out.println(Chifoumi.getActionBeatenBy(ChifoumiAction.SCISSOR));
    }
}