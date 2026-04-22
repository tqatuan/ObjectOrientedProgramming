README.TXT file for Assignment 10

PROGRAM 1 - DATA FORMATTER

I.    Overview:
This program is designed to read a .txt file that contains district population, child population and child poverty rate in 2013. It write data to a specify destination path
    
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

II.   Functionality
    
This program first validates command line arguments, requiring 3 parameters: source file path, destination file path and number of records need to be process. The program writes a header line at the top of the output file for clarity then it reads each line of the source file using BufferedReader. For each line, it safely extracts key fields using fixed character position. It handles the I/O exceptions accordingly while reading

In the main() class, the program also use safeSubstring() to safely extract fields from the input lines to prevent out of bounds exception

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

III.  How to run
Compile the program
Run the program with 3 inline arguments:
- 1: path to the input text file
- 2: path to the output destination file
- 3: Number of records need to be processed
The data is written to a destination path with appropriate header. The consoles will displays messages for skipped lines due to error and confirm successful file creation

PROGRAM 2 - REPORT GENERATOR
 
I.    Overview:
This program is designed to read a .txt file that contains district population, child population and child poverty rate in 2013. It reproduces the data in a standard format and calculate the child poverty rate for each state
    
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

II.   Functionality
    
The program reads a specific numbers of records including state code, total population, child population, and child poverty population. Since the data is granular at school district level, this program aggregates the data by state and then calculate the child poverty rate by each state

StateData is an additional class designed to handle the aggression and calculation of child poverty rate. Each instance of StateData represents a state and keeps track of key metrics from the source data. This class provides methods to add new population data cumulatively and another methods to calculate the percentage of child poverty rate using getChildPovertyPct().

In the main() class, the program also use safeSubstring() to safely extract fields from the input lines to prevent out of bounds exception

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

III.  How to run
Compile the program
Run the program with 2 inline arguments:
- 1: path to the text file
- 2: number of records from the file to process
The data is displayed in a table format with headers and properly aligned columns


