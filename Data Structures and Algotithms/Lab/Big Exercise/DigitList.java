public class DigitList {
    private int digit;
    private DigitList nextDigit;

    public DigitList() {
        this.digit = 0;
        this.nextDigit = null;
    }

    public DigitList(int d, DigitList next) {
        this.digit = d;
        this.nextDigit = next;
    }

    public int getDigit() {
        return this.digit;
    }

    public DigitList getNextDigit() {
        return this.nextDigit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public void setNextDigit(DigitList next) {
        this.nextDigit = next;
    }

    public DigitList copy() {
        if (this.nextDigit == null)
            return new DigitList(this.digit, null);
        else
            return new DigitList(this.digit, this.nextDigit.copy());
    }

    public int length() {
        if (this.nextDigit == null)
            return 1;
        else
            return 1 + this.nextDigit.length();
    }

    public void print() {
        DigitList tmp = this;
        System.out.print("List: " + tmp.getDigit());
        tmp = tmp.getNextDigit();
        while (tmp != null) {
            System.out.print(" -> " + tmp.getDigit());
            tmp = tmp.getNextDigit();
        }
        System.out.println();
    }

    public static DigitList digitize(int n) {
        if (n == 0)
            return null;
        else
            return new DigitList(n % 10, digitize(n / 10));
    }

    public static int compareDigitLists(DigitList L1, DigitList L2) {
        /**
         * L1 == L2: return 0 L1 > L2: return 1 L1 < L2: return -1
         */
        if ((L1 == null) && (L2 == null))
            return 0;
        else if (L1 == null)
            return -1;
        else if (L2 == null)
            return 1;
        else {
            switch (compareDigitLists(L1.getNextDigit(), L2.getNextDigit())) {
                case 1:
                    return 1;
                case -1:
                    return -1;
                case 0:
                    if (L1.getDigit() > L2.getDigit())
                        return 1;
                    else if (L1.getDigit() == L2.getDigit())
                        return 0;
                    else
                        return -1;
            }
        }
        return -1;
    }

    public static DigitList addDigitLists(int c, DigitList L1, DigitList L2) {
        if ((L1 == null) && (L2 == null))
            return digitize(c);
        else if (L1 == null)
            return addDigitLists(c, L2, null);
        else if (L2 == null) {
            int t = c + L1.getDigit();
            return new DigitList(t % 10, addDigitLists(t / 10, L1.getNextDigit(), null));
        } else {
            int t = c + L1.getDigit() + L2.getDigit();
            return new DigitList(t % 10, addDigitLists(t / 10, L1.getNextDigit(), L2.getNextDigit()));
        }
    }

    public DigitList leftDigits(int n) {
        if (n <= 0)
            return null;
        else if (this.nextDigit == null)
            return new DigitList(this.digit, null);
        else
            return new DigitList(this.digit, this.nextDigit.leftDigits(n - 1));
    }

    public DigitList rightDigits(int n) {
        if (n <= 0)
            return null;
        else if (length() <= n)
            return null;
        else {
            DigitList pTemp;
            pTemp = this;

            for (int i = 0; i < length() - n; i++)
                pTemp = pTemp.getNextDigit();

            DigitList pHead = null;
            DigitList pTail = null;
            DigitList node;

            while (pTemp != null) {
                node = new DigitList();
                node.setDigit(pTemp.getDigit());
                node.setNextDigit(null);

                if (pHead == null) {
                    pHead = node;
                    pTail = node;
                } else {
                    pTail.setNextDigit(node);
                    pTail = node;
                }
                pTemp = pTemp.getNextDigit();
            }
            return pHead;
        }
    }

    public static DigitList trimDigitList(DigitList L) {
        if (L == null || L.getNextDigit() == null)
            return L;
        else {
            DigitList prev = L;
            DigitList curr = L.getNextDigit();
            while (curr.getNextDigit() != null) {
                prev = prev.getNextDigit();
                curr = curr.getNextDigit();
            }
            if (curr.getDigit() == 0) {
                prev.setNextDigit(null);
                return trimDigitList(L);
            }
            return L;
        }
    }

    /********************************* STUDENT'S CODE ********************************/

    public static DigitList subDigitLists(int c, DigitList L1, DigitList L2) {
        // code here
        int t;
        if (L1 == null) {
            return digitize(c);
        } else if (L2 == null) {
            if (c > 0) {
                if(L1.getDigit() < c) {
                    t = L1.getDigit() + 10 - c;
                    return new DigitList(t, subDigitLists(1, L1.getNextDigit(), null));
                } else {
                    t = L1.getDigit() - c;
                    return new DigitList(t, subDigitLists(0, L1.getNextDigit(), null));
                }
            }
            return new DigitList(L1.getDigit(), subDigitLists(0, L1.getNextDigit(), null));

        } else {
            if (L1.getDigit() < L2.getDigit()) {
                if(c > 0) {
                    t = L1.getDigit() + 10 - L2.getDigit() - c;
                    return new DigitList(t, subDigitLists(1, L1.getNextDigit(), L2.getNextDigit()));
                }
                t = L1.getDigit() + 10 - L2.getDigit();
                return new DigitList(t, subDigitLists(1, L1.getNextDigit(), L2.getNextDigit()));
            } else if (L1.getDigit() == L2.getDigit()) {
                if (c > 0) {
                    t = L1.getDigit() + 10 - L2.getDigit() - c;
                    return new DigitList(t, subDigitLists(1, L1.getNextDigit(), L2.getNextDigit()));
                } 
                t = L1.getDigit() - L2.getDigit() - c;
                return new DigitList(t, subDigitLists(0, L1.getNextDigit(), L2.getNextDigit()));
            } else {
                t = L1.getDigit() - L2.getDigit() - c;
                return new DigitList(t, subDigitLists(0, L1.getNextDigit(), L2.getNextDigit()));
            }
        }

    }

    public static DigitList digitize(String str) {
        // complete this code to handle ! operator
        if (str.indexOf("^") != -1) {
            String x = str.substring(0, str.indexOf("^"));
            String y = str.substring(str.indexOf("^") + 1);

            DigitList L = null;
            DigitList M = null;

            for (int i = 0; i < x.length(); i++) {
                L = new DigitList(x.charAt(i) - '0', L);
            }
            for (int i = 0; i < y.length(); i++) {
                M = new DigitList(y.charAt(i) - '0', M);
            }

            L = trimDigitList(L);
            M = trimDigitList(M);
            return BigInteger.pow(new BigInteger(L), new BigInteger(M)).getDigits();
        } else if (str.indexOf("!") != -1) {
            // code here
            String x = str.substring(0, str.indexOf("!"));
            DigitList L = null;
            for(int i = 0; i < x.length(); i++) {
                L = new DigitList(x.charAt(i) - '0', L);
            }
            L = trimDigitList(L);
            return BigInteger.factorial(new BigInteger(L)).getDigits();
        } else {
            DigitList L = null;
            for (int i = 0; i < str.length(); i++) {
                L = new DigitList(str.charAt(i) - '0', L);
            }
            L = trimDigitList(L);
            return L;
        }
    }
}