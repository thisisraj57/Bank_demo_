# Function to check if a number is prime
def is_prime(number):
    """
    Check if a number is a prime number.

    :param number: The number to check.
    :return: True if the number is prime, False otherwise.
    """
    if number <= 1:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True

# Example usage
if __name__ == "__main__":
    num = 29
    if is_prime(num):
        print(f"{num} is a prime number.")
    else:
        print(f"{num} is not a prime number.")