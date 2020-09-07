import java.util.Arrays;
import java.lang.CharSequence;
/**
 * Created by KSafonov on 11/09/2017.
 */

public class AsciiCharSequence implements CharSequence {

        private final byte value[];

        public AsciiCharSequence(byte value[]) {
            this.value = Arrays.copyOf(value, value.length);
        }

        public int length(){return value.length;}

        public AsciiCharSequence subSequence(int beginIndex, int endIndex) {

            return new AsciiCharSequence(Arrays.copyOfRange(this.value, beginIndex, endIndex));
        }

        public char charAt(int index) {
            return (char)value[index];
        }
        public String toString(){return new String(this.value);}
}
