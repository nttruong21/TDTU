import java.util.ArrayList;

public class BigInteger {
    private DigitList digits;
    private int sign;

    public BigInteger() {
        this.digits = null;
        this.sign = 1;
    }

    public BigInteger(DigitList L) {
        this.digits = L;
        this.sign = 1;
    }

    public BigInteger(int i, DigitList L) {
        this.digits = L;
        this.sign = sgn(i);
    }

    public BigInteger(int i) {
        this.digits = DigitList.digitize(Math.abs(i));
        this.sign = sgn(i);
    }

    public BigInteger(String str) {
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            this.digits = DigitList.digitize(str);
            this.sign = -1;
        } else {
            this.digits = DigitList.digitize(str);
            this.sign = 1;
        }
    }

    public DigitList getDigits() {
        return this.digits;
    }

    public int getSign() {
        return this.sign;
    }

    public void setDigits(DigitList digits) {
        this.digits = digits;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    private int sgn(int i) {
        if (i < 0)
            return -1;
        else
            return 1;
    }

    public int length() {
        if (this.digits == null)
            return 0;
        else
            return this.digits.length();
    }

    public BigInteger copy() {
        if (this.digits == null)
            return new BigInteger(0);
        else
            return new BigInteger(this.sign, this.digits.copy());
    }

    public BigInteger trimDigit() {
        return new BigInteger(this.sign, DigitList.trimDigitList(this.digits));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BigInteger) {
            BigInteger other = (BigInteger) obj;
            if (this.sign == other.sign && DigitList.compareDigitLists(this.digits, other.digits) == 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.digits != null) {
            String integer = "";
            DigitList tmp = this.digits;
            integer = tmp.getDigit() + integer;
            tmp = tmp.getNextDigit();
            while (tmp != null) {
                integer = tmp.getDigit() + integer;
                tmp = tmp.getNextDigit();
            }
            return ((this.sign == -1) ? "-" : "") + integer;
        } else
            return "";
    }

    public BigInteger leftDigits(int n) {
        return new BigInteger(this.digits.leftDigits(n));
    }

    public BigInteger rightDigits(int n) {
        return new BigInteger(this.digits.rightDigits(n));
    }

    public BigInteger shift(int n) {
        if (n < 1)
            return this;
        else {
            BigInteger clone = this.copy();
            clone.digits = new DigitList(0, clone.digits);
            return clone.shift(n - 1);
        }
    }

    /********************************
     * STUDENT'S CODE
     ********************************/

    public BigInteger add(BigInteger other) {
        // complete this code
        if (this.sign == other.sign)
            return new BigInteger(this.sign, DigitList.addDigitLists(0, this.digits, other.digits));
        else {
            if (this.sign == -1) {
                if (DigitList.compareDigitLists(this.digits, other.digits) < 0) {
                    DigitList temp = DigitList.subDigitLists(0, other.getDigits(), this.getDigits());
                    return new BigInteger(1, DigitList.trimDigitList(temp));
                } else {
                    DigitList temp = DigitList.subDigitLists(0, this.getDigits(), other.getDigits());
                    return new BigInteger(-1, DigitList.trimDigitList(temp));
                }

            } else {
                if (DigitList.compareDigitLists(this.digits, other.digits) < 0) {
                    DigitList temp = DigitList.subDigitLists(0, other.getDigits(), this.getDigits());
                    return new BigInteger(-1, DigitList.trimDigitList(temp));
                } else {
                    DigitList temp = DigitList.subDigitLists(0, this.getDigits(), other.getDigits());
                    return new BigInteger(1, DigitList.trimDigitList(temp));
                }
            }
        }
    }

    public BigInteger sub(BigInteger other) {
        // code here
        // Trường hợp cùng dấu
        if (this.sign == other.sign) {
            // Cùng dấu dương
            if (this.sign == 1) {
                if (DigitList.compareDigitLists(this.digits, other.digits) < 0) {
                    DigitList temp = DigitList.subDigitLists(0, other.getDigits(), this.getDigits());
                    return new BigInteger(-1, DigitList.trimDigitList(temp));
                } else {
                    DigitList temp = DigitList.subDigitLists(0, this.getDigits(), other.getDigits());
                    return new BigInteger(1, DigitList.trimDigitList(temp));
                }
            }
            // Cùng dấu âm
            else {
                if (DigitList.compareDigitLists(this.digits, other.digits) < 0) {
                    DigitList temp = DigitList.subDigitLists(0, other.getDigits(), this.getDigits());
                    return new BigInteger(1, DigitList.trimDigitList(temp));
                } else {
                    DigitList temp = DigitList.subDigitLists(0, this.getDigits(), other.getDigits());
                    return new BigInteger(-1, DigitList.trimDigitList(temp));
                }
            }
        }
        // Trường hợp trái dấu
        else {
            // Trường hợp a âm
            if (this.getSign() == -1) {
                DigitList temp = DigitList.addDigitLists(0, this.getDigits(), other.getDigits());
                return new BigInteger(-1, DigitList.trimDigitList(temp));
            }
            // Trường hợp a dương
            else {
                DigitList temp = DigitList.addDigitLists(0, this.getDigits(), other.getDigits());
                return new BigInteger(1, DigitList.trimDigitList(temp));
            }
        }
    }


    public BigInteger mul(BigInteger other) {
        // code here
        if (this.getDigits() == null || other.getDigits() == null) {
            return new BigInteger(0);
        } else if (this.length() == 1 && other.length() == 1) {
            return new BigInteger(DigitList.digitize(this.getDigits().getDigit() * other.getDigits().getDigit()));
        } else {
            if (this.length() >= other.length()) {
                if(this.length() > other.length()) {
                    BigInteger clone = other.copy();
                    DigitList temp = clone.getDigits();
                    while(temp.getNextDigit() != null) {
                        temp = temp.getNextDigit();
                    }
                    for(int i = 0; i < this.length() - other.length(); i++) {
                        temp.setNextDigit(new DigitList(0, null));
                        temp = temp.getNextDigit();
                    }
                    other.setDigits(clone.getDigits());
                }
                int n = this.length() / 2;
                BigInteger para1 = this.leftDigits(n).mul(other.leftDigits(n));
                BigInteger para2 = this.rightDigits(length() - n).mul(other.leftDigits(n));
                BigInteger para3 = this.leftDigits(n).mul(other.rightDigits(length() - n));
                BigInteger para4 = this.rightDigits(length() - n).mul(other.rightDigits(length() - n));
                return new BigInteger(this.getSign()*other.getSign(), para1.add(((para2.add(para3)).shift(n)).add(para4.shift(2*n))).trimDigit().getDigits());
            } else {
               return other.mul(this);
            }
        }
    }

    public static BigInteger pow(BigInteger X, BigInteger Y) {
        // code here
        BigInteger result = new BigInteger(X.getDigits());
        BigInteger temp = new BigInteger(X.getDigits());
        BigInteger count = Y;
        while(DigitList.compareDigitLists(count.getDigits(), DigitList.digitize(1)) != 0) {
            result = result.mul(temp);
            count = count.sub(new BigInteger(1));
        }
        return new BigInteger(X.getSign(), result.getDigits());
    }

    public static BigInteger factorial(BigInteger X) {
        // code here
        BigInteger result = new BigInteger(X.getDigits());
        BigInteger temp = (new BigInteger(X.getDigits()).sub(new BigInteger(1)));
        while(DigitList.compareDigitLists(temp.getDigits(), DigitList.digitize(1)) != 0) {
            result = result.mul(temp);
            temp = temp.sub(new BigInteger(1));
        }
        return new BigInteger(X.getSign(), result.getDigits());
    }

    public static BigInteger computeValue(ArrayList<BigInteger> operandArr, ArrayList<Character> operatorArr) {
        // complete - and * operator
        BigInteger output = operandArr.get(0);
        for (int j = 0; j < operatorArr.size(); j++) {
            switch (operatorArr.get(j)) {
                case '+':
                    output = output.add(operandArr.get(j + 1));
                    break;
                case '-':
                    output = output.sub(operandArr.get(j + 1));
                    break;
                case '*':
                    output = output.mul(operandArr.get(j + 1));
                    break;
                default:
                    break;
            }
        }
        return output;
    }
}