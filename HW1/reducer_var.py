import sys


def main():
    for line in sys.stdin:
            cj, mj, vj = [float(x) for x in line.split()]
            break

    for line in sys.stdin:
            ck, mk, vk = [float(x) for x in line.split()]
            vi = ((cj * vj + ck * vk) / (ck + cj)) + cj * ck * ((mj - mk)/ (ck + cj)) ** 2
            cj, mj, vj = ck, mk, vi

    print(vj)


if  __name__ == '__main__':
    main()