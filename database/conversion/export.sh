rm -r output
mkdir output
for mdbfile in $(ls input); do
	dbname=$(echo $mdbfile | cut -f 1 -d '.')
	mkdir output/$dbname
	mkdir output/$dbname/schema
	mkdir output/$dbname/inserts

	echo "Generating schema for $mdbfile"
	mdb-schema input/$mdbfile sqlite > output/$dbname/schema/$dbname.sql
	for table in $(mdb-tables input/$mdbfile); do
		echo "Generating inserts for $dbname::$table"
		mdb-export -D "%Y-%m-%d %H:%M:%S" -I sqlite input/$mdbfile $table > output/$dbname/inserts/$table.sql
	done
done

