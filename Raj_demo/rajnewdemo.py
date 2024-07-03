# Python3 Code to Demonstrate Remove empty List
# from List using filter() Method
 
# Initializing list by custom values
test_list = [5, 6, [], 3, [], [], 9]
 
# Printing original list
print("The original list is : " + str(test_list))
 
# Removing empty List from List
# using filter() method
res = list(filter(None, test_list))
 
# Printing the resultant list
print("List after empty list removal : " + str(res))
