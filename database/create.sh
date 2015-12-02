rm -r build
mkdir build

for dbname in $(ls output); do
	echo ".read output/$dbname/schema/$dbname.sql" > build/commands.tmp
	
	for filename in $(ls output/$dbname/inserts); do
		echo "BEGIN TRANSACTION;" >> build/commands.tmp 
		echo ".read output/$dbname/inserts/$filename" >> build/commands.tmp
		echo "COMMIT TRANSACTION;" >> build/commands.tmp 
	done
	echo ".quit" >> build/commands.tmp
	echo "Building database : $dbname..."
	sqlite3 build/$dbname.db -batch -echo < build/commands.tmp
done
