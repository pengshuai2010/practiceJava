package lintCode;

/**
 * Created by speng on 4/28/17.
 */
public class Q128_HashFunction {
    /**
     * @param key:       A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) {//ask interviewer how to deal with these cases
            return 0;
        }
        int base = 33;
        long ans = 0;//always use long to avoid overflow when number increase exponentially
        for (int i = 0; i < key.length; i++) {
            ans = (ans * base + key[i]) % HASH_SIZE;
        }
        return (int) ans;
    }
}
