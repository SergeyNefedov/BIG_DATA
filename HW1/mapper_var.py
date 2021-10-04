import sys


def main():

    s = 0  # sum
    v = 0  # var
    n = 0  # count

    for line in sys.stdin:
        p = float(line)  # price
        s += p
        v += (p * p)
        n += 1

    cm = s / n  # chunk mean
    cv = v / n - (cm * cm)  # chunk var

    print(n, cm, cv) 


if  __name__ == '__main__':
    main()