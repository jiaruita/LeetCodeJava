
public class PlusOne {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len + 1];
        if (len == 0) {
        	return digits;
        }
        int carry = 0;
        if (digits[len - 1] < 9) {
        	digits[len - 1] += 1;
        	return digits;
        }
        else {
        	digits[len - 1] = 0;
        	carry = 1;
        }
        for (int i = len - 2; i >=0; i--) {
        	int digit = digits[i] + carry;
        	if (digit >= 10) {
        		carry = 1;
        		digits[i] = digit - 10;
        	}
        	else {
        		digits[i] = digit;
        		carry = 0;
        		break;
        	}
        }
        if (carry == 1) {
        	result[0] = 1;
        	for (int i = 0; i < len; i++) {
        		result[i + 1] = digits[i];
        	}
        	return result;
        }
        return digits;
    }
}
