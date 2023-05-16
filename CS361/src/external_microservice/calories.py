import csv
import os
import sys
def main():

    # Get unit from input parameter
    unit = int(sys.argv[1])
    
    # Get a list of all CSV files in the current directory
    csv_files = [f for f in os.listdir('.') if f.endswith('.csv')]

    # Get first csv file
    selected_file = csv_files[0]


    # Open the CSV file and read the numbers
    with open(selected_file, 'r') as file:
        reader = csv.reader(file)
        calories = [float(row[0]) for row in reader]

    # Sum up the numbers and print the result
    total = sum(calories)  
    with open("output.txt", 'w') as f:
        if unit == 0:
            f.write("Cal: " + str(total) + '\n')
            f.write("KJ: " + str(round(total*4.184, 2)))

        elif unit == 1:
            f.write("Cal: " + str(round(total/4.184, 2)) + '\n')
            f.write("KJ: "+ str(total))
    return 0
main()
