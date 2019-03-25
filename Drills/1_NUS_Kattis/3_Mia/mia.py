import sys
import getopt
import time


def cal_rank(n1, n2):
    if (n1 == 1 and n2 == 2) or (n1 == 2 and n2 == 1):
        return 1

    if (n1 == n2):
        return 2

    return 3



def exeTime(func):
    def newFunc(*args, **args2):
        # t0 = time.time() # more precise in Unix
        t0 = time.clock()  # more precise in windows, the cpu time for this program only
        print ("start @%s, {%s} " % (time.strftime("%X", time.localtime()), func.__name__))
        back = func(*args, **args2)
        print ("end @%s, {%s} " % (time.strftime("%X", time.localtime()), func.__name__))
        # print ("@%.3fs taken for {%s}" % (time.time() - t0, func.__name__))
        print ("@%.3fs taken for {%s}" % (time.clock() - t0, func.__name__))  # more precise
        return back

    return newFunc

@exeTime
def main():
    for input_line in sys.stdin:

        numbers = list(map(int, input_line.split()))

        if (numbers[0] == 0 and numbers[1] == 0 and numbers[2] == 0 and numbers[3] == 0):
            return

        rank1 = cal_rank(numbers[0], numbers[1])

        rank2 = cal_rank(numbers[2], numbers[3])

        if (rank1 < rank2):
            print("Player 1 wins.")

        elif (rank1 > rank2):
            print("Player 2 wins.")


        else:
            if (rank1 == 1):
                print("Tie.")
                return

            elif (rank1 == 2):

                if numbers[0] > numbers[2]:
                    print("Player 1 wins.")

                if numbers[0] < numbers[2]:
                    print("Player 2 wins.")
                if numbers[0] == numbers[2]:
                    print("Tie.")

            else:

                player1_large = numbers[0] if numbers[0] > numbers[1] else numbers[1]
                player1_small = numbers[0] if numbers[0] < numbers[1] else numbers[1]

                player2_large = numbers[2] if numbers[2] > numbers[3] else numbers[3]
                player2_small = numbers[2] if numbers[2] < numbers[3] else numbers[3]

                player1 = player1_large * 10 + player1_small
                player2 = player2_large * 10 + player2_small

                if player1 > player2:
                    print("Player 1 wins.")

                elif player1 < player2:
                    print("Player 2 wins.")

                else:
                    print("Tie.")


if __name__ == "__main__":
    sys.exit(main())