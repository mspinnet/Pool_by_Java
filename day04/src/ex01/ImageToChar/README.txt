Для компиляции проекта используйте: mkdir target ; javac -d target/ src/java/edu/school21/printer/*/*.java ; cp -r ./src/resources ./target ; cd target

Для запуска используйте: jar -cvfm images-to-chars-printer.jar ../src/manifest.txt . ; java -jar images-to-chars-printer.jar argument

Где:
argument это два символа, 1 - отображает белые пиксели, 2 - отображает черные пиксели