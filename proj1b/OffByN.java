public class OffByN implements CharacterComparator {
    public int offValue;

    public OffByN(int N) {
        offValue = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff = Math.abs(x - y);
        if (diff == offValue) {
            return true;
        } else {
            return false;
        }
    }
}
