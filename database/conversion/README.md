#MDB to SQLite conversion utility
This is a simple utility to convert Microsoft Access database files into SQLite database files.  It only supports exporting the schema and table data at the moment.

##Instructions
1. Create a folder in this directory named 'input'.
2. Place your .mdb files into the 'input' folder. 
3. Run ./convert.sh and your converted database(s) will appear in the 'build' directory.

##Dependencies
This utility was intended to be run in bash and depends on the following tools:
* mdb-tools
* sqlite3