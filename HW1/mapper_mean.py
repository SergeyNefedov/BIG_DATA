import sys


def main():

	s = 0   # sum
	n = 0   # count

	for line in sys.stdin:
		s += float(line)
		n += 1

	cm = s / n   # chunk_mean
	print(n, cm)


if __name__ == '__main__':
    main()