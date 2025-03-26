src_dir=$(pwd)
cd $(dirname "$0")

app_dir="$(pwd)/app"

sudo chmod 777 -R .

# app build
cd app/src/main/resources/frontend
rm -rf node_modules package-lock.json
npm install

npm run build

# create package
mvn clean -f "$app_dir/pom.xml"
mvn package -f "$app_dir/pom.xml"

cd $src_dir
exit 0