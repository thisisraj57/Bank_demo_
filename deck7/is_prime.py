# Function to check if a number is odd
def is_odd(number):
    """
    Check if a number is odd.

    :param number: The number to check.
    :return: True if the number is odd, False otherwise.
    """
    return number % 2 != 0

# Example usage
num = 15
if is_odd(num):
    print(f"{num} is an odd number.")
else:
    print(f"{num} is not an odd number.")