import sys


def main():
    for line in sys.stdin:
            cj, mj = [float(x) for x in line.split()]
            break

    for line in sys.stdin:
            ck, mk = [float(x) for x in line.split()]
            mi = (cj * mj + ck * mk) / (cj + ck)
            cj, mj = ck, mi

    print(mj)


if __name__ == '__main__':
    main()